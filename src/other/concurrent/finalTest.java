package other.concurrent;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fyypumpkin on 2018/7/12
 */
public class finalTest {
    public final List<String> test = new ArrayList<>();
    public final BigInteger[] bigIntegers;
    public String a = "a";

    public finalTest() {
        test.add("1");
        test.add("2");
        test.add("3");
        bigIntegers = new BigInteger[2];
        bigIntegers[0] = new BigInteger("111");
        bigIntegers[1] = new BigInteger("111");
    }

    public void testA() {
        System.out.println(test + " " + a);
        bigIntegers[0] = new BigInteger("2000");
        System.out.println(bigIntegers[0]);
    }

    public static void main(String[] args) {
        finalTest finalTest = new finalTest();
        finalTest.test.add("5");
        System.out.println(finalTest.test);
        finalTest.testA();
    }
}

class Holder {
    int n = 1;

    public Holder(int n) {
        this.n = ++n;
    }

    public Holder() {
    }

    public void test() {
        this.n++;
        System.out.println(n);
        if (n != n) {
            throw new AssertionError("错误");
        }
    }
}

class Main {
    static Holder holder;

    public static void main(String[] args) {
        Holder holder = new Holder();
        Th e = new Th(holder);
        int i = 1000;
        while (i > 0) {
            new Thread(e).start();
            i--;
        }
    }

}

class Th implements Runnable {
    Holder holder;

    public Th(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        holder.test();
    }
}

class Th2 extends Thread {
    private String lock;
    private int id;

    public Th2(int id, String lock) {
        this.lock = lock;
        this.id = id;
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";
        for (int i = 0; i < 10; i++) {
            new Th2(i, lock).start();
//            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                System.out.println("NO:" + this.id + "   ->" + i);
            }
        }
    }
}