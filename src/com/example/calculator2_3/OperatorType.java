package com.example.calculator2_3;

import java.util.Optional;

/**
*[OperatorType] enum 맵핑 클래스
* 기존 연산까지 담당하던 로직 분리
* 속성 필드 private로 getter를 통해 접근한다
*/
public enum OperatorType {
    PLUS('+', Operators.PLUS),
    MINUS('-', Operators.MINUS),
    MULTIPLY('*', Operators.MULTIPLY),
    DIVIDE('/', Operators.DIVIDE);
    //속성
    private final char operator;
    private final Operators.Operator op;

    //생성자
    /**
     * @param operator 연산자 기호 ('+', '-', '*', '/')
     * @param op 실제 연산 로직을 수행하는 함수형 인터페이스(Operators.Operator)
     * */
    OperatorType(char operator, Operators.Operator op) {
        this.operator = operator;
        this.op = op;
    }

    //기능
    /** @param c 조회할 연산자 문자 ('+', '-', '*', '/')
     * @return 일치하는 OperatorType을 Optional로 감싼 객체.
     *         - 일치하는 연산자가 존재하면 Optional.of(op)
     *         - 존재하지 않으면 Optional.empty() 반환
     */
    public static Optional<OperatorType> getOperator(char c) {
        for (OperatorType op : OperatorType.values()) {
            if (op.operator == c) return Optional.of(op);
        }
        return Optional.empty();
    }
    public double applyResult(double x, double y) {
        return op.apply(x, y);
    }
}