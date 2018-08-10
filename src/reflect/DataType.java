package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author fyypumpkin on 2018/7/16
 */
public class DataType {
    private final Integer a = 1;
    public final String b = "1";
    static String c = "c";
    static final String d = "1"; // 不能修改（反射也不行）

    public Integer getA() {
        return a;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Test.test();
    }

    static void test() throws NoSuchFieldException, IllegalAccessException {
        DataType dataType = new DataType();
        Field field = dataType.getClass().getDeclaredField("c");
//        Field field2 = dataType.getClass().getField("b");
//        field2.set(dataType, "888");
        field.setAccessible(true);
        field.set(dataType, "222");
        System.out.println(DataType.c);

        Field filed3 = dataType.getClass().getDeclaredField("d");
        Field field4 = filed3.getClass().getDeclaredField("modifiers");
        field4.setAccessible(true);
        field4.setInt(filed3, filed3.getModifiers() & (~Modifier.FINAL)); // 抹去final修饰符
        filed3.setAccessible(true);
        filed3.set(dataType, "yy");
        System.out.println(DataType.d);
    }
}
