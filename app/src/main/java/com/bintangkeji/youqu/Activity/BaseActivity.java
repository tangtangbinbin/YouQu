package com.bintangkeji.youqu.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class BaseActivity extends AppCompatActivity {

    //退出程序
    private static final String ACTION_EXIT_APPLICATION = "exit_application";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    protected class BaseActivityReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_EXIT_APPLICATION)){
                finish();
            }
        }
    }
}
