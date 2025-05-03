package com.example.calculator;

public class ArithmeticCalculator_Lv3 {
    //null값 사용 위해 자료형 Integer로 지정
    public Integer calculate(int n1, int n2, OperatorType_Lv3 op) {
        int res = 0;
        switch (op) {
            case PLUS:
                res = n1 + n2;
                break;
            case MINUS:
                res = n1 - n2;
                break;
            case MUL:  // '*'만 지원
                res = n1 * n2;
                break;
            case DIV:
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return null;
                }
                res = n1 / n2;
                break;
        }

        return res;
    }
}
