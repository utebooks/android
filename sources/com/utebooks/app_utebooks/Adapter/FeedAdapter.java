package com.utebooks.app_utebooks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.utebooks.app_utebooks.C0719R;
import com.utebooks.app_utebooks.Interface.ItemClickListener;
import com.utebooks.app_utebooks.Model.RSSObject;

public class FeedAdapter extends RecyclerView.C0337Adapter<FeedViewHolder> {
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public RSSObject rssObject;

    public FeedAdapter(RSSObject rssObject2, Context mContext2) {
        this.rssObject = rssObject2;
        this.mContext = mContext2;
        this.inflater = LayoutInflater.from(mContext2);
    }

    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeedViewHolder(this.inflater.inflate(C0719R.layout.row, parent, false));
    }

    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.txtTitle.setText(this.rssObject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(this.rssObject.getItems().get(position).getPubDate());
        holder.txtContent.setText(this.rssObject.getItems().get(position).getContent());
        holder.setItemClickListener(new ItemClickListener() {
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {
                    FeedAdapter.this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(FeedAdapter.this.rssObject.getItems().get(position).getLink())));
                }
            }
        });
    }

    public int getItemCount() {
        return this.rssObject.items.size();
    }
}
