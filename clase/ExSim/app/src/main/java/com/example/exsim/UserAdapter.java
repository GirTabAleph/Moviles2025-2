package com.example.exsim;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<UserDao> userList;
    private Context context;

    public UserAdapter(Context context, List<UserDao> userList) {
        this.context = context;
        this.userList = userList;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userName;

        public UserViewHolder(View view) {
            super(view);
            userName = view.findViewById(R.id.userName);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserDao user = userList.get(position);
        holder.userName.setText(user.getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", user.getName());
            intent.putExtra("phone", user.getPhone());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

}
