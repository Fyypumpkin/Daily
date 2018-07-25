package design.observer;

/**
 * 观察者接口
 * @author fyypumpkin on 2018/7/25
 */
public interface Observer {
    public void update(double temp, double humidity, double pressure);
}
