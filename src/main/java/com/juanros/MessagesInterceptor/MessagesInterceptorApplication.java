package com.juanros.MessagesInterceptor;

import com.juanros.MessagesInterceptor.parser.Parser;
import com.juanros.MessagesInterceptor.udpsocket.SimpleSocketListener;
import com.juanros.MessagesInterceptor.unansweredrequest.UnansweredRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessagesInterceptorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MessagesInterceptorApplication.class, args);

        SimpleSocketListener l = context.getBean("udpServer", SimpleSocketListener.class);
        l.newRunnable().run();
        
        context.close();
	}
    
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
