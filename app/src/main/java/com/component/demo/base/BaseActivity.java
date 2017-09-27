package com.component.demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jiahongfei on 2017/8/17.
 */

public class BaseActivity extends AppCompatActivity {

//    private Unbinder unbinder;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        EventBus.getDefault().register(this);
//
//    }
//
//    @Override
//    public void onContentChanged() {
//        super.onContentChanged();
//
//        unbinder = ButterKnife.bind(this);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        EventBus.getDefault().unregister(this);
//
//        if (unbinder != null) {
//            unbinder.unbind();
//            unbinder = null;
//        }
//    }
//
//    protected void showLoadingView() {
////        TODO:显示网络加载对话框
//    }
//
//    protected void dismissLoadingView() {
////        TODO:隐藏网络加载对话框
//    }
}
