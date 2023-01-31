package com.oracle.micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * @Controller注解的值是一个RFC-6570 URI模板，所以你可以使用URI模板规范定义的语法在路径中嵌入URI变量。
 * 许多其他框架，包括Spring，都实现了URI模板规范。
 * 实际的实现是由UriMatchTemplate类处理的，它扩展了UriTemplate。
 * 你可以在你的应用程序中使用这个类来构建URI。
 * 你可以使用UriTemplate来建立路径，以包括在你的响应中。
 */
// 该类被定义为一个控制器，其@Controller注解被映射到路径/hello上。
@Controller("/hello")
public class HelloController {

    // 该方法响应对/hello的GET请求，并返回一个text/plain内容类型的响应。
    @Get(processes = MediaType.TEXT_PLAIN)
    public String index() { // 通过定义一个名为index的方法，该方法通过/hello URI公开。
        return "Hello World!";
    }
}
