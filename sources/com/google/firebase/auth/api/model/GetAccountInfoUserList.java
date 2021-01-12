package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzacw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetAccountInfoUserList extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetAccountInfoUserList> CREATOR = new zzc();
    @zzacw
    public final int mVersionCode;
    private List<GetAccountInfoUser> zzbFT;

    public GetAccountInfoUserList() {
        this.mVersionCode = 1;
        this.zzbFT = new ArrayList();
    }

    GetAccountInfoUserList(int i, List<GetAccountInfoUser> list) {
        this.mVersionCode = i;
        this.zzbFT = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public List<GetAccountInfoUser> zzOF() {
        return this.zzbFT;
    }
}
