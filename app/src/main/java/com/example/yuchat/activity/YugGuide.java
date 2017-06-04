package com.example.yuchat.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yuchat.R;
import com.example.yuchat.adapter.AdapterGuideViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */

public class YugGuide extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    private AdapterGuideViewPager adapterGuideViewPager;
    private List<View> viewList;
    private ImageView imageView[]=new ImageView[3];
    private int[] indicatorDotId={R.id.iv_indicator_dot1,R.id.iv_indicator_dot2,R.id.iv_indicator_dot3};
    private Button btnTomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.yu_guide);

        initView();
    }

    @SuppressLint("InflateParams")
    private void initView(){
        final LayoutInflater inflater=LayoutInflater.from(this);

        viewList=new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_page1,null));
        viewList.add(inflater.inflate(R.layout.guide_page2,null));
        viewList.add(inflater.inflate(R.layout.guide_page3,null));

        for (int i=0;i<indicatorDotId.length;i++){
            imageView[i]=(ImageView)findViewById(indicatorDotId[i]);
        }

        adapterGuideViewPager=new AdapterGuideViewPager(viewList,this);

        viewPager=(ViewPager)findViewById(R.id.vp_guide);
        viewPager.setAdapter(adapterGuideViewPager);
        viewPager.addOnPageChangeListener(this);

        btnTomain=(Button)(viewList.get(2)).findViewById(R.id.btn_to_main);
        btnTomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(YugGuide.this,YuLoginOrRegister.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < indicatorDotId.length; i++) {
            if (i != position) {
                imageView[i].setImageResource(R.drawable.unselected);
            } else {
                imageView[i].setImageResource(R.drawable.selected);
            }
        }
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
