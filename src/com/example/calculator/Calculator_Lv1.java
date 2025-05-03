package com.example.calculator;

import java.util.Scanner;

public class Calculator_Lv1 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        while (true){
            //1) 정수 입력(readint 함수 이용)
            int n1 = readint(sc, "첫 번째 정수 입력: ");
            int n2 = readint(sc, "두 번째 정수 입력: ");

            //2) 연산자 입력 받기
            System.out.print("사칙연산 기호 입력 (+,-,x,/):");
            char op = sc.next().charAt(0);


            //3) 연산 결과 처리
            int res = 0;
            boolean error = false;
            switch (op){
                case '+':
                    res = n1 + n2;
                    break;
                case '-':
                    res = n1 - n2;
                    break;
                case 'x':
                    res = n1 * n2;
                    break;
                case '/':
                    if (n2 == 0){
                        System.out.println("0으로 나눌 수 없습니다.");
                        error = true;
                    }else{
                        res = n1/n2;
                    }
                    break;

                default:
                    System.out.println("유효하지 않은 연산자 입니다.");
                    error = true;
            }

            if (!error){
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

    // 정수가 아닌 수 입력 시 에러처리
    private static int readint(Scanner sc, String msg){
        while(true){
            System.out.print(msg);
            String input = sc.next();
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("0 이상의 정수를 입력하세요.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력하세요.");
            }
        }
    }
}
