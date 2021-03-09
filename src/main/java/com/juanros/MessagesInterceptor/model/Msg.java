/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Juan Ros Pina
 */
public class Msg {
    private String originIp;
    private String destinationIp;
    private String originPort;
    private String destinationPort;
    private List<Op> ops;

    public Msg() {
    }
    
    public Msg(String originIp, String destinationIp, String originPort, String destinationPort) {
        this.originIp = originIp;
        this.destinationIp = destinationIp;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
    }
    
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

    public boolean isResponse(Msg request) {
        return (this.isResponse() && this.destinationIp.equals(request.originIp) && this.originIp.equals(request.destinationIp)
                && this.destinationPort.equals(request.originPort) && this.originPort.equals(request.destinationPort)
                && request.ops.get(request.ops.size()-1).getResult() == this.getOps().get(0).getResult());
    }
    
    public boolean isResponse() {
        return (this.getOps().size() == 1 && this.getOps().get(0).getOperation().equals("="));
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Msg))
            return false;
        if(o == null) return false;
        Msg m = (Msg)o;
        return (Objects.equals(m.destinationIp, this.destinationIp) && Objects.equals(m.originIp, this.originIp)
                && Objects.equals(m.destinationPort, this.destinationPort) && Objects.equals(m.originPort, this.originPort));
    }
    
    @Override 
    public String toString() {
        return "[originIp:'"+originIp+"', originPort:" + originPort + ", destinationIp:"
                + destinationIp + ", destinationPort:" + destinationPort + ", ops: " + ops +"]";
    }

    public List<Op> getOps() {
        return ops;
    }

    public void setOps(List<Op> ops) {
        this.ops = ops;
    }


}
