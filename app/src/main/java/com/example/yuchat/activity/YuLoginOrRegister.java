package com.example.yuchat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.yuchat.R;

/**
 * Created by Administrator on 2017/6/4.
 */

public class YuLoginOrRegister extends AppCompatActivity implements View.OnClickListener {
    private TabHost tabHost;

    private Button loginButton;
    private EditText loginusername;
    private EditText loginpassword;

    private Button registerButton;
    private EditText registerusername;
    private EditText registerpassword1;
    private EditText registerpassword2;

//    private ServerManager serverManager = ServerManager.getServerManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.yu_loginorregister);
        initView();
    }

    private void initView() {
        tabHost = (TabHost) findViewById(R.id.tabhost);

        loginButton = (Button) findViewById(R.id.button_login);
        loginusername = (EditText) findViewById(R.id.et_username);
        loginpassword = (EditText) findViewById(R.id.et_password);

        registerButton = (Button) findViewById(R.id.button_register);
        registerusername = (EditText) findViewById(R.id.et_register_username);
        registerpassword1 = (EditText) findViewById(R.id.et_register_password1);
        registerpassword2 = (EditText) findViewById(R.id.et_register_password2);

        tabHost.setup();
//        tabHost.newTabSpec("Login").setIndicator("Login").setContent(R.id.login_layout);
//        tabHost.newTabSpec("Register").setIndicator("Register").setContent(R.id.register_layout);
        tabHost.addTab(tabHost.newTabSpec("Login").setIndicator("Login").setContent(R.id.login_layout));
        tabHost.addTab(tabHost.newTabSpec("Register").setIndicator("Register").setContent(R.id.register_layout));

        for (int i = 0; i < 2; i++) {
            TextView tv = ((TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title));
            tv.setAllCaps(false);
            tv.setTextSize(16);
        }

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_layout: {
                Intent intent = new Intent(this,YuMain.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.register_layout: {
                Intent intent = new Intent(this,YuMain.class);
                startActivity(intent);
                finish();
                break;
            }
            default:
                break;
        }
    }
}
