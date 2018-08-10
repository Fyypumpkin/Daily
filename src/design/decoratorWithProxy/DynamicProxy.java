package design.decoratorWithProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class DynamicProxy implements InvocationHandler {
    Object object = null;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy---------");
        return method.invoke(this.object, args);
    }
}
