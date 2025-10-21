package com.example.calculator2_3;

/**
* [Operators] 연산 클래스
* 필드 접근 제어자 public - 전역에서 재사용 가능한 상수처럼 쓰기 위함
* 인터페이스 Operator 사용해서 같은 타입, 각 연산 기호에 맞는 연산 수행
 *
*/
public class Operators {
     public interface Operator {
         /**
          * @param x 첫 번째 피연산자
          * @param y 두 번째 피연산자
          * */
         public double apply(double x, double y);
     }

    public static final Operator PLUS = (x, y) -> x + y;
    public static final Operator MINUS = (x, y) -> x - y;
    public static final Operator MULTIPLY = (x, y) -> x * y;
    public static final Operator DIVIDE = (x, y) -> {
        if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return x / y;
    };
}
