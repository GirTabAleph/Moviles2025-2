package com.example.a23032025;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAgregar;
    List<Button> listaBotones = new ArrayList<Button>();
    //LinearLayout root;
    GridLayout root;


    int conteoBoton = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        root = findViewById(R.id.lytMain);
        /*
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v -> {
            generarImagen();
        });
        */
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setText("Generar botón");

        btnAgregar.setOnClickListener(v -> {
            generarBotones();
        });

    }

    //Esto mata los botones y reestablece el contador en cero.
    @Override
    protected void onResume() {
        super.onResume();
        conteoBoton = 0;
        root.removeAllViews();
        root.addView(btnAgregar); // Vuelve a agregar el botón principal
    }

    void generarImagen(){

        //Inflado de vistas: Tomamos un XML desde Java y lo modificamos sin usar
        //el XML directamente.
        LinearLayout lytItemPrueba = (LinearLayout)LinearLayout.inflate(this, R.layout.item_prueba, null);
        ImageView img = new ImageView(this);

        //Generar la imagen.
        img.setImageResource(R.mipmap.ic_launcher);
        img.setMinimumHeight(100);
        img.setMinimumWidth(MATCH_PARENT);

        //Agregamos elementos desde java.
        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(img);
        lytItemPrueba.setMinimumWidth(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.crimson, getTheme()));

        //Agregar el layout inflado a la vista root.
        root.addView(lytItemPrueba);

    }

    void generarBotones(){

        //Preincremento por cuestiones de programación.
        ++conteoBoton;
        Button nuevo = new Button(this);
        nuevo.setText("Botón " + conteoBoton);
        int posicion = conteoBoton;

        nuevo.setOnClickListener(v -> {

            Toast.makeText(MainActivity.this, "Botón " + posicion, Toast.LENGTH_SHORT).show();

        });

        listaBotones.add(nuevo);
        root.addView(nuevo);

    }

}