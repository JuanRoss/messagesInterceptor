/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

import com.juanros.messagesinterceptor.model.Comm;
import com.juanros.messagesinterceptor.model.Msg;
import com.juanros.messagesinterceptor.model.Op;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Juan Ros Pina
 */
@Component
public class Parser {
    
    private UnansweredRequest ur;
    
    @Autowired
    public Parser(UnansweredRequest ur) {
        this.ur = ur;
    }
    
    public List<Comm> crunch(byte[] raw) {
        List<Msg> messages = new ArrayList<>();
        int pivotalPos = 0;
        while(pivotalPos < raw.length) {
            int nextPos = pivotalPos+Utils.ORI_IP_SIZE+Utils.DEST_IP_SIZE;    //skip originIp and destinationIp
            
            int nChar = Utils.getCharsRemainingToFirstAppearance(raw, "#", nextPos);
            if(nChar == -1) break;              //if "#" isn't found, there aren't more messages
            byte[] bodyLength = new byte[nChar];   //get the ascii representation of the body length
            System.arraycopy(raw, pivotalPos+(Utils.ORI_IP_SIZE+Utils.DEST_IP_SIZE), bodyLength, 0, bodyLength.length);
            byte[] frame = new byte[Utils.asciiArrayToInt(bodyLength)+Utils.ORI_IP_SIZE+Utils.DEST_IP_SIZE+bodyLength.length+1];//total length=body length + originIp (3) + destinationIp(3) + bodyLengthRepresentation + first layer separator (1)
            System.arraycopy(raw, pivotalPos, frame, 0, frame.length);
            NetworkProtocol np = new NetworkProtocol();
            np.parseMessage(frame);
            TransportProtocol tp = new TransportProtocol();
            tp.parseMessage(np.getBody());
            ApplicationProtocol ap = new ApplicationProtocol();
            ap.parseMessage(tp.getBody());
            for(Op op : ap.getOps())
                System.out.println(op);
            
            Msg msg = new Msg(np.getOriginIp(), np.getDestinationIp(), tp.getOriginPort(), tp.getDestinationPort());
            msg.setOps(ap.getOps());
            messages.add(msg);
            pivotalPos += frame.length;    //update "pivotalPos" to the initial position of next message, if exists
        }
        List<Comm> comms = groupCommunications(messages);
        
        return comms;
    }   
    
    private List<Comm> groupCommunications(List<Msg> messages) {
        List<Comm> comms = new ArrayList<>();
        List<Msg> rss = new ArrayList<>();
        
        //Check if message is a response of a previously received request
        int i = 0;
        while(i<messages.size() && ur.hasRequests()) {
            Msg m = messages.get(i);
            if(m.isResponse()) {
                Msg rq = ur.getUnansweredRequest(m);
                Comm c = new Comm();
                if(rq !=null) {
                    c.setRq(rq);
                    c.setRs(m);
                    comms.add(c);
                }
            }
            i++;
        }
        
        //If unanswered requests still remains, we assume that the response is lost
        List<Msg> oldRequests = ur.clear();
        for(Msg m : oldRequests) {
            Comm c = new Comm();
            c.setRq(m);
            comms.add(c);
        }
        
        int rsToDelete = -1;
        for(i=messages.size()-1; i>=0; i--) {
            if(rsToDelete >= 0) {
                rss.remove(rsToDelete);
            }
            Msg m = messages.get(i);
            if(m.isResponse()) {
                rss.add(m);
                rsToDelete = -1;
            }else {
                int j;
                for(j=0; j<rss.size(); j++) {
                    Msg rs = rss.get(j);
                    if(rs.isResponse(m)) {
                        Comm c = new Comm();
                        c.setRq(m);
                        c.setRs(rs);
                        comms.add(c);
                        rsToDelete = j;
                        break;
                    }
                }
                if(j == rss.size()) {
                    rsToDelete = -1;
                    ur.addUnansweredRequest(m);
                }
            }        
        }
            
        return comms;
    }
    
    
}
