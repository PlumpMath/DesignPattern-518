package subjectobserver;

public class HeatIndexDisplay implements Observer, DisplayElement{

    private WeatherData weatherData;
    public HeatIndexDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void unregister(){
        weatherData.unregisterObserver(this);
    }
    
    @Override
    public void display() {
        System.out.println("当前酷热指数:" + getHeatIndex());
    }
    
    private float getHeatIndex(){
        float heatIndex = 0F;
        heatIndex = (float) (temp*Math.PI + humidity*Math.E + pressure*1.01315)/5;
        return heatIndex;
    }

    private float temp;
    private float humidity;
    private float pressure;
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

}
