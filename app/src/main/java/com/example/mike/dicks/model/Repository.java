package com.example.mike.dicks.model;

import com.example.mike.dicks.model.remote_data_source.RemoteDataSource;
import com.example.mike.dicks.model.venue_gson.Venues;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    public static void getVenues(final Callback callback ){
        RemoteDataSource.getVenues()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Venues>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Venues venues) {
                callback.onSuccess(venues);
            }

            @Override
            public void onError(Throwable e) {
                callback.onFailure(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public interface Callback{
        void onSuccess( Venues venues );
        void onFailure( Throwable e );
    }

}
