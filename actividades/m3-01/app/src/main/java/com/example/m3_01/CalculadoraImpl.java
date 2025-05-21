package com.example.m3_01;

import android.util.Log;

//Clase de implementación de la interfaz.
public class CalculadoraImpl implements ICalculadora{

    //Operadores.
    private Double x, y;

    //Sobrecargas.
    @Override
    public Double suma(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double resta(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiplicacion(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double division(Double x, Double y) {
       if(y == 0){

           Log.e("Calculadora", "Error NaN: divisón entre cero es indefinida.");
           return Double.NaN;

       }

       return x / y;

    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    //Constructor parametrizado.
    public CalculadoraImpl(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    //Constructor vacío.
    public CalculadoraImpl(){
        
    }

}