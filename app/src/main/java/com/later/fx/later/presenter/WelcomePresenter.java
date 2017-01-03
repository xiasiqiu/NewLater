package com.later.fx.later.presenter;

import com.later.fx.later.app.FXApplication;
import com.later.fx.later.model.ApiService;
import com.later.fx.later.model.entity.WelcomeEntity;
import com.later.fx.later.util.NetUtil;
import com.later.fx.later.util.OkHttpImageDownloader;
import com.later.fx.later.util.TimeUtil;
import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 21:01
 */

public class WelcomePresenter implements WelcomeContract.Presenter {
    private WelcomeContract.View view;
    private ApiService apiService;

    @Inject
    public WelcomePresenter(WelcomeContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
        Logger.d("app:" + apiService);
    }

    @Override
    public void getWelcome(String deviceId) {
        String client = "android";
        String version = "1.3.0";
        Long time = TimeUtil.getCurrentSeconds();
        apiService.getWelcome(client, version, time, deviceId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<WelcomeEntity>() {
                               @Override
                               public void onCompleted() {
                                   Logger.e("load welcoemImage onCompleted");
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Logger.e("load welcoemImage Error");
                               }

                               @Override
                               public void onNext(WelcomeEntity welcomeEntity) {
                                   if (NetUtil.isWifi(FXApplication.getInstance().getApplicationContext())) {
                                       if (welcomeEntity != null) {
                                           List<String> imgs = welcomeEntity.getImages();
                                           for (String url : imgs) {
                                               OkHttpImageDownloader.download(url);
                                           }
                                       }
                                   } else {
                                       Logger.i("不是wifi");
                                   }
                               }
                           }


                );


    }
}
