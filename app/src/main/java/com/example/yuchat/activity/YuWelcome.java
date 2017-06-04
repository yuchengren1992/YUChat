package com.example.yuchat.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.yuchat.R;

/**
 * Created by Administrator on 2017/6/4.
 */

public class YuWelcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yu_welcome);
        getSupportActionBar().hide();//隐藏toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void initload(){
        SharedPreferences sharedPreferences=getSharedPreferences("yuchat",MODE_PRIVATE);
        boolean welcome=sharedPreferences.getBoolean("welcome",true);
        if (!welcome){
            handler.sendMessageDelayed(GO_HOME,DELAY);
        }else{
            handler.sendMessageDelayed(GO_GUIDE,DELAY);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("welcome",false);
            editor.apply();
        }
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_GUIDE:{
                    goGuide();
                    break;
                }
                case GO_HOME:{
                    goHome();
                    break;
                }
                default:
                    break;
            }
        }
    };

}
