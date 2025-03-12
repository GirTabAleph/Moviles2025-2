package com.example.webservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContactService {

    @GET("FCA")
    Call<List<Contact>> listContacts();

}
