package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<Configuration> {
    static void zza(Configuration configuration, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, configuration.mVersionCode);
        zzb.zzc(parcel, 2, configuration.zzbkB);
        zzb.zza(parcel, 3, (T[]) configuration.zzbkC, i, false);
        zzb.zza(parcel, 4, configuration.zzbkD, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzgR */
    public Configuration createFromParcel(Parcel parcel) {
        String[] zzC;
        Flag[] flagArr;
        int i;
        int i2;
        String[] strArr = null;
        int i3 = 0;
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        Flag[] flagArr2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap)) {
                case 1:
                    String[] strArr2 = strArr;
                    flagArr = flagArr2;
                    i = i3;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
                    zzC = strArr2;
                    break;
                case 2:
                    i2 = i4;
                    Flag[] flagArr3 = flagArr2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
                    zzC = strArr;
                    flagArr = flagArr3;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    String[] strArr3 = strArr;
                    flagArr = (Flag[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap, Flag.CREATOR);
                    zzC = strArr3;
                    break;
                case 4:
                    zzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzap);
                    flagArr = flagArr2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
                    zzC = strArr;
                    flagArr = flagArr2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            flagArr2 = flagArr;
            strArr = zzC;
        }
        if (parcel.dataPosition() == zzaq) {
            return new Configuration(i4, i3, flagArr2, strArr);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zzkn */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
