package design.decorator;

/**
 * 我是一个人
 * @author fyypumpkin on 2018/7/25
 */
public class Me implements AbstractPerson {
    @Override
    public void show() {
        System.out.println("现在是裸体的");
    }
}
