package com.example.calculator2;

public class Calculator {
    //속성
    double result;

    //기본 생성자
    public Calculator() {
        this.result = 0;
    }

    //기능
    public double plus(double a, double b) {
        result = a + b;
        return result;
    }
    public double minus(double a, double b) {
        result = a - b;
        return result;
    }
    public double multiply(double a, double b) {
        result = a * b;
        System.out.println("!!"+result);
        return result;
    }
    public double divide(double a, double b) {
        result = a / b;
        return result;
    }
    // 연산 결과 저장
    public double getResult() {
        return result;
    }
}
