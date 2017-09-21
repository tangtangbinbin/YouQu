package com.bintangkeji.youqu.Activity.Main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bintangkeji.youqu.Fragment.Fragment_BenBen;
import com.bintangkeji.youqu.Fragment.Fragment_FuWu;
import com.bintangkeji.youqu.Fragment.Fragment_My;
import com.bintangkeji.youqu.Fragment.Fragment_YouQu;
import com.bintangkeji.youqu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.rb_benben)
    RadioButton rbBenben;
    @BindView(R.id.rb_youqu)
    RadioButton rbYouqu;
    @BindView(R.id.rb_fuwu)
    RadioButton rbFuwu;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    private List<Fragment> fragments = new ArrayList<>();
    private Fragment currentfragment = new Fragment();
    private FragmentManager fragmentManager;
    private int currentIndex = 0;
    private static final String FRAGMENT_INDEX = "fragment_index";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getFragmentManager();
        if (savedInstanceState != null) {//被系统重启时
            currentIndex = savedInstanceState.getInt(FRAGMENT_INDEX, 0);
            fragments.removeAll(fragments);
            fragments.add(fragmentManager.findFragmentByTag(0 + ""));
            fragments.add(fragmentManager.findFragmentByTag(1 + ""));
            fragments.add(fragmentManager.findFragmentByTag(2 + ""));
            fragments.add(fragmentManager.findFragmentByTag(3 + ""));
            recoverFragment();
        } else {
            fragments.add(new Fragment_BenBen());
            fragments.add(new Fragment_YouQu());
            fragments.add(new Fragment_FuWu());
            fragments.add(new Fragment_My());
            showFragment();
        }

    }

    //被系统销毁时保存当前tag
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(FRAGMENT_INDEX, currentIndex);
        super.onSaveInstanceState(outState);
    }


    //显示fragemnt
    private void showFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!fragments.get(currentIndex).isAdded()) {//如果没有添加则添加
            transaction.hide(currentfragment)
                    .add(R.id.main_content, fragments.get(currentIndex), currentIndex + "");
            currentfragment = fragments.get(currentIndex);
            transaction.commit();
        } else {
            transaction.hide(currentfragment)
                    .show(fragments.get(currentIndex));
            currentfragment = fragments.get(currentIndex);
            transaction.commit();
        }
    }

    //恢复显示fragment
    private void recoverFragment() {
        FragmentTransaction recoverTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == currentIndex) {
                recoverTransaction.show(fragments.get(currentIndex));
            } else {
                recoverTransaction.hide(fragments.get(currentIndex));
            }
        }
        recoverTransaction.commit();
        currentfragment = fragments.get(currentIndex);
    }

    @OnClick({R.id.rb_benben, R.id.rb_youqu, R.id.rb_fuwu, R.id.rb_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_benben:
                currentIndex = 0;
                break;
            case R.id.rb_youqu:
                currentIndex = 1;
                break;
            case R.id.rb_fuwu:
                currentIndex = 2;
                break;
            case R.id.rb_my:
                currentIndex = 3;
                break;
        }
        showFragment();
    }
}
