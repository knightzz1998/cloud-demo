package cn.itcast.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 王天赐
 * @title: AuthorizationFilter
 * @projectName cloud-demo
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/4/24 16:45
 */
@Slf4j
@Order(0)
@Component
public class AuthorizationFilter implements GlobalFilter , Ordered{


    static {
        log.warn("过滤器 ................");
    }

    /**
     * @param exchange 请求上下文，里面可以获取Request、Response等信息
     * @param chain    用来把请求委托给下一个过滤器
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 判断 :
        // 参数中是否有authorization
        // authorization参数值是否为admin
        log.warn("进入全局过滤器==========================================");
        // 获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        String auth = params.getFirst("authorization");
        if ("admin".equals(auth)) {
            // 满足条件直接放行
            return chain.filter(exchange);
        }

        // 不满足条件, 设置响应状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        // 结束处理
        return exchange.getResponse().setComplete();
    }
}
