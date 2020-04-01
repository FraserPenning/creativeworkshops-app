package com.example.workshopfacilitationguide;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

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

public class ListsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ExampleAdapter.OnItemListener {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> mExampleList;
    private Toolbar toolBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        createExampleList();
        buildRecyclerView();
        buildNavigationToolbar();



        //EditText
        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void createExampleList() {
        //Array lists for recycle view deleted ArrayList<ExampleItem>
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "1-2-4-All", "Generate question and ideas with many people", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "5 Whys", "Get to the root cause of a problem", ""));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Affinity Sizing", "Prioritise and relatively size ideas", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Dot Voting", "Simple voting system to reduce scope", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Feedback Techniques", "Give and receive meaningful feedback", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Importance Urgency Matrix", "Sort ideas rapidly to make priority decisions", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Intercept Interviews", "Interview non-recruited customers in a concise and empathetic way", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Lean Coffee", "Hold an agenda-less open conversation", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Planning Poker", "Gain a shared understanding over the complexity of an idea", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Room Setup", "Create a collaborative environment", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Silent Mindmap", "Generate relational ideas on an even playing field", "5 - 10 minutes"));
        mExampleList.add(new ExampleItem(R.drawable.create_logo, "Vision Board", "Visualise your vision", "5 - 10 minutes"));
    }

    public void buildNavigationToolbar() {
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
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        //keep an eye on this below "this"
        mAdapter = new ExampleAdapter(mExampleList, (ExampleAdapter.OnItemListener) this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();
        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
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

    @Override
    public void onItemClick(int position) {
    Intent mIntent;
        switch (position) {
            case 0: //first item in recyclerView
                mIntent = new Intent(this, Workshop.class);
                startActivity(mIntent);
                break;
            case 1: //first item in recyclerView
                mIntent = new Intent(this, WorkshopItem1.class);
                startActivity(mIntent);
                break;
            case 2: //first item in recyclerView
                mIntent = new Intent(this, WorkshopItem2.class);
                startActivity(mIntent);
                break;
            case 3: //first item in recyclerView
                mIntent = new Intent(this, WorkshopItem3.class);
                startActivity(mIntent);
                break;
            case 4: //first item in recyclerView
                mIntent = new Intent(this, WorkshopItem4.class);
                startActivity(mIntent);
                break;
            case 5: //first item in recyclerView
                mIntent = new Intent(this, WorkshopItem5.class);
                startActivity(mIntent);
        }
    }
}
