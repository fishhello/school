package com.example.sha.fish03.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sha.fish03.CurrentItemActivity;
import com.example.sha.fish03.R;
import com.example.sha.fish03.entity.EssayItem;
import com.example.sha.fish03.utils.LogUtil;

import java.util.List;

/**
 * 建立一个adapter数据源，可以给AdapterView提供数据，并根据数据创建对应的UI
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private static final String TAG = "ListAdapter";

    private Context mContext;
    private List<EssayItem> mEssayItem;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView essayImage;
        TextView essayName;
        //TextView essayText;
        public ViewHolder(View view) {
            super(view);
            cardView=(CardView)view;
            essayImage=(ImageView)view.findViewById(R.id.essay_image);
            essayName=(TextView)view.findViewById(R.id.essay_name);
            //essayText=(TextView)view.findViewById(R.id.ess)
        }
    }

    public ListAdapter(List<EssayItem> mFruitList) {
        this.mEssayItem = mFruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.essay_item,parent,false);
//点击显示的资源后进入详细页面
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前点击
                //int position = holder.getAdapterPosition();
               // getState((Integer) v.getTag());
                int position =  (Integer) v.getTag();
                /*if(position == -1)+1
                    return;*/
                EssayItem fruit = mEssayItem.get(position);
                Intent intent = new Intent(mContext, CurrentItemActivity.class);
                /*intent.putExtra(CurrentItemActivity.FRUIT_NAME, fruit.getEssayTitle());
                intent.putExtra(CurrentItemActivity.FRUIT_IMAGE_ID, fruit.getImageId());*/
                Bundle bundle = new Bundle();
                bundle.putSerializable("currentCItem", fruit);
                intent.putExtras(bundle);
                LogUtil.i(TAG,fruit.toString());
                mContext.startActivity(intent);

            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        EssayItem essay=mEssayItem.get(position);
        holder.essayName.setText(essay.getEssayTitle());
        //holder.
        Glide.with(mContext).load(essay.getImageId()).into(holder.essayImage);
        holder.itemView.setTag(position);
    }

    /**
     * 返回数据源数量
     * @return
     */
    @Override
    public int getItemCount() {
        return mEssayItem.size();
    }
}
