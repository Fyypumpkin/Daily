package design.decorator;

/**
 * 帽子，一个装饰器
 * @author fyypumpkin on 2018/7/25
 */
public class Hat extends AbstractClothes{
    public Hat(AbstractPerson abstractPerson) {
        super(abstractPerson);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("我有帽子了");
    }

    public void hatSpe(){
        System.out.println("只有帽子有的功能");
    }
}
