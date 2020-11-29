package com.syb.demo3;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import static java.lang.System.out;

/**
 * @author shenyb
 * @time 2020-11-28 17:45
 */
public class CreateObservable {
    public static void main(String[] args) {
        // 直接create
        Observable.create((ObservableOnSubscribe<Integer>)
                observableEmitter -> {
                    if (!observableEmitter.isDisposed()) {
                        for (int i = 0; i < 10; i++) {
                            observableEmitter.onNext(i);
                        }
                        observableEmitter.onComplete();
                    }
                }).subscribe(data -> System.out.println(data),
                err -> out.println(err),
                () -> out.println("create complete"));
        out.println("-----------------");
        //just
        Observable.just("hello world").subscribe(data -> System.out.println(data),
                err -> out.println(err),
                () -> out.println("just complete"));
        out.println("-----------------");
        //range
        Observable.range(1, 5).repeat(2).subscribe(data -> System.out.println(data),
                err -> out.println(err),
                () -> out.println("range complete"));

        out.println("-----------------");
        //defer
        Observable.defer(() -> Observable.just("hello")).subscribe(data -> System.out.println(data),
                err -> out.println(err),
                () -> out.println("defer complete"));

    }
}
