package com.example.calculator;

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

    public static OperatorType_Lv3 fromChar(char in){
        for(OperatorType_Lv3 op : OperatorType_Lv3.values()){
            if (op.getSym() == in){
                return op;
            }
        }
        System.out.println("유효하지 않은 연산자입니다.");
        return null;
    }
}