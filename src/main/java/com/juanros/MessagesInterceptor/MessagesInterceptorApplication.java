package com.juanros.MessagesInterceptor;

import com.juanros.MessagesInterceptor.udpsocket.SimpleSocketListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MessagesInterceptorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MessagesInterceptorApplication.class, args);

        SimpleSocketListener l = context.getBean("udpServer", SimpleSocketListener.class);
        l.newRunnable().run();
        
        context.close();
	}

}
