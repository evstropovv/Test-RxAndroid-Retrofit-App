package com.vasyaevstropov.retrofitrxjavatestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.vasyaevstropov.retrofitrxjavatestapp.Retrofit.APIService;
import com.vasyaevstropov.retrofitrxjavatestapp.Retrofit.RetroClient;
import com.vasyaevstropov.retrofitrxjavatestapp.Retrofit.Success;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

//    json downloaded from http://taisondigital.com.ph/testforyou/all-messages
//    http://pojo.sodhanalibrary.com/


    RecyclerView rvListContainer;
    MessageAdapter adapter;
    List<String > list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListContainer =(RecyclerView)findViewById(R.id.rcView);
        rvListContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MessageAdapter(list);
        rvListContainer.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RetroClient.getApiService().getShopList("artmurka", "CUchqePQNHIuQ6ceMfaziBOLI42sah", "X0S3jMEVlOvxAQSsIZ40zeYzYvOnthchpK.abu1d", "6Gcq2RVe02fL3qUk8hsVaXmri92y5NpHP3RzXA6a")
                .enqueue(new Callback<List<Success>>() {
            @Override
            public void onResponse(Call<List<Success>> call, Response<List<Success>> response) {

                Log.d("Log.d", call.toString() + response.toString());
            }

            @Override
            public void onFailure(Call<List<Success>> call, Throwable t) {

            }
        });



//        Observable<MessageModel> observable = apiService.getAllMessages(); //request from retrofit
//        observable.subscribeOn(Schedulers.newThread()) //subscribe in new thread
//                .observeOn(AndroidSchedulers.mainThread()) //result in main thread
//                .subscribe(responseData-> {
//                    for (int i = 0; i <responseData.getData().length ; i++) {
//                        list.add(responseData.getData()[i].getMessage());
//                        adapter.notifyDataSetChanged();
//                    }
//                });


    }
}
