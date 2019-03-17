package com.bawei.mymvp.bean;

import java.util.ArrayList;

/**
 * @Author：陈冲
 * @E-mail： 1586503085@qq.com
 * @Date：2019/3/17 13:39
 * @Description：描述信息
 */
public class JsonBean {
    private ArrayList<One> results;

    public JsonBean(ArrayList<One> results) {
        this.results = results;
    }

    public ArrayList<One> getResults() {
        return results;
    }

    public void setResults(ArrayList<One> results) {
        this.results = results;
    }
}
