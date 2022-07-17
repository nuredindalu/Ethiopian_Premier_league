package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.group_d.ethiopianpremierleague.databinding.ActivityTeamBinding;

public class Team extends Drawerbaseactivity {
    String clubname[]={ "Adama Ketema FC","Addis Ababa Ketema FC","Arba Minch Ketema FC","Bahir Dar Ketema FC","Dire Dawa Ketema SC","Ethiopia Bunna SC","Fasil Kenema FC","Hadiya Hossana FC","Hawassa Ketema FC","Jimma Aba Jifar FC","Kidus Giorgis SA","Mekelakeya SC","Sebeta Ketema FC","Sidama Bunna SC","Wolaita Dicha SC","Wolkite Ketema SC"};
    int clubimage[]={R.drawable.adama_ketema,R.drawable.addis_ababa_kenema,R.drawable.arbaminch_ketema,R.drawable.bahir_dar_kenema,R.drawable.dire_dawa_kenema,R.drawable.ethiopian_coffe,R.drawable.fasil_kenema,R.drawable.hadiya_hossana,R.drawable.hawassa_ketema,R.drawable.jimma_ketema,R.drawable.saint_george,R.drawable.mekelakeyia,R.drawable.sebeta_kenema,R.drawable.sidaama_bunna,R.drawable.welayta_dicha,R.drawable.welkite_kenema};
   ListView listView;
    ArrayAdapter<String> arrayAdapter;

   ActivityTeamBinding activityTeamBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTeamBinding = ActivityTeamBinding.inflate(getLayoutInflater());
        setContentView(activityTeamBinding.getRoot());
        allocateactivitytitle("Team");
        listView =(ListView) findViewById(R.id.clublistedview);
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,clubname);
       listView.setAdapter(arrayAdapter);
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
        getMenuInflater().inflate(R.menu.search_menuu,menu);
        MenuItem menuItem = menu.findItem(R.id.serach_menu);
        SearchView searchView =(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
             arrayAdapter.getFilter().filter(s);
                return false;
            }
        });
        inflater.inflate(R.menu.rightmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id==R.id.share_menu){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Check out this cool application");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Your application link here");
            startActivity(Intent.createChooser(sharingIntent, "Share Via"));
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