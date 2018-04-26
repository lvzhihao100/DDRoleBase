package com.gamerole.common.base.mvp;

import android.content.Context;

import com.gamerole.common.base.Common;
import com.gamerole.common.base.ILoadView;
import com.lzy.okgo.OkGo;


import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;

/**
 * eated by Lee on 2018/1/25 0025.
 */
public class BasePresenter<VIEW extends IBaseView> {
    public VIEW mView;
    private WeakReference<VIEW> mReference;
    public Context mContext;
    private ILoadView mProgressDialogs;


    public Context getContext() {
        return mContext;
    }

    public void setProgressDialogs(ILoadView mProgressDialogs) {
        this.mProgressDialogs = mProgressDialogs;
    }

    /**
     * 绑定View
     *
     * @param view
     * @param context
     */
    public void attachView(VIEW view, Context context) {
        mReference = new WeakReference<VIEW>(view);
        mView = mReference.get();
        mContext = context;
        if (mProgressDialogs == null) {
            try {
                Class<?> aClass = Class.forName(Common.getDefaultLoadView().getClass().getName());
                Constructor constructor = aClass.getConstructor(Context.class);
                mProgressDialogs = (ILoadView) constructor.newInstance(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void showLoading() {
        if (mProgressDialogs!=null){
            mProgressDialogs.showLoading();
        }
    }

    public void hideLoading() {
        if (mProgressDialogs!=null){
            mProgressDialogs.hideLoading();
        }
    }

    /**
     * 解除绑定
     */
    public void detachView() {
        if (mReference != null) {
            mReference.clear();
        }
    }

    public void cancelRequest() {
        OkGo.getInstance().cancelTag(this);
    }

}
