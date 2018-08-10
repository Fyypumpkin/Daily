package Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author fyypumpkin on 2018/7/28
 */
public class TestMultiThread implements Runnable {
    private static AtomicInteger num2 = new AtomicInteger(0);

    /**
     * stamp版本需要自己维护
     */
    AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(10, 0);

    private static AtomicInteger num4 = new AtomicInteger(0);

    private static Integer num1 = 0;

    private static volatile Integer num3 = 0;

    private static Integer num5 = 0;

    private static Integer num6 = 0;

    private static Integer num7 = 0;

    private static Integer num8 = 0;

    Object o = new Object();

    static Object o1 = new Object();


    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            num1++;
            num2.incrementAndGet();
            // 对象锁，但是锁不住，原因是该实例不是唯一的，所以锁不住
            synchronized (o){
                num5++;
            }
            // 也是自定义对象锁，但是使用static修饰，保证了唯一性，可以锁住
            synchronized (o1){
                num6++;
            }
            // 同理，对象锁，但是实例不同所以也锁不住
            synchronized (this){
                num7++;
            }
            // 类锁，所有实例都会使用同一个类对象，所以可以锁住
            synchronized (TestMultiThread.class){
                num8++;
            }
            num3++;
        }
        num4.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        TestMultiThread run1 = new TestMultiThread();
        TestMultiThread run2 = new TestMultiThread();
        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();
        while (true) {
            if (num4.intValue() == 2) {
                System.out.println(num1 + " " + num2 + " " + num3 + " " + num5 + " " + num6 + " " + num7 +  " " + num8);
                break;
            }
        }
    }
}
