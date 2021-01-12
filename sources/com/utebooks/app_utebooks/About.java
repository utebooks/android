package com.utebooks.app_utebooks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class About extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_about);
        ((ImageView) findViewById(C0719R.C0721id.facebok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent("android.intent.action.VIEW");
                myWebLink.setData(Uri.parse("https://www.facebook.com/utebooks"));
                About.this.startActivity(myWebLink);
            }
        });
        ((ImageView) findViewById(C0719R.C0721id.twt)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent("android.intent.action.VIEW");
                myWebLink.setData(Uri.parse("https://twitter.com/utebooks"));
                About.this.startActivity(myWebLink);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
