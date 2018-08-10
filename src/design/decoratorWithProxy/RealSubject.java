package design.decoratorWithProxy;

/**
 * 被代理类
 * @author fyypumpkin on 2018/7/25
 */
public class RealSubject implements AbstractSubject{
    @Override
    public void request() {
        System.out.println("real subject");
    }
}
