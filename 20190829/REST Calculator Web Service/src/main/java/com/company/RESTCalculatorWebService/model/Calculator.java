package com.company.RESTCalculatorWebService.model;

public class Calculator {

    int operand1;
    int operand2;
    int addResult;
    int subtractResult;
    int multiplyResult;
    int divideResult;

    public int getAddResult() {
        return operand1 + operand2;
    }

    public void setAddResult(int addResult) {
        this.addResult = addResult;
    }

    public int getSubtractResult() {
        return operand1 - operand2;
    }

    public void setSubtractResult(int subtractResult) {
        this.subtractResult = subtractResult;
    }

    public int getMultiplyResult() {
        return operand1 * operand2;
    }

    public void setMultiplyResult(int multiplyResult) {
        this.multiplyResult = multiplyResult;
    }

    public int getDivideResult() {
        return operand1 / operand2;
    }

    public void setDivideResult(int divideResult) {
        this.divideResult = divideResult;
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
}
