package com.example.yuchat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yuchat.R;

public class YuMain extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yu_main);
        textView=(TextView)findViewById(R.id.ed_helloworld);
    }
}
