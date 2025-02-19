package com.example.calculadora19_02_25;

public class Fibonacci {

    public Fibonacci(){
    }

    public static long fibonacciRecursivo(long topeSerie){

        if(topeSerie == 0){

            return 0;

        }

        if(topeSerie == 1 || topeSerie == 2){

            return 1;

        }

        return fibonacciRecursivo(topeSerie - 2) + fibonacciRecursivo(topeSerie - 1);

    }

}
