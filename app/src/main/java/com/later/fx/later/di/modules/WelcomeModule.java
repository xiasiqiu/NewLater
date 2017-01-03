package com.later.fx.later.di.modules;

import com.later.fx.later.presenter.WelcomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 20:36
 */
@Module
public class WelcomeModule {
    private WelcomeContract.View view;
    public WelcomeModule(WelcomeContract.View view){
        this.view=view;
    }
    @Provides
    public WelcomeContract.View provideView(){
        return view;
    }
}
