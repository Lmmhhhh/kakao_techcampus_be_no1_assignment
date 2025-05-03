package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator_Lv2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Calculator_class_Lv2 cal = new Calculator_class_Lv2();

        while (true) {
            //1) 정수 입력(readint 함수 이용)
            int n1 = readint(sc, "첫 번째 정수 입력: ");
            int n2 = readint(sc, "두 번째 정수 입력: ");

            //2) 연산자 입력 받기
            System.out.print("사칙연산 기호 입력 (+,-,x,/):");
            char op = sc.next().charAt(0);

            //Cal class 이용하여 계산
            Integer res = cal.calculate(n1,n2,op);

            if (res != null){
                System.out.println("결과: "+ res);
            }

            //getter, setter, remove 메서드 활용 : 옵션 선택(pass가 입력될 때까지 반복)
            while (true) {
                System.out.print("옵션 선택: ans(최근결과)  / history(결과 목록) / reset(결과 목록 초기화) /remove(가장 오래된 값 삭제) / pass : ");
                String option = sc.next();

                switch (option.toLowerCase()) {
                    case "ans":
                        List<Integer> result = cal.getRes();
                        if (!result.isEmpty()) {
                            System.out.println("ANS(가장 최근 결과): " + result.get(result.size() - 1));
                        } else {
                            System.out.println("저장된 결과가 없습니다.");
                        }
                        break;

                    case "history":
                        System.out.println("계산 결과 history: " + cal.getRes());
                        break;

                    case "reset":
                        cal.setRes(new ArrayList<>());
                        System.out.println("결과가 초기화되었습니다.");
                        break;

                    case "pass":
                        System.out.println("다음 계산으로 넘어갑니다.");
                        break;

                    case "remove":
                        cal.removeRes();
                        System.out.println("가장 먼저 저장된 결과가 제거되었습니다.");
                        break;

                    default:
                        System.out.println("유효하지 않은 옵션입니다.");
                }

                // pass를 입력하면 옵션 루프를 빠져나감
                if (option.equalsIgnoreCase("pass")) {
                    break;
                }
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

