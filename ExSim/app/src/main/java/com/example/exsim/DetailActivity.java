package com.example.exsim;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView nameText;
    private TextView phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameText = findViewById(R.id.nameText);
        phoneText = findViewById(R.id.phoneText);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");

        nameText.setText("Nombre: " + name);
        phoneText.setText("Teléfono: " + phone);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        nameText.setText("");
        phoneText.setText("");
    }
}