package com.syb.demo1;

import io.vertx.core.Vertx;

import java.io.IOException;

/**
 * @author shenyb
 * @time 2020-11-29 15:46
 */
public class Hello {
    public static void main(String[] args) throws IOException {
        Vertx vertx = Vertx.vertx();
        vertx.executeBlocking(future -> {
            String result = "hello";
            future.complete(result);

        },asyncResult -> {
            System.out.println(asyncResult);
        });
    }
}

