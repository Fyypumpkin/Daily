package Java8Test;

import java.util.function.Predicate;

/**
 * 布尔类型函数
 * @author fyypumpkin on 2018/4/26.
 */

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 0;

        System.out.println(predicate.test("aaaaa"));
    }
}
