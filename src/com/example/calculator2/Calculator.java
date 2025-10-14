package com.example.calculator2;

import java.util.ArrayDeque;

public class Calculator {
    //속성
    private int result = 0;
    private ArrayDeque<Integer> results = new ArrayDeque<>();

    //기본 생성자 생략

    //기능
    public int plus(int a, int b) {
        result = a + b;
        setResults(result);
        return result;
    }
    public int minus(int a, int b) {
        result = a - b;
        setResults(result);
        return result;
    }
    public int multiply(int a, int b) {
        result = a * b;
        setResults(result);
        return result;
    }
    public int divide(int a, int b) {
        result = a / b;
        setResults(result);
        return result;
    }
    // 연산 결과 관련 기능
    public int getResult(){
        return result;
    }
    public void setResults(int result) {
        this.results.add(result);
    }
    public void removeFirstResult() {
        if(!results.isEmpty()){
            this.results.removeFirst();
        }
        System.out.println("당신의 최근 계산 결과 값 기록입니다 : "+ results);
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
