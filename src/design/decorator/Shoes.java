package design.decorator;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class Shoes extends AbstractClothes {
    public Shoes(AbstractPerson abstractPerson) {
        super(abstractPerson);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("我有鞋子了");
    }
}
