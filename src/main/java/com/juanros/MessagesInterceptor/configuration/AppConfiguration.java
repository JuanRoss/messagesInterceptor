/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.configuration;

import com.juanros.messagesinterceptor.parser.Parser;
import com.juanros.messagesinterceptor.parser.UnansweredRequest;
import com.juanros.messagesinterceptor.udpsocketlistener.SimpleSocketListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author juan
 */
@Configuration
public class AppConfiguration {
    
    @Bean
    public UnansweredRequest unansweredRequest() {
        return new UnansweredRequest();
    }
    
    @Bean
    public Parser myParser() {
        return new Parser(unansweredRequest());
    }
    
    @Bean
    public SimpleSocketListener udpServer() {
        return new SimpleSocketListener(myParser());
    }
}
