package com.oracle.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// 通过@MicronautTest注解类，以便Micronaut框架初始化应用程序上下文和嵌入式服务器。
@MicronautTest
public class MainControllerTest {

    // 注入 HttpClient Bean 并将其指向嵌入式服务器。
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testMain() {
        // 创建HTTP请求很容易，这要归功于Micronaut框架API。
        HttpRequest<String> request = HttpRequest.GET("/");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Hello World!", body);
    }
}
