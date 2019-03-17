package com.bawei.mymvp.mvp.model;

/**
 * @Author：陈冲
 * @E-mail： 1586503085@qq.com
 * @Date：2019/3/17 13:07
 * @Description：描述信息
 */
public interface Models {
    //接口
    interface CallBacko{
        void success(String data);
        void bai();
    }
    void getData(CallBacko callBacko);
}
