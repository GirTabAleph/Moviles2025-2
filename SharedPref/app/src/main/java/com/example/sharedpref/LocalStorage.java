package com.example.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sharedpref.Storage;

public class LocalStorage<T> implements Storage {

    private static String id = "com.local.storage";

    Context context;

    SharedPreferences sharedPreferences;

    public LocalStorage(Context context){

        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(
                id,
                Context.MODE_PRIVATE

        );

    }

    @Override
    public void setValue(Object value, String key) throws StorageException {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(value instanceof String){

            editor.putString(key, (String) value);
        } else if(value instanceof Integer){
            editor.putInt(key, (Integer) value);
        } else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        } else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        } else {
            throw new StorageException();
        }
        editor.apply();
    }

    @Override
    public T getValue(String key) {
        String value =sharedPreferences.getString(key, "");

        if(!value.isEmpty()){

            return (T)value;

        }
    }
}