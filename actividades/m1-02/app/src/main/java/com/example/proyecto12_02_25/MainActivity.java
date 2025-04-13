package com.example.proyecto12_02_25;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Le ponemos un nombre a nuestro log.
    private static final String TAG = "MiApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Este mensaje aparecerá en logcat.
        Log.d(TAG, "Hello, World! Now on logcat!");
    }

}