package com.volkangurbuz.mongodbfirst;

import com.volkangurbuz.mongodbfirst.Class.User;

/**
 * Created by VolkanGurbuz on 2/22/2018.
 */

public class Common {

    private static String DB_NAME = "mydb";
    private static String COLLENTION_NAME = "user";
    public static String API_KEY = "B4rIceg_xIqS-E5noWotIzc1LFLUIPrN";

    public static String getAdressSingle(User user){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME,COLLENTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("/"+user.get_id().getOid()+"?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    public static String getAdressAPI(){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s", DB_NAME,COLLENTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }





}
