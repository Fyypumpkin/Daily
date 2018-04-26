package Java8Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author fyypumpkin on 2018/4/26.
 */

public class StreamTest {
    /**
     * stream是单线程的
     * parallelStream是多线程的，并行的
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {{
            add("a");
            add("c");
            add("b");
        }};

        // forEach, 接受一个consumer对象
        Consumer<String> consumer = System.out::print;
        list.forEach(System.out::print);
        System.out.println();
        list.forEach(consumer);


        // filter,接受一个predicate对象
        list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);

        // sorted按照自然排序，或者指定comparator（不会改变原集合）
        list.stream().sorted().forEach(System.out::print);
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

        // map一个中间操作，可以传递一个Function
        Function<String, String> function = String::toUpperCase;
        list.stream().map(function).forEach(System.out::print);
        list.stream().map(String::toUpperCase).forEach(System.out::print);

        // match，一个终结操作，返回是否匹配，boolean类型,接受一个predicate对象
        Predicate predicate = s -> s.equals("b");
        System.out.println(list.stream().anyMatch(s -> s.equals("a")));
        System.out.println(list.stream().anyMatch(predicate));

        // count，一个终结操作，包含的元素数量
        System.out.println(list.stream().count());

        // reduce，一个终结操作，对元素削减操作
        Optional<String> reduced = list.stream().sorted().reduce((a, b) -> a + "$" + b);
        reduced.ifPresent(System.out::print);

        System.out.println();

        list.stream().map(s -> {
            System.out.println("map -> " + s);
            return s.toUpperCase();
        }).filter(s -> {
            System.out.println("filter -> " + s);
            return true;
        }).forEach(s -> {
            System.out.println("foreach -> " + s);
        });


        Stream stream = list.stream().filter(s -> s.startsWith("a"));
        stream.forEach(System.out::print);
    }
}
