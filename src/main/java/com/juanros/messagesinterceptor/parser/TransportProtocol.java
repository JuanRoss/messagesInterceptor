/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

/**
 *
 * @author juan
 */
public class TransportProtocol implements Protocol {
    private String originPort;
    private String destinationPort;
    private byte[] body;

    public String getOriginPort() {
        return originPort;
    }

    public void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
    
    public void parseMessage(byte[] frame) {
        System.out.println("TRANSPORT LAYER");
        this.setOriginPort(Character.toString((char)frame[0]));
        this.setDestinationPort(Character.toString((char)frame[1]));
        int currentPos = Utils.ORI_PORT_SIZE+Utils.DEST_PORT_SIZE;
        int nCharBodyLengthTransport = Utils.getCharsRemainingToFirstAppearance(frame, "#", currentPos);
        byte[] bodyLength = new byte[nCharBodyLengthTransport];
        System.arraycopy(frame, currentPos, bodyLength, 0, bodyLength.length);
        int length = Utils.asciiArrayToInt(bodyLength);
        System.out.println(length);
        body = new byte[length];
        currentPos = currentPos + bodyLength.length + 1;
        System.arraycopy(frame, currentPos, body, 0, length);
        System.out.println(new String(body));
    }
    
}
