package other.test2;

/**
 * @author fyypumpkin on 2018/7/23
 */
abstract public class AS extends AF {
    @Override
    protected void execute(String request) throws Exception {
        test2();
    }

    protected void test(){
        System.out.println("AF test");
    }
}
