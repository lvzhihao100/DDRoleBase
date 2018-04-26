package com.gamerole.common.v.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gamerole.common.R;
import com.gamerole.common.room.DBUtil;
import com.gamerole.common.room.User;
import com.gamerole.common.rxbus2.RxBus;
import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;
import com.lzy.okgo.OkGo;

/**
 * <pre>
 *     author : 吕志豪
 *     e-mail : 1030753080@qq.com
 *     time   : 2018/04/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@RouteNode(path = "/shareBook", desc = "分享书籍页面")
@Route(path = "/share/shareBook")
public class TestActivity extends AppCompatActivity {
    @Autowired
    String bookName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutowiredService.Factory.getInstance().create().autowire(this);
        setContentView(R.layout.common_activity_main);
        User user = new User();
        user.setId(1);
        user.setIdCard("2");
        DBUtil.insertUser(user);
        View viewById = findViewById(R.id.tv_content);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIRouter.getInstance().openUri(TestActivity.this,
                        "Role://test/test", null, 7777);
                ARouter.getInstance().build("/test/test")
                        .navigation();

            }
        });
        RxBus.getDefault().post(user);

    }
}
