package com.bintangkeji.youqu.Net;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/9/8 0008.
 */

public interface BenBenService {
    @GET("efficient/robot?")
    Call<ResponseBody> listRepos(@QueryMap Map<String,String> map);
}
