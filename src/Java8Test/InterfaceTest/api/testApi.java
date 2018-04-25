package Java8Test.InterfaceTest.api;

/**
 * @author fyypumpkin on 2018/4/25.
 */

@FunctionalInterface
public interface testApi {

    void getName(String name);

    default testApi testLaInInterface() {
        return this::getName;
    }

//    default testApi testLaInInterface() {
//        return name -> {
//            getName(name);
//        };
//    }

    default void test() {
        System.out.println("default");
    }
}
