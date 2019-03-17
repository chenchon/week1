package com.bawei.mymvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.mymvp.MainActivity;
import com.bawei.mymvp.R;
import com.bawei.mymvp.bean.One;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @Author：陈冲
 * @E-mail： 1586503085@qq.com
 * @Date：2019/3/17 13:41
 * @Description：描述信息
 */
public class NewAdapter extends RecyclerView.Adapter<NewAdapter.MyviewHolder> {
    private ArrayList<One> list = new ArrayList<>();
    private Context context;

    public NewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item1, null);
        MyviewHolder myviewHolder = new MyviewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
        String type = list.get(i).getType();
        String url = list.get(i).getUrl();
        myviewHolder.text1.setText(type);
        Picasso.with(context).load(url).into(myviewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setData(ArrayList<One> list){
        this.list=list;
        notifyDataSetChanged();
    }
    public class MyviewHolder extends RecyclerView.ViewHolder{

        private  TextView text1;
        private  ImageView img;

        public MyviewHolder(@NonNull View itemView) {
        super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            img = itemView.findViewById(R.id.img);
        }
}


}
