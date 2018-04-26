package Java8Test;

import java.util.function.Consumer;

/**
 * @author fyypumpkin on 2018/4/25.
 */

public class ConsumerTest {
    public static void main(String[] args) {
        // 对一个参数需要进行的操作
        Consumer<Object> printToString = o -> {
            System.out.println(o.toString());
        };

        printToString.accept(new Person() {{
            setName("jack");
            setSex("male");
        }});
    }
}
