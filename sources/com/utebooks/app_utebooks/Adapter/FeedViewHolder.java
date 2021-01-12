package com.utebooks.app_utebooks.Adapter;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.utebooks.app_utebooks.C0719R;
import com.utebooks.app_utebooks.Interface.ItemClickListener;

/* compiled from: FeedAdapter */
class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private ItemClickListener itemClickListener;
    public TextView txtContent;
    public TextView txtPubDate;
    public TextView txtTitle;

    public FeedViewHolder(View itemView) {
        super(itemView);
        this.txtTitle = (TextView) itemView.findViewById(C0719R.C0721id.txtTitle);
        this.txtPubDate = (TextView) itemView.findViewById(C0719R.C0721id.txtPubDate);
        this.txtContent = (TextView) itemView.findViewById(C0719R.C0721id.txtContent);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener2) {
        this.itemClickListener = itemClickListener2;
    }

    public void onClick(View v) {
        this.itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    public boolean onLongClick(View v) {
        this.itemClickListener.onClick(v, getAdapterPosition(), true);
        return true;
    }
}
