package com.google.android.gms.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzadh extends FirebaseUser {
    @zzaku("cachedTokenState")
    private String zzbGf;
    @zzaku("defaultUserInfo")
    private zzadf zzbGg;
    @zzaku("applicationName")
    private String zzbGh;
    @zzaku("type")
    private String zzbGi = "com.google.firebase.auth.internal.DefaultFirebaseUser";
    @zzaku("userInfos")
    private List<zzadf> zzbGj;
    @zzaku("providers")
    private List<String> zzbGk;
    @zzaku("providerInfo")
    private Map<String, zzadf> zzbGl;
    @zzaku("anonymous")
    private boolean zzbGm;

    public zzadh(@NonNull FirebaseApp firebaseApp, @NonNull List<? extends UserInfo> list) {
        zzaa.zzz(firebaseApp);
        this.zzbGh = firebaseApp.getName();
        zzN(list);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzbGg.getDisplayName();
    }

    @Nullable
    public String getEmail() {
        return this.zzbGg.getEmail();
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzbGg.getPhotoUrl();
    }

    @NonNull
    public List<? extends UserInfo> getProviderData() {
        return this.zzbGj;
    }

    @NonNull
    public String getProviderId() {
        return this.zzbGg.getProviderId();
    }

    @Nullable
    public List<String> getProviders() {
        return this.zzbGk;
    }

    @NonNull
    public String getUid() {
        return this.zzbGg.getUid();
    }

    public boolean isAnonymous() {
        return this.zzbGm;
    }

    @NonNull
    public FirebaseUser zzN(@NonNull List<? extends UserInfo> list) {
        zzaa.zzz(list);
        this.zzbGj = new ArrayList(list.size());
        this.zzbGk = new ArrayList(list.size());
        this.zzbGl = new ArrayMap();
        for (int i = 0; i < list.size(); i++) {
            zzadf zzadf = new zzadf((UserInfo) list.get(i));
            if (zzadf.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzbGg = zzadf;
            } else {
                this.zzbGk.add(zzadf.getProviderId());
            }
            this.zzbGj.add(zzadf);
            this.zzbGl.put(zzadf.getProviderId(), zzadf);
        }
        if (this.zzbGg == null) {
            this.zzbGg = this.zzbGj.get(0);
        }
        return this;
    }

    @NonNull
    public FirebaseApp zzOl() {
        return FirebaseApp.getInstance(this.zzbGh);
    }

    @NonNull
    public String zzOm() {
        return this.zzbGf;
    }

    /* renamed from: zzaL */
    public zzadh zzaK(boolean z) {
        this.zzbGm = z;
        return this;
    }

    public void zzhG(@NonNull String str) {
        zzaa.zzdl(str);
        this.zzbGf = str;
    }

    @NonNull
    public FirebaseUser zzhI(@NonNull String str) {
        this.zzbGk.add(zzaa.zzdl(str));
        return this;
    }
}
