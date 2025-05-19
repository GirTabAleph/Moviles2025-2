package com.example.pryecto260225;

public enum Operacion {

    SUMA, RESTA, MULT, DIV, PORC, NONE;

    public static String convert(Operacion operacion){

        switch(operacion){
            case SUMA:
                return "+";
            case RESTA:
                return "-";
            case MULT:
                return "*";
            case DIV:
                return "/";
            case PORC:
                return "%";
            case NONE:
                return "Error";
        }

        return "";

    }

}
