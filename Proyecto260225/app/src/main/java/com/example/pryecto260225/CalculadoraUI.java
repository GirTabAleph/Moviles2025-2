package com.example.pryecto260225;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraUI implements ICalculadoraUI{

    ICalculadoraMemoria memoria = new CalculadoraMemoria();

    //Por si acaso.
    Context context;

    //Display.
    TextView vistaResultados;

    Button btnSuma;
    Button btnResta;
    Button btnMultiplicacion;
    Button btnDivision;
    Button btnPorcentaje;
    Button btnNegativo;
    Button btnParentesis;
    Button btnIgual;
    Button btnClear;

    Button btnUno, btnDos, btnTres, btnCuatro,
    btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnCero;

    public CalculadoraUI(Activity activity){

        context = activity.getApplicationContext();

        vistaResultados = activity.findViewById(R.id.vistaResultados);

        btnCero = activity.findViewById(R.id.btnCero);
        btnUno = activity.findViewById(R.id.btnUno);
        btnDos = activity.findViewById(R.id.btnDos);
        btnTres = activity.findViewById(R.id.btnTres);
        btnCuatro = activity.findViewById(R.id.btnCuatro);
        btnCinco = activity.findViewById(R.id.btnCinco);
        btnSeis = activity.findViewById(R.id.btnSeis);
        btnSiete = activity.findViewById(R.id.btnSiete);
        btnOcho = activity.findViewById(R.id.btnOcho);
        btnNueve = activity.findViewById(R.id.btnNueve);

        btnSuma = activity.findViewById(R.id.btnSuma);
        btnResta = activity.findViewById(R.id.btnResta);
        btnMultiplicacion = activity.findViewById(R.id.btnMultiplicacion);
        btnDivision = activity.findViewById(R.id.btnDivision);
        btnPorcentaje = activity.findViewById(R.id.btnPorcentaje);
        btnParentesis = activity.findViewById(R.id.btnParentesis);
        btnNegativo = activity.findViewById(R.id.btnNegativo);
        btnIgual = activity.findViewById(R.id.btnIgual);

        btnClear = activity.findViewById(R.id.btnClear);

        btnCero.setOnClickListener(v -> {
            addNumber("0");
        });


        btnUno.setOnClickListener(v -> {
            addNumber("1");
        });

        btnDos.setOnClickListener(v -> {
            addNumber("2");
        });

        btnTres.setOnClickListener(v -> {
            addNumber("3");
        });


        btnCuatro.setOnClickListener(v -> {
            addNumber("4");
        });


        btnCinco.setOnClickListener(v -> {
            addNumber("5");
        });


        btnSeis.setOnClickListener(v -> {
            addNumber("6");
        });


        btnSiete.setOnClickListener(v -> {
            addNumber("7");
        });


        btnOcho.setOnClickListener(v -> {
            addNumber("8");
        });


        btnNueve.setOnClickListener(v -> {
            addNumber("9");
        });

    }

    @Override
    public void clear() {
        vistaResultados.setText("");
        memoria.clear();
    }

    @Override
    public void showResult(String result) {
        vistaResultados.setText(result);
    }

    @Override
    public String addNumber(String numero) {
        vistaResultados.setText(numero);
        return memoria.concat(numero);
    }

    @Override
    public void addOperation(Operacion operacion) {
        vistaResultados.setText(Operacion.convert(operacion));
        memoria.concat(operacion);
    }

}