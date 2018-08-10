package design.decoratorWithProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 装饰器和代理模式混合
 * @author fyypumpkin on 2018/7/25
 */
public class ProxyFactory {
    public static AbstractSubject getProxy(AbstractSubject real){
        ClassLoader loader = real.getClass().getClassLoader();

        Class<?>[] interfaces = real.getClass().getInterfaces();

        InvocationHandler handler = new DynamicProxy(real);

        AbstractSubject subject = (AbstractSubject) Proxy.newProxyInstance(loader, interfaces, handler);

        return subject;
    }
}

class Main{
    public static void main(String[] args) {
        AbstractSubject real = new RealSubject();
        AbstractSubject proxy = ProxyFactory.getProxy(real);
        System.out.println("-----调用装饰器前-----");
        System.out.println("未装饰类名：" + proxy.getClass().getName());
        proxy.request();
        System.out.println("--------------------");
        System.out.println("-----调用装饰器01-----");
        proxy = new Decorator01(proxy);
        System.out.println("装饰01后类名：" + proxy.getClass().getName());
        proxy.request();
        System.out.println("--------------------");
        System.out.println("-----调用装饰器02-----");
        proxy = new Decorator02(proxy);
        System.out.println("装饰02后类名：" + proxy.getClass().getName());
        proxy.request();


    }
}
