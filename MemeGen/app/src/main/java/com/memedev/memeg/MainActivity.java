package com.memedev.memeg;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    setTitle("VIEWS"); //this will set title of Action Bar
                    GalleryFragment fragment1 = new GalleryFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.framgmentConstainer, fragment1);  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("CREATE"); //this will set title of Action Bar
                    CreateFragment fragment2 = new CreateFragment(-1);
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.framgmentConstainer, fragment2);  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction2.commit();

                    return true;
                case R.id.navigation_notifications:
                    setTitle("DONE"); //this will set title of Action Bar
                    DoneFragment fragment3 = new DoneFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.framgmentConstainer, fragment3);  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.container); // находим дровер
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0); // создаём штуку, которая будет анимировать иконку (и не только)
        mDrawerLayout.addDrawerListener(mDrawerToggle); // подписываем её на события открытия и закрытия дровера (чтобы она знала, когда нужно анимировать кнопку)

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setTitle("Fragment One"); //this will set title of Action Bar
        GalleryFragment fragment1 = new GalleryFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.framgmentConstainer, fragment1, "Fragment One");  //create first framelayout with id fram in the activity where fragments will be displayed
        fragmentTransaction1.commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // если нажали на
            case android.R.id.home: // кнопку меню
                // ищем меню
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.container);
                if (drawerLayout.isDrawerOpen(Gravity.START)) { // если уже открыто
                    drawerLayout.closeDrawer(Gravity.START); // закрываем
                } else { // иначе
                    drawerLayout.openDrawer(Gravity.START); // открываем
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
