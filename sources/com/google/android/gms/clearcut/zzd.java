package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Parcelable.Creator<LogEventParcelable> {
    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, (Parcelable) logEventParcelable.zzajL, i, false);
        zzb.zza(parcel, 3, logEventParcelable.zzajM, false);
        zzb.zza(parcel, 4, logEventParcelable.zzajN, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzab */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        int[] zzw;
        byte[] bArr;
        PlayLoggerContext playLoggerContext;
        int i;
        int[] iArr = null;
        int zzaq = zza.zzaq(parcel);
        int i2 = 0;
        byte[] bArr2 = null;
        PlayLoggerContext playLoggerContext2 = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    int[] iArr2 = iArr;
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = zza.zzg(parcel, zzap);
                    zzw = iArr2;
                    break;
                case 2:
                    i = i2;
                    byte[] bArr3 = bArr2;
                    playLoggerContext = (PlayLoggerContext) zza.zza(parcel, zzap, PlayLoggerContext.CREATOR);
                    zzw = iArr;
                    bArr = bArr3;
                    break;
                case 3:
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    int[] iArr3 = iArr;
                    bArr = zza.zzt(parcel, zzap);
                    zzw = iArr3;
                    break;
                case 4:
                    zzw = zza.zzw(parcel, zzap);
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    zzw = iArr;
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    break;
            }
            i2 = i;
            playLoggerContext2 = playLoggerContext;
            bArr2 = bArr;
            iArr = zzw;
        }
        if (parcel.dataPosition() == zzaq) {
            return new LogEventParcelable(i2, playLoggerContext2, bArr2, iArr);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zzbz */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
