/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor;

import com.juanros.messagesinterceptor.parser.Utils;
import com.juanros.messagesinterceptor.udpsocketlistener.UDPClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Ros Pina
 */
public class SimulateFrameInjection {
    private final static String host = "localhost";
    private final static String raw = "ABCXYZ18#ui13#2+[2#2]-[*#3]EFGZYX19#Yt14#2*[6#1]-[85#*]ZYXEFG12#tY8#1=[79#-]XYZABC11#iu7#1=[1#-]";
    private final static String raw1 = "ABCXYZ18#ui13#2+[2#2]-[*#3]EFGZYX19#Yt14#2*[6#1]-[85#*]ZYXEFG12#tY8#1=[79#-]";
    private final static String raw2 = "XYZABC11#iu7#1=[1#-]";
    private final static String raw3 = "ABCXYZ18#ui13#2+[2#2]-[*#3]EFGZYX19#Yt14#2*[6#1]-[85#*]";
    
    public static void main(String[] args) {
        UDPClient c = new UDPClient();
        try {
            c.send("localhost", Utils.LISTENER_PORT, raw.getBytes());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulateFrameInjection.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.send("localhost", Utils.LISTENER_PORT, raw1.getBytes());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulateFrameInjection.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.send("localhost", Utils.LISTENER_PORT, raw2.getBytes());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulateFrameInjection.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.send("localhost", Utils.LISTENER_PORT, raw3.getBytes());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimulateFrameInjection.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.send("localhost", Utils.LISTENER_PORT, raw2.getBytes());
        } catch (IOException ex) {
            System.out.println("Request failed");
        }
        
    }
}
