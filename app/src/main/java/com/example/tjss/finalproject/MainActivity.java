package com.example.tjss.finalproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentOneInterface{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public void addNewMovie(Movie movie){
        mFragmentTwo.addMovieAndUpdate(movie);
    }






    //------------------------------------//
    //Fragment Controller in Main activity//
    //------------------------------------//


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 :
                    mFragmentOne = FragmentOne.newInstance();
                    return mFragmentOne;

                case 1 :
                    mFragmentTwo = FragmentTwo.newInstance();
                    return mFragmentTwo;
                default :
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;       // Show 3 total pages.
        }
    }



}