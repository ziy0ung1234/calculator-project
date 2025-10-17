package com.example.calculator2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *[ArithmeticCalculator] 계산 결과 조회/저장 클래스
 * 속성 필드 private로 getter를 통해 접근한다
 * 연산 결과 나온 시점에 setter로 리스트에 저장한다
 * @param <T> Number 타입을 상속한 숫자형 타입 (Integer, Double 등)
 */
public class ArithmeticCalculator <T extends Number> {
    //속성
    private Number result = 0;
    private List<Number> results =  new ArrayList<>();

    //기본 생성자 생략

    //기능
    /**
     * @param a 첫 번째 숫자 (T 타입)
     * @param b 두 번째 숫자 (T 타입)
     * @param op 연산자 문자 ('+', '-', '*', '/')
     * @return 오류 시 true, 정상 수행 false
     */
    public boolean calculate(T a, T b, char op) {
        Optional<OperatorType> optionalOp = OperatorType.getOperator(op);
        if (optionalOp.isEmpty()) {
            System.out.println("잘못된 연산기호입니다.");
            return true;
        }
        OperatorType operator = optionalOp.get();
        double x = a.doubleValue();
        double y = b.doubleValue();
        if (operator == OperatorType.DIVIDE && isNotDividedByZero(y)) {
            return true; // error
        }

        // 결과값 정수 실수 판별후 해당 타입으로 저장
        try {
            double temp = operator.applyResult(x, y);
            result = DoubleOrInt(temp);
            setResults(result);
            return false;
        } catch (ArithmeticException e) {
            System.out.println("연산 중 오류가 발생했습니다: " + e.getMessage());
            return true;
        }
    }
    public Number getResult(){
        return result;
    }
    public ArrayList<Number> getResults() {
        return new ArrayList<>(this.results);
    }
    public void setResults(Number result) {
        Optional.ofNullable(result).ifPresent(x -> this.results.add(x));
    }
    public void filterResults(String str) {
        try{
            Number num = str.contains(".") ? Double.parseDouble(str) : Integer.parseInt(str);
            List<Number> numList = getResults().stream()
                    .filter(n -> n.doubleValue() > num.doubleValue())
                    .collect(Collectors.toList());

            System.out.println(" 당신이 입력한 값보다 큰 결과들 입니다.: "+ numList);
        } catch(ArithmeticException e){
            System.out.println("잘못된 숫자 입력입니다.");
        }

    }
    //검증
    public boolean isDigit(String str) {
        if(!str.matches("^-?\\d+(\\.\\d+)?$")) {
            System.out.println("숫자를 입력해주세요.");
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
