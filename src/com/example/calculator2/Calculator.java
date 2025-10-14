package com.example.calculator2;

public class Calculator {
    //속성
    private int result;

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
        if (!isDividedByZero(b)) {
            result = a / b;
        }
        return 0;
    }
    // 연산 결과 저장
    public int getResult() {
        return result;
    }
    public boolean isDividedByZero(int n) {
        if(n == 0) {
            System.out.println("나눗셈에서 0으로 나눌 수 없습니다.");
            return true;
        }
        return false;
    }
}
