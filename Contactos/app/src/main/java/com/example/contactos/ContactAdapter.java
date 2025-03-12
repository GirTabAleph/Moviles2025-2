package com.example.contactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txvName, txvPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txvName = itemView.findViewById(R.id.txvName);
            this.txvPhone = itemView.findViewById(R.id.txvPhone);
        }

        public void setName(String txvName){
            this.txvName.setText(txvName);
        }

        public void setPhone(String txvPhone){
            this.txvPhone.setText(txvPhone);
        }

    }


    List<Contact> contactList;

    public ContactAdapter(List<Contact> contactList){

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Contact contacto = contactList.get(position);

        holder.setName(contacto.getName());
        holder.setPhone(contacto.getPhone());

    }

    @Override
    public int getItemCount() {
        return this.contactList.size();
    }
}

