package com.utebooks.app_utebooks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.support.p003v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.gson.Gson;
import com.utebooks.app_utebooks.Adapter.FeedAdapter;
import com.utebooks.app_utebooks.Common.HTTPDataHandler;
import com.utebooks.app_utebooks.Model.RSSObject;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final String RSS_link = "http://fetchrss.com/rss/5ad0fba28a93f832348b4567675564381.xml";
    private final String RSS_to_Json_API = "https://api.rss2json.com/v1/api.json?rss_url=";
    ActionBarDrawerToggle aToggle;
    DrawerLayout mDrawerLayout;
    NavigationView nav_viewId;
    RecyclerView recyclerView;
    RSSObject rssObject;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_main);
        setNavigationViewListner();
        if (getWindow().getDecorView().getLayoutDirection() == 0) {
            getWindow().getDecorView().setLayoutDirection(1);
        }
        this.mDrawerLayout = (DrawerLayout) findViewById(C0719R.C0721id.drawerlayout0);
        this.aToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, C0719R.string.open, C0719R.string.close);
        this.mDrawerLayout.addDrawerListener(this.aToggle);
        this.nav_viewId = (NavigationView) findViewById(C0719R.C0721id.nav_view);
        this.toolbar = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        this.toolbar.setTitle((CharSequence) "أخبار كلية الهندسة");
        setSupportActionBar(this.toolbar);
        this.aToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.recyclerView = (RecyclerView) findViewById(C0719R.C0721id.recyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), 1, false));
        loadRSS();
    }

    private void setNavigationViewListner() {
        ((NavigationView) findViewById(C0719R.C0721id.nav_view)).setNavigationItemSelectedListener(this);
    }

    private void loadRSS() {
        AsyncTask<String, String, String> loadRSSAsync = new AsyncTask<String, String, String>() {
            ProgressDialog mDialog = new ProgressDialog(MainActivity.this);

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                this.mDialog.setMessage("الرجاء الإنتظار...");
                this.mDialog.show();
            }

            /* access modifiers changed from: protected */
            public String doInBackground(String... params) {
                return new HTTPDataHandler().GetHTTPData(params[0]);
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String s) {
                this.mDialog.dismiss();
                MainActivity.this.rssObject = (RSSObject) new Gson().fromJson(s, RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(MainActivity.this.rssObject, MainActivity.this.getBaseContext());
                MainActivity.this.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        loadRSSAsync.execute(new String[]{"https://api.rss2json.com/v1/api.json?rss_url=" + "http://fetchrss.com/rss/5ad0fba28a93f832348b4567675564381.xml"});
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case C0719R.C0721id.timetable /*2131231009*/:
                startActivity(new Intent(this, TimeTable.class));
                break;
        }
        this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0719R.C0722menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0719R.C0721id.menu_refresh) {
            loadRSS();
        }
        if (this.aToggle.onOptionsItemSelected(item)) {
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
