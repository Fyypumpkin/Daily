package other.test2;

/**
 * @author fyypumpkin on 2018/7/23
 */
public class S extends AS {
    @Override
    protected void test() {
        super.test();
        System.out.println("AS");
    }

    @Override
    protected void test2() {
        super.test2();
        System.out.println("S test2");
    }
}
