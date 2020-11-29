package com.syb.demo4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static java.lang.System.out;

/**
 * @author shenyb
 * @time 2020-11-28 20:00
 */
public class ThreadModel {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                out.println("Thread1 name:" + Thread.currentThread().getName());
                observableEmitter.onNext("hello world");
            }
        });
        observable.subscribeOn(Schedulers.newThread())
                .subscribe(data ->
                        {
                            out.println(data);
                            out.println("Thread2 name:" + Thread.currentThread().getName());
                        },
                        err -> out.println(err),
                        () -> out.println("just complete"));

        Thread.sleep(3000);
    }
}
