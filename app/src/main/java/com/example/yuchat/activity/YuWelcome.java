package com.example.yuchat.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.yuchat.R;

/**
 * Created by Administrator on 2017/6/4.
 */

public class YuWelcome extends AppCompatActivity {

    private static final int DELAY = 2000;
    private static final int GO_GUIDE = 0;
    private static final int GO_HOME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yu_welcome);
        getSupportActionBar().hide();//隐藏toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initload();
    }

    private void initload() {
        SharedPreferences sharedPreferences = getSharedPreferences("yuchat", MODE_PRIVATE);
        boolean guide=sharedPreferences.getBoolean("guide", true);
        if (!guide) {
            handler.sendEmptyMessageDelayed(GO_HOME,DELAY);
        } else {
            handler.sendEmptyMessageDelayed(GO_GUIDE,DELAY);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("welcome", false);
            editor.apply();
        }
    }

        private void goHome() {
            Intent intent = new Intent(this, YuLoginOrRegister.class);
            startActivity(intent);
            finish();
        }

        private void goGuide() {
            Intent intent = new Intent(this, YugGuide.class);
            startActivity(intent);
            finish();
        }

        Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUIDE: {
                    goGuide();
                    break;
                }
                case GO_HOME: {
                    goHome();
                    break;
                }
                default:
                    break;
            }
        }
    };

    }

