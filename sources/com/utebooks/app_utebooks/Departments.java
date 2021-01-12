package com.utebooks.app_utebooks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.MenuItem;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Departments extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle aToggle0;
    DrawerLayout mDrawerLayout0;
    NavigationView nav_viewId0;
    Toolbar toolbar0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_dep);
        setNavigationViewListner();
        if (getWindow().getDecorView().getLayoutDirection() == 0) {
            getWindow().getDecorView().setLayoutDirection(1);
        }
        this.nav_viewId0 = (NavigationView) findViewById(C0719R.C0721id.nav_view);
        this.mDrawerLayout0 = (DrawerLayout) findViewById(C0719R.C0721id.drawerlayout0);
        this.aToggle0 = new ActionBarDrawerToggle(this, this.mDrawerLayout0, C0719R.string.open, C0719R.string.close);
        this.mDrawerLayout0.addDrawerListener(this.aToggle0);
        this.toolbar0 = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        this.toolbar0.setTitle((CharSequence) "الأقسام");
        setSupportActionBar(this.toolbar0);
        this.aToggle0.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.aToggle0.onOptionsItemSelected(item)) {
        }
        return true;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case C0719R.C0721id.timetable /*2131231009*/:
                startActivity(new Intent(this, TimeTable.class));
                break;
        }
        this.mDrawerLayout0.closeDrawer((int) GravityCompat.START);
        return true;
    }

    private void setNavigationViewListner() {
        ((NavigationView) findViewById(C0719R.C0721id.nav_view)).setNavigationItemSelectedListener(this);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
