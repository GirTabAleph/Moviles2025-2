package com.example.m4_01;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Log.i("INFO", "Mensaje de creación de la actividad: onCreate().");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("INFO", "onResume: La actividad está en uso.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("INFO", "La actividad fue pausada, onPause().");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("INFO", "La actividad se detuvo, onStop().");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("INFO", "La actividad se está rebooteando.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("INFO", "La actividad fue matada: onDestroy().");
    }

}