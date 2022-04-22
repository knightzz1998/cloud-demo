package cn.itcast.feign.pojo;

import lombok.Data;

/**
 * @author 王天赐
 * @title: Client
 * @projectName cloud-demo
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/4/22 16:47
 */
@Data
public class User {
    private Long id;
    private String username;
    private String address;
}