package com.bawei.mymvp.mvp.presenter;

import android.view.Display;

import com.bawei.mymvp.mvp.model.Model;
import com.bawei.mymvp.mvp.model.Models;
import com.bawei.mymvp.mvp.view.View;

/**
 * @Author：陈冲
 * @E-mail： 1586503085@qq.com
 * @Date：2019/3/17 13:23
 * @Description：描述信息
 */
public class Presenter implements Presenters, Model.CallBacko {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void doData() {
        model.getData(this);
    }

    @Override
    public void success(String data) {
        view.success(data);
    }

    @Override
    public void bai() {
        view.bai();
    }
    public void destory(){
        if (model!=null){
            model = null;
        }
        if (view!=null){
            view = null;
        }
    }
}
