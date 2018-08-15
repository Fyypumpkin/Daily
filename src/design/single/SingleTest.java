package design.single;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fyypumpkin on 2018/8/10
 */
public class SingleTest {
}

// 非线程安全 饿汉
class hungry {
    private static hungry instance = new hungry();

    private hungry() {
    }

    public static hungry getInstance() {
        return instance;
    }
}

// 非线程安全 懒汉
class lazy {
    private static lazy instance;

    private lazy() {
    }

    public static lazy getInstance() {
        if (instance == null) {
            instance = new lazy();
        }
        return instance;
    }
}

// 线程安全 懒汉
class SafeHungry {
    private static SafeHungry instance;

    private SafeHungry() {
    }

    ;

    public static synchronized SafeHungry getInstance() {
        if (instance == null) {
            instance = new SafeHungry();
        }
        return instance;
    }
}

// 线程安全 双重判断
class Duo {
    private volatile static Duo instance;

    private static Duo getInstance() {
        if (instance == null) {
            synchronized (Duo.class) {
                if (instance == null) {
                    instance = new Duo();
                }
            }
        }
        return instance;
    }
}

// 线程安全 静态内部类
class StaticInner {
    private StaticInner() {
    }

    ;

    public static StaticInner getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static StaticInner instance = new StaticInner();
    }
}

// 线程安全 枚举
enum EnumSingleton {
    INSTANCE;

    private void doSomeThing() {
    }
}

class SingletonManager {

    private static Map<String, Object> objMap = new HashMap<String, Object>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}