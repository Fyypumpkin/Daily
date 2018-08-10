package Thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author fyypumpkin on 2018/7/29
 */
public class InterruptTest {
    private static long time = 0;

    private static void resetTime() {
        InterruptTest.time = System.currentTimeMillis();
    }

    private static void printContent(String content) {
        System.out.println(content + " 时间： " + (System.currentTimeMillis() - InterruptTest.time));
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Thread1 thread1 = new Thread1();
        thread1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        System.out.println("线程中断测试");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            resetTime();
            int num = 0;
            while (true) {
                if (isInterrupted()) {
                    printContent("当前线程中断了");
                    break;
                }

                // 这里会导致输出异常，输出异常后，interrupt状态又变成了false,异常的原因是线程中断了，但是有调用了Thread.sleep，导致catch异常，使得中断状态又变成false
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                num++;

                if (num % 100 == 0) {
                    printContent("num : " + num);
                }
            }
        }
    }
}

class Main{
    private static volatile boolean status = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread1();
        t.start();
        Thread.sleep(2000);
//        t.interrupt(); // interrupt也可以打断park状态
        status = true;
        LockSupport.unpark(t);
        System.out.println(Thread.interrupted());
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (!status){
                System.out.println("while true");
                System.out.println("park");
                LockSupport.park();
                System.out.println("unpark");
                break;
            }
        }
    }
}
