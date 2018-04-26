package com.gamerole.ddrolebase.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gamerole.common.base.CommonService;
import com.gamerole.common.room.DBHelper;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * <pre>
 *     author : 吕志豪
 *     e-mail : 1030753080@qq.com
 *     time   : 2018/04/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class MyApplication extends Application {
    @Autowired
    CommonService commonService;

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        UIRouter.getInstance().registerUI("app");
        DBHelper.getInstance().init(this);
        commonService.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
