package com.google.android.gms.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfo;

public class zzadf implements UserInfo {
    @zzaku("userId")
    @NonNull
    private String zzVA;
    @Nullable
    @zzaku("photoUrl")
    private String zzaBl;
    @Nullable
    @zzaku("email")
    private String zzacn;
    @Nullable
    @zzaku("displayName")
    private String zzaco;
    @zzaku("providerId")
    @NonNull
    private String zzbFO;
    @Nullable
    @zzacw
    private Uri zzbFn;

    public zzadf(@NonNull UserInfo userInfo) {
        zzaa.zzz(userInfo);
        this.zzVA = zzaa.zzdl(userInfo.getUid());
        this.zzbFO = zzaa.zzdl(userInfo.getProviderId());
        this.zzaco = userInfo.getDisplayName();
        if (userInfo.getPhotoUrl() != null) {
            this.zzbFn = userInfo.getPhotoUrl();
            this.zzaBl = userInfo.getPhotoUrl().toString();
        }
        this.zzacn = userInfo.getEmail();
    }

    public zzadf(@NonNull GetAccountInfoUser getAccountInfoUser, @NonNull String str) {
        zzaa.zzz(getAccountInfoUser);
        zzaa.zzdl(str);
        this.zzVA = zzaa.zzdl(getAccountInfoUser.getLocalId());
        this.zzbFO = str;
        this.zzacn = getAccountInfoUser.getEmail();
        this.zzaco = getAccountInfoUser.getDisplayName();
        Uri photoUri = getAccountInfoUser.getPhotoUri();
        if (photoUri != null) {
            this.zzaBl = photoUri.toString();
            this.zzbFn = photoUri;
        }
    }

    public zzadf(@NonNull ProviderUserInfo providerUserInfo) {
        zzaa.zzz(providerUserInfo);
        this.zzVA = zzaa.zzdl(providerUserInfo.zzOK());
        this.zzbFO = zzaa.zzdl(providerUserInfo.getProviderId());
        this.zzaco = providerUserInfo.getDisplayName();
        Uri photoUri = providerUserInfo.getPhotoUri();
        if (photoUri != null) {
            this.zzaBl = photoUri.toString();
            this.zzbFn = photoUri;
        }
        this.zzacn = null;
    }

    @Nullable
    public String getDisplayName() {
        return this.zzaco;
    }

    @Nullable
    public String getEmail() {
        return this.zzacn;
    }

    @Nullable
    public Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzaBl) && this.zzbFn == null) {
            this.zzbFn = Uri.parse(this.zzaBl);
        }
        return this.zzbFn;
    }

    @NonNull
    public String getProviderId() {
        return this.zzbFO;
    }

    @NonNull
    public String getUid() {
        return this.zzVA;
    }
}
