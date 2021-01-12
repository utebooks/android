package com.utebooks.app_utebooks.Fragments;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.utebooks.app_utebooks.C0719R;

public class DepFragment extends Fragment {
    public WebView mWebView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0719R.layout.fragment_dep, container, false);
        this.mWebView = (WebView) v.findViewById(C0719R.C0721id.wvPage1);
        this.mWebView.loadUrl("https://drive.google.com/open?id=0B9rEorKFNmGZdGt4RUY2U3NPcWs");
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebViewClient(new WebViewClient());
        return v;
    }
}
