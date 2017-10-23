package BaseClass;

public class FarmDate {
    private static FarmDate instance = null;
    private int day;
    private int month;
    private int year;
    private Weather weather;

    private FarmDate(){
        if(instance != null){
            throw new IllegalStateException("Already initialized!");
        }
        day = 0;
        month = 0;
        year = 0;
        weather.getInstance();
    }

    public static FarmDate getInstance(){
        FarmDate result = instance;
        if (result == null){
            instance = result = new FarmDate();
        }
        return result;
    }

    public void nextDay(){
        day++;
        if(day > 30){
            day = 0;
            month++;
        }
        if(month > 12){
            year++;
            month = 0;
        }
    }
}
