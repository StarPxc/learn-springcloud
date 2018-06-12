# eureka-client
### 说明

一张图说明一切

![1528813822566](C:\Users\PXC\AppData\Local\Temp\1528813822566.png)

此模块是eureka的 Eureka Client端也是服务提供者

> 调用流程

服务消费者先去注册中心获取服务列表，然后根据负载均衡算法找到对应的服务地址调用其中某个服务

> pom.xml

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

**注意和注册中心的区别**

### 配置文件说明

```properties
server.port=8081
spring.application.name=hello-service
eureka.client.service-url.defaultZone=http://localhost:8888/eureka/,http://localhost:8889/eureka/
```

- spring.application.name如果是一样的表明是一组服务提供者
- eureka.client.service-url.defaultZone填写的是注册中心的地址