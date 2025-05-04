package com.example.calculator;

public class ArithmeticCalculator_Lv3<T extends Number> {
    public Double calculate(T n1, T n2, OperatorType_Lv3 op) {
        double a = n1.doubleValue();
        double b = n2.doubleValue();
        double res = 0;
        switch (op) {
            case PLUS:
                res = a+b;
                break;
            case MINUS:
                res = a-b;
                break;
            case MUL:  // '*'만 지원
                res = a*b;
                break;
            case DIV:
                if (b == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return null;
                }
                res = a/b;
                break;
        }

        return res;
    }
}
