package com.guohe3.eurekaclient.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.guohe3.eurekaclient.hello
 * @Description: TODO
 * @date 2018/5/5 8:06
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "croud 我来了！我第一个";
    }
}
