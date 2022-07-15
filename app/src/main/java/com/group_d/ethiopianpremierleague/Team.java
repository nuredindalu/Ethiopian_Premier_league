package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.group_d.ethiopianpremierleague.databinding.ActivityTeamBinding;
import com.group_d.ethiopianpremierleague.databinding.ActivityTeamBinding;

public class Team extends Drawerbaseactivity {
    String clubname[]={ "Jimma Aba Jifar","Ethiopian Coffee","Saint George","Adama City","Awassa City","Sidama Coffee","Hadiya Hossana","Welayta Dicha","Arba Minch City"};
    int clubimage[]={R.drawable.jimma_ketema,R.drawable.ethiopian_coffe,R.drawable.saint_george,R.drawable.adama_ketema,R.drawable.awassa_ketema,R.drawable.sidaama_bunna,R.drawable.hadiya_hossana,R.drawable.welayta_dicha,R.drawable.arbaminch_ketema};
   ListView listView;
   ActivityTeamBinding activityTeamBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTeamBinding = ActivityTeamBinding.inflate(getLayoutInflater());
        setContentView(activityTeamBinding.getRoot());
        allocateactivitytitle("Team");

       listView =(ListView) findViewById(R.id.clublistedview);
        Adapterclass adapterclass= new Adapterclass(getApplication(),clubname,clubimage);
        listView.setAdapter(adapterclass);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0)
                {
                     startActivity(new Intent(Team.this,Detail_Jimma_city.class));
                }
                else if(position==1)
                {
                    startActivity(new Intent(Team.this, Matches.class));
                }
                else{

                }
            }
        });
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
            AlertDialog.Builder builder =new AlertDialog.Builder(Team.this);
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
    public class Adapterclass extends BaseAdapter {
        Context context;
        String clubname[];
        int clubimage[];
        LayoutInflater inflater;

        public  Adapterclass(Context ctx,String[]name,int[]image){
            this.context=ctx;
            this.clubname=name;
            this.clubimage=image;
            inflater=LayoutInflater.from(ctx);

        }
        @Override
        public int getCount() {
            return clubname.length  ;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            // convertview=inflater.inflate(R.drawable.activity_club_list,)
            convertview=inflater.inflate(R.layout.activity_club_list,null);
            TextView clubnamee=(TextView) convertview.findViewById(R.id.club_name);
            ImageView clubimagee=(ImageView) convertview.findViewById(R.id.club_icon);
            clubnamee.setText(clubname[position]);
            clubimagee.setImageResource(clubimage[position]);
            return convertview;

        }
    }
}