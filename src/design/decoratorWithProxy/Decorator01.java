package design.decoratorWithProxy;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class Decorator01 extends Decorator {
    public Decorator01(AbstractSubject subject) {
        super(subject);
    }

    @Override
    public void request() {
        System.out.println("Decorator01");
        super.request();
    }
}
