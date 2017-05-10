package com.blankj.androidutilcode.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.androidutilcode.Config;
import com.blankj.androidutilcode.R;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * <pre>
 *     author: Blankj
 *     blog : http://blankj.com
 *     time : 2016/10/13
 *     desc : App工具类Demo
 * </pre>
 */

public class AppActivity extends Activity
        implements View.OnClickListener {

    private String appPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        appPath = AppUtils.getAppPath();

        TextView tvAboutApp = (TextView) findViewById(R.id.tv_about_app);

        findViewById(R.id.btn_install_app).setOnClickListener(this);
        findViewById(R.id.btn_install_app_silent).setOnClickListener(this);
        findViewById(R.id.btn_uninstall_app).setOnClickListener(this);
        findViewById(R.id.btn_uninstall_app_silent).setOnClickListener(this);
        findViewById(R.id.btn_launch_app).setOnClickListener(this);
        findViewById(R.id.btn_get_app_details_settings).setOnClickListener(this);

        tvAboutApp.setText(AppUtils.getAppInfo().toString()
                + "\nisInstallTestApp: " + AppUtils.isInstallApp("com.blankj.testinstallapk")
                + "\nisAppRoot: " + AppUtils.isAppRoot()
                + "\nisAppDebug: " + AppUtils.isAppDebug()
                + "\nisTestAppDebug: " + AppUtils.isAppDebug(Config.TEST_PKG)
                + "\nAppSignatureSHA1: " + AppUtils.getAppSignatureSHA1()
                + "\nisAppForeground: " + AppUtils.isAppForeground()
                + "\nisTestForeground: " + AppUtils.isAppForeground(Config.TEST_PKG)
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_install_app:
                AppUtils.installApp(Config.getTestApkPath(), "com.blankj.androidutilcode.provider");
                break;
            case R.id.btn_install_app_silent:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppUtils.installAppSilent(appPath);
                    }
                }).start();
                break;
            case R.id.btn_uninstall_app:
                if (AppUtils.isInstallApp("com.blankj.testinstallapk")) {
                    AppUtils.uninstallApp(this.getPackageName());
                } else {
                    ToastUtils.showShort(R.string.app_uninstall_tips);
                }
                break;
            case R.id.btn_uninstall_app_silent:
                if (AppUtils.isInstallApp("com.blankj.testinstallapk")) {
                    if (AppUtils.uninstallAppSilent(this.getPackageName(), false)) {
                        ToastUtils.showShort("uninstall success");
                    }else {
                        ToastUtils.showShort("uninstall fail");
                    }
                } else {
                    ToastUtils.showShort(R.string.app_uninstall_tips);
                }
                break;
            case R.id.btn_launch_app:
                AppUtils.launchApp(this.getPackageName());
                break;
            case R.id.btn_get_app_details_settings:
                AppUtils.getAppDetailsSettings();
                break;
        }
    }
}
