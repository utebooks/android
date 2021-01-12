package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzaku;

public class VerifyAssertionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VerifyAssertionRequest> CREATOR = new zzh();
    @zzacw
    public final int mVersionCode;
    @zzaku("postBody")
    private String zzCf;
    @zzacw
    private String zzabK;
    @Nullable
    @zzacw
    private String zzacn;
    @zzacw
    private String zzbFO;
    @zzaku("requestUri")
    private String zzbGa;
    @zzaku("idToken")
    private String zzbGb;
    @zzaku("oauthTokenSecret")
    private String zzbGc;
    @zzaku("returnSecureToken")
    private boolean zzbGd;
    @zzacw
    private String zzbmS;

    public VerifyAssertionRequest() {
        this.mVersionCode = 2;
        this.zzbGd = true;
    }

    VerifyAssertionRequest(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z) {
        this.mVersionCode = i;
        this.zzbGa = str;
        this.zzbGb = str2;
        this.zzabK = str3;
        this.zzbmS = str4;
        this.zzbFO = str5;
        this.zzacn = str6;
        this.zzCf = str7;
        this.zzbGc = str8;
        this.zzbGd = z;
    }

    public VerifyAssertionRequest(@Nullable String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5) {
        this.mVersionCode = 2;
        this.zzbGa = "http://localhost";
        this.zzabK = str;
        this.zzbmS = str2;
        this.zzbGc = str5;
        this.zzbGd = true;
        if (!TextUtils.isEmpty(this.zzabK) || !TextUtils.isEmpty(this.zzbmS)) {
            this.zzbFO = zzaa.zzdl(str3);
            this.zzacn = str4;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzabK)) {
                sb.append("id_token").append("=").append(this.zzabK).append("&");
            }
            if (!TextUtils.isEmpty(this.zzbmS)) {
                sb.append("access_token").append("=").append(this.zzbmS).append("&");
            }
            if (!TextUtils.isEmpty(this.zzacn)) {
                sb.append("identifier").append("=").append(this.zzacn).append("&");
            }
            if (!TextUtils.isEmpty(this.zzbGc)) {
                sb.append("oauth_token_secret").append("=").append(this.zzbGc).append("&");
            }
            sb.append("providerId").append("=").append(this.zzbFO);
            this.zzCf = sb.toString();
            return;
        }
        throw new IllegalArgumentException("Both idToken, and accessToken cannot be null");
    }

    public String getAccessToken() {
        return this.zzbmS;
    }

    @Nullable
    public String getEmail() {
        return this.zzacn;
    }

    public String getIdToken() {
        return this.zzabK;
    }

    public String getProviderId() {
        return this.zzbFO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public String zzOO() {
        return this.zzbGa;
    }

    public String zzOP() {
        return this.zzbGb;
    }

    public String zzOQ() {
        return this.zzbGc;
    }

    public boolean zzOR() {
        return this.zzbGd;
    }

    public String zzfb() {
        return this.zzCf;
    }
}
