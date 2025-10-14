package com.example.calculator2;

public class Calculator {
    //속성
    int result;

    //기본 생성자
    public Calculator() {
        this.result = 0;
    }

    //기능
    public int plus(int a, int b) {
        result = a + b;
        return result;
    }
    public int minus(int a, int b) {
        result = a - b;
        return result;
    }
    public int multiply(int a, int b) {
        result = a * b;
        return result;
    }
    public int divide(int a, int b) {
        result = a / b;
        return result;
    }
    // 연산 결과 저장
    public double getResult() {
        return result;
    }
}
