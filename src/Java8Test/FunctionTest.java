package Java8Test;

import java.util.function.Function;

/**
 * @author fyypumpkin on 2018/4/25.
 */

public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        System.out.println(toInteger.apply("888"));

        Function<char[], String> toString = (String::new);

        Function<char[], String> toUpperString = toString.andThen(String::toUpperCase);
        char[] testChar = new char[]{'a','b','c','d'};
        System.out.println(toUpperString.apply(testChar));
    }
}
