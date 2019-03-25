package com.example.sewayuk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

    final Fragment fragment1 = new SB1Fragment();
    final Fragment fragment2 = new SB2Fragment();
    final Fragment fragment3 = new SB3Fragment();
    final Fragment fragment4 = new SB4Fragment();
    final Fragment fragment5 = new SB5Fragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction().add(R.id.main_container, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.main_container, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").hide(fragment1).commit();
        fm.beginTransaction().hide(active).show(fragment1).commit();

        BottomNavigationView navigation = findViewById(R.id.BNMenu);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.Sb1:
                    active = fragment1;
                    break;

                case R.id.Sb2:
                    active = fragment2;
                    break;

                case R.id.Sb3:
                    active = fragment3;
                    break;

                case R.id.Sb4:
                    active = fragment4;
                    break;

                case R.id.Sb5:
                    active = fragment5;
                    break;
            }
            fm.beginTransaction().replace(R.id.main_container, active).commit();
            return false;
        }
    };
}
