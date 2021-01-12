package com.utebooks.app_utebooks.font_class;

import android.app.Application;
import com.utebooks.app_utebooks.C0719R;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyConfig;

public class SegoeUI extends Application {
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/segoeui.ttf").setFontAttrId(C0719R.attr.fontPath).build());
    }
}
