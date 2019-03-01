package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;
import com.example.coolweather.gson.Hourly_forecast;
import com.example.coolweather.gson.Weather;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by clay on 2019/2/24.
 */

public class Utility {
    /*
    *  解析和处理服务器返回的省级数据
    * */
    public static boolean handleProvinceResponse(String response) {
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allprovinces =new JSONArray(response);
                for(int i =0 ;i<allprovinces.length();i++){
                    JSONObject provinceObject =allprovinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /*
  *  解析和处理服务器返回的市级数据
  * */
    public static boolean handleCityResponse(String response , int provinceId) {
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allprovinces =new JSONArray(response);
                for(int i =0 ;i<allprovinces.length();i++){
                    JSONObject cityObject =allprovinces.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
 *  解析和处理服务器返回的县级数据
 * */
    public static boolean handlCountyResponse(String response , int cityId) {
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allprovinces =new JSONArray(response);
                for(int i =0 ;i<allprovinces.length();i++){
                    JSONObject countyObject =allprovinces.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
    *  将返回的JSON数据解析成Weather实体类
    * */
    public static Weather handlWeatherResponse(String response){
        try {
            JSONObject jsonObject =new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return   new  Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    *  将返回的JSON数据解析成 Hourly_forecast事例
    * */
    public static Hourly_forecast handlHourlyResponse(String response){
        try {
            JSONObject jsonObject =new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return   new  Gson().fromJson(weatherContent, Hourly_forecast.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

