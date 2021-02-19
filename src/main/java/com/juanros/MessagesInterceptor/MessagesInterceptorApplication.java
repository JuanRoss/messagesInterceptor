package com.juanros.MessagesInterceptor;

import com.juanros.messagesinterceptor.parser.Utils;
import com.juanros.messagesinterceptor.udpsocketlistener.SimpleSocketListener;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
