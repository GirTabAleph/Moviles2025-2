package com.example.pryecto260225;

public class CalculadoraMemoria implements ICalculadoraMemoria{

    String display = "";
    Operacion operacion = null;
    @Override
    public String concat(String numero) {

        return (display += numero);
    }


    @Override
    public void clear() {
        display  = "";
        this.operacion = null;
    }

    @Override
    public String concat(Operacion operacion) {
        this.operacion = operacion;
        return Operacion.convert(operacion);
    }
}
