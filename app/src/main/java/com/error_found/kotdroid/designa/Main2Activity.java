package com.error_found.kotdroid.designa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.error_found.kotdroid.designa.models.Main3Activity;
import com.error_found.kotdroid.designa.models.SerializableModel;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SerializableModel model=new SerializableModel();
        model.id=4;
        model.name="sam";

        Bundle bundle=new Bundle();
        for (int i=0;i<1000;i++)
        {
            bundle.putSerializable("model1",model);
            Log.e("tag","success");

        }





    }
}
