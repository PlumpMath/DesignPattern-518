package subjectobserver;

public class StateData {
    
    private float temp;
    private float humidity;
    private float pressure;
    
    public float getTemp() {
        return temp;
    }
    
    public void setTemp(float temp) {
        this.temp = temp;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
    
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public String toString() {
        return "StateData [temp=" + temp + ", humidity=" + humidity + ", pressure=" + pressure
                + "]";
    }
}
