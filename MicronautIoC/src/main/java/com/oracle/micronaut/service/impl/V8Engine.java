package com.oracle.micronaut.service.impl;

import com.oracle.micronaut.service.Engine;
import jakarta.inject.Singleton;

/**
 * Bean是一个对象，其生命周期由Micronaut IoC容器管理。
 * 该生命周期可能包括创建、执行和销毁。
 * Micronaut实现了JSR-330（javax.injection）--Java的依赖注入规范，
 * 因此要使用Micronaut，你只需使用javax.injection提供的注释。
 */
// 定义一个 V8Engine 的实现，并被标记为Singleton范围
@Singleton
public class V8Engine implements Engine {
    private int cylinders = 8;

    @Override
    public int getCylinders() {
        return cylinders;
    }

    @Override
    public String start() {
        return "Starting V8";
    }
}
