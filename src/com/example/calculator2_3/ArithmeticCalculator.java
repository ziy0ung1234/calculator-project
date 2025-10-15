package com.example.calculator2_3;

import java.util.ArrayDeque;
import java.util.function.IntBinaryOperator; // 함수형 인터페이스 임포트

enum OperatorType {
    PLUS('+',(x, y) -> x + y),
    MINUS('-', (x, y) -> x - y),
    MULTIPLY('*', (x, y) -> x * y),
    DIVIDE('/',(x, y) -> x / y);

    private final char operator;
    private final IntBinaryOperator op;

    OperatorType(char operator, IntBinaryOperator op) {
        this.operator = operator;
        this.op = op;
    }

    public static OperatorType parseOperator(char c) {
        for (OperatorType op : OperatorType.values()) {
            if (op.operator == c) return op;
        }
        return null;
    }
    public int apply(int x, int y) {
        return op.applyAsInt(x, y);
    }
}
public class ArithmeticCalculator {
    //속성
    private int result = 0;
    private ArrayDeque<Integer> results = new ArrayDeque<>();

    //기본 생성자 생략

    //기능
    public boolean calculate(int a, int b, char op) {
        OperatorType operator = OperatorType.parseOperator(op);
        //TODO 예외처리
        if (operator == null) {
            System.out.println("잘못된 연산기호입니다.");
            return true;
        }
        if (operator == OperatorType.DIVIDE && isNotDividedByZero(b)) {
            return true; // error
        }
        result = operator.apply(a, b);
        setResults(result);
        return false;
    }
    // 연산 결과 관련 기능
    public int getResult(){
        return result;
    }
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
