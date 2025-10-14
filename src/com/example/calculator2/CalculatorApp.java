package com.example.calculator2;
import java.util.*;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        System.out.println("안녕하세요 계산기입니다.");
        System.out.println("두 개의 숫자(0 이상)와 연산기호(+,-,*,/)를 입력할 수 있어요.");
        System.out.println("종료하려면 'exit'를 입력하세요.");

        while(true) {
            System.out.print("첫번째 숫자를 입력하세요: ");
            String input1 = sc.next();
            if(input1.equalsIgnoreCase("exit")) break;

            if(!input1.matches("\\d+")) {
                System.out.println("정수를 입력해주세요.");
                continue;
            }

            System.out.print("두번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            if(input2.equalsIgnoreCase("exit")) break;

            if(!input2.matches("\\d+")) {
                System.out.println("정수를 입력해주세요.");
                continue;
            }

            System.out.print("연산 기호를 입력하세요: ");
            String opInput = sc.next();
            if(opInput.equalsIgnoreCase("exit")) break;

            int firstNum = Integer.parseInt(input1);
            int secondNum = Integer.parseInt(input2);
            char operator = opInput.charAt(0);
            boolean error = false;
            int result = 0;

            switch(operator) {
                case '+':
                    result = cal.plus(firstNum,secondNum);
                    break;
                case '-':
                    result = cal.minus(firstNum,secondNum);
                    break;
                case '*':
                    result = cal.multiply(firstNum,secondNum);
                    break;
                case '/':
                    if(secondNum == 0) {
                        System.out.println("나눗셈에서 0으로 나눌 수 없습니다.");
                        error = true;
                    } else {
                        result = cal.divide(firstNum,secondNum);
                    }
                    break;
                default:
                    System.out.println("잘못된 연산기호입니다.");
                    error = true;
            }
            if(!error) {
                System.out.println("결과는 " + result + "입니다.");
                System.out.println("더 계산하시겠습니까? exit 입력 시 종료합니다. 계속하시려면 아무키나 눌러주세요");
                String inputExit = sc.next();
                if(inputExit.equalsIgnoreCase("exit")) {
                    sc.close();
                }
            } else {
                System.out.println("다시 입력해주세요.");
            }
        }
        System.out.println("계산기를 종료합니다.");
        sc.close();
    }
}
