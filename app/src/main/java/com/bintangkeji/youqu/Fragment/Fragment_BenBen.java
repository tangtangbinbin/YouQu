package com.bintangkeji.youqu.Fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bintangkeji.youqu.Adapter.ChatAdapter;
import com.bintangkeji.youqu.widget.InitData;
import com.bintangkeji.youqu.Net.BenBenService;
import com.bintangkeji.youqu.R;
import com.bintangkeji.youqu.model.ChatModel;
import com.bintangkeji.youqu.model.ItemModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class Fragment_BenBen extends Fragment {

    @BindView(R.id.recyclerView)
    android.support.v7.widget.RecyclerView recyclerView;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.tvSend)
    TextView tvSend;
    Unbinder unbinder;
    private ChatAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_benben, container, false);
        unbinder = ButterKnife.bind(this, view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter = new ChatAdapter());
        adapter.replaceAll(InitData.getInitData());
        initData();
        return view;
    }

    private void initData() {
        tvSend.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ArrayList<ItemModel> data = new ArrayList<>();
                ChatModel model = new ChatModel();
                model.setIcon("http://p3.so.qhmsg.com/bdr/_240_/t0158f094a401d44758.jpg");
                model.setContent(et.getText().toString());
                data.add(new ItemModel(ItemModel.CHAT_B, model));
                adapter.addAll(data);
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(adapter.getItemCount()-1);
                //hideKeyBorad(et);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://apis.haoservice.com/")
                        .build();
                BenBenService service = retrofit.create(BenBenService.class);
                Map<String,String> map = new HashMap<String, String>();
                map.put("key","4ceb8d209f574165b5b8af45556b2022");
                map.put("info",et.getText().toString());
                et.setText("");
                Call<ResponseBody> repos = service.listRepos(map);
                repos.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String result = response.body().string();
                            Log.w("result1",result);
                            JSONObject obj = new JSONObject(result);
                            String error_code = obj.getString("error_code");
                            if (error_code.equals("0")){
                                JSONObject resultobj = obj.getJSONObject("result");
                                String text = resultobj.getString("text");
                                ChatModel mode2 = new ChatModel();
                                mode2.setContent(text);
                                mode2.setIcon("http://p2.so.qhimgs1.com/bdr/_240_/t01aed59d8044c2c192.jpg");
                                ArrayList<ItemModel> data = new ArrayList<>();
                                data.add(new ItemModel(ItemModel.CHAT_A,mode2));
                                adapter.addAll(data);
                                adapter.notifyDataSetChanged();
                                recyclerView.scrollToPosition(adapter.getItemCount()-1);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void hideKeyBorad(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }
}
