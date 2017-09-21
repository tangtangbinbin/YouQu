package com.bintangkeji.youqu.Application;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class MyLeanCloudApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"uvhsagtOVso2nCAvCh32jhGX-gzGzoHsz","9FlciUqxomaGeLURvHiWaM7A");
    }
}
