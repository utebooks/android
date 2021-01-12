package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzaku;

public class GetTokenResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetTokenResponse> CREATOR = new zzd();
    @zzacw
    public final int mVersionCode;
    @zzaku("expires_in")
    private Long zzbFU;
    @zzaku("token_type")
    private String zzbFV;
    @zzaku("issued_at")
    private Long zzbFW;
    @zzaku("refresh_token")
    private String zzbFo;
    @zzaku("access_token")
    private String zzbmS;

    public GetTokenResponse() {
        this.mVersionCode = 1;
        this.zzbFW = Long.valueOf(System.currentTimeMillis());
    }

    GetTokenResponse(int i, String str, String str2, Long l, String str3, Long l2) {
        this.mVersionCode = i;
        this.zzbFo = str;
        this.zzbmS = str2;
        this.zzbFU = l;
        this.zzbFV = str3;
        this.zzbFW = l2;
    }

    public String getAccessToken() {
        return this.zzbmS;
    }

    public boolean isValid() {
        return zzh.zzuW().currentTimeMillis() + 300000 < this.zzbFW.longValue() + (this.zzbFU.longValue() * 1000);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public String zzOG() {
        return this.zzbFo;
    }

    public long zzOH() {
        if (this.zzbFU == null) {
            return 0;
        }
        return this.zzbFU.longValue();
    }

    @Nullable
    public String zzOI() {
        return this.zzbFV;
    }

    public long zzOJ() {
        return this.zzbFW.longValue();
    }

    public void zzhH(@NonNull String str) {
        this.zzbFo = zzaa.zzdl(str);
    }
}
