/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

import com.juanros.messagesinterceptor.model.Op;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class ApplicationProtocol {
    private List<Op> ops;

    public List<Op> getOps() {
        return ops;
    }

    public void setOps(List<Op> ops) {
        this.ops = ops;
    }
    
    public void parseMessage(byte[] frame) {
        System.out.println("APPLICATION LAYER");
        ops = new ArrayList<>();
        int pivotalPos = 1;
        while(pivotalPos < frame.length) {
            Op op = new Op();
            op.setOperation(Character.toString((char)frame[pivotalPos]));
            pivotalPos+=2;   //Skip operation and first "["
            int nCharOp1 = Utils.getCharsRemainingToFirstAppearance(frame, "#", pivotalPos);
            byte[] operand1 = new byte[nCharOp1];   //From current "#" position, skip number of operations and operation symbol
            System.arraycopy(frame, pivotalPos, operand1, 0, operand1.length);
            op.setOperand1(getOperandValue(ops, operand1));
       
            pivotalPos = pivotalPos+nCharOp1+1; // +1 to skip separator
            int nCharOp2 = Utils.getCharsRemainingToFirstAppearance(frame, "]", pivotalPos);
            byte[] operand2 = new byte[nCharOp2];   //From current "#" position, skip number of operations and operation symbol
            System.arraycopy(frame, pivotalPos, operand2, 0, operand2.length);
            if(!op.getOperation().equals("="))
                op.setOperand2(getOperandValue(ops, operand2));
            
            op.calculateResult();
            ops.add(op);
            pivotalPos = pivotalPos+nCharOp2+1;
        }
    }
    
    private int getOperandValue(List<Op> ops, byte[] operand) {
        if(Character.toString((char)operand[0]).equals("*") && !ops.isEmpty()) {
            return ops.get(ops.size()-1).getResult();
        }
        return Utils.asciiArrayToInt(operand);
    }
}
