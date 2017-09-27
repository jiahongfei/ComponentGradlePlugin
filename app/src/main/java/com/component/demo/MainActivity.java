package com.component.demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.component.demo.base.BaseActivity;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainLayout);
            mainLayout.setSystemUiVisibility(SYSTEM_UI_FLAG_IMMERSIVE_STICKY | SYSTEM_UI_FLAG_FULLSCREEN);
        }
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textView) {
            try {
                Intent intent = new Intent(this, Class.forName("com.component.library.Module1Activity"));
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if(v.getId() == R.id.textView2){
            try {
                Intent intent = new Intent(this, Class.forName("com.component.library2.Module2Activity"));
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
