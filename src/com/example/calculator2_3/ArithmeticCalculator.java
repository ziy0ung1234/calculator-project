package com.example.calculator2_3;

import java.util.ArrayDeque;
import java.util.function.DoubleBinaryOperator; // 함수형 인터페이스 임포트

enum OperatorType {
    PLUS('+',(x, y) -> x + y),
    MINUS('-', (x, y) -> x - y),
    MULTIPLY('*', (x, y) -> x * y),
    DIVIDE('/',(x, y) -> x / y);
    //속성
    private final char operator;
    private final DoubleBinaryOperator op;

    //생성자
    OperatorType(char operator, DoubleBinaryOperator op) {
        this.operator = operator;
        this.op = op;
    }

    //기능
    public static OperatorType parseOperator(char c) {
        for (OperatorType op : OperatorType.values()) {
            if (op.operator == c) return op;
        }
        return null;
    }
    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
public class ArithmeticCalculator <T extends Number> {
    //속성
    private Number result = 0;
    private ArrayDeque<Number> results =  new ArrayDeque<>();

    //기본 생성자 생략

    //기능
    public boolean calculate(T a, T b, char op) {
        OperatorType operator = OperatorType.parseOperator(op);
        if (operator == null) {
            System.out.println("잘못된 연산기호입니다.");
            return true;
        }
        double x = a.doubleValue();
        double y = b.doubleValue();
        if (operator == OperatorType.DIVIDE && isNotDividedByZero(y)) {
            return true; // error
        }

        // 결과값 정수 실수 판별후 해당 타입으로 저장
        double temp = operator.apply(x, y);
        result = DoubleOrInt(temp);
        setResults(result);
        return false;
    }
    // 연산 결과 관련 기능
    public Number getResult(){
        return result;
    }
    public ArrayDeque<Number> getResults() {
        return new ArrayDeque<>(this.results);
    }
    public void setResults(Number result) {
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
    public boolean isNotDividedByZero(double n) {
        if(n == 0) {
            System.out.println("나눗셈에서 0으로 나눌 수 없습니다.");
            return true;
        }
        return false;
    }
    public Number DoubleOrInt(double x) {
        if(x % 1 == 0) return (int) x;
        else return x;
    }

}
