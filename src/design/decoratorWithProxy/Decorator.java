package design.decoratorWithProxy;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class Decorator implements AbstractSubject {
    private AbstractSubject subject;

    public Decorator(AbstractSubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("Decorator");
    }
}
