package com.example.calculator2_3;
import java.util.*;

/**
* [ArithmeticCalculatorApp] 입출력 클래스
* 연산에 필요한 입력과 그에 따른 결과를 출력
*/
public class ArithmeticCalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calc = new ArithmeticCalculator<>();

        System.out.println("안녕하세요 계산기입니다.");
        System.out.println("두 개의 숫자(0 이상)와 연산기호(+,-,*,/)를 입력할 수 있어요.");
        System.out.println("종료하려면 'exit'를 입력하세요.");

        while(true) {
            System.out.print("첫번째 숫자를 입력하세요: ");
            String input1 = sc.next();
            if (input1.equalsIgnoreCase("exit")) break;
            if (!calc.isDigit(input1)) continue;

            System.out.print("두번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            if (input2.equalsIgnoreCase("exit")) break;
            if (!calc.isDigit(input2)) continue;

            System.out.print("연산 기호를 입력하세요: ");
            String opInput = sc.next();
            if (opInput.equalsIgnoreCase("exit")) break;

            char operator = opInput.charAt(0);
            try {
                Number result = calc.calculate(Double.parseDouble(input1), Double.parseDouble(input2), operator);
                System.out.println("결과는 " + result + "입니다.");
                System.out.println("더 계산하시겠습니까? exit 입력 시 종료합니다. 계속하시려면 아무키나 눌러주세요");
                String inputExit = sc.next();
                if (inputExit.equalsIgnoreCase("exit")) break;
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage() + " 다시 입력해주세요.");
                // 사용자 입력 다시 받기
            }
        }
        // 유저가 입력 한 값보다 큰 results 출력
        System.out.println("종료 전 숫자 하나를 입력하시면 계산 결과값들 중 선택하신 숫자보다 큰 결과를 보여드려요.");
        System.out.print("숫자를 입력하세요: ");
        String selectedNum = sc.next();
        if (calc.isDigit(selectedNum)) {
            calc.filterResultsGreaterThan(selectedNum);
        } else {
            System.out.println("계산기를 종료합니다.");
        }
        sc.close();
    }
}
