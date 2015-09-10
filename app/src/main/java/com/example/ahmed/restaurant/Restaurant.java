package com.example.ahmed.restaurant;

import java.io.Serializable;

/**
 * Created by Lenovo on 9/9/2015.
 */
public class Restaurant implements Serializable
{
    private int Mid;
    private String Mphone;
    private String Menu;
    private String Maddress ;
    private double X;
    private double Y;
    private String category;

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMphone() {
        return Mphone;
    }

    public void setMphone(String mphone) {
        Mphone = mphone;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getMaddress() {
        return Maddress;
    }

    public void setMaddress(String maddress) {
        Maddress = maddress;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMid() {
        return Mid;
    }

    public void setMid(int mid) {
        Mid = mid;
    }

    private String Mname;

    public Restaurant(int mid, double y, double x, String category, String maddress, String menu, String mphone, String mname) {
        this.Mid = mid;
        this.Y = y;
        this.X = x;
        this.category = category;
        this.Maddress = maddress;
        this.Menu = menu;
        this.Mphone = mphone;
        this.Mname = mname;
    }
    public Restaurant() {

    }



}

