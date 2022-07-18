package com.group_d.ethiopianpremierleague;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Navbar extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_open, R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Log.i("Menu_Drawer_Tag", "home is clicked");

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.matches:
                        Log.i("Menu_Drawer_Tag", "matches is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Transfers:
                        Log.i("Menu_Drawer_Tag", "transfers is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Standings:
                        Log.i("Menu_Drawer_Tag", "standings is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.share:
                        Log.i("Menu_Drawer_Tag", "share is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.rateus:
                        Log.i("Menu_Drawer_Tag", "rateus is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });
    }
}
