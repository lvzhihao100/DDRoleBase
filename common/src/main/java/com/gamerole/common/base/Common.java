package com.gamerole.common.base;

import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName：（项目名称）
 * DESC: (类描述)
 * Created by 吕志豪 on 2018/04/25 10:34
 * updateName:(吕志豪)
 * updateTime:(10:34)
 * updateDesc:(修改内容)
 */

public  class Common {
    private static Map<String, Class<? super ILoadView>> loadViewMap = new HashMap<>();
    private static String defaultLoadViewTag;

    public static void addLoadView(String tag, Class<? super ILoadView> clazz) {
        loadViewMap.put(tag, clazz);
    }
    public static void setDefautLoadView(String tag){
        Class<? super ILoadView> aClass = loadViewMap.get(tag);
        if(aClass!=null){
            defaultLoadViewTag =tag;
        }else {
            throw new IllegalStateException("没有添加该Tag的LoadView");

        }
    }
    public static Class<? super ILoadView> getDefaultLoadView(){
        return loadViewMap.get(defaultLoadViewTag);
    }

}
