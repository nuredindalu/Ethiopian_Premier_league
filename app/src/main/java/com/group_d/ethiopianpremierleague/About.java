package com.group_d.ethiopianpremierleague;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class About extends ListFragment {
ListView listabouts;
    String[] name={"Abel Mamo","Israel Mesfin","Bereket Amare",
            "Asrat Tunjo","Haile Gebretensay","Wondimeneh Dereje","Abebe Tilahun",
            "Gezahagn Desalagn","Yabkal Fereja","Temesgen castro","Tewodros Bekele","Abinet Demissie"
            ," Amanuel Yohannes","William Solomon","Abel Endale","Robel Teklemichael","Tefese Solomon"
            ,"Surafel Seyfu","Mikiyas Mekonnen","Redwan Nassir","Abubakir Nassir","Endale Debalkie"
            ,"temesgen gebrekidan","Alazar Shimalis"};
    String[] Position={"GK","GK","GK","L-B","L-B","C-B","C-B","R-B","R-M",
            "D-M","R-M","GK","D-M","C-M","A-M","D-M","C-M",
            "A-M","R-W","L-B","L-W","C-F","R-F","L-W"};
    String[] Age={"28","23","29","25","-","22","22",
            "26","-","22","27","30","29","23","-","21",
            "29","32","-","-","22","-","32","-"};
int[] images={R.drawable.abelmamo,R.drawable.alazarshimelis,R.drawable.bereketamare,R.drawable.asrattonjo,R.drawable.hailegebre,
        R.drawable.wendimeneh,R.drawable.abebetilahun,R.drawable.alazarshimelis,
        R.drawable.alazarshimelis,R.drawable.tamekastro,R.drawable.tewodrosb,R.drawable.alazarshimelis,
        R.drawable.amanyohannes,R.drawable.alazarshimelis,R.drawable.abelendale,R.drawable.robelteklemichael,
        R.drawable.alazarshimelis,R.drawable.alazarshimelis,R.drawable.mikiyasmekonin,R.drawable.alazarshimelis,
        R.drawable.abubakirnasir,R.drawable.endaledebalke,R.drawable.tekaligndejene,R.drawable.alazarshimelis
};


    public About() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            for (int i = 0; i < name.length; i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("name", name[i]);
                map.put("position",Position[i]);
                map.put("Age",Age[i]);
                map.put("images", Integer.toString(images[i]));
                aList.add(map);
            }

            // Keys used in Hashmap
            String[] from = { "images", "name","position","Age"};

            // Ids of views in listview_layout
            int[] to = { R.id.imageView, R.id.textview1,R.id.textview2,R.id.textview3};

            // Instantiating an adapter to store each items
            // R.layout.listview_layout defines the layout of each item
            SimpleAdapter adapter = new SimpleAdapter(getActivity()
                    .getBaseContext(), aList, R.layout.single_item, from, to);

            setListAdapter(adapter);

            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

