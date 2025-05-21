package com.example.m3_01;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Declarar como interfaz..
    private ICalculadora calculadora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Operandos con valores de prueba.
        Double x = 22.0;
        Double y = 4.0;

        //Instanciar la calculadora.
        calculadora = new CalculadoraImpl(x, y);

        //Operar y mostrar en logcat.
        Log.i("Calculadora", "Resultados");
        Log.i("Calculadora", "Suma: " + calculadora.suma(x, y));
        Log.i("Calculadora", "Resta: " + calculadora.resta(x, y));
        Log.i("Calculadora", "Multiplicación: " + calculadora.multiplicacion(x, y));
        Log.i("Calculadora", "División: " + calculadora.division(x, y));

    }

}