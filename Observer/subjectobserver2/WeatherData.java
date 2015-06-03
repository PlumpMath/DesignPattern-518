package subjectobserver2;

import java.util.Observable;

public class WeatherData extends Observable{

    private float temp;
    private float humidity;
    private float pressure;
    
    public WeatherData(){}
    
    public void setWeatherData(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        dataChanged();
    }
    
    public void dataChanged(){
        setChanged();
        notifyObservers();
    }
    
    public float getTemp() {
        return temp;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
}
