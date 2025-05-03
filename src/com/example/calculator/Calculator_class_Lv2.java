package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator_class_Lv2 {
    private List<Integer> result = new ArrayList<>();

    //null값 사용 위해 자료형 Integer로 지정
    public Integer calculate(int n1, int n2, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case 'x':  // '*'만 지원
                res = n1 * n2;
                break;
            case '/':
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return null;
                }else{
                    res = n1 / n2;
                    break;
                }

            default:
                System.out.println("유효하지 않은 연산자입니다.");
                return null;
        }
        result.add(res);
        return res;
    }

    // getter
    public List<Integer> getRes(){
        return this.result;
    }

    //setter
    public void setRes(List<Integer> result){
        this.result = result;
    }

    public void removeRes(){
        if (!result.isEmpty()){
            result.remove(0);
        }
    }
}