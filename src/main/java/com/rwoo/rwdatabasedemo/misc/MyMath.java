package com.rwoo.rwdatabasedemo.misc;

public class MyMath {
    public int sum(int[] numbers){
        int sum=0;
        for (int i :numbers){
            sum += i;
        }
        return  sum;
    }
}