package com.utebooks.app_utebooks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.CardView;
import android.support.p003v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private CardView Lib;
    ActionBarDrawerToggle aToggle;
    private CardView info;
    DrawerLayout mDrawerLayout;
    NavigationView nav_viewId;
    private CardView timetable;
    private CardView timetable1;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_menu);
        this.mDrawerLayout = (DrawerLayout) findViewById(C0719R.C0721id.drawerlayout0);
        this.aToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, C0719R.string.open, C0719R.string.close);
        this.mDrawerLayout.addDrawerListener(this.aToggle);
        this.nav_viewId = (NavigationView) findViewById(C0719R.C0721id.nav_view);
        this.toolbar = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        this.toolbar.setTitle((CharSequence) "المكتبة الإلكترونية");
        setSupportActionBar(this.toolbar);
        this.aToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.Lib = (CardView) findViewById(C0719R.C0721id.subjectlist);
        this.timetable = (CardView) findViewById(C0719R.C0721id.timetable);
        this.timetable1 = (CardView) findViewById(C0719R.C0721id.timetableE);
        this.info = (CardView) findViewById(C0719R.C0721id.infoE);
        this.Lib.setOnClickListener(this);
        this.timetable.setOnClickListener(this);
        this.timetable1.setOnClickListener(this);
        this.info.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0719R.C0721id.subjectlist /*2131230993*/:
                startActivity(new Intent(this, SubjectList.class));
                return;
            case C0719R.C0721id.timetable /*2131231009*/:
                startActivity(new Intent(this, TimeTable.class));
                return;
            case C0719R.C0721id.timetableE /*2131231010*/:
                startActivity(new Intent(this, TimeTabe_Semester.class));
                return;
            default:
                return;
        }
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(C0719R.C0722menu.main_menu, menu);
        return true;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case C0719R.C0721id.about /*2131230790*/:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://utebooks.com/app-privacy-policy/")));
                return true;
            default:
                return false;
        }
    }
}
