package design.observer;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class ConditionDisplay implements Observer, Display {
    private Subject weatherData;
    private double temp;
    private double pressure;

    public ConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        // 注册
        weatherData.reg(this);
    }



    @Override
    public void display() {
        System.out.println(temp + " " + pressure + " " + weatherData);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        this.temp = temp;
        this.pressure = pressure;
        display();
    }
}
