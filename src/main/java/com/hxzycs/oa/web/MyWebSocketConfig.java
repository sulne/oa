package com.hxzycs.oa.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
@Configuration
@EnableWebMvc
@EnableWebSocket
public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	@Resource(name="myWebSocketHandler")
    private MyWebSocketHandler handler;
	
	 public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

	        //添加websocket处理器，添加握手拦截器
	        webSocketHandlerRegistry.addHandler(handler, "/ws").addInterceptors(new MyWebSocketInterceptor());

	        //添加websocket处理器，添加握手拦截器
	        webSocketHandlerRegistry.addHandler(handler, "/ws/sockjs").addInterceptors(new MyWebSocketInterceptor()).withSockJS();
	    }

}
