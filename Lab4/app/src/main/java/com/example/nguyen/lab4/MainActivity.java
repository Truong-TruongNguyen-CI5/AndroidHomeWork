package com.example.nguyen.lab4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

import layout.AFragment;
import layout.BFragment;
import layout.CFragment;
import layout.DFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ActionBarDrawerToggle toggle;
    private boolean menuSendVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setDefaultToggle();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setTitleFromUser(String title){
        this.setTitle(title);
    }

    public void setDefaultToggle(){
        setTitle("Home");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem sendMenuItem = menu.findItem(R.id.action_send);
        sendMenuItem.setVisible(menuSendVisible);
        return super.onPrepareOptionsMenu(menu);
    }

    public ActionBarDrawerToggle getToggle(){
        return toggle;
    }

    @Override
    protected void onStart() {
        setShowActionBar(true);
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        this.setTitle("Home");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setShowActionBar(true);
        setDefaultToggle();
        showSendMenu(false);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        System.out.println("BAckkkk");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_send) {
            openFragment(new DFragment(), true);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            setTitle("Article");
            openFragment( new AFragment(), true);
        } else if (id == R.id.nav_slideshow) {
            setTitle("Payment");
            openFragment(new BFragment(), true);
        } else if (id == R.id.nav_manage) {
            setTitle("Settings");
            openFragment(new CFragment(), true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openFragment( Fragment fragment, boolean addToBackStack){
        if(addToBackStack)
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
        else getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
    }

    public void setShowActionBar(boolean visible){
        if(visible){
            getSupportActionBar().show();
        }
        else getSupportActionBar().hide();
    }

    public void showSendMenu(boolean visible){
        this.menuSendVisible = visible;
        this.invalidateOptionsMenu();
    }
}
