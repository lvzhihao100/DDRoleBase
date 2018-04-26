package com.gamerole.ddrolebase;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gamerole.common.room.DBUtil;
import com.gamerole.common.room.User;
import com.gamerole.common.rxbus2.RxBus;
import com.gamerole.common.rxbus2.Subscribe;
import com.gamerole.common.rxbus2.ThreadMode;
import com.gamerole.common.util.SPUtil;
import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/main" ,desc = "主页面")
@Route(path = "/app/amin" )
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.tv_content);
        SPUtil.put("idCard","1");
        User user = new User();
        user.setId(1);
        user.setIdCard("1");
        DBUtil.insertUser(user);
        DBUtil.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                System.out.println("MainActivity"+user);
            }
        });
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UIRouter.getInstance().openUri(MainActivity.this,
//                        "Role://common/shareBook?bookName=Gone with the Wind", null, 7777);
                ARouter.getInstance().build("/share/shareBook")
                        .withString("bookName", "Gone with the Wind")
                        .navigation();

            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updataUser(User user){
        System.out.println("update"+user);
    }
}
