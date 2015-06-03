package subjectobserver2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AvgStateDisplay implements Observer, DisplayElement{
    
    private Observable observable;
    public AvgStateDisplay(Observable observable){
        observable.addObserver(this);
        this.observable = observable;
    }
    
    public void unregister(){
        observable.deleteObserver(this);
    }
    
    public void display() {
        System.out.println(getShowInfo());
    }
    
    private String getShowInfo(){
        StringBuilder displayData = new StringBuilder();
        if (tempList.size() == 0) {
            displayData.append("暂时没有数据...");
            return displayData.toString();
        }
        
        float tempAve = calculatorAve(tempList);
        displayData.append("平均气温:" + tempAve);
        
        float humidityAve = calculatorAve(humidityList);
        displayData.append(",平均湿度:" + humidityAve);
        
        float pressureAve = calculatorAve(pressureList);
        displayData.append(",平均压强:" + pressureAve);
        
        return displayData.toString();
    }
    
    private float calculatorAve(List<Float> dataList){
        float sum = 0F;
        for (Float float1 : dataList) {
            sum = sum + float1;
        }
        float ave = sum/dataList.size();
        return ave;
    }
    
    private List<Float> tempList;
    private float temp;
    private List<Float> humidityList;
    private float humidity;
    private List<Float> pressureList;
    private float pressure;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            
            if (tempList == null) {
                tempList = new ArrayList<Float>();
            }
            tempList.add(temp);
            
            if (humidityList == null) {
                humidityList = new ArrayList<Float>();
            }
            humidityList.add(humidity);
            
            if (pressureList == null) {
                pressureList = new ArrayList<Float>();
            }
            pressureList.add(pressure);
            
            display();
        }
    }

}
