package other.test2;

/**
 * @author fyypumpkin on 2018/7/23
 */
abstract public class AF {

    public void t() throws Exception {
        execute("d");
    }

    protected abstract void execute(String request) throws Exception;

    protected void test2(){
        System.out.println("AF test2");
    }

}
