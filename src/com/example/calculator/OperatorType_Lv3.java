package com.example.calculator;

import java.util.Scanner;

public enum OperatorType_Lv3 {
    PLUS('+'),
    MINUS('-'),
    MUL('x'),
    DIV('/');

    private final char sym;
    OperatorType_Lv3(char sym){
        this.sym = sym;
    }

    public char getSym(){
        return sym;
    }

    public static OperatorType_Lv3 fromChar(Scanner sc){
        while(true){
            System.out.print("사칙연산 기호 입력 (+,-,x,/):");
            char in = sc.next().charAt(0);
            for(OperatorType_Lv3 op : OperatorType_Lv3.values()){
                if (op.getSym() == in){
                    return op;
                }
            }
            System.out.println("유효하지 않은 연산자입니다.");
        }
    }
}