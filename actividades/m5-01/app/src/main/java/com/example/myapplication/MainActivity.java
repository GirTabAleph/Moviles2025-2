package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GestorFibonacci gestorFibonacci;
    private TextView txtFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestorFibonacci = new GestorFibonacci();
        txtFibonacci = findViewById(R.id.txtFibonacci);

        Button btnNext = findViewById(R.id.btnNext);
        Button btnPrevious = findViewById(R.id.btnPrevious);

        // Mostrar el valor inicial
        txtFibonacci.setText(String.valueOf(gestorFibonacci.getCurrent()));

        btnNext.setOnClickListener(v -> {
            gestorFibonacci.next();
            txtFibonacci.setText(String.valueOf(gestorFibonacci.getCurrent()));
        });

        btnPrevious.setOnClickListener(v -> {
            gestorFibonacci.previous();
            txtFibonacci.setText(String.valueOf(gestorFibonacci.getCurrent()));
        });
    }
}
