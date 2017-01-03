package com.later.fx.later.app;

import android.app.Application;
import android.content.Context;

import com.later.fx.later.BuildConfig;
import com.later.fx.later.R;
import com.later.fx.later.di.NetComponent;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by fx on 2016/12/26 0026.
 */

public class FXApplication extends Application {

    private static FXApplication instance;

    public static FXApplication get(Context context) {
        return (FXApplication) context.getApplicationContext();
    }

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();

        initDatabase();
        initTypeFace();
    }

    private void initLogger() {
        LogLevel logLevel;
        if (!BuildConfig.API_ENV) {
            logLevel = LogLevel.FULL;
        } else {
            logLevel = LogLevel.NONE;
        }
        Logger.init("GitFxLater")                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                .logLevel(logLevel);       // default LogLevel.FULL
    }


    private void initDatabase() {

    }

    private void initTypeFace() {
        CalligraphyConfig calligraphyConfig = new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/PMingLiU.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
        CalligraphyConfig.initDefault(calligraphyConfig);
    }


    public static FXApplication getInstance() {
        return instance;
    }
}
