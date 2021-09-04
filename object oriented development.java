package problem;
/* 
Scenario:
Assume we are building a Weather Application, which notifies the viewers about Current Day Weather and NextDay Weather Prediction. Two displays one is CurrentDayWeather and NextDayWeather.
Whenever the weather report changes the display elements will be updated with the new data.
*/

class WeatherData{
    // data
    String forecast;
    float temperature;

    // displays
    CurrentDayWeather currentDayWeather;
    NextDayWeather nextDayWeather;

    public WeatherData(CurrentDayWeather currentDayWeather, NextDayWeather nextDayWeather){
        this.currentDayWeather = currentDayWeather;
        this.nextDayWeather = nextDayWeather;
    }

    private String getUpdatedForecast(){
        // Assumption
        return "Cloudy";
    }

    private float getUpdatedTemperature(){
        // Assumption
        return (float) 20.3;
    }

    public void weatherChanged(){
        // latest data
        forecast = getUpdatedForecast();
        temperature = getUpdatedTemperature();

        // Notifiying
        currentDayWeather.updatedWeather(forecast, temperature);
        nextDayWeather.updatedWeather(forecast, temperature);
        
    }

}

class CurrentDayWeather{
    String forecast;
    float temperature;
    public void updatedWeather(String forecast, float temperature){
        this.forecast = forecast;
        this.temperature = temperature;
        display();
    }

    public void display(){
        System.out.println("Current Day Weather report is:\n Forecast: "+forecast + "\n Temperature: " + temperature);
    }

}

class NextDayWeather{
    String forecast;
    float temperature;
    public void updatedWeather(String forecast, float temperature){
        if(forecast.equals("Cloudy"))
            this.forecast = "Rainy";
        else if(forecast.equals("Rainy"))
            this.forecast = "Partial Cloudy";
        this.temperature = (float) (temperature + 1.1);
        display();
    }

    public void display(){
        System.out.println("Next Day Weather Predication Report is:\n Forecast: "+forecast + "\n Temperature: " + temperature);
    }

}

class WaatherApplication{
    public static void main(String... args){
        CurrentDayWeather currentDayWeather = new CurrentDayWeather();
        NextDayWeather nextDayWeather = new NextDayWeather();

        WeatherData weatherData = new WeatherData(currentDayWeather, nextDayWeather);

        weatherData.weatherChanged();

    }
}


/**
 * Problem: In the WeatherApplication.java, we have several design issues with classes. 
 * 1. CurrentDayWeather and NextDayWeather are Tightly Coupled.
 * 2. Not followed several rules in both the display classes. Mainly "Program to interfaces, not implementations".
 * 3. If we want add any other display element, we need to modify the WeatherData class. Which makes no sense. 
 * Above are some of the problems from the WeatherApplication.java
 */
