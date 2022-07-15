package com.group_d.ethiopianpremierleague;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.group_d.ethiopianpremierleague.databinding.ActivityNavigationBinding;

public class Navigation extends Drawerbaseactivity {
    ActivityNavigationBinding activityNavigationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNavigationBinding= ActivityNavigationBinding.inflate(getLayoutInflater());
        allocateactivitytitle("Home");
        setContentView(activityNavigationBinding.getRoot());

    }

}