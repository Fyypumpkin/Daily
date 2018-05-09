package ClassTest.ClassLoaderTest;

/**
 * @author fyypumpkin on 2018/5/9.
 */

public class demo {
    public void test() {
        demo2 demo2 = new demo2();
        DemoOuter demoOuter = new DemoOuter();
        demoOuter.test();
        demo2.test();
        System.out.println("test method");
    }

    @Override
    public String toString() {
        return "demo test";
    }
}

class DemoOuter {
    public void test() {
        System.out.println("outer test method");
    }
}