package memoryTest;

import java.util.ArrayList;
import java.util.List;

// -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
public class heapOOM {
    public static void main(String[] args) {
        List<heapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new heapOOM());
        }
    }
}
