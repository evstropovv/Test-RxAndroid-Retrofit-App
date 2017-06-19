package com.vasyaevstropov.retrofitrxjavatestapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Вася on 19.06.2017.
 */

public class RetroClient {
    private static final String MURKA_URL = "http://artmurka.com/";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(MURKA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getApiService(){
        return getRetrofitInstance().create(APIService.class);
    }

}
