package com.example.sharedpref;

import android.os.Bundle;
import android.widget.Toast;

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

        Storage localStorage = new LocalStorage(this);

        try{

            String prevVal = (String) localStorage.getValue("llave", null);
            if(prevVal != null){
                Toast.makeText(
                        this,
                        "Valor: " + prevVal,
                        Toast.LENGTH_LONG
                ).show();
            }

            localStorage.setValue("Facultad", "llave");
        }catch(StorageException e){
            Toast.makeText(
                    this,
                    "No se puede guargar ese tipo de datos",
                    Toast.LENGTH_LONG
            ).show();
        }


    }
}