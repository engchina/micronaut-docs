package com.oracle.micronaut.facade;

import com.oracle.micronaut.service.Engine;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
public class Vehicle {

    private final Engine engine;

//    // Engine 是通过构造器注入而被注入的
//    public Vehicle(Engine engine) {
//        this.engine = engine;
//    }

    // javax.inject.Named注解表明，使用V8Engine的实现。
    @Inject
    public Vehicle(@Named("v8") Engine engine) {//
        this.engine = engine;
    }

    public String start() {
        return engine.start();
    }
}
