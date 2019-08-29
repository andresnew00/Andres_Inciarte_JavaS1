package com.company.RESTCalculatorWebService.model;

public class Calculator {

    int operand1;
    int operand2;

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

    public int AddResult(){
        return operand1 + operand2;
    }

    public int SubtractResult(){
        return operand1 - operand2;
    }


    public int MultiplyResult(){
        return operand1 * operand2;
    }


    public int DivideResult(){
        return operand1 / operand2;
    }
}
