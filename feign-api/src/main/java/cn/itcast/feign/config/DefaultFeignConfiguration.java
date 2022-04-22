package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author 王天赐
 * @title: DefaultFeignConfiguration
 * @projectName cloud-demo
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/4/22 16:47
 */
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
