package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator_Lv3<T extends Number> {
    private List<Double> result = new ArrayList<>();

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
            case MUL:
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
        result.add(res);
        return res;
    }

    // getter
    public List<Double> getRes(){
        return this.result;
    }

    //setter
    public void setRes(List<Double> result){
        this.result = result;
    }

    public void removeRes(){
        if (!result.isEmpty()){
            result.remove(0);
        }
    }

    //람다,스트림 적용
    public List<Double> filterGreater(double th){
        return result.stream().filter(a -> a>th)
                .collect(Collectors.toList());
    }

    public List<Double> filterBetween(double min, double max){
        return result.stream().filter(a -> a>=min && a<=max)
                .collect(Collectors.toList());
    }
}
