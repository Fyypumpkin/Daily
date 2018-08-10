package design.observer;

/**
 * 观察者模式
 * @author fyypumpkin on 2018/7/25
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Subject weatherData = new WeatherData();
        new ConditionDisplay(weatherData);
        ((WeatherData) weatherData).setEle(1, 2, 3);
        Thread.sleep(2000);
        ((WeatherData) weatherData).setEle(2, 3, 4);

    }
}
