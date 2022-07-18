package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabbedLayoutforProject extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private About about;
    private Matches matches;
    private Standing standing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_layoutfor_project);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_layout);

        standing=new Standing();
        about= new About();
        matches= new Matches();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragments(standing,"");
        viewPagerAdapter.addFragments(matches,"");
        viewPagerAdapter.addFragments(about,"");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setText("Standing");
        tabLayout.getTabAt(1).setText("Matches");
        tabLayout.getTabAt(2).setText("Squad");

//        BadgeDrawable badgeDrawable= tabLayout.getTabAt(0).getOrCreateBadge();
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(5);



    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments=new ArrayList<>();

        private List<String> fragmentTitles=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        public void addFragments(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }
}