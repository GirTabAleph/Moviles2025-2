package com.example.pryecto260225;

import java.math.BigDecimal;

public class Calculadora implements ICalculadora{
    @Override
    public BigDecimal calculadora(Operacion operacion, BigDecimal x, BigDecimal y) {
        switch(operacion){
            case SUMA:
                return x.add(y);
            case RESTA:
                return x.subtract(y);
            case MULT:
                return x.multiply(y);
            case DIV:
                return x.divide(y);
            case PORC:
                //rEGRESAR LUEGO.
                return BigDecimal.ZERO;
        }
        return BigDecimal.ZERO;
    }
}
