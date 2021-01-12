package com.google.firebase.auth.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzaku;
import java.util.List;

public class GetAccountInfoUser implements SafeParcelable {
    public static final Parcelable.Creator<GetAccountInfoUser> CREATOR = new zzb();
    @zzacw
    public final int mVersionCode;
    @zzaku("photoUrl")
    private String zzaBl;
    @zzaku("passwordHash")
    private String zzabx;
    @zzaku("email")
    private String zzacn;
    @zzaku("displayName")
    private String zzaco;
    @zzaku("localId")
    private String zzayv;
    @zzaku("emailVerified")
    private boolean zzbFR;
    @zzaku("providerUserInfo")
    private ProviderUserInfoList zzbFS;

    public GetAccountInfoUser() {
        this.mVersionCode = 1;
        this.zzbFS = new ProviderUserInfoList();
    }

    GetAccountInfoUser(int i, String str, String str2, boolean z, String str3, String str4, ProviderUserInfoList providerUserInfoList, String str5) {
        this.mVersionCode = i;
        this.zzayv = str;
        this.zzacn = str2;
        this.zzbFR = z;
        this.zzaco = str3;
        this.zzaBl = str4;
        this.zzbFS = providerUserInfoList == null ? ProviderUserInfoList.zzOL() : ProviderUserInfoList.zza(providerUserInfoList);
        this.zzabx = str5;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getDisplayName() {
        return this.zzaco;
    }

    @Nullable
    public String getEmail() {
        return this.zzacn;
    }

    @NonNull
    public String getLocalId() {
        return this.zzayv;
    }

    @Nullable
    public String getPassword() {
        return this.zzabx;
    }

    @Nullable
    public Uri getPhotoUri() {
        if (!TextUtils.isEmpty(this.zzaBl)) {
            return Uri.parse(this.zzaBl);
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public boolean zzOC() {
        return this.zzbFR;
    }

    @NonNull
    public List<ProviderUserInfo> zzOD() {
        return this.zzbFS.zzOD();
    }

    public ProviderUserInfoList zzOE() {
        return this.zzbFS;
    }

    @Nullable
    public String zzOo() {
        return this.zzaBl;
    }
}
