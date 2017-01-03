package com.later.fx.later.di.components;

import com.later.fx.later.di.NetComponent;
import com.later.fx.later.di.modules.WelcomeModule;
import com.later.fx.later.di.scopes.UserScope;
import com.later.fx.later.view.activity.WelcomeActivity;

import dagger.Component;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 20:36
 */
@UserScope
@Component(modules = WelcomeModule.class,dependencies = NetComponent.class)
public interface WelcomeComponent {
    void inject(WelcomeActivity welcomeActivity);
}
