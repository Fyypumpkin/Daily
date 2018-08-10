package ali.theory;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
        }};
//        ((ArrayList)(list.subList(0,2))).add("add"); // java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
        list.subList(0,2);
        List<String> list1 = new ArrayList<>(list.subList(0,2)); // 使用这种方式截取部分list
        list1.add("add");
        String concatA = "aa" + "bb" + "cc";
        StringBuilder builderC = new StringBuilder("aabbcc");
        String constB = "aabbcc";
        System.out.println((concatA == constB )+ " " + (concatA == builderC.toString()));
        System.out.println(list);
    }
}
