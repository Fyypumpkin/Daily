package genericTest;

import java.util.ArrayList;
import java.util.List;

public class genericTest {
    public static <R> R test(List<R> list){
        return list.get(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList(){{
            add(1);
            add(2);
        }};
        System.out.println(genericTest.test(list));
    }
}
