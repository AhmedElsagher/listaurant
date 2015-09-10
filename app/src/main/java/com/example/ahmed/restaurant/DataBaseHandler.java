package com.example.ahmed.restaurant;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHandler extends SQLiteOpenHelper{

    public DataBaseHandler(Context context)
    {
        super(context, "MenusDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMERS_TABLE="CREATE TABLE Customers(ID INTEGER PRIMARY KEY autoincrement,Name TEXT not null,Phone TEXT not null,Email TEXT not null unique ,Password TEXT not null , Address TEXT not null)";
        db.execSQL(CREATE_CUSTOMERS_TABLE);

        String CREATE_Restaurants_TABLE="CREATE TABLE Restaurants(ID INTEGER PRIMARY KEY autoincrement,Name TEXT not null,Phone TEXT not null,Address TEXT not null,X TEXT not null ,Y TEXT not null, Image TEXT not null , Category TEXT not null)";
        db.execSQL(CREATE_Restaurants_TABLE);

        String CREATE_FORIGNE_TABLE="CREATE TABLE Forigne(CID INTEGER not null,RID INTEGER not null)";
        db.execSQL(CREATE_FORIGNE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contacts");
        onCreate(db);
    }
    public void addCustomer(String name,String email,String password,String phone,String address){
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("Name",name);
        values.put("Phone",phone);
        values.put("Email",email);
        values.put("Password",password);
        values.put("Address",address);
        mydb.insert("Customers", null, values);
        mydb.close();
    }

    public void addRestaurant(String name,String menu,String category,String phone,String address,double X,double Y){
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("Name",name);
        values.put("Phone",phone);
        values.put("Image",menu);
        values.put("Category",category);
        values.put("Address",address);
        values.put("X",X);
        values.put("Y",Y);
        mydb.insert("Restaurants", null, values);
        mydb.close();
    }

    public int updateRestaurant(Restaurant R){
        SQLiteDatabase mydb=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("Name",R.getMname());
        values.put("Address",R.getMaddress());
        values.put("X", R.getX());
        values.put("Y", R.getY());
        values.put("Category", R.getCategory());
        values.put("Image", R.getMenu());

        int updateItems=mydb.update("Restaurants", values, "ID=?", new String[]{String.valueOf(R.getMid())});
        mydb.close();
        return updateItems;
    }

    public int updateCustomer(Customer C){
        SQLiteDatabase mydb=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("Name",C.getName());
        values.put("Phone",C.getPhone());
        values.put("Email", C.getEmail());
        values.put("Password", C.getPassword());
        values.put("Address", C.getAddress());

        int updateItems=mydb.update("Customers", values, "ID=?", new String[]{String.valueOf(C.getId())});
        mydb.close();
        return updateItems;
    }
    public void deleteRestaurant( Restaurant R){

        SQLiteDatabase mydb=this.getWritableDatabase();
        mydb.delete("Forigne", "ID=?", new String[]{String.valueOf(R.getMid())});

        mydb.delete("Restaurants", "ID=?", new String[]{String.valueOf(R.getMid())});

        mydb.close();
    }
    public void addFavorit (Customer C , Restaurant R ){
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put("CID",C.getId());
        Values.put("RID", R.getMid());
        mydb.insert("Forigne", null, Values);
        mydb.close();
    }

    public void UpdateFavorit(Customer C , Restaurant R){
        String UpdateQuery="DELETE FROM Forigne WHERE CID=;"+C.getId()+"AND RID="+R.getMid();
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor cursor = mydb.rawQuery(UpdateQuery,null);
        mydb.close();
    }

    public ArrayList<Restaurant> SearchByName (String N){
        String selectQuery="SELECT * FROM Restaurants WHERE Name LIKE '"+N+"%'";
        SQLiteDatabase mydb=this.getReadableDatabase();
        ArrayList<Restaurant> RestaurantList=new ArrayList<Restaurant>();
        Cursor cursor = mydb.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                int Mid =cursor.getInt(0);
                String Mname= cursor.getString(1);
                String Mphone = cursor.getString(2);
                String Menu= cursor.getString(1);
                String Maddress = cursor.getString(3);
                double X =  Double.parseDouble(cursor.getString(4));
                double Y = Double.parseDouble(cursor.getString(5));
                String category= cursor.getString(6);

                Restaurant oneRestaurant=new Restaurant();
                RestaurantList.add(oneRestaurant);
            }
            while(cursor.moveToNext());
        }

        mydb.close();
        return RestaurantList;
    }
    public ArrayList<Restaurant> SearchByCategory (String N){
        String selectQuery="SELECT * FROM Restaurants WHERE Category LIKE '"+N+"%'";
        SQLiteDatabase mydb=this.getReadableDatabase();
        ArrayList<Restaurant> RestaurantList=new ArrayList<Restaurant>();
        Cursor cursor = mydb.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                int Mid =cursor.getInt(0);
                String Mname= cursor.getString(1);
                String Mphone = cursor.getString(2);
                String Menu= cursor.getString(1);
                String Maddress = cursor.getString(3);
                double X =  Double.parseDouble(cursor.getString(4));
                double Y = Double.parseDouble(cursor.getString(5));
                String category= cursor.getString(6);

                Restaurant oneRestaurant=new Restaurant();
                RestaurantList.add(oneRestaurant);
            }
            while(cursor.moveToNext());
        }

        mydb.close();
        return RestaurantList;
    }
    public ArrayList<Restaurant> SearchByAddress (String N){
        String selectQuery="SELECT * FROM Restaurants WHERE Address LIKE '"+N+"%'";
        SQLiteDatabase mydb=this.getReadableDatabase();
        ArrayList<Restaurant> RestaurantList=new ArrayList<Restaurant>();
        Cursor cursor = mydb.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                int Mid =cursor.getInt(0);
                String Mname= cursor.getString(1);
                String Mphone = cursor.getString(2);
                String Menu= cursor.getString(1);
                String Maddress = cursor.getString(3);
                double X =  Double.parseDouble(cursor.getString(4));
                double Y = Double.parseDouble(cursor.getString(5));
                String category= cursor.getString(6);

                Restaurant oneRestaurant=new Restaurant();
                RestaurantList.add(oneRestaurant);
            }
            while(cursor.moveToNext());
        }

        mydb.close();
        return RestaurantList;
    }
    public ArrayList<Restaurant> SearchByCategoryAndAddress (String N ,String M){
        String selectQuery="SELECT * FROM Restaurants WHERE Category LIKE '"+N+"%'"+ "AND Address LIKE ' "+M+"%'";
        SQLiteDatabase mydb=this.getReadableDatabase();
        ArrayList<Restaurant> RestaurantList=new ArrayList<Restaurant>();
        Cursor cursor = mydb.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                int Mid =cursor.getInt(0);
                String Mname= cursor.getString(1);
                String Mphone = cursor.getString(2);
                String Menu= cursor.getString(1);
                String Maddress = cursor.getString(3);
                double X =  Double.parseDouble(cursor.getString(4));
                double Y = Double.parseDouble(cursor.getString(5));
                String category= cursor.getString(6);

                Restaurant oneRestaurant=new Restaurant();
                RestaurantList.add(oneRestaurant);
            }
            while(cursor.moveToNext());
        }

        mydb.close();
        return RestaurantList;
    }
}
