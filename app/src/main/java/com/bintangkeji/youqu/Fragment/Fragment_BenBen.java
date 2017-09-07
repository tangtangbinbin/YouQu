package com.bintangkeji.youqu.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bintangkeji.youqu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class Fragment_BenBen extends Fragment {

    @BindView(R.id.recylerView)
    android.support.v7.widget.RecyclerView recylerView;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.tvSend)
    TextView tvSend;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_benben, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.recylerView, R.id.et, R.id.tvSend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recylerView:
                break;
            case R.id.et:
                break;
            case R.id.tvSend:
                break;
        }
    }
}
