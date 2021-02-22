/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.model;

import java.util.Objects;

/**
 *
 * @author Juan Ros Pina
 */
public class Comm {
    private Msg rq;
    private Msg rs;

    public Comm() {
    }

    public Comm(Msg rq, Msg rs) {
        this.rq = rq;
        this.rs = rs;
    }

    public Msg getRq() {
        return rq;
    }

    public void setRq(Msg rq) {
        this.rq = rq;
    }

    public Msg getRs() {
        return rs;
    }

    public void setRs(Msg rs) {
        this.rs = rs;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Comm))
            return false;
        if(o == null) return false;
        Comm c = (Comm)o;
        return (Objects.equals(this.rq, c.rq) && Objects.equals(this.rs, c.rs));
    }
    
    @Override
    public String toString() {
        return "[rq: " + rq + ", rs: " + rs + "]";
    }
}
