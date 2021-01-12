package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<ProviderUserInfoList> {
    static void zza(ProviderUserInfoList providerUserInfoList, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, providerUserInfoList.mVersionCode);
        zzb.zzc(parcel, 2, providerUserInfoList.zzOD(), false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjq */
    public ProviderUserInfoList createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        ArrayList<ProviderUserInfo> arrayList = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel, zzap);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzap, ProviderUserInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new ProviderUserInfoList(i, arrayList);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zzns */
    public ProviderUserInfoList[] newArray(int i) {
        return new ProviderUserInfoList[i];
    }
}
