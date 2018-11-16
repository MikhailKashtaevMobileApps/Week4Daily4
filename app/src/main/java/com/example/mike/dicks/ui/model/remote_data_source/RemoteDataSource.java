package com.example.mike.dicks.ui.model.remote_data_source;

import com.example.mike.dicks.ui.model.venue_gson.Venues;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RemoteDataSource {

    public static Observable<Venues> getVenues(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://movesync-qa.dcsg.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create( Service.class ).getVenues();
    }


    private interface Service{
        @GET("dsglabs/mobile/api/venue/")
        Observable<Venues> getVenues();
    }
}

