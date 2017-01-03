package com.later.fx.later.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 20:58
 */

public  abstract class BaseActivity extends AppCompatActivity{

    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }
    protected void attachBaseContext(Context context){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }
}
