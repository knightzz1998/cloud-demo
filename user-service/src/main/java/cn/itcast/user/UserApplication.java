package cn.itcast.user;

import cn.itcast.user.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;

/**
 * @author knightzz98
 */
@MapperScan("cn.itcast.user.mapper")
@SpringBootApplication
public class UserApplication {

    @Resource
    private UserMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
