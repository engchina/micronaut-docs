package com.oracle.micronaut;

import com.oracle.micronaut.facade.Vehicle;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.BeanContext;
import io.micronaut.runtime.Micronaut;


public class Application {

    public static void main(String[] args) {
//        Micronaut.run(Application.class, args);

        // 示例1
        /**
         * IoC的入口是ApplicationContext接口，它包括一个run方法。
         * 下面的例子演示了如何使用它。
         */
        /**
         * 本例使用Java try-with-resources语法来确保ApplicationContext在应用程序退出时被干净地关闭
         */
//        // 运行ApplicationContext
//        try (ApplicationContext context = ApplicationContext.run()) {
//            // 从ApplicationContext中获取一个bean
//            Vehicle vehicle = context.getBean(Vehicle.class);
//            System.out.println(vehicle.start());
//        }

        // 示例2
        /**
         * 为了执行依赖注入，使用run()方法运行BeanContext，并使用getBean(Class)查找一个Bean，
         * 如下面的例子。
         */
        /**
         * Micronaut自动发现classpath上的依赖注入元数据，并根据你定义的注入点将Bean连接起来。
         */
        /**
         * BeanContext是所有Bean定义的一个容器对象（它也实现了BeanDefinitionRegistry）。
         * 它也是Micronaut的初始化点。
         * 然而，一般来说，你不会直接与BeanContext API交互，
         * 而可以简单地使用jakarta.inject注释和io.micronaut.context.annotation包中的注释来满足你的依赖注入需求。
         */
        final BeanContext context = BeanContext.run();
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle.start());
    }
}