/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.parser;

/**
 *
 * @author Juan Ros Pina
 */
public class Utils {
    public final static int LISTENER_PORT = 4000;
    private final static int FRAME_MAX_SIZE = 200;
    public final static int ORI_PORT_SIZE = 1;
    public final static int DEST_PORT_SIZE = 1;
    public final static int ORI_IP_SIZE = 3;
    public final static int DEST_IP_SIZE = 3;
    
    public static int asciiArrayToInt(byte[] frame) {
        int result=0, decimal=frame.length-1;
        for(byte b : frame) {
            
            if(b < 48 || b > 57) throw new IllegalArgumentException("Not an ASCII number");
            result += ((b-48)*Math.pow(10, decimal));
            decimal--;
        }
        return result;
    }
    
    public static Integer getCharsRemainingToFirstAppearance(byte[] frame, String symbol, int currentPos) {
        int pos = currentPos;
        while(pos < frame.length && !Character.toString((char)frame[pos]).equals(symbol) && pos < FRAME_MAX_SIZE)
            pos++;
            
        if(pos<frame.length && pos < FRAME_MAX_SIZE)
            return pos-currentPos;
        return -1;
        //throw new IllegalArgumentException("Symbol "+ symbol +" not found in frame " + new String(frame) + " from position " + currentPos);
    }    
    
    public static String byteArrayToHexString(byte[] bytes) {
		final char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
    
}
