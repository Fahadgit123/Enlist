package com.example.toshiba.enlistcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    BottomNavigationView bottomNavigationView;
    ImageButton cartList;
    TextView cartproductCount;
    private int cartCount;
    ImageView cart1, cart2, cart3, cart4;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageurls = new ArrayList<>();

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cart_add_img :
                    plusCounter();
                    break;
                case R.id.cart_add_img2 :
                    plusCounter();
                    break;
                case R.id.cart_add_img3 :
                    plusCounter();
                    break;
                case R.id.cart_add_img4 :
                    plusCounter();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cartproductCount = (TextView) findViewById(R.id.cartBubbleCount_txt);

        cart1 = (ImageView) findViewById(R.id.cart_add_img);
        cart2 = (ImageView) findViewById(R.id.cart_add_img2);
        cart3 = (ImageView) findViewById(R.id.cart_add_img3);
        cart4 = (ImageView) findViewById(R.id.cart_add_img4);
        cart1.setOnClickListener(clickListener);
        cart2.setOnClickListener(clickListener);
        cart3.setOnClickListener(clickListener);
        cart4.setOnClickListener(clickListener);

        cartList = (ImageButton) findViewById(R.id.img_cartlist);
        cartList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartlistActivity.class);
                startActivity(intent);
            }
        });

        getImages();
        initCounter();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
    }

    private void initCounter() {
        cartCount = 0;
        cartproductCount.setText(cartCount+"");
    }
    private void plusCounter() {
        cartCount ++;
        cartproductCount.setText(cartCount+"");
    }
    private void getImages(){
        mImageurls.add("Category 1");
        mNames.add("Havasu Falls");
        mImageurls.add("Category 2");
        mNames.add("Havasu Falls");
        mImageurls.add("Category 3");
        mNames.add("Havasu Falls");
        mImageurls.add("Category 4");
        mNames.add("Havasu Falls");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);//
        RecyclerView recyclerview =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageurls);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
