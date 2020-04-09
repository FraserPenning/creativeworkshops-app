package com.example.workshopfacilitationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;


import com.google.android.material.navigation.NavigationView;

import java.util.Objects;



public class Settings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buildNavigationToolbar();

    }

    public void buildNavigationToolbar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        toolBar = findViewById(R.id.toolBar);
        //Toolbar set as action bar
        setSupportActionBar(toolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Settings");
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //navigation clickable
        navigationView.setNavigationItemSelectedListener(this);
        //Set home screen information on start
        navigationView.setCheckedItem(R.id.nav_lists);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_settings:
                break;
            case R.id.nav_information:
                Intent intent = new Intent(Settings.this, Information3.class);
                startActivity(intent);
                break;
            case R.id.nav_lists:
                intent = new Intent(Settings.this, ListsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_categories:
                intent = new Intent(Settings.this, CategoriesActivity.class);
                startActivity(intent);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
