package com.utebooks.app_utebooks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.p000v4.view.ViewPager;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import com.utebooks.app_utebooks.Adapter.SectionPageAdapter;
import com.utebooks.app_utebooks.Fragments.DepFragment;
import com.utebooks.app_utebooks.Fragments.GSFragment;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SubjectList extends AppCompatActivity {
    private static final String TAG = "TimeTable";
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;
    Toolbar toolbar0;

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_subject_list);
        Log.d(TAG, "onCreate: Starting.");
        if (getWindow().getDecorView().getLayoutDirection() == 0) {
            getWindow().getDecorView().setLayoutDirection(1);
        }
        this.mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        this.mViewPager = (ViewPager) findViewById(C0719R.C0721id.container);
        setupViewPage(this.mViewPager);
        ((TabLayout) findViewById(C0719R.C0721id.tabs)).setupWithViewPager(this.mViewPager);
        this.toolbar0 = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        this.toolbar0.setTitle((CharSequence) "المناهج الدراسية");
        setSupportActionBar(this.toolbar0);
    }

    private void setupViewPage(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new GSFragment(), "المواد العامة");
        adapter.addFragment(new DepFragment(), "الأقسام");
        viewPager.setAdapter(adapter);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        return true;
    }
}
