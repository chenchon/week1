package com.bawei.mymvp.net;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @Author：陈冲
 * @E-mail： 1586503085@qq.com
 * @Date：2019/3/17 12:11
 * @Description：描述信息
 */
public class HttpUtils {
    private Httplistner listner;
    private int HTTP_SUCCESS = 1000;
    private int HTTP_BAI = 1001;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == HTTP_SUCCESS){
                String data = (String) msg.obj;
                listner.success(data);
            }else {
                listner.bai();
            }
        }
    };
    public void result(Httplistner listner){
        this.listner=listner;
    }
    public HttpUtils get(String url){
        doHttp(url,0,null);
        return this;
    }public HttpUtils post(String url,FormBody.Builder bodybuid){
        doHttp(url,1,bodybuid);
        return this;
    }

    private void doHttp(String url, int type, FormBody.Builder bodybuid) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LanJie()).build();
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        Request request = builder.build();
        final Message message = Message.obtain();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            message.what=HTTP_BAI;
            handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.obj=response.body().string();
                message.what=HTTP_SUCCESS;
                handler.sendMessage(message);
            }
        });
    }

    public interface Httplistner{
        void success(String data);
        void bai();
    }
    public class LanJie implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            boolean https = request.isHttps();
            return chain.proceed(request);
        }
    }
}
