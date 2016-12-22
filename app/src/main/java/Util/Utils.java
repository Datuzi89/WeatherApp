package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Xuezhu on 12/11/16.
 */
//This class parses different types of data from Json files
public class Utils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";
    public static final String APIKey = "&appid=033f4b441683dc2133130d7bb1b41be5";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject(tagName);
    }

    public static String getString( String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }

    public static float getFloat( String tagName, JSONObject jsonObject) throws JSONException {
        return (float)jsonObject.getDouble(tagName);
    }

    public static double getDouble( String tagName, JSONObject jsonObject) throws JSONException {
        return (float)jsonObject.getDouble(tagName);
    }

    public static int getInt( String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }
}
