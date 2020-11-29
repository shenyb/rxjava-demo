package com.syb.demo2;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * @author shenyb
 * @time 2020-11-28 16:28
 */
public class AllSubject {
    public static void main(String[] args) {
        // AsyncSubject,只会接收到complete之前的最后一条
        AsyncSubject<String> subject1 = AsyncSubject.create();
        subject1.onNext("asyncSubject1");
        subject1.onNext("asyncSubject2");
        subject1.subscribe(
                s -> System.out.println("accept:" + s),
                throwable -> System.out.println("throwable" + throwable),
                () -> System.out.println("complete"));
        subject1.onNext("asyncSubject3");
        subject1.onComplete();
        subject1.onNext("asyncSubject4");

        System.out.println("--------------------------");
        // BehaviorSubject,只会接收到订阅之后的最后一条以及complete之前的
        BehaviorSubject<String> subject2 = BehaviorSubject.create();
        subject2.onNext("BehaviorSubject1");
        subject2.onNext("BehaviorSubject2");
        subject2.subscribe(
                s -> System.out.println("accept:" + s),
                throwable -> System.out.println("throwable" + throwable),
                () -> System.out.println("complete"));
        subject2.onNext("BehaviorSubject3");
        subject2.onComplete();
        subject2.onNext("BehaviorSubject4");

        System.out.println("--------------------------");
        // ReplaySubject,complete之前所有的数据
        ReplaySubject<String> subject3 = ReplaySubject.create();
        subject3.onNext("ReplaySubject1");
        subject3.onNext("ReplaySubject2");
        subject3.subscribe(
                s -> System.out.println("accept:" + s),
                throwable -> System.out.println("throwable" + throwable),
                () -> System.out.println("complete"));
        subject3.onNext("ReplaySubject3");
        subject3.onNext("ReplaySubject4");
        subject3.onComplete();

        System.out.println("--------------------------");
        // PublishSubject,订阅之后所有的数据
        PublishSubject<String> subject4 = PublishSubject.create();
        subject4.onNext("PublishSubject1");
        subject4.onNext("PublishSubject2");
        subject4.subscribe(
                s -> System.out.println("accept:" + s),
                throwable -> System.out.println("throwable" + throwable),
                () -> System.out.println("complete"));
        subject4.onNext("PublishSubject3");
        subject4.onNext("PublishSubject4");
        subject4.onComplete();


    }
}
