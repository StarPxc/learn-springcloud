package com.guohe3.eurekaclient.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.guohe3.eurekaclient.consumer
 * @Description: TODO
 * @date 2018/5/7 16:45
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")//服务降级后调用的方法
    public String helloService() throws ExecutionException, InterruptedException {
        Future<String> future = new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
            }
        };
        return future.get();
    }

    public String helloFallback() {
        return "error";
    }

}
