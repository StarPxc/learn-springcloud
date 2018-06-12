package com.guohe3.eurekaclient.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.guohe3.eurekaclient.consumer
 * @Description: TODO
 * @date 2018/5/5 8:06
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private RestTemplate restTemplate;

    /*  @RequestMapping("helloConsumer")
      public String helloConsumer(){
          return helloService.helloService();
      }*/
    @RequestMapping("helloConsumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {
   /*   HelloServiceCommand command=new HelloServiceCommand("hello",restTemplate);
      //String result=command.execute();//阻塞式
      Future<String> future=command.queue();
      return future.get();*/


        List<String> list = new ArrayList<>();
        HelloServiceObserveCommand command = new HelloServiceObserveCommand("hello", restTemplate);
        //Observable observable = command.observe();//热执行 不会等所有的注册完就会去执行业务方法
        Observable observable = command.toObservable();//冷执行 会等所有注册完毕后才去执行业务方法
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("任务完成，聚合所有请求");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String string) {
                list.add(string);
            }
        });
        return list.toString();
    }
}
