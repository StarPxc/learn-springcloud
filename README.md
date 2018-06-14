Spring Cloud学习

暑假要去一家做大数据的公司实习，公司技术桟中有使用Spring Cloud全家桶，所以准备在实习前入个门。

> 一张图说明一切

![1528813799159](https://github.com/StarPxc/learn-springcloud/blob/master/img/p1.png)

此模块是eureka的 Eureka Service端也就是所谓的注册中心，为了防止服务端的单点故障，做个注册中心的集群，新增一个注册中心分别把对方作为服务进行注册

> 调用流程

服务消费者先去注册中心获取服务列表，然后根据负载均衡算法找到对应的服务地址调用其中某个服务

> 项目地址

- [eureka-client(服务提供者)](https://github.com/StarPxc/learn-springcloud/blob/master/eureka-client/pom.xml)
- [eureka-server(注册中心)](https://github.com/StarPxc/learn-springcloud/blob/master/springcloud-eureka/pom.xml)

