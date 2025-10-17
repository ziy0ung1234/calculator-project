package com.example.calculator2;

import java.util.ArrayDeque;

public class Calculator {
    //속성
    private int result = 0;
    private ArrayDeque<Integer> results = new ArrayDeque<>();

    //기본 생성자 생략

    //기능
    public boolean calculate(int a, int b, char op) {
        boolean error = false;
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
                    error = true;
                } else {
                    result = a / b;
                }
                break;
            default:
                System.out.println("잘못된 연산기호입니다.");
                error = true;
        }
        if(!error) setResults(result);
        return error;
    }

    // 연산 결과 관련 기능
    public int getResult(){
        return this.result;
    }
    public ArrayDeque<Integer> getResults() {
        return new ArrayDeque<>(this.results);
    }
    private void setResults(int result) {
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
