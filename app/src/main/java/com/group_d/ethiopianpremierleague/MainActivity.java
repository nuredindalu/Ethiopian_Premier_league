package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Navigation {
    String clubname[]={ "Jimma Aba Jifar","Ethiopian Coffee","Saint George","Adama City","Awassa City","Sidama Coffee","Hadiya Hossana","Welayta Dicha","Arba Minch City"};
    int clubimage[]={R.drawable.jimma_ketema,R.drawable.ethiopian_coffe,R.drawable.saint_george,R.drawable.adama_ketema,R.drawable.awassa_ketema,R.drawable.sidaama_bunna,R.drawable.hadiya_hossana,R.drawable.welayta_dicha,R.drawable.arbaminch_ketema};
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       LayoutInflater inflater = LayoutInflater.from(this);
       View v =inflater.inflate(R.layout.activity_main,null,false);
       drawerLayout.addView(v,0);

        listView =(ListView) findViewById(R.id.clublistedview);
        Adapterclass adapterclass= new Adapterclass(getApplication(),clubname,clubimage);
        listView.setAdapter(adapterclass);
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
            AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
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
        return true;
    }
}