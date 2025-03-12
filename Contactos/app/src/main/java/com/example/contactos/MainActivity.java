package com.example.contactos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ContactAdapter contactAdapter;

    RecyclerView contactList;

    public static List<Contact> createContacts(){

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Fortnite", "5543153174"));
        contacts.add(new Contact("Gabriel Ultrakill", "5538779463"));
        contacts.add(new Contact("Maurice", "5526316817"));

        return contacts;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        contactList = findViewById(R.id.contactList);
        contactAdapter = new ContactAdapter(MainActivity.createContacts());
        contactList.setAdapter(contactAdapter);
        contactList.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}