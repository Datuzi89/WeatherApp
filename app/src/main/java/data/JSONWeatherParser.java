package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.CurrentCondition;
import model.Place;
import model.Weather;


public class JSONWeatherParser {
    public static Weather getWeather(String data) {
        Weather weather = new Weather();

        //create JsonObject from data

        try {
            JSONObject jsonObject = new JSONObject(data);

            Place place = new Place();
            JSONObject coorObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat", coorObj));
            place.setLon(Utils.getFloat("lon", coorObj));

            //get the sys obj
            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setCity(Utils.getString("name", jsonObject));
            place.setLastupdate(Utils.getInt("dt", jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));
            weather.place = place;

            //weather infor in Json file is a Json arr
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);

            CurrentCondition currentCondition = new CurrentCondition();
            currentCondition.setWeatherId(Utils.getInt("id", jsonWeather));
            currentCondition.setDescription(Utils.getString("description",jsonWeather));
            currentCondition.setIcon(Utils.getString("icon", jsonWeather));
            currentCondition.setCondition(Utils.getString("main", jsonWeather));
            JSONObject mainObj = Utils.getObject("main", jsonObject);
            currentCondition.setTemperature(Utils.getDouble("temp", mainObj));
            currentCondition.setPressure(Utils.getFloat("pressure", mainObj));
            currentCondition.setHumidity(Utils.getFloat("humidity", mainObj));
            currentCondition.setMaxTemp(Utils.getFloat("temp_max", mainObj));
            currentCondition.setMinTemp(Utils.getFloat("temp_min", mainObj));
            weather.currentCondition = currentCondition;

            JSONObject windObj = Utils.getObject("wind", jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed", windObj));
            weather.wind.setDeg(Utils.getFloat("deg", windObj));

            JSONObject cloudObj = Utils.getObject("clouds", jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all", cloudObj));

            return weather;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
