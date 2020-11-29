package com.syb.demo5;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.io.IOException;

/**
 * @author shenyb
 * @time 2020-11-29 09:17
 */
public class BackPressure {
    public static void main(String[] args) throws IOException {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> flowableEmitter) throws Exception {
                System.out.println("emit thread"+Thread.currentThread().getName());
                for(int i=0;i<200;i++){
                    flowableEmitter.onNext(i);
                }
            }
        }, BackpressureStrategy.LATEST)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.computation()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("val:"+integer+"  "+Thread.currentThread().getName());
            }
        });
        System.in.read();
    }
}
