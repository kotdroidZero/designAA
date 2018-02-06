package com.error_found.kotdroid.designa.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.error_found.kotdroid.designa.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        SerializableModel model= (SerializableModel) getIntent().getExtras()
                .getSerializable("model1");

    }
}
