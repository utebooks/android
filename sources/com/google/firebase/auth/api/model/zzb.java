package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<GetAccountInfoUser> {
    static void zza(GetAccountInfoUser getAccountInfoUser, Parcel parcel, int i) {
        int zzar = com.google.android.gms.common.internal.safeparcel.zzb.zzar(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getAccountInfoUser.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getAccountInfoUser.getLocalId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getAccountInfoUser.getEmail(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, getAccountInfoUser.zzOC());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, getAccountInfoUser.getDisplayName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, getAccountInfoUser.zzOo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) getAccountInfoUser.zzOE(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, getAccountInfoUser.getPassword(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjm */
    public GetAccountInfoUser createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaq = zza.zzaq(parcel);
        ProviderUserInfoList providerUserInfoList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel, zzap);
                    break;
                case 2:
                    str5 = zza.zzq(parcel, zzap);
                    break;
                case 3:
                    str4 = zza.zzq(parcel, zzap);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzap);
                    break;
                case 5:
                    str3 = zza.zzq(parcel, zzap);
                    break;
                case 6:
                    str2 = zza.zzq(parcel, zzap);
                    break;
                case 7:
                    providerUserInfoList = (ProviderUserInfoList) zza.zza(parcel, zzap, ProviderUserInfoList.CREATOR);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzap);
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new GetAccountInfoUser(i, str5, str4, z, str3, str2, providerUserInfoList, str);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zzno */
    public GetAccountInfoUser[] newArray(int i) {
        return new GetAccountInfoUser[i];
    }
}
