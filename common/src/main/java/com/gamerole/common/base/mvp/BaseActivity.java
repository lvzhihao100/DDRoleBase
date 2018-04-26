package com.gamerole.common.base.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gamerole.common.base.AppManager;
import com.gamerole.common.util.ToastUtil;

import java.util.Date;
import java.util.Stack;

import butterknife.ButterKnife;

/**
 * Created by Lee on 2018/1/25 0025.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView{
    public T mPresenter;
    public BaseActivity mActivity;
    private static long oldTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTheme();
        setContentView(getLayoutResId());
        mActivity = this;
        mPresenter = getPresenter();
        mPresenter.attachView(this, this);
        onViewBinding();
        initView();
        initData();
    }

    protected  void initData(){}

    protected  void initView(){}

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    private void initTheme() {

    }

    /**
     * 初始化布局ID
     * @return
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化当前View 的 presenter
     * @return
     */
    public abstract T getPresenter();

    /**
     * 初始化
     */
    protected  void onViewBinding(){};

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.cancelRequest();
        mPresenter.detachView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Stack<Activity> allActivities = AppManager.getAppManager().getAllActivities();
        if (allActivities.size() <= 1) {
            long nowTime = new Date().getTime();
            if (nowTime - oldTime <= 2000) {
                AppManager.getAppManager().AppExit(this);
            } else {
                oldTime = nowTime;
                ToastUtil.showShort("再次点击退出程序");
            }
        } else {
            super.onBackPressed();
        }
    }
}
