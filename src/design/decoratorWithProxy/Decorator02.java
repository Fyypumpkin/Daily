package design.decoratorWithProxy;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class Decorator02 extends Decorator {
    public Decorator02(AbstractSubject subject) {
        super(subject);
    }

    @Override
    public void request() {
        super.request();
        System.out.println("Decorator02");
    }
}
