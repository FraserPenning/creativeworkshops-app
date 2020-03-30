package com.example.workshopfacilitationguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Objects;

public class ListsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> mExampleList;
    private Toolbar toolBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        //Navigation Drawer hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        toolBar = findViewById(R.id.toolBar);
        //Toolbar set as action bar
        setSupportActionBar(toolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //navigation clickable
        navigationView.setNavigationItemSelectedListener(this);
        //Set home screen information on start
        navigationView.setCheckedItem(R.id.nav_lists);
        //Array lists for recycle view
        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 1", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 2", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 3", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 4", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 5", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 6", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 7", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 8", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 9", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 10", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 11", "Details"));
        exampleList.add(new ExampleItem(R.drawable.create_logo, "Line 12", "Details"));

        //Main Window Design Recycle View
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_lists:
                break;
            case R.id.nav_information:
                Intent intent = new Intent(ListsActivity.this, Information3.class);
                startActivity(intent);
                break;
            case R.id.nav_categories:
                intent = new Intent(ListsActivity.this, CategoriesActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
