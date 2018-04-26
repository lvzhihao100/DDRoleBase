package com.gamerole.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/test" ,desc = "测试页面")
@Route(path = "/test/test" )
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);
    }
}
