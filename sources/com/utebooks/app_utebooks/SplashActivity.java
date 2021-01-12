package com.utebooks.app_utebooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashActivity extends Activity {
    private int SPLASH_TIMER = 2500;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0719R.layout.splash_layout);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, Menu.class));
                SplashActivity.this.finish();
            }
        }, (long) this.SPLASH_TIMER);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
