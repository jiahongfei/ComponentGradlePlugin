package com.component.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jiahongfei on 2017/8/18.
 */

public class Module1Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_res);
    }

    @Override
    public void onClick(View view){
        try {
            Intent intent = new Intent(this, Class.forName("com.component.demo.liblibrary.Sub2Module1Activity"));
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
