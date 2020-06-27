package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "----testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p1",required = false) String p2){
        return "----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "-------deal_testHotKey";
    }
}
