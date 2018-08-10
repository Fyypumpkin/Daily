package other.test2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fyypumpkin on 2018/7/23
 */
public class list {
    private static  void set(List list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("1"))iterator.remove();
        }
    }

    public static void main(String[] args) {
        List list1 = new ArrayList(){{
            add("1");
            add("2");
            add("3");
        }};
        System.out.println(list1);
        list.set(list1);
        System.out.println(list1);
    }
}
