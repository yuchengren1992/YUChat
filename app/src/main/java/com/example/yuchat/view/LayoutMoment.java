package com.example.yuchat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuchat.R;

/**
 * Created by Administrator on 2017/6/6.
 */

public class LayoutMoment extends Fragment{

    private View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview=(View)inflater.inflate(R.layout.layout_moment,container,false);
        return rootview;
    }
}
