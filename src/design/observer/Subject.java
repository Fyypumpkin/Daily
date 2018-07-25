package design.observer;

/**
 * 主题接口
 * @author fyypumpkin on 2018/7/25
 */
public interface Subject {
    public void reg(Observer o);
    public void delObserver(Observer o);
    public void notifyObservers();
}
