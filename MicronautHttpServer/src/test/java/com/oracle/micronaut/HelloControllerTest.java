package com.oracle.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriMatchTemplate;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class HelloControllerTest {

    // 要从单元测试中运行应用程序，请使用EmbeddedServer接口。
    @Inject
    EmbeddedServer server; // EmbeddedServer被运行，@AutoCleanup注解确保服务器在完成后被停止。

    @Inject
    @Client("/")
    HttpClient client; // EmbeddedServer接口提供了被测服务器的URL，该服务器在一个随机的端口上运行。

    @Test
    void testHelloWorldResponse() {
        String response = client.toBlocking() // 该测试使用Micronaut HTTP客户端进行调用
                .retrieve(HttpRequest.GET("/hello")); // retrieve方法将控制器的响应作为一个字符串返回。
        assertEquals("Hello World!", response);
    }

    @Test
    void testUriMatchTemplate() {
        UriMatchTemplate template = UriMatchTemplate.of("/hello/{name}");

        assertTrue(template.match("/hello/John").isPresent()); // 使用match方法来匹配一个路径
        assertEquals("/hello/John", template.expand( // 使用expand方法将一个模板扩展为一个URI
                Collections.singletonMap("name", "John")
        ));
    }
}
