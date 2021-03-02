package com.example.android_eservices_antoinebon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import data.api.dependencyInjection.DependencyInjection;

import android.content.Intent;
import android.os.Bundle;

import com.example.charDisplay.fragment.CharListFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Things to do on onCreate when launching main activity of the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.app_name);

        DependencyInjection.setContext(this);

        // Init the view pager
        initViewPager();

    }

    private void initViewPager() {
        viewPager = findViewById(R.id.main_view_pager);

        CharListFragment charListFragmentInstance = CharListFragment.newInstance(0);
        CharListFragment charListFragmentInstanceGrid = CharListFragment.newInstance(1);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            // Need to create a new instance for each tabs (here 2 instance because 2 tabs)
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return charListFragmentInstance;
                }
                return charListFragmentInstanceGrid;
            }

            // I made tab name available in strings.xml file to make replace or traduction easier
            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return getString(R.string.tab_title_linear);
                }
                return getString(R.string.tab_title_grid);
            }


            @Override
            public int getCount() {
                return 2;
            }
        });
    }

}