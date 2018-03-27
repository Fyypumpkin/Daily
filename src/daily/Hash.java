package daily;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hash {
    public static void main(String[] args) {
        Hash hash = new Hash();
        Hash hash1 = new Hash();
        System.out.println(hash.hashCode() == hash1.hashCode());
        System.out.println(hash.hashCode()+ " " + hash1.hashCode());

        Map map = new HashMap();
        map.put("1","1");
        map.put("2","1");
        System.out.println(map.size());
    }

    @Override
    public int hashCode() {
        return new Date().getSeconds();
    }
}
