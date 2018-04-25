package Thread;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * @author fyypumpkin on 2018/4/25.
 */

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocalValue = new ThreadLocal<>();

    private static void testThreadLocal() {
        IntStream.range(1, 1000).forEach(i -> {
            Thread t = new Thread(() -> {
                threadLocalValue.set(String.valueOf(i));
                System.out.println(threadLocalValue.get());
            });
            try {
                t.start();
                // join必须等待t线程结束才继续
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.activeCount());
        });

    }

    public static void main(String[] args) {
        ThreadLocalTest.testThreadLocal();
    }
}

class YieldTest {
    /**
     * yield是线程做出让步让其他线程竞争
     */

    private static void testYield(String name) {
        Thread t = new Thread(() -> {
            IntStream.rangeClosed(0, 30).forEach(i -> {
                ThreadGroup group = currentThread().getThreadGroup();
                Thread[] threads = new Thread[Thread.activeCount()];
                group.enumerate(threads);
                System.out.println(currentThread().getName() + "  -> " + i + " current thread count -> " + Thread.activeCount() + " -> " + Arrays.asList(threads) );
                if (i == 20) {
                    Thread.yield();
                }
            });
        }, name);
        t.start();
    }

    public static void main(String[] args) throws InterruptedException {
        currentThread().join(10000);
        YieldTest.testYield("thread 1");
        YieldTest.testYield("thread 2");
//        Thread.sleep(2000);
    }
}