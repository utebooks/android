package com.utebooks.app_utebooks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.utebooks.app_utebooks.Adapter.FeedAdapter;
import com.utebooks.app_utebooks.Common.HTTPDataHandler;
import com.utebooks.app_utebooks.Model.RSSObject;

public class NewsFragment extends Fragment {
    private final String RSS_link = "http://feeds.rapidfeeds.com/87338";
    private final String RSS_to_Json_API = "https://api.rss2json.com/v1/api.json?rss_url=";
    RecyclerView recyclerView;
    RSSObject rssObject;
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0719R.layout.fragment_news, container, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(C0719R.C0721id.recyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(), 1, false));
        loadRSS();
        return rootView;
    }

    private void loadRSS() {
        AsyncTask<String, String, String> loadRSSAsync = new AsyncTask<String, String, String>() {
            ProgressDialog mDialog = new ProgressDialog(NewsFragment.this.getActivity());

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                this.mDialog.setMessage("الرجاء الأنتظار...");
                this.mDialog.show();
            }

            /* access modifiers changed from: protected */
            public String doInBackground(String... params) {
                return new HTTPDataHandler().GetHTTPData(params[0]);
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String s) {
                this.mDialog.dismiss();
                NewsFragment.this.rssObject = (RSSObject) new Gson().fromJson(s, RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(NewsFragment.this.rssObject, NewsFragment.this.getActivity().getBaseContext());
                NewsFragment.this.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        loadRSSAsync.execute(new String[]{"https://api.rss2json.com/v1/api.json?rss_url=" + "http://feeds.rapidfeeds.com/87338"});
    }
}
