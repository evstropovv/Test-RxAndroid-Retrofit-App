package com.vasyaevstropov.retrofitrxjavatestapp.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface APIService {
    @GET("uapi/shop/request?page=categories")
    Call<List<Success>> getShopList(@Query("oauth_consumer_key") String oauth_consumer_key,
                                    @Query("oauth_consumer_secret") String oauth_consumer_secret,
                                    @Query("oauth_token") String oauth_token,
                                    @Query("oauth_token_secret") String oauth_token_secret);
}
