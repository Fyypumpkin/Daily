package design.decorator;

/**
 *
 * 衣物的抽象类
 * @author fyypumpkin on 2018/7/25
 */
public class AbstractClothes implements AbstractPerson {
    AbstractPerson abstractPerson;

    public AbstractClothes(AbstractPerson abstractPerson) {
        this.abstractPerson = abstractPerson;
    }

    @Override
    public void show() {
        abstractPerson.show();
    }
}
