package com.gamerole.common.room;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;

/**
 * ProjectName：（项目名称）
 * DESC: (类描述)
 * Created by 吕志豪 on 2018/04/23 17:09
 * updateName:(吕志豪)
 * updateTime:(17:09)
 * updateDesc:(修改内容)
 */

public class UserLiveData extends LiveData<User> {
    private static UserLiveData sInstance;



    @MainThread
    public static UserLiveData get(String symbol) {
        if (sInstance == null) {
            sInstance = new UserLiveData(symbol);
        }
        return sInstance;
    }

    private UserLiveData(String symbol) {

    }

    @Override
    protected void onActive() {

    }

    @Override
    protected void onInactive() {
    }
}
