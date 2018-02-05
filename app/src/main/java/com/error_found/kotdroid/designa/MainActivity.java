package com.error_found.kotdroid.designa;

import android.app.FragmentTransaction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<ModelStore> modelStoreList;
    StoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*getFragmentManager().beginTransaction().add(R.id.fl_container,new OneFragment())
                .setReorderingAllowed(true)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
*/      modelStoreList = new ArrayList<>();
        setData();
        adapter = new StoreAdapter(modelStoreList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
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

    public void loadMoreDataToList()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
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
                adapter.updateList();
                Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
            }
        },3000);
    }
}
