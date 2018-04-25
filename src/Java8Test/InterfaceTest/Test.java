package Java8Test.InterfaceTest;

import Java8Test.InterfaceTest.api.testApi;
import Java8Test.InterfaceTest.api.testApi2;

/**
 * @author fyypumpkin on 2018/4/25.
 */

public class Test {
    static String lastName3 = "last3";
    String lastName4 = "last4";

    public void test() {
        testApi test = System.out::println;
        test.getName("hello");

        testApi test4 = name -> {
            System.out.println(name);
        };


        testApi api = new testApi() {
            @Override
            public void getName(String name) {
                System.out.println();
            }
        };

        testApi2 test2 = FuncRefer::staticFunc;
        test2.getName("HHHHHHHH");
        FuncRefer funcRefer = new FuncRefer();

        test2 = funcRefer::func;
        test2.getName("sssss");

        String lastName1 = "last1";
        final String lastName2 = "last2";

        // 匿名对象可以访问其外的final类型的变量，lambda都可访问 (可以直接访问到成员变量)
        test2 = name -> {
            String.valueOf(name + lastName3);
            String.valueOf(name + lastName1);
            String.valueOf(name + lastName2);
            String.valueOf(name + lastName4);
            // 成员变量可以修改
            lastName4 = "111";
            return "";
        };

        // 虽然lambda都可以访问，但是未定义为final的非静态局部变量会被编译器隐式定义成final，所以在lambda里面或者后面更改都是不允许的
        // lastName1 = "111";
        lastName3 = "333";
    }

    public static void main(String[] args) {
        new Test().test();
    }
}

class FuncRefer {
    String func(String s) {
        System.out.println(s.toUpperCase());
        return s.toUpperCase();
    }

    static String staticFunc(String s) {
        System.out.println(s.toLowerCase());
        return s.toLowerCase();
    }
}