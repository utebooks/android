package com.utebooks.app_utebooks.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.utebooks.app_utebooks.C0719R;

public class tueFragment extends Fragment {
    private static final String TAG = "Sunday";

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(C0719R.layout.tue_fragment, container, false);
    }
}
