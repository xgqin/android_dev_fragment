package com.glriverside.xgqin.listviewdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    private NewsListFragment.OnItemClickListener itemClickListener = new NewsListFragment.OnItemClickListener() {
        @Override
        public void onItemClick(int id) {
            DetailFragment detail = DetailFragment.newInstance(id);

            FragmentTransaction ft = fragmentManager.beginTransaction();

            ft.replace(R.id.fragment_container, detail);
            ft.addToBackStack(null);
            ft.commit();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        /*
        NewsListFragment newsListFragment = (NewsListFragment) fragmentManager.findFragmentById(R.id.fragment_list);
        newsListFragment.setItemClickListener(itemClickListener);
        */

        FragmentTransaction ft = fragmentManager.beginTransaction();
        NewsListFragment newsListFragment = new NewsListFragment();
        newsListFragment.setItemClickListener(itemClickListener);

        ft.replace(R.id.fragment_container, newsListFragment);
        ft.commit();
    }
}
