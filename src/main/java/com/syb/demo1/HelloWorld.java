package com.syb.demo1;

import io.reactivex.Observable;

/**
 * @author shenyb
 * @time 2020-11-25 22:14
 */
public class HelloWorld {
    public static void main(String[] args) {
        Observable.just("hello world").subscribe(System.out::println);
    }
}
