package com.gamerole.test.base;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
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

public class TestAppLike implements IApplicationLike {
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        uiRouter.registerUI("test");
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("test");
    }

}
