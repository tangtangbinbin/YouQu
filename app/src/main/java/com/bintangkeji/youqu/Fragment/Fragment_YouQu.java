package com.bintangkeji.youqu.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bintangkeji.youqu.R;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class Fragment_YouQu extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_youqu,container,false);
        return view;
    }
}
