package ClassTest;

/**
 * @author fyypumpkin on 2018/7/12
 */
public class StaticInnerThisTest {
    private String test;
    static class Inner{
        public void inner(){
            
            System.out.println(this);
        }
        public static void sinner(){
            System.out.println("sinner");
        }
    }

    class Inner2{
        public void inner2()
        {
            test="a";
            System.out.println(this);
        }
    }

    public void test(){
        System.out.println(this);
        new Inner2().inner2();
        Inner.sinner();
    }

    public static void main(String[] args) {
       new StaticInnerThisTest.Inner().inner();
       new StaticInnerThisTest().test();
    }
}
