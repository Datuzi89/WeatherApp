package model;

/**
 * Created by Xuezhu on 12/11/16.
 */

public class Weather {
    public Place place;
    public String iconData;
    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    public Clouds clouds = new Clouds();
    public Snow snow = new Snow();
}
