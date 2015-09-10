package com.example.ahmed.restaurant;

import java.io.Serializable;

/**
 * Created by Bebooo43 on 8/16/2015.
 */
public class Customer implements Serializable {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String address;

    public Customer()
    {

    }
    public Customer(int id, String name, String phone, String email,String password, String address)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
