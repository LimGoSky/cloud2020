package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡规则类
 */
@Configuration
public class MySelfRule {

    public IRule myRule(){
        return new RandomRule();
    }
}
