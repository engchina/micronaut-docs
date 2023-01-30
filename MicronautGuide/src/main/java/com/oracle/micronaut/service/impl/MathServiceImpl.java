package com.oracle.micronaut.service.impl;

import com.oracle.micronaut.service.MathService;
import jakarta.inject.Singleton;

@Singleton
public class MathServiceImpl implements MathService {
    @Override
    public Integer compute(Integer num) {
        return num * 4;
    }
}
