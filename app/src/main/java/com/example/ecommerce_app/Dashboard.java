package com.example.ecommerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import static com.example.ecommerce_app.R.string.close;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //===============Hooks for connect xml file=========

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //===============Tool Bar========================

        setSupportActionBar(toolbar);

        //=====================Hide and Show Item=========

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
       // menu.findItem(R.id.nav_profile).setVisible(false);

        //=================Naviagtion Drawer==================

        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
               // Toast.makeText(this, "Welcome to Home Screen..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_jewlary:
                Toast.makeText(this, "Welcome to jewlary Screen..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_cart:
                Toast.makeText(this, "Welcome to cart Screen..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_login:
                Intent login = new Intent(Dashboard.this,Login.class);
                startActivity(login);
                finish();
                break;
            case R.id.nav_logout:
                Intent logout = new Intent(Dashboard.this,Login.class);
                finish();
                startActivity(logout);

                break;
            case R.id.nav_share:
                Toast.makeText(this, "Welcome to share Screen..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate:
                Toast.makeText(this, "Welcome to rate Screen..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_watch:
                Toast.makeText(this, "Welcome to watch Screen..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_profile:
                Intent profile = new Intent(Dashboard.this,Profile.class);
                startActivity(profile);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
