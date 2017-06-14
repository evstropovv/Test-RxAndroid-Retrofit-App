package com.vasyaevstropov.retrofitrxjavatestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListContainer;
    MessageAdapter adapter;
    List<String > list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListContainer =(RecyclerView)findViewById(R.id.rcView);
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
        observable.subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(responseData-> {
                    for (int i = 0; i <responseData.getData().length ; i++) {
                        list.add(responseData.getData()[i].getMessage());

                    }

                });

    }
}
