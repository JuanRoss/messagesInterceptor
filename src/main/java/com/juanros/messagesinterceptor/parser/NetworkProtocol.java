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
public class NetworkProtocol {
    private String originIp;
    private String destinationIp;
    private byte[] body;
    
    

    public String getOriginIp() {
        return originIp;
    }

    public void setOriginIp(String originIp) {
        this.originIp = originIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public void setDestinationIp(String destinationIp) {
        this.destinationIp = destinationIp;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }


    
    public void parseMessage(byte[] frame) {
        System.out.println("NETWORK LAYER");
        String frameString = new String(frame);
       
        byte[] destIp = new byte[Utils.DEST_IP_SIZE];
        byte[] oriIp = new byte[Utils.ORI_IP_SIZE];
        System.arraycopy(frame, 0, oriIp, 0, Utils.ORI_IP_SIZE);
        System.arraycopy(frame, Utils.ORI_IP_SIZE, destIp, 0, Utils.DEST_IP_SIZE);
        this.setOriginIp(new String(oriIp));
        this.setDestinationIp(new String(destIp));
        
        int currentPos = Utils.ORI_IP_SIZE+Utils.DEST_IP_SIZE;
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
