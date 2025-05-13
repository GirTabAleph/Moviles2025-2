package com.example.myapplication;

public class GestorFibonacci {

    int index = 1;

    public int getCurrent() {
        return fibonacci(index);
    }

    public int next() {
        index++;
        return fibonacci(index);
    }

    public int previous() {
        if (index > 1) {
            index--;
        }
        return fibonacci(index);
    }

    private int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;

        int a = 1, b = 1, result = 1;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

}