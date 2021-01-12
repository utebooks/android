package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.measurement.internal.zzm;

public class zzo extends zzd<zzm> {
    public zzo(Context context, Looper looper, zzd.zzb zzb, zzd.zzc zzc) {
        super(context, looper, 93, zzb, zzc, (String) null);
    }

    /* renamed from: zzdw */
    public zzm zzab(IBinder iBinder) {
        return zzm.zza.zzdv(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        return "com.google.android.gms.measurement.START";
    }

    /* access modifiers changed from: protected */
    public String zzhU() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
