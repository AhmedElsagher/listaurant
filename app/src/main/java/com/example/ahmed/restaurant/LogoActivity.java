package com.example.ahmed.restaurant;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LogoActivity extends SingleFragmentActivity {


    @Override
    public Fragment getFragment() {
        return new LogoFragment();
    }
}
