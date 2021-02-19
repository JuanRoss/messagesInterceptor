/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.udpsocketlistener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Juan Ros Pina
 */
public class SocketUDPCommunication {
    private int port;
    private DatagramSocket socket;
    
    private final static int PACKAGE_MAX_SIZE = 4096;


    public SocketUDPCommunication() throws SocketException {
        if (socket == null) 
            socket = new DatagramSocket();
            port = socket.getLocalPort();
	}


    public SocketUDPCommunication(int port) throws SocketException {
	if (socket == null) 
            socket = new DatagramSocket(port);		
            this.port = port;
    }

    public void closeConnection() {
	if (socket != null) {
            if (!this.socket.isClosed()) {
		this.socket.close();
            }
	}
        System.out.println("Connection closed.");
    }

    public DatagramPacket receiveResponse() throws IOException {
	byte[] receiveData = new byte[PACKAGE_MAX_SIZE];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	socket.receive(receivePacket);

	return receivePacket;
    }
    
    public void sendRequest(byte[] sendData, InetAddress ip, int port) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
        socket.send(sendPacket);
    }

}
