package Thread.ConcurrentContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fyypumpkin on 2018/7/29
 */
public class Test {
    static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    public static void main(String[] args) {

        Map hashMap = new HashMap<>(3);
//        hashMap.put(1,1);
//        hashMap.put(2,1);
//        hashMap.put(3,1);
//        hashMap.put(4,1);
//        hashMap.put(5,1);
//        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
//            System.out.println(entry.getKey() + ":  " + entry.getValue());
//        }

        int n = 9;
        System.out.println(hashMap.get("com.sun.glass"));
        n+=n-1;
        System.out.println(hashMap.size());
        System.out.println(n);
    }
}
