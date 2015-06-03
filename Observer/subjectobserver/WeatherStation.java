package subjectobserver;

public class WeatherStation {
    
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        AvgStateDisplay stateDisplay = new AvgStateDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        
        weatherData.setWeatherData(25.0F, 80F, 1.01F);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherData.setWeatherData(26.2F, 76F, 1.02F);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherData.setWeatherData(27.8F, 70F, 1.01F);
    }

}
