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
            OperatorType_Lv3 op = OperatorType_Lv3.fromChar(sc);

            //Cal class 이용하여 계산
            Double res = cal.calculate(n1,n2,op);

            if (res!=null){
                System.out.println("결과: "+ res);
            }

            //getter, setter, remove 메서드 활용 : 옵션 선택(pass가 입력될 때까지 반복)
            //Lv3 기준값 출력 옵션 추가(람다, 스트림)
            while (true) {
                System.out.print("옵션 선택: ans(최근결과)  / history(결과 목록) / reset(결과 목록 초기화) " +
                        "\n /remove(가장 오래된 값 삭제) / threshold(기준값 입력)/ pass : ");
                String option = sc.next();

                switch (option.toLowerCase()) {
                    case "ans":
                        List<Double> result = cal.getRes();
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
                        //System.out.println("다음 계산으로 넘어갑니다.");
                        break;

                    case "remove":
                        cal.removeRes();
                        System.out.println("가장 먼저 저장된 결과가 제거되었습니다.");
                        break;
                    //Lv3 추가
                    case "threshold":
                        System.out.print("기준을 선택하세요 : greater/between : ");
                        String stand = sc.next();

                        switch(stand.toLowerCase()){
                            case "greater":
                                System.out.print("기준값을 입력하세요: ");
                                double th = Double.parseDouble(sc.next());
                                System.out.println("기준값보다 큰 결과: " + cal.filterGreater(th));
                                break;
                            case "between":
                                System.out.print("하한값을 입력하세요: ");
                                double min = Double.parseDouble(sc.next());
                                System.out.print("상한값을 입력하세요: ");
                                double max = Double.parseDouble(sc.next());
                                System.out.println(min + "~" + max + " 사이 결과: " + cal.filterBetween(min, max));
                                break;

                            default:
                                System.out.println("유효하지 않은 기준입니다.");
                        }
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
