package com.component.library2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Module2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library2_activity_res2);

    }

    @Override
    public void onClick(View v) {
        try {
            Intent intent = new Intent(this, Class.forName("com.component.demo.liblibrary.Sub2Module1Activity"));
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
