package com.oracle.micronaut;

import io.micronaut.runtime.Micronaut;

public class Application {

    // 为了运行服务器，创建一个带有静态void main方法的应用程序类
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}