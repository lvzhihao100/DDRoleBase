package com.gamerole.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gamerole.common.room.DBUtil;
import com.gamerole.common.room.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_main);
        User value = DBUtil.getUser().getValue();
    }
}
