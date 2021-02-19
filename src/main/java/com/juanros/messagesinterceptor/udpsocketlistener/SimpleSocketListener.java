/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.udpsocketlistener;

import com.juanros.messagesinterceptor.model.Comm;
import com.juanros.messagesinterceptor.parser.Parser;
import com.juanros.messagesinterceptor.parser.UnansweredRequest;
import com.juanros.messagesinterceptor.parser.Utils;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Ros Pina
 */
@Component
public class SimpleSocketListener {

    private Parser myParser;
    private SocketUDPCommunication comm;

    
    public SimpleSocketListener(Parser parser) {
        this.myParser = parser;
    }
    
    
    public Runnable newRunnable() {
        return new Runnable() {
            public void run() {
                try {
                    comm = new SocketUDPCommunication(Utils.LISTENER_PORT);
                    DatagramPacket data;
                    //Parser myParser = new Parser();
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            
                            System.out.println("Listening...");
                            data = comm.receiveResponse();
                            System.out.println("Received: " + new String(data.getData()));
                            List<Comm> comms = myParser.crunch(data.getData());
                            for(Comm c : comms)
                                System.out.println(c);
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to process request: " + e.getMessage());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Illegal Argument: " + ex.getMessage());
                    } finally {
                        comm.closeConnection();
                    }
                } catch (SocketException ex) {
                    Logger.getLogger(SimpleSocketListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }

    public Parser getMyParser() {
        return myParser;
    }

    public void setMyParser(Parser myParser) {
        this.myParser = myParser;
    }

    @PreDestroy
    public void closeSocket() {
        System.out.println("Closing socket...");
        comm.closeConnection();
    }
    
    
}
