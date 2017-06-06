package com.example.yuchat.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.yuchat.R;
import com.example.yuchat.adapter.AdapterMainViewPager;
import com.example.yuchat.view.LayoutChat;
import com.example.yuchat.view.LayoutContract;
import com.example.yuchat.view.LayoutMoment;

import java.util.ArrayList;
import java.util.List;

public class YuMain extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<TabLayout.Tab> tabList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.yu_main);

        initView();

    }

    public void initView(){

        viewPager=(ViewPager)findViewById(R.id.vp_main);
        tabLayout=(TabLayout)findViewById(R.id.tl_main);

        tabList=new ArrayList<>();

        AdapterMainViewPager adapterMainViewPager=new AdapterMainViewPager(getSupportFragmentManager());

        adapterMainViewPager.addFragment(new LayoutChat());
        adapterMainViewPager.addFragment(new LayoutContract());
        adapterMainViewPager.addFragment(new LayoutMoment());

        viewPager.setAdapter(adapterMainViewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabList.add(tabLayout.getTabAt(0));
        tabList.add(tabLayout.getTabAt(1));
        tabList.add(tabLayout.getTabAt(2));

        tabList.get(0).setIcon(R.drawable.msgselected).setText("Chat");
        tabList.get(1).setIcon(R.drawable.contactsunselected).setText("Contact");
        tabList.get(2).setIcon(R.drawable.momentunselected).setText("Moment");

//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tabList.get(tab.getPosition()).setIcon(ImageManager.imageID[tab.getPosition()+3]);
//                tabLayout.setTabTextColors(
//                        ContextCompat.getColor(YuMain.this,R.color.colorBlack),
//                        ContextCompat.getColor(YuMain.this,R.color.colorBlue)
//                );
//            }

//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                tabList.get(tab.getPosition()).setIcon(ImageManager.imageID[tab.getPosition()]);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}
