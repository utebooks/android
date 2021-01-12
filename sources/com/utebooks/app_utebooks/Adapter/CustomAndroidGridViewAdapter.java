package com.utebooks.app_utebooks.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.utebooks.app_utebooks.C0719R;

public class CustomAndroidGridViewAdapter extends BaseAdapter {
    private final int[] Imageid;
    private Context mContext;
    private final String[] string;

    public CustomAndroidGridViewAdapter(Context c, String[] string2, int[] Imageid2) {
        this.mContext = c;
        this.Imageid = Imageid2;
        this.string = string2;
    }

    public int getCount() {
        return this.string.length;
    }

    public Object getItem(int p) {
        return null;
    }

    public long getItemId(int p) {
        return 0;
    }

    public View getView(int p, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        if (convertView != null) {
            return convertView;
        }
        new View(this.mContext);
        View grid = inflater.inflate(C0719R.layout.gridview_custom_layout, (ViewGroup) null);
        ((TextView) grid.findViewById(C0719R.C0721id.gridview_text)).setText(this.string[p]);
        ((ImageView) grid.findViewById(C0719R.C0721id.gridview_image)).setImageResource(this.Imageid[p]);
        return grid;
    }
}
