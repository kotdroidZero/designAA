package com.error_found.kotdroid.designa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user12 on 5/2/18.
 */

public class StoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 1;
    public static final int LOADER = 3;
    List<ModelStore> modelStoreList=new ArrayList<>();
    Context context;
    private boolean loading=true;

    public StoreAdapter( Context context) {

        this.context = context;
        setData();
    }

    private void setData() {



        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Solitaire", 10, 4.2, "FREE", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Subway Surfers", 53, 4.6, "FREE", 1));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Ninza", 10, 4.2, "FREE", 1));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Asphalt 8", 500, 4.9, "100 Rs.", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Maze Runner", 645, 4, "2000 Rs.", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Solitaire", 10, 4.2, "FREE", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Subway Surfers", 53, 4.6, "FREE", 1));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Ninza", 10, 4.2, "FREE", 1));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Asphalt 8", 500, 4.9, "100 Rs.", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Maze Runner", 645, 4, "2000 Rs.", 0));

    }

    public void setMoreData()
    {
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Solitaire", 10, 4.2, "FREE", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Subway Surfers", 53, 4.6, "FREE", 1));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Ninza", 10, 4.2, "FREE", 1));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Asphalt 8", 500, 4.9, "100 Rs.", 0));
        modelStoreList.add(new ModelStore(R.mipmap.ic_launcher_round,
                "Maze Runner", 645, 4, "2000 Rs.", 0));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case POSITION_LEFT:
                return new ViewHolderLeft(LayoutInflater.from(context)
                        .inflate(R.layout.row_item_left, parent, false));
            case POSITION_RIGHT:
                return new ViewHolderLeft(LayoutInflater.from(context)
                        .inflate(R.layout.row_item_right, parent, false));
            case LOADER:
                return new ViewHolderFooterLoader(LayoutInflater.from(context)
                        .inflate(R.layout.footer_loader, parent, false));

        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolderLeft) {
            ((ViewHolderLeft) holder).tvSize.setText(modelStoreList.get(position).size + " MB ");
            ((ViewHolderLeft) holder).tvName.setText(modelStoreList.get(position).name);
            ((ViewHolderLeft) holder).tvPrice.setText(modelStoreList.get(position).price);
            ((ViewHolderLeft) holder).tvRating.setText(modelStoreList.get(position).rating + "*");
        } else if (holder instanceof ViewHolderRight) {

            ((ViewHolderRight) holder).tvSize.setText(modelStoreList.get(position).size + " MB ");
            ((ViewHolderRight) holder).tvName.setText(modelStoreList.get(position).name);
            ((ViewHolderRight) holder).tvPrice.setText(modelStoreList.get(position).price);
            ((ViewHolderRight) holder).tvRating.setText(modelStoreList.get(position).rating + "*");
        }
        else if (holder instanceof ViewHolderFooterLoader)
        {
            if (loading)
            {
                ((ViewHolderFooterLoader) holder).progressBar.setVisibility(View.VISIBLE);
                if (modelStoreList.size()<100)
                {

                    ((MainActivity)context).loadMoreDataToList();
                    //load more from activity
                    //set boolean loading to true
                    setLoaded(true);
                }
                if (modelStoreList.size()==100)
                {
                    ((ViewHolderFooterLoader) holder).progressBar.setVisibility(View.GONE);
                    //setboolean to false
                    setLoaded(false);
                    ((ViewHolderFooterLoader) holder).tvDone.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                ((ViewHolderFooterLoader) holder).progressBar.setVisibility(View.GONE);
                //setboolean loaded to false
                setLoaded(false);
            }
        }




    }

    private void setLoaded(boolean isLoading)
    {
        loading=isLoading;
    }

    public void updateList()
    {
        notifyDataSetChanged();
    }
    @Override
    public int getItemViewType(int position) {
        if (position == modelStoreList.size()) {
            return LOADER;
        }
        return modelStoreList.get(position).position;

    }

    @Override
    public int getItemCount() {
        return modelStoreList.size() + 1;
    }

    public class ViewHolderLeft extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_rating)
        TextView tvRating;
        @BindView(R.id.tv_size)
        TextView tvSize;

        public ViewHolderLeft(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ViewHolderRight extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_rating)
        TextView tvRating;
        @BindView(R.id.tv_size)
        TextView tvSize;

        public ViewHolderRight(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ViewHolderFooterLoader extends RecyclerView.ViewHolder {

        @BindView(R.id.progressbar)
        ProgressBar progressBar;
        @BindView(R.id.tv_done)
        TextView tvDone;

        public ViewHolderFooterLoader(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
