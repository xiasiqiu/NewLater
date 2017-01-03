package com.later.fx.later.model;

import com.later.fx.later.model.entity.WelcomeEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fx on 2016/12/26 0026.
 */

public interface ApiService {

    /**
     *
     * @param client
     * @param version
     * @param time
     * @param deviceId
     * @return
     */
    @GET("static/picture_list.text")
    Observable<WelcomeEntity>getWelcome(@Query("client")String client,@Query("version")String version,@Query("time")Long time,@Query("device_id")String deviceId);
}
