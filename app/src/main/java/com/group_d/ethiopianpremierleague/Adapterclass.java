package com.group_d.ethiopianpremierleague;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
