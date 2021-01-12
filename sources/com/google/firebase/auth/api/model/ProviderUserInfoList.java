package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProviderUserInfoList extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProviderUserInfoList> CREATOR = new zzf();
    public final int mVersionCode;
    private List<ProviderUserInfo> zzbFY;

    public ProviderUserInfoList() {
        this.mVersionCode = 1;
        this.zzbFY = new ArrayList();
    }

    ProviderUserInfoList(int i, List<ProviderUserInfo> list) {
        this.mVersionCode = i;
        if (list == null || list.isEmpty()) {
            this.zzbFY = Collections.emptyList();
        } else {
            this.zzbFY = Collections.unmodifiableList(list);
        }
    }

    public static ProviderUserInfoList zzOL() {
        return new ProviderUserInfoList();
    }

    public static ProviderUserInfoList zza(ProviderUserInfoList providerUserInfoList) {
        List<ProviderUserInfo> zzOD = providerUserInfoList.zzOD();
        ProviderUserInfoList providerUserInfoList2 = new ProviderUserInfoList();
        if (zzOD != null) {
            providerUserInfoList2.zzOD().addAll(zzOD);
        }
        return providerUserInfoList2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public List<ProviderUserInfo> zzOD() {
        return this.zzbFY;
    }
}
