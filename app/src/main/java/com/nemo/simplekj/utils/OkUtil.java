package com.nemo.simplekj.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by nemo on 2016/8/11 0011.
 */

public class OkUtil {

    public final static String BASE_URL="http://route.showapi.com/197-1";

    public static void get(Map<String,String> params, Callback call) {
        OkHttpClient client = new OkHttpClient();
        StringBuilder url = new StringBuilder();
        if(params!=null && params.size()>0){
            url.append(BASE_URL+"?");
            Iterator<Map.Entry<String,String>> set = params.entrySet().iterator();
            for (int i = 0; i < params.entrySet().size(); i++) {
                Map.Entry<String,String> e = set.next();
                url.append(e.getKey()+"="+e.getValue());
                if(set.hasNext()){
                    url.append("&");
                }
            }
            System.out.println(url);
        }else{
            url.append(BASE_URL);
        }
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        client.newCall(request).enqueue(call);
    }
}
