package com.example.gato;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    //Tablero de juego.
    private ImageView[][] tablero = new ImageView[3][3];
    //Estado actual del juego.
    private char[][] gameState = new char[3][3]; // 'X', 'O' , ' '
    //Siguiendo las covenciones inmemoriales del tres en raya, x inicia.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Llenar el tablero con las imágenes del layout.
        tablero[0][0] = findViewById(R.id.img1);
        tablero[0][1] = findViewById(R.id.img2);
        tablero[0][2] = findViewById(R.id.img3);
        tablero[1][0] = findViewById(R.id.img4);
        tablero[1][1] = findViewById(R.id.img5);
        tablero[1][2] = findViewById(R.id.img6);
        tablero[2][0] = findViewById(R.id.img7);
        tablero[2][1] = findViewById(R.id.img8);
        tablero[2][2] = findViewById(R.id.img9);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void imprimirGanador(){
        Toast.makeText(this, "Winner winner chicken dinner: ", Toast.LENGTH_LONG).show();
    }

}