package com.error_found.kotdroid.designa;

import android.app.FragmentTransaction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    StoreAdapter adapter;
    GridAdapter adapter1;
    GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*getFragmentManager().beginTransaction().add(R.id.fl_container,new OneFragment())
                .setReorderingAllowed(true)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
*/
        adapter = new StoreAdapter(this);
       /* recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);*/
        adapter1=new GridAdapter(this);

        manager=new GridLayoutManager(this,3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){

            @Override
            public int getSpanSize(int position) {
                int type=recyclerView.getAdapter().getItemViewType(position);
                return type==0?3:1;
            }
        });
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter1);
    }



    public void loadMoreDataToList()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setMoreData();
                adapter.updateList();
                Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
            }
        },3000);
    }


}
