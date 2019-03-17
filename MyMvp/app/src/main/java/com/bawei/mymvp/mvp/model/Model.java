package com.bawei.mymvp.mvp.model;

import com.bawei.mymvp.net.HttpUtils;

/**
 * @Author：陈冲
 * @E-mail： 1586503085@qq.com
 * @Date：2019/3/17 13:13
 * @Description：描述信息
 */
public class Model implements Models {
    @Override
    public void getData(final CallBacko callBacko) {
        new HttpUtils().get("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1").result(new HttpUtils.Httplistner() {
            @Override
            public void success(String data) {
                callBacko.success(data);
            }

            @Override
            public void bai() {
                callBacko.bai();
            }
        });
    }
}
