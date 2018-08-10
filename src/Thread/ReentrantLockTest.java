package Thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author fyypumpkin on 2018/7/28
 */
public class ReentrantLockTest implements Runnable {
    SpinLock lock = new SpinLock();

    public void get() {
        // 多次进入不会死锁
        lock.lock();
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        IntStream.range(0, 2).forEach(item -> {
            get2();
        });
        lock.unlock();
        lock.unlock();
    }

    public void get2() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
    }

    @Override
    public void run() {
        get();
    }
}

/**
 * 自旋锁简单实现
 * 如果自旋锁被另外一个线程对象持有，
 * 那么当前获取锁的线程将陷入while循环等待，
 * 直到那个持有自旋锁的线程对象释放它所持有的自旋锁，
 * 那么那些想要获取该自旋锁的线程对象 将会有一个获得该自旋锁。
 * <p>
 * 这是一个可重入的自旋锁，多次进入不会死锁
 */
class SpinLock {
    private AtomicReference<Thread> threads = new AtomicReference<>();

    /**
     * 用于记录锁进入次数
     */
    private int count;

    public void lock() {
        Thread current = Thread.currentThread();
        if (current == threads.get()) {
            count++;
            System.out.println("count: " + count);
            return;
        }
        while (!threads.compareAndSet(null, current)) {
            System.out.println("-------------> " + Thread.currentThread().getId() + " -> " + threads.get().getId());
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == threads.get()) {
            if (count > 0) {
                count--;
            } else {
                while (!threads.compareAndSet(current, null)) {
                    System.out.println("+++++++++++++> " + Thread.currentThread().getId() + " -> " + threads.get().getId());
                }
            }
        }
    }
}

/**
 * 不可重入锁，普通锁
 */
class NoReenLock {
    private boolean locked = false;

    private static int i = 0;

    public synchronized void lock() {
        while (locked) {
            try {
                System.out.println(Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
    }

    public synchronized void unlock() {
        System.out.println(Thread.currentThread().getName() + " p");
        locked = false;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        NoReenLock lock = new NoReenLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                IntStream.range(0, 10000).forEach(item -> {
                    i++;
                });
                lock.unlock();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(2000);
        System.out.println(i);
    }
}

class ReenLock {
    private AtomicBoolean locked = new AtomicBoolean(false);
    private AtomicInteger count = new AtomicInteger(0);
    private AtomicReference<Thread> lockedBy = new AtomicReference<>(null);
    private static int a = 0;

    public synchronized void lock() {
        Thread thread = Thread.currentThread();
        while (locked.get() && lockedBy.get() != thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked.compareAndSet(false, true);
        count.incrementAndGet();
        lockedBy.compareAndSet(null, thread);

    }

    public synchronized void unlock() {
        Thread thread = Thread.currentThread();
        if (thread == lockedBy.get()) {
            count.decrementAndGet();
            if (count.intValue() == 0) {
                locked.compareAndSet(true, false);
                lockedBy.compareAndSet(thread, null);
                notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenLock lock = new ReenLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 锁可重入
                lock.lock();
                lock.lock();
                lock.lock();
                IntStream.range(0, 2000).forEach(item -> {
                    a++;
                });
                lock.unlock();
                lock.unlock();
                lock.unlock();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(2000);
        System.out.println(a);
    }

}