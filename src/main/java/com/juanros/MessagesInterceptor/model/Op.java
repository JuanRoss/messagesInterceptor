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
public class Op {
    private String operation;
    private int operand1;
    private int operand2;
    private int result;
    
    public Op() {
    }

    public Op(String operation, int operand1, int operand2) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public int getResult() {
        return result;
    }

    public void calculateResult() {
        switch(operation) {
            case "+":
                result = operand1+operand2;
                break;
            case "-":
                result = operand1-operand2;
                break;
            case "*":
                result = operand1*operand2;
                break;
            case "/":
                result = operand1/operand2;
                break;
            case "=":
                result = operand1;
                break;
            default:
                throw new IllegalArgumentException("Bad operator");
        }
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Op))
            return false;
        if(o == null) return false;
        Op op = (Op)o;
        return(this.operand1 == op.operand1 && this.operand2 == op.operand2 && Objects.equals(this.operation, op.operation));
    }
    
    @Override 
    public String toString() {
        return "[operation:'"+operation+"', operand1:" + operand1 + ", operand2:"
                + operand2 + ", result:" + result + "]";
    }
}
