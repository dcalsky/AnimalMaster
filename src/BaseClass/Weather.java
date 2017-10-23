package BaseClass;


enum WeatherType{
    SUNNY,RAINY,WINDY
}

public class Weather{
    private static Weather instance = null;

    private Weather(){
        if(instance !=null ){
            throw new IllegalStateException("Already initialized!");
        }
        weatherType = WeatherType.SUNNY;
    }

    public static Weather getInstance(){
        Weather result = instance;
        if (result == null){
            instance = result = new Weather();
        }

        return result;
    }

    private WeatherType weatherType;

    private void changeWeather(WeatherType weatherType){
        this.weatherType = weatherType;
    }

}