package ClassTest.ClassLoaderTest;

import java.lang.reflect.Method;

/**
 * @author fyypumpkin on 2018/5/9.
 */

public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        new test().loadClassTest();
    }

    void loadClassTest() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        ClassLoader.getPlatformClassLoader();
        Class clazz = classLoader.loadClass("ClassTest.ClassLoaderTest.TestLoadClass");
        Class.forName("ClassTest.ClassLoaderTest.TestLoadClass");
        this.getClass().getClassLoader().loadClass("ClassTest.ClassLoaderTest.TestLoadClass");
        for (Method m : clazz.getMethods()) {
            System.out.println(m.getName());
        }
    }
}

class TestLoadClass {
    public String test() {
        return "";
    }
}