package com.bintangkeji.youqu.widget;


import com.bintangkeji.youqu.model.ChatModel;
import com.bintangkeji.youqu.model.ItemModel;

import java.util.ArrayList;

/**
 * Created by：Administrator on 2015/12/21 16:43
 */
public class InitData {

    public static ArrayList<ItemModel> getInitData() {
        ArrayList<ItemModel> models = new ArrayList<>();
        ChatModel model = new ChatModel();
        model.setContent("你好,我是笨笨 你可以随便问我什么，反正我也只会胡说八道~");
        model.setIcon("http://p2.so.qhimgs1.com/bdr/_240_/t01aed59d8044c2c192.jpg");
        models.add(new ItemModel(ItemModel.CHAT_A, model));
        return models;
    }

}
