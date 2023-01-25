package com.oracle.micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

// 该类被定义为控制器，其中@Controller注映射到路径"/"。
@Controller("/")
public class MainController {

    // @Get注解将sayHello方法映射到"/"上的 HTTP GET 请求。
    // 默认情况下，Micronaut 响应使用 application/json。
    // 我们返回一个字符串，而不是一个 JSON 对象，因此我们将其 Content-Type 设置为 text/plain。
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        // 返回字符串"Hello World!"作为结果
        return "Hello World!";
    }
}
