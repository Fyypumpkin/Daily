import java.util.ArrayList;
import java.util.Vector;

/**
 * @author fyypumpkin on 2018/7/28
 */
public class Test {
    public static void main(String[] args) {
        // 非线程安全
        ArrayList list = new ArrayList();
        //线程安全
        Vector vector = new Vector();
    }
}
