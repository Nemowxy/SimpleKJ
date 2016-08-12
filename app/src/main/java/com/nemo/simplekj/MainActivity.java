package com.nemo.simplekj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nemo.simplekj.utils.OkUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String,String> map = new HashMap<>();
        map.put("showapi_appid","23230");
        map.put("showapi_sign","e19c00fcb56f4ee8a00c4bf824e3c671");
        map.put("num","10");
        OkUtil.get(map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.fillInStackTrace());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("response:"+response.body().string());
            }
        });
    }
}
