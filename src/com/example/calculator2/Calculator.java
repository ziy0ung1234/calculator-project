package com.example.calculator2;

import java.util.ArrayDeque;

public class Calculator {
    //속성
    private ArrayDeque<Integer> results = new ArrayDeque<>();

    //기본 생성자 생략

    //기능
    public int calculate(int a, int b, char op) {
        int result;
        switch(op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if(isNotDividedByZero(b)) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                } else {
                    result = a / b;
                }
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산기호입니다.");
        }
        setResults(result);
        return result;
    }

    // 연산 결과 관련 기능
    public ArrayDeque<Integer> getResults() {
        return new ArrayDeque<>(this.results);
    }
    public void setResults(int result) {
        this.results.add(result);
    }
    public void removeFirstResult() {
        if(!results.isEmpty()){
            this.results.removeFirst();
        }
        System.out.println("당신의 최근 계산 결과 값 기록입니다 : "+ getResults());
    }
    //검증
    public boolean isInteger(String str) {
        if(!str.matches("\\d+")) {
            System.out.println("정수를 입력해주세요.");
            return false;
        }
        return true;
    }
    public boolean isNotDividedByZero(int n) {
        if(n == 0) {
            System.out.println("나눗셈에서 0으로 나눌 수 없습니다.");
            return true;
        }
        return false;
    }

}
