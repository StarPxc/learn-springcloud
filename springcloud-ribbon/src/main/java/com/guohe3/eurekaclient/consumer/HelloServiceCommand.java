package com.guohe3.eurekaclient.consumer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.guohe3.eurekaclient.consumer
 * @Description: TODO
 * @date 2018/5/12 9:50
 */
public class HelloServiceCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;//不能自动注入 ，因为HelloServiceCommand是new出来的


    public HelloServiceCommand(String commandGroupKey, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "error";
    }
}
