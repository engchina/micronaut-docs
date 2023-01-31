package com.oracle.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IssuesControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() { // 嵌入服务器和HTTP客户端被启动
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() { // 测试结束后，服务器和客户端会被清理
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void testIssue() {
        String body = client.toBlocking().retrieve("/issues/12"); // 该测试向URI /issues/12发送一个请求
        assertNotNull(body);
        assertEquals("Issue # 12!", body); // 然后断言响应是 "Issue # 12!"
    }

    @Test
    public void testShowWithInvalidInteger() {
        HttpClientResponseException e = assertThrows(HttpClientResponseException.class, () ->
                client.toBlocking().exchange("/issues/hello"));
        assertEquals(400, e.getStatus().getCode()); // 另一个测试断言，当URL中发送一个无效的数字时，会返回一个400状态码
    }

    @Test
    public void testIssueWithoutNumber() {
        HttpClientResponseException e = assertThrows(HttpClientResponseException.class, () ->
                client.toBlocking().exchange("/issues"));
        assertEquals(404, e.getStatus().getCode()); // 另一个测试断言，当URL中没有提供数字时，将返回404状态码。变量的存在是路由被执行的必要条件。
    }
}
