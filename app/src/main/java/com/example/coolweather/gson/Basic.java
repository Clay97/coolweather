package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by clay on 2019/2/25.
 */

public class Basic {
    @SerializedName("location")
    public String  cityName;

    @SerializedName("cid")
    public String  weatherId;

}
