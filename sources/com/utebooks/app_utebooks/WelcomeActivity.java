package com.utebooks.app_utebooks;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.support.p003v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.utebooks.app_utebooks.Welcome_Class.PrefManager;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WelcomeActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public Button btnNext;
    /* access modifiers changed from: private */
    public Button btnSkip;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    /* access modifiers changed from: private */
    public int[] layouts;
    private MyViewPagerAdapter myViewPagerAdapter;
    private PrefManager prefManager;
    /* access modifiers changed from: private */
    public ViewPager viewPager;
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        public void onPageSelected(int position) {
            WelcomeActivity.this.addBottomDots(position);
            if (position == WelcomeActivity.this.layouts.length - 1) {
                WelcomeActivity.this.btnNext.setText(WelcomeActivity.this.getString(C0719R.string.start));
                WelcomeActivity.this.btnSkip.setVisibility(8);
                return;
            }
            WelcomeActivity.this.btnNext.setText(WelcomeActivity.this.getString(C0719R.string.next));
            WelcomeActivity.this.btnSkip.setVisibility(0);
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageScrollStateChanged(int arg0) {
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_welcome);
        this.prefManager = new PrefManager(this);
        if (!this.prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
        }
        setContentView((int) C0719R.layout.activity_welcome);
        this.viewPager = (ViewPager) findViewById(C0719R.C0721id.view_pager);
        this.dotsLayout = (LinearLayout) findViewById(C0719R.C0721id.layoutDots);
        this.btnSkip = (Button) findViewById(C0719R.C0721id.btn_skip);
        this.btnNext = (Button) findViewById(C0719R.C0721id.btn_next);
        this.layouts = new int[]{C0719R.layout.welcome_side1, C0719R.layout.welcome_slide2, C0719R.layout.welcome_slide3};
        addBottomDots(0);
        changeStatusBarColor();
        this.myViewPagerAdapter = new MyViewPagerAdapter();
        this.viewPager.setAdapter(this.myViewPagerAdapter);
        this.viewPager.addOnPageChangeListener(this.viewPagerPageChangeListener);
        this.btnSkip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WelcomeActivity.this.launchHomeScreen();
            }
        });
        this.btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int current = WelcomeActivity.this.getItem(1);
                if (current < WelcomeActivity.this.layouts.length) {
                    WelcomeActivity.this.viewPager.setCurrentItem(current);
                } else {
                    WelcomeActivity.this.launchHomeScreen();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void addBottomDots(int currentPage) {
        this.dots = new TextView[this.layouts.length];
        int[] colorsActive = getResources().getIntArray(C0719R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(C0719R.array.array_dot_inactive);
        this.dotsLayout.removeAllViews();
        for (int i = 0; i < this.dots.length; i++) {
            this.dots[i] = new TextView(this);
            this.dots[i].setText(Html.fromHtml("&#8226;"));
            this.dots[i].setTextSize(35.0f);
            this.dots[i].setTextColor(colorsInactive[currentPage]);
            this.dotsLayout.addView(this.dots[i]);
        }
        if (this.dots.length > 0) {
            this.dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    /* access modifiers changed from: private */
    public int getItem(int i) {
        return this.viewPager.getCurrentItem() + i;
    }

    /* access modifiers changed from: private */
    public void launchHomeScreen() {
        this.prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        public Object instantiateItem(ViewGroup container, int position) {
            this.layoutInflater = (LayoutInflater) WelcomeActivity.this.getSystemService("layout_inflater");
            View view = this.layoutInflater.inflate(WelcomeActivity.this.layouts[position], container, false);
            container.addView(view);
            return view;
        }

        public int getCount() {
            return WelcomeActivity.this.layouts.length;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
