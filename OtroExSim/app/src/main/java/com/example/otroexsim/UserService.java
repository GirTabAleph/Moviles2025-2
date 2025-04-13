package com.example.otroexsim;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.Call;

public interface UserService {

    @GET("/")
    Call<List<User>> listUsers();
}
