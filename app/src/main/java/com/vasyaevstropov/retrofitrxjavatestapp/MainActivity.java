package com.vasyaevstropov.retrofitrxjavatestapp;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://taisondigital.com.ph/")
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Observable<MessageModel> observable = apiService.getAllMessages();
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseData-> {
                    for (int i = 0; i <responseData.getData().length ; i++) {
                        list.add(responseData.getData()[i].getMessage());
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
