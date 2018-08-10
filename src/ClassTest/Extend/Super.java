package ClassTest.Extend;

import java.util.Date;

/**
 * @author fyypumpkin on 2018/7/28
 */
public class Super {
    public Super() {
        System.out.println("super");
        test(); // 父类中调用方法被重写会错误的导致运行
    }

    protected void test(){
        System.out.println("this is super");
    }
}

class Child extends Super{
    private final Date date;

    Child() {
        date = new Date();
    }

    @Override
    protected void test() {
        System.out.println("this is child" + " " + date);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.test();
    }
}
