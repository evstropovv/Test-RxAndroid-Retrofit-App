package com.vasyaevstropov.retrofitrxjavatestapp;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Вася on 14.06.2017.
 */

public interface APIService {
    @GET("testforyou/all-messages")
    Observable<MessageModel> getAllMessages();


}
