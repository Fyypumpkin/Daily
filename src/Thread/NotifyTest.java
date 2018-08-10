package Thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author fyypumpkin on 2018/7/28
 */
public class NotifyTest {
    private static final NotifyTest test = new NotifyTest();
    private void test() throws InterruptedException {
        synchronized (test) {
            System.out.println(Thread.currentThread().getId() + " ----Start ");
            wait(0);
            System.out.println(Thread.currentThread().getId() + " ----End ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        final NotifyTest test = new NotifyTest();
        IntStream.range(0, 4).forEach(item -> {
            new Thread(() -> {
                try {
                    test.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });

//        synchronized (test){
//            System.out.println(Thread.currentThread() + " " + Thread.currentThread().getId());
//            test.notify();
//        }

        Thread.sleep(1000);

        synchronized (test) {
            test.notifyAll();
        }
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(1==2 && 2==2 || 2==1);
//        ConcurrentHashMap
    }
}