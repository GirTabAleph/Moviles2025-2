package com.example.otroexsim;

public class User {

    private String name;
    private String phone;

    public User(String name, String phone){

        this.name = name;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
