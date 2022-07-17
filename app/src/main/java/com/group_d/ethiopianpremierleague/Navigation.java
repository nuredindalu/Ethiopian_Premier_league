package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.group_d.ethiopianpremierleague.databinding.ActivityNavigationBinding;

public class Navigation extends Drawerbaseactivity {
    ActivityNavigationBinding activityNavigationBinding;
    private  long backpressbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNavigationBinding= ActivityNavigationBinding.inflate(getLayoutInflater());
        allocateactivitytitle("Home");
        setContentView(activityNavigationBinding.getRoot());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.rightmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id==R.id.smenuexit)
        {
            AlertDialog.Builder builder =new AlertDialog.Builder(Navigation.this);
            builder.setMessage("Do you want to exit? ");
            builder.setCancelable(true);
            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });
            builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(id==R.id.share_menu){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Check out this cool application");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Your application link here");
            startActivity(Intent.createChooser(sharingIntent, "Share Via"));
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (backpressbtn + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }
        else
        {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backpressbtn=System.currentTimeMillis();
    }
}