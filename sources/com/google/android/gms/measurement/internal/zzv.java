package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzamb;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public class zzv extends zzaa {
    private final Map<String, Map<String, String>> zzbec = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzbed = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzbee = new ArrayMap();
    private final Map<String, zzso.zzb> zzbef = new ArrayMap();
    private final Map<String, String> zzbeg = new ArrayMap();

    zzv(zzx zzx) {
        super(zzx);
    }

    private Map<String, String> zza(zzso.zzb zzb) {
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzb == null || zzb.zzbgN == null)) {
            for (zzso.zzc zzc : zzb.zzbgN) {
                if (zzc != null) {
                    arrayMap.put(zzc.zzaB, zzc.value);
                }
            }
        }
        return arrayMap;
    }

    private void zza(String str, zzso.zzb zzb) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        if (!(zzb == null || zzb.zzbgO == null)) {
            for (zzso.zza zza : zzb.zzbgO) {
                if (zza != null) {
                    String str2 = AppMeasurement.zza.zzbbm.get(zza.name);
                    if (str2 != null) {
                        zza.name = str2;
                    }
                    arrayMap.put(zza.name, zza.zzbgJ);
                    arrayMap2.put(zza.name, zza.zzbgK);
                }
            }
        }
        this.zzbed.put(str, arrayMap);
        this.zzbee.put(str, arrayMap2);
    }

    @WorkerThread
    private zzso.zzb zze(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzso.zzb();
        }
        zzamb zzN = zzamb.zzN(bArr);
        zzso.zzb zzb = new zzso.zzb();
        try {
            zzso.zzb zzb2 = (zzso.zzb) zzb.mergeFrom(zzN);
            zzFm().zzFL().zze("Parsed config. version, gmp_app_id", zzb.zzbgL, zzb.zzbbK);
            return zzb;
        } catch (IOException e) {
            zzFm().zzFG().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    @WorkerThread
    private void zzfx(String str) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        if (!this.zzbef.containsKey(str)) {
            byte[] zzfm = zzFh().zzfm(str);
            if (zzfm == null) {
                this.zzbec.put(str, (Object) null);
                this.zzbed.put(str, (Object) null);
                this.zzbee.put(str, (Object) null);
                this.zzbef.put(str, (Object) null);
                this.zzbeg.put(str, (Object) null);
                return;
            }
            zzso.zzb zze = zze(str, zzfm);
            this.zzbec.put(str, zza(zze));
            zza(str, zze);
            this.zzbef.put(str, zze);
            this.zzbeg.put(str, (Object) null);
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzFb() {
        super.zzFb();
    }

    public /* bridge */ /* synthetic */ zzc zzFc() {
        return super.zzFc();
    }

    public /* bridge */ /* synthetic */ zzac zzFd() {
        return super.zzFd();
    }

    public /* bridge */ /* synthetic */ zzn zzFe() {
        return super.zzFe();
    }

    public /* bridge */ /* synthetic */ zzg zzFf() {
        return super.zzFf();
    }

    public /* bridge */ /* synthetic */ zzad zzFg() {
        return super.zzFg();
    }

    public /* bridge */ /* synthetic */ zze zzFh() {
        return super.zzFh();
    }

    public /* bridge */ /* synthetic */ zzal zzFi() {
        return super.zzFi();
    }

    public /* bridge */ /* synthetic */ zzv zzFj() {
        return super.zzFj();
    }

    public /* bridge */ /* synthetic */ zzaf zzFk() {
        return super.zzFk();
    }

    public /* bridge */ /* synthetic */ zzw zzFl() {
        return super.zzFl();
    }

    public /* bridge */ /* synthetic */ zzp zzFm() {
        return super.zzFm();
    }

    public /* bridge */ /* synthetic */ zzt zzFn() {
        return super.zzFn();
    }

    public /* bridge */ /* synthetic */ zzd zzFo() {
        return super.zzFo();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzU(String str, String str2) {
        zzkN();
        zzfx(str);
        Map map = this.zzbec.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzV(String str, String str2) {
        zzkN();
        zzfx(str);
        Map map = this.zzbed.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzW(String str, String str2) {
        zzkN();
        zzfx(str);
        Map map = this.zzbee.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzb(String str, byte[] bArr, String str2) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        zzso.zzb zze = zze(str, bArr);
        if (zze == null) {
            return false;
        }
        zza(str, zze);
        this.zzbef.put(str, zze);
        this.zzbeg.put(str, str2);
        this.zzbec.put(str, zza(zze));
        zzFc().zza(str, zze.zzbgP);
        try {
            zze.zzbgP = null;
            byte[] bArr2 = new byte[zze.getSerializedSize()];
            zze.writeTo(zzamc.zzO(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzFm().zzFG().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzFh().zzd(str, bArr);
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzfA(String str) {
        zzkN();
        this.zzbeg.put(str, (Object) null);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public zzso.zzb zzfy(String str) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        zzfx(str);
        return this.zzbef.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public String zzfz(String str) {
        zzkN();
        return this.zzbeg.get(str);
    }

    public /* bridge */ /* synthetic */ void zzkN() {
        super.zzkN();
    }

    /* access modifiers changed from: protected */
    public void zzkO() {
    }

    public /* bridge */ /* synthetic */ void zzlP() {
        super.zzlP();
    }

    public /* bridge */ /* synthetic */ zze zzlQ() {
        return super.zzlQ();
    }
}
