/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.udpsocketlistener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Juan Ros Pina
 */
public class UDPClient {
    public boolean send(String ip, int port, byte[] data) throws IOException{
	InetAddress ipAddress;

	try {
            ipAddress = InetAddress.getByName(ip);
	} catch (UnknownHostException ex) {
            return false;
	}
	try {
            SocketUDPCommunication comm = new SocketUDPCommunication();
            comm.sendRequest(data, ipAddress, port);
            comm.closeConnection();
	} catch (SocketException ex) {
            return false;
	}

	return true;
	}
}
