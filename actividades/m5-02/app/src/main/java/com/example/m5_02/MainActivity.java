package com.example.m5_02;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Intentar leer el archivo.
        try {

            InputStream datos = getResources().openRawResource(R.raw.datos);
            BufferedReader reader = new BufferedReader(new InputStreamReader(datos));
            StringBuilder builder = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {

                builder.append(linea).append("\n");

            }

            procesarDatos(builder.toString());

        } catch (IOException e) {

            Log.e("Error", "Error leyendo el archivo", e);
            e.printStackTrace();

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void procesarDatos(String input) {

        String[] grupos = input.split("\\n\\s*\\n");

        int maxCalorias = 0;
        int elfoMax = -1;

        for (int i = 0; i < grupos.length; i++) {

            String[] lineas = grupos[i].split("\\n");
            int suma = 0;

            for (String linea : lineas) {

                if (!linea.trim().isEmpty()) {

                    suma += Integer.parseInt(linea.trim());

                }

            }

            String elfoActual = "Elfo " + (i + 1) + " tiene " + suma + " calorías.";
            Log.i("Elfo actual", elfoActual);

            if (suma > maxCalorias) {

                maxCalorias = suma;
                elfoMax = i + 1;

            }
        }

        String mensaje = "El elfo con más calorías es el número " + elfoMax + ", con " + maxCalorias
                + " calorías.";

        Log.i("Resultado", mensaje);

    }

}