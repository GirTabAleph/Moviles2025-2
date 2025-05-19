package com.example.sharedpref;

public interface Storage<T>{

    void setValue(T value, String key) throws StorageException;

    T getValue(String key, T optional);
}
