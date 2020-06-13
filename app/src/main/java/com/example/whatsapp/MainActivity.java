package com.example.whatsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.provider.CallLog;
import android.telecom.Call;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }



        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new chats();
                case 1:
                    return new Status();
                case 2:
                    return new Contacts();

            }
            return null;
        }

        @Override
        public int getCount()
        {
            return 3;
        }
    }

    @Nullable


    public CharSequence getPageTitle(int position)
    {
        switch (position) {
            case 0:
                return "chats";
            case 1:
                return "Status";
            case 2:
                return "Contacts";
        }
            return  getPageTitle(position);
    }
}








