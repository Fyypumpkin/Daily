package ClassTest;

/**
 * 内部类，静态内部类测试
 *
 * @author fyypumpkin on 2018/4/25.
 */

public class InnerStaticTest {
    private static String staticValue = "outer private static value";
    private String nonStaticValue = "outer private non static value";
    static String publicStaticValue = "outer public static value";
    String publicNonStaticValue = "outer public non static value";

    private void outerPrint() {
        System.out.println("outer print: " + nonStaticValue + " " + staticValue);
    }

    private static void staticOuterPrint() {
        System.out.println("static outer print: " + " " + staticValue);
    }

    /**
     * 访问权限影响其他类的访问
     */
    private class Inner {
        private String innerValue = "";
//        内部类不能有static，包括属性和方法
//        private static String test = "test";

        private void innerPrint() {
            InnerStaticTest outerClass = new InnerStaticTest();
            InnerStaticTest.StaticInner staticInner = new InnerStaticTest.StaticInner();
            staticInner.print();
            StaticInner.staticPrint();
            outerClass.outerPrint();
            System.out.println("inner print: " + outerClass.nonStaticValue + " " + outerClass.publicNonStaticValue);
            InnerStaticTest.staticOuterPrint();
        }

        final void innerFinalPrint() {
            InnerStaticTest outerClass = new InnerStaticTest();
            outerClass.outerPrint();
            System.out.println("inner final print");
        }
    }

    static class StaticInner {
        private String staticInnerValue = "static inner value";
        private static String staticInnerStaticValue = "static inner static value";

        static void staticPrint() {
            InnerStaticTest outer = new InnerStaticTest();
            outer.outerPrint();
            InnerStaticTest.Inner inner = outer.new Inner();
            inner.innerFinalPrint();
            System.out.println("静态内部类静态打印方法：");
        }

        private void print() {
            System.out.println("静态内部类非静态打印方法: ");
        }

    }

    /**
     * 外部类可以访问内部类的所有成员变量以及方法
     * 内部类也可以访问外部类所有成员变量和方法
     */
    public static void main(String[] args) {
        InnerStaticTest outer = new InnerStaticTest();
        InnerStaticTest.Inner inner = outer.new Inner();
        InnerStaticTest.StaticInner staticInner = new InnerStaticTest.StaticInner();
        staticInner.print();
        inner.innerPrint();
        inner.innerFinalPrint();
        System.out.println(StaticInner.staticInnerStaticValue + StaticInner.staticInnerStaticValue +  inner.innerValue);
    }
}

class ThridClass {
    public static void main(String[] args) {
        InnerStaticTest outer = new InnerStaticTest();
    }
}