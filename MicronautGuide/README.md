## Commands

测试
```
./mvnw test
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/a690edd05b1846ea892cfb4348503897.png)

运行应用程序
```
./mvnw mn:run
```

构建原生镜像
```
./mvnw package -Dpackaging=native-image
```

运行原生镜像
```
./target/micronautguide
```

通过curl访问
```
curl localhost:8080; echo
```

## Micronaut 3.8.2 Documentation

- [User Guide](https://docs.micronaut.io/3.8.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

