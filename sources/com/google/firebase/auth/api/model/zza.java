package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<CreateAuthUriResponse> {
    static void zza(CreateAuthUriResponse createAuthUriResponse, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, createAuthUriResponse.mVersionCode);
        zzb.zza(parcel, 2, createAuthUriResponse.zzOz(), false);
        zzb.zza(parcel, 3, createAuthUriResponse.isRegistered());
        zzb.zza(parcel, 4, createAuthUriResponse.getProviderId(), false);
        zzb.zza(parcel, 5, createAuthUriResponse.zzOA());
        zzb.zza(parcel, 6, (Parcelable) createAuthUriResponse.zzOB(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjl */
    public CreateAuthUriResponse createFromParcel(Parcel parcel) {
        StringList stringList = null;
        boolean z = false;
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        String str = null;
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzap);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzap);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzap);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzap);
                    break;
                case 6:
                    stringList = (StringList) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzap, StringList.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new CreateAuthUriResponse(i, str2, z2, str, z, stringList);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zznn */
    public CreateAuthUriResponse[] newArray(int i) {
        return new CreateAuthUriResponse[i];
    }
}
