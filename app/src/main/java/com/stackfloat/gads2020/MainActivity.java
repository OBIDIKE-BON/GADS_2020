package com.stackfloat.gads2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.stackfloat.gads2020.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  SectionsPagerAdapter sectionsPagerAdapter  =
                new SectionsPagerAdapter(getSupportFragmentManager(), this.getLifecycle(), this);
        ViewPager2 pager2 = findViewById(R.id.view_pager);
        pager2.setAdapter(sectionsPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(sectionsPagerAdapter.getPageTitle(position));
            }
        }).attach();
    }


    public void startSubmit(View view) {
        startActivity(new Intent(this, SubmitActivity.class));
    }


}