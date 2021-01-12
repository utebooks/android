package com.utebooks.app_utebooks;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ExpandableListView extends ExpandableListActivity {
    android.widget.ExpandableListView expandableListView;
    private ExpandableListAdapter mAdapterView;
    private Toolbar supportActionBar;
    Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0719R.layout.expandable_listview);
        if (getWindow().getDecorView().getLayoutDirection() == 0) {
            getWindow().getDecorView().setLayoutDirection(1);
        }
        this.toolbar = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        this.toolbar.setTitle((int) C0719R.string.app_name);
        this.toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(this.toolbar);
        this.toolbar.setTitle((CharSequence) "الجدول الزمني لفصل خريف 2017");
        List<Map<String, String>> groupListItem = new ArrayList<>();
        List<List<Map<String, String>>> childListItem = new ArrayList<>();
        HashMap hashMap = new HashMap();
        groupListItem.add(hashMap);
        hashMap.put("parentItem", "بداية التسجيل");
        List<Map<String, String>> children1 = new ArrayList<>();
        HashMap hashMap2 = new HashMap();
        children1.add(hashMap2);
        hashMap2.put("childItem", "ListView Example");
        HashMap hashMap3 = new HashMap();
        children1.add(hashMap3);
        hashMap3.put("childItem", "ListView Tutorial");
        HashMap hashMap4 = new HashMap();
        children1.add(hashMap4);
        hashMap4.put("childItem", "Expandable ListView");
        childListItem.add(children1);
        HashMap hashMap5 = new HashMap();
        groupListItem.add(hashMap5);
        hashMap5.put("parentItem", "بداية الدراسة");
        List<Map<String, String>> children2 = new ArrayList<>();
        HashMap hashMap6 = new HashMap();
        children2.add(hashMap6);
        hashMap6.put("childItem", "Android ListView");
        HashMap hashMap7 = new HashMap();
        children2.add(hashMap7);
        hashMap7.put("childItem", "Expandable ListView");
        Map<String, String> child8 = new HashMap<>();
        children2.add(child8);
        child8.put("childItem", "ListView Example");
        childListItem.add(children2);
        HashMap hashMap8 = new HashMap();
        groupListItem.add(hashMap8);
        hashMap8.put("parentItem", "آخر موعد لإضافة مقرر");
        List<Map<String, String>> children3 = new ArrayList<>();
        HashMap hashMap9 = new HashMap();
        children3.add(hashMap9);
        hashMap9.put("childItem", "Android ListView");
        HashMap hashMap10 = new HashMap();
        children3.add(hashMap10);
        hashMap10.put("childItem", "Expandable ListView");
        HashMap hashMap11 = new HashMap();
        children3.add(hashMap11);
        hashMap11.put("childItem", "ListView Example");
        childListItem.add(children3);
        new HashMap();
        groupListItem.add(hashMap8);
        hashMap8.put("parentItem", "الإمتحان النصفي للمقررات العامة");
        new ArrayList();
        new HashMap();
        children3.add(hashMap9);
        hashMap9.put("childItem", "Android ListView");
        new HashMap();
        children3.add(hashMap10);
        hashMap10.put("childItem", "Expandable ListView");
        new HashMap();
        children3.add(hashMap11);
        hashMap11.put("childItem", "ListView Example");
        childListItem.add(children3);
        this.mAdapterView = new SimpleExpandableListAdapter(this, groupListItem, 17367046, new String[]{"parentItem"}, new int[]{16908308, 16908309}, childListItem, 17367047, new String[]{"childItem"}, new int[]{16908308});
        setListAdapter(this.mAdapterView);
        this.expandableListView = getExpandableListView();
        this.expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(android.widget.ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "ListView Example", 1).show();
                                return false;
                            case 1:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "ListView Tutorial", 1).show();
                                return false;
                            case 2:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "Expandable ListView", 1).show();
                                return false;
                            default:
                                return false;
                        }
                    case 1:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "Android ListView", 1).show();
                                return false;
                            case 1:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "Expandable ListView", 1).show();
                                return false;
                            case 2:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "Expandable ListView", 1).show();
                                return false;
                            default:
                                return false;
                        }
                    case 2:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "Android ListView", 1).show();
                                return false;
                            case 1:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "Expandable ListView", 1).show();
                                return false;
                            case 2:
                                Toast.makeText(ExpandableListView.this.getBaseContext(), "ListView Example", 1).show();
                                return false;
                            default:
                                return false;
                        }
                    default:
                        return false;
                }
            }
        });
    }

    public void setSupportActionBar(Toolbar supportActionBar2) {
        this.supportActionBar = supportActionBar2;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
