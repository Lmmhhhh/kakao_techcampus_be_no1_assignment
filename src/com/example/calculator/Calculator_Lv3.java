package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator_Lv3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator_Lv3<Double> cal = new ArithmeticCalculator_Lv3<>();

        while (true) {
            //1) 실수 입력(readDouble 함수 이용)
            double n1 = readDouble(sc, "첫 번째 실수 입력: ");
            double n2 = readDouble(sc, "두 번째 실수 입력: ");

            //2) 연산자 입력 받기
            System.out.print("사칙연산 기호 입력 (+,-,x,/):");
            char opChar = sc.next().charAt(0);
            OperatorType_Lv3 op = OperatorType_Lv3.fromChar(opChar);

            //Cal class 이용하여 계산
            Double res = cal.calculate(n1,n2,op);

            if (res!=null){
                System.out.println("결과: "+ res);
            }

            System.out.println("더 계산 하시겠습니다까? (exit 입력 시 종료)");
            String nx = sc.next();
            if (nx.equals("exit")){
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        sc.close();

    }

    // 실수가 아닌 수 입력 시 에러처리
    private static double readDouble(Scanner sc, String msg){
        while(true){
            System.out.print(msg);
            String input = sc.next();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("실수를 입력하세요.");
            }
        }
    }
}
