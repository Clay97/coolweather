package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by clay on 2019/2/25.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond_txt")
    public String  more;

    public  String wind_dir;

    public String wind_sc;

}
