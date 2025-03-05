package com.example.pryecto260225;

public interface ICalculadoraUI {

    CalculadoraMemoria memoria = null;

    //Limpieza de pantalla.
    void clear();

    //Mostrar resultado.
    void showResult(String result);

    //Agregar operación.
    String addNumber(String numero);

    void addOperation(Operacion operacion);

}
