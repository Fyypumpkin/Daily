package ClassTest.Extend.diamond_extend;

/**
 * @author fyypumpkin on 2018/7/28
 */
public class A {
}

class B extends A{

}

class C extends A{

}
//
//class D extends B, C{
//    // 当这里调用A中某个方法，B重写了，C没重写，这时候D就不知道调用哪个方法
//}

interface A1{
    void override1();
}

interface B1 extends A1{
    @Override
    void override1();
}

interface C1 extends A1{
    @Override
    void override1();
}

class D1 implements B1,C1{

    @Override
    public void override1() {
        System.out.println("haha");
    }

    public static void main(String[] args) {
        A1 a1 = new D1();
        a1.override1();
    }
}