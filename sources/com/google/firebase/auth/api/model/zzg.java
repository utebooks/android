package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Parcelable.Creator<StringList> {
    static void zza(StringList stringList, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, stringList.mVersionCode);
        zzb.zzb(parcel, 2, stringList.zzOM(), false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjr */
    public StringList createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel, zzap);
                    break;
                case 2:
                    arrayList = zza.zzE(parcel, zzap);
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new StringList(i, arrayList);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zznt */
    public StringList[] newArray(int i) {
        return new StringList[i];
    }
}
