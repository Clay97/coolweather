package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by clay on 2019/2/28.
 */

public class Hourly_forecast {
    public String status;

    public List<Hourly> hourly;

    public class Hourly{
        public String  time;

        @SerializedName("cond_txt")
        public String  more;

        public  String wind_dir;

        public String wind_sc;
    }
}
