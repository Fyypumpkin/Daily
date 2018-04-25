package Java8Test;

import java.util.Comparator;

/**
 * @author fyypumpkin on 2018/4/25.
 */

public class ComparatorsTest {
    public static void main(String[] args) {
        Comparator<Person> compare = Comparator.comparing(Person::getName);
        System.out.println(compare.compare(new Person() {{
            setName("jack");
        }}, new Person() {{
            setName("jack");
        }}));

    }
}
