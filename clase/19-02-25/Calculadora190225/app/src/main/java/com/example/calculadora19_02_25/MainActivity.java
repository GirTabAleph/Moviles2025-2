package com.example.calculadora19_02_25;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txvMiTexto = null; //Atributo de tipo TextView
    String cadena = "";
   // Button btnReinicio;
    Button btnFibonacci;
    int numeroClick = 0;
    long resultado;

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
        Log.println(Log.INFO, null, "onCreate savedInstance");

        txvMiTexto = findViewById(R.id.txv_main);
        /*
        btnReinicio = findViewById(R.id.btn_reinicio);
        btnReinicio.setText("Reinicio");
        btnReinicio.setOnClickListener(this);
         */
        btnFibonacci = findViewById(R.id.btn_fibonacci);
        btnFibonacci.setText("Fibonacci");
        btnFibonacci.setOnClickListener(this);
        //Estas líneas se copian a los métodos del lyfecycle.
        //cadena += "\n| onCreate(savedInstance) ";

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.println(Log.INFO, null, "onCreate savedInstance persistentState");

        //cadena += "|\n onCreate(savedInstance, persistentState) ";
        //txvMiTexto.setText(cadena);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.println(Log.INFO, null, "onStart");

        //cadena += "\n| onStart() ";
        //txvMiTexto.setText(cadena);
        //cadena += "Resultado de la serie Fibonacci en este click: " + resultado + "\n";
        //txvMiTexto.setText(cadena);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.println(Log.INFO, null, "onPause");

        //cadena += "\n| onPause() ";
        //txvMiTexto.setText(cadena);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.println(Log.INFO, null, "onStop");

        //cadena += "\n| onStop() ";
        //txvMiTexto.setText(cadena);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.println(Log.INFO, null, "onDestroy");

        //cadena += "\n| onDestroy() ";
        //txvMiTexto.setText(cadena);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.println(Log.INFO, null, "onRestart");

        //cadena += "\n| onRestart() ";
        txvMiTexto.setText(cadena);

    }

    @Override
    public void onClick(View v) {

      cadena = ("");

      resultado =  Fibonacci.fibonacciRecursivo(numeroClick);
      numeroClick++;

      // Actualizar el TextView con el nuevo resultado
      cadena += "Resultado de la serie Fibonacci en este click: " + resultado + "\n";
      txvMiTexto.setText(cadena);

      //Limpiar la cadena.
      cadena = ("");

    }

}