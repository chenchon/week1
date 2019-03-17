package com.bawei.mymvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.bawei.mymvp.adapter.NewAdapter;
import com.bawei.mymvp.bean.JsonBean;
import com.bawei.mymvp.bean.One;
import com.bawei.mymvp.mvp.model.Model;
import com.bawei.mymvp.mvp.presenter.Presenter;
import com.bawei.mymvp.mvp.view.View;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View {
    private Presenter presenter;
    private XRecyclerView x_recy;
    private NewAdapter newAdapter;
    private ArrayList<One> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x_recy = findViewById(R.id.x_recy);
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        x_recy.setLayoutManager(linearLayoutManager);
        newAdapter = new NewAdapter(this);
        x_recy.setAdapter(newAdapter);
        x_recy.setLoadingMoreEnabled(true);
        x_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.doData();
            }

            @Override
            public void onLoadMore() {
                presenter.doData();
            }
        });
        presenter = new Presenter(new Model(), this);
        presenter.doData();
    }

    @Override
    public void success(String data) {
        JsonBean jsonBean = new Gson().fromJson(data, JsonBean.class);
        list = jsonBean.getResults();
        newAdapter.setData(list);
        Log.i("aaa",list.toString());
        x_recy.refreshComplete();
        x_recy.loadMoreComplete();
    }

    @Override
    public void bai() {
        x_recy.refreshComplete();
        x_recy.loadMoreComplete();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destory();
    }
}
