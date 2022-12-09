package org.example;

/**
 * @author gaols
 * @version 1.0
 * @date 2022/12/7 16:24
 */
public class Calculator {
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
    public int division(int a,int b){
        if (b!=0){
            return a/b;
        }else {
            return 0;
        }
    }
}
