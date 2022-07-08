package com.gateway.gateway.filter;

import com.gateway.gateway.common.WhiteList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author :zsl
 * @date :2022/7/8 0008
 * 认证过滤器
 **/
@Component
public class AuthFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().toString();
        boolean fi =  WhiteList.getWhiteList().contains(path);
        if(fi){
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("Authertication");


        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
