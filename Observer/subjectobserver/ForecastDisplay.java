package subjectobserver;

/**
 * 天气预报布告板
 * @author 
 *
 */
public class ForecastDisplay implements Observer, DisplayElement {
    
    private WeatherData weatherData; 
    
    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this); //初始化时就注册为观察者
    }

    public void display() {
        String displayData = "ForecastDisplay [temp=" + temp + ", humidity=" + humidity + ", pressure="
                + pressure + "]";
        System.out.println(displayData);
    }

    private float temp;
    private float humidity;
    private float pressure;
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
