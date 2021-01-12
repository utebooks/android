package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<GetAccountInfoUserList> {
    static void zza(GetAccountInfoUserList getAccountInfoUserList, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, getAccountInfoUserList.mVersionCode);
        zzb.zzc(parcel, 2, getAccountInfoUserList.zzOF(), false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjn */
    public GetAccountInfoUserList createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        ArrayList<GetAccountInfoUser> arrayList = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel, zzap);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzap, GetAccountInfoUser.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new GetAccountInfoUserList(i, arrayList);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zznp */
    public GetAccountInfoUserList[] newArray(int i) {
        return new GetAccountInfoUserList[i];
    }
}
