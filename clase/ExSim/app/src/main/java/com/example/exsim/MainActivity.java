package com.example.exsim;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exsim.UserAdapter;
import com.example.exsim.UserDao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<UserDao> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new UserAdapter(this, userList);
        recyclerView.setAdapter(adapter);

        // Aquí puedes simular o hacer una petición real a tu servidor
        fetchJsonData();
    }

    private void fetchJsonData() {

        //Había mejores formas de hacer esto, pero no lo haré-
        try {
            String json = "[{\"name\": \"Lechucita\", \"phone\": \"5512121212\"}, " +
                    "{\"name\": \"Santi\", \"phone\": \"no lo se\"}, " +
                    "{\"name\": \"Lady bug\", \"phone\": \"5512121212\"}]";

            JSONArray jsonArray = new JSONArray(json);
            userList.clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                userList.add(new UserDao(obj.getString("name"), obj.getString("phone")));
            }

            adapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
