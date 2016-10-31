package com.blankj.androidutilcode;

import android.app.Application;
import android.os.Handler;
import android.os.Message;

import com.blankj.utilcode.utils.CrashUtils;
import com.blankj.utilcode.utils.LogUtils;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/12
 *     desc  :
 * </pre>
 */
public class App extends Application {

    private static App ourInstance;

    public static App getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        CrashUtils.getInstance().init(this);
        LogUtils.getBuilder(this).setTag("MyTag").setLog2FileSwitch(true).create();
    }
}
