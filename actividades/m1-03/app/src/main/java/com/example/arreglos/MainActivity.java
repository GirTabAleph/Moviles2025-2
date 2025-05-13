package com.example.arreglos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Para los aleatórios.
import java.lang.Math;

//Para ordenamiento.
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Arreglo con un millon de elementos int generados aleatoriamente.
    int[] arreglo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Llenado del arreglo.
        for(int i = 0; i <= 1000000; ++i){

            //Generación del aleatorio en cada posición.
            arreglo[i] = (int) java.lang.Math.random();

        }

        //Ordenar el arreglo con sort();
        Arrays.sort(arreglo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}