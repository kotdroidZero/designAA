package com.error_found.kotdroid.designa;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user12 on 5/2/18.
 */

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int HEADER=0;
    static final int ITEM=1;
    Context context;
    List<PicModel> list;

   /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date;//1 = sdf.parse("2009-12-31");*/

    public GridAdapter(Context context) {
        this.context = context;
        setData();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType)
        {
            case HEADER:
                return new HeaderHolder(LayoutInflater.from(context)
                .inflate(R.layout.header,parent,false));
            case ITEM:
                return new GridViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.ite_grid,parent,false));
                default:                return new GridViewHolder(LayoutInflater.from(context)
                        .inflate(R.layout.ite_grid,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER) {
            if (holder instanceof HeaderHolder)
                ((HeaderHolder) holder).tvHeader.setText(list.get(position).month);

        } else if (getItemViewType(position) == ITEM)
        {
            if (holder instanceof GridViewHolder)
                ((GridViewHolder) holder).ivImage.setImageResource(list.get(position).image);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (!(list.size()-position<=1)){
            return !list.get(position).month.equalsIgnoreCase(list.get(position+1).month)? HEADER :ITEM;
        }
        else return ITEM;
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_image)
        ImageView ivImage;
        public GridViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class HeaderHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_header)
        TextView tvHeader;
        public HeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private void setData()  {
        list=new ArrayList<>();
        list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"January"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"February"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"March"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"April"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"May"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
      list.add(new PicModel(R.mipmap.ic_launcher_round,"June"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"July"));
        list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));
       list.add(new PicModel(R.mipmap.ic_launcher_round,"December"));


        Collections.sort(list, new Comparator<PicModel>() {
            @Override
            public int compare(PicModel picModel, PicModel t1) {
                return picModel.month.compareTo(t1.month);
            }
        });

    }
}
