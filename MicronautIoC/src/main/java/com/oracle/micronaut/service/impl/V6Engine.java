package com.oracle.micronaut.service.impl;

import com.oracle.micronaut.service.Engine;
import jakarta.inject.Singleton;

@Singleton
public class V6Engine implements Engine {  //
    @Override
    public String start() {
        return "Starting V6";
    }

    @Override
    public int getCylinders() {
        return 6;
    }
}