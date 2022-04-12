package com.example.aspectjdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Statistics("登陆")
    public void clickLogin(View view) {
        Log.e("lianwenhong", " >>> clickLogin");
    }

    @Statistics("我的")
    public void clickMine(View view) {
        Log.e("lianwenhong", " >>> clickMine");
    }

    @Statistics("专区")
    public void clickArea(View view) {
        Log.e("lianwenhong", " >>> clickArea");
    }
}