package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zze;
import com.google.android.gms.measurement.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzx {
    private static volatile zzx zzbex;
    private final Context mContext;
    private final boolean zzWh;
    private final zzp zzbeA;
    private final zzw zzbeB;
    private final zzaf zzbeC;
    private final zzv zzbeD;
    private final AppMeasurement zzbeE;
    private final zzal zzbeF;
    private final zze zzbeG;
    private final zzq zzbeH;
    private final zzad zzbeI;
    private final zzg zzbeJ;
    private final zzac zzbeK;
    private final zzn zzbeL;
    private final zzr zzbeM;
    private final zzai zzbeN;
    private final zzc zzbeO;
    public final FirebaseAnalytics zzbeP = new FirebaseAnalytics(this);
    private boolean zzbeQ;
    private Boolean zzbeR;
    private FileLock zzbeS;
    private FileChannel zzbeT;
    private List<Long> zzbeU;
    private int zzbeV;
    private int zzbeW;
    private final zzd zzbey;
    private final zzt zzbez;
    private final zze zzsd;

    private class zza implements zze.zzb {
        zzsp.zze zzbeY;
        List<Long> zzbeZ;
        long zzbfa;
        List<zzsp.zzb> zzqD;

        private zza() {
        }

        private long zza(zzsp.zzb zzb) {
            return ((zzb.zzbgX.longValue() / 1000) / 60) / 60;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.zzqD == null || this.zzqD.isEmpty();
        }

        public boolean zza(long j, zzsp.zzb zzb) {
            zzaa.zzz(zzb);
            if (this.zzqD == null) {
                this.zzqD = new ArrayList();
            }
            if (this.zzbeZ == null) {
                this.zzbeZ = new ArrayList();
            }
            if (this.zzqD.size() > 0 && zza(this.zzqD.get(0)) != zza(zzb)) {
                return false;
            }
            long serializedSize = this.zzbfa + ((long) zzb.getSerializedSize());
            if (serializedSize >= ((long) zzx.this.zzFo().zzER())) {
                return false;
            }
            this.zzbfa = serializedSize;
            this.zzqD.add(zzb);
            this.zzbeZ.add(Long.valueOf(j));
            return this.zzqD.size() < zzx.this.zzFo().zzES();
        }

        public void zzc(zzsp.zze zze) {
            zzaa.zzz(zze);
            this.zzbeY = zze;
        }
    }

    zzx(zzab zzab) {
        zzaa.zzz(zzab);
        this.mContext = zzab.mContext;
        this.zzsd = zzab.zzl(this);
        this.zzbey = zzab.zza(this);
        zzt zzb = zzab.zzb(this);
        zzb.initialize();
        this.zzbez = zzb;
        zzp zzc = zzab.zzc(this);
        zzc.initialize();
        this.zzbeA = zzc;
        zzFm().zzFJ().zzj("App measurement is starting up, version", Long.valueOf(zzFo().zzEi()));
        zzFm().zzFJ().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzFm().zzFK().log("Debug logging enabled");
        zzFm().zzFK().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.zzbeF = zzab.zzi(this);
        zzg zzn = zzab.zzn(this);
        zzn.initialize();
        this.zzbeJ = zzn;
        zzn zzo = zzab.zzo(this);
        zzo.initialize();
        this.zzbeL = zzo;
        zze zzj = zzab.zzj(this);
        zzj.initialize();
        this.zzbeG = zzj;
        zzc zzr = zzab.zzr(this);
        zzr.initialize();
        this.zzbeO = zzr;
        zzq zzk = zzab.zzk(this);
        zzk.initialize();
        this.zzbeH = zzk;
        zzad zzm = zzab.zzm(this);
        zzm.initialize();
        this.zzbeI = zzm;
        zzac zzh = zzab.zzh(this);
        zzh.initialize();
        this.zzbeK = zzh;
        zzai zzq = zzab.zzq(this);
        zzq.initialize();
        this.zzbeN = zzq;
        this.zzbeM = zzab.zzp(this);
        this.zzbeE = zzab.zzg(this);
        zzaf zze = zzab.zze(this);
        zze.initialize();
        this.zzbeC = zze;
        zzv zzf = zzab.zzf(this);
        zzf.initialize();
        this.zzbeD = zzf;
        zzw zzd = zzab.zzd(this);
        zzd.initialize();
        this.zzbeB = zzd;
        if (this.zzbeV != this.zzbeW) {
            zzFm().zzFE().zze("Not all components initialized", Integer.valueOf(this.zzbeV), Integer.valueOf(this.zzbeW));
        }
        this.zzWh = true;
        if (!this.zzbey.zzmW() && !zzGh()) {
            if (!(this.mContext.getApplicationContext() instanceof Application)) {
                zzFm().zzFG().log("Application context is not an Application");
            } else if (Build.VERSION.SDK_INT >= 14) {
                zzFd().zzGw();
            } else {
                zzFm().zzFK().log("Not tracking deep linking pre-ICS");
            }
        }
        this.zzbeB.zzg(new Runnable() {
            public void run() {
                zzx.this.start();
            }
        });
    }

    private void zzD(List<Long> list) {
        zzaa.zzaj(!list.isEmpty());
        if (this.zzbeU != null) {
            zzFm().zzFE().log("Set uploading progress before finishing the previous upload");
        } else {
            this.zzbeU = new ArrayList(list);
        }
    }

    @WorkerThread
    private boolean zzGk() {
        zzkN();
        return this.zzbeU != null;
    }

    private boolean zzGm() {
        zzkN();
        zzma();
        return zzFh().zzFu() || !TextUtils.isEmpty(zzFh().zzFp());
    }

    @WorkerThread
    private void zzGn() {
        zzkN();
        zzma();
        if (zzGr()) {
            if (!zzFX() || !zzGm()) {
                zzGc().unregister();
                zzGd().cancel();
                return;
            }
            long zzGo = zzGo();
            if (zzGo == 0) {
                zzGc().unregister();
                zzGd().cancel();
            } else if (!zzGb().zzod()) {
                zzGc().zzoa();
                zzGd().cancel();
            } else {
                long j = zzFn().zzbdI.get();
                long zzEV = zzFo().zzEV();
                if (!zzFi().zzc(j, zzEV)) {
                    zzGo = Math.max(zzGo, j + zzEV);
                }
                zzGc().unregister();
                long currentTimeMillis = zzGo - zzlQ().currentTimeMillis();
                if (currentTimeMillis <= 0) {
                    zzGd().zzv(1);
                    return;
                }
                zzFm().zzFL().zzj("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis));
                zzGd().zzv(currentTimeMillis);
            }
        }
    }

    private long zzGo() {
        long currentTimeMillis = zzlQ().currentTimeMillis();
        long zzEY = zzFo().zzEY();
        long zzEW = zzFo().zzEW();
        long j = zzFn().zzbdG.get();
        long j2 = zzFn().zzbdH.get();
        long max = Math.max(zzFh().zzFs(), zzFh().zzFt());
        if (max == 0) {
            return 0;
        }
        long abs = currentTimeMillis - Math.abs(max - currentTimeMillis);
        long abs2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
        long max2 = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), abs2);
        long j3 = zzEY + abs;
        if (!zzFi().zzc(max2, zzEW)) {
            j3 = max2 + zzEW;
        }
        if (abs2 == 0 || abs2 < abs) {
            return j3;
        }
        for (int i = 0; i < zzFo().zzFa(); i++) {
            j3 += ((long) (1 << i)) * zzFo().zzEZ();
            if (j3 > abs2) {
                return j3;
            }
        }
        return 0;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(int i, Throwable th, byte[] bArr) {
        boolean z = false;
        zzkN();
        zzma();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.zzbeU;
        this.zzbeU = null;
        if ((i == 200 || i == 204) && th == null) {
            zzFn().zzbdG.set(zzlQ().currentTimeMillis());
            zzFn().zzbdH.set(0);
            zzGn();
            zzFm().zzFL().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzFh().beginTransaction();
            try {
                for (Long longValue : list) {
                    zzFh().zzae(longValue.longValue());
                }
                zzFh().setTransactionSuccessful();
                zzFh().endTransaction();
                if (!zzGb().zzod() || !zzGm()) {
                    zzGn();
                } else {
                    zzGl();
                }
            } catch (Throwable th2) {
                zzFh().endTransaction();
                throw th2;
            }
        } else {
            zzFm().zzFL().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzFn().zzbdH.set(zzlQ().currentTimeMillis());
            if (i == 503 || i == 429) {
                z = true;
            }
            if (z) {
                zzFn().zzbdI.set(zzlQ().currentTimeMillis());
            }
            zzGn();
        }
    }

    private void zza(zzaa zzaa) {
        if (zzaa == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzaa.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void zza(zzz zzz) {
        if (zzz == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private zzsp.zza[] zza(String str, zzsp.zzg[] zzgArr, zzsp.zzb[] zzbArr) {
        zzaa.zzdl(str);
        return zzFc().zza(str, zzbArr, zzgArr);
    }

    public static zzx zzbd(Context context) {
        zzaa.zzz(context);
        zzaa.zzz(context.getApplicationContext());
        if (zzbex == null) {
            synchronized (zzx.class) {
                if (zzbex == null) {
                    zzbex = new zzab(context).zzGv();
                }
            }
        }
        return zzbex;
    }

    @WorkerThread
    private void zze(AppMetadata appMetadata) {
        boolean z = true;
        zzkN();
        zzma();
        zzaa.zzz(appMetadata);
        zzaa.zzdl(appMetadata.packageName);
        zza zzfk = zzFh().zzfk(appMetadata.packageName);
        String zzfv = zzFn().zzfv(appMetadata.packageName);
        boolean z2 = false;
        if (zzfk == null) {
            zza zza2 = new zza(this, appMetadata.packageName);
            zza2.zzeV(zzFn().zzFO());
            zza2.zzeX(zzfv);
            zzfk = zza2;
            z2 = true;
        } else if (!zzfv.equals(zzfk.zzEc())) {
            zzfk.zzeX(zzfv);
            zzfk.zzeV(zzFn().zzFO());
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzbbK) && !appMetadata.zzbbK.equals(zzfk.zzEb())) {
            zzfk.zzeW(appMetadata.zzbbK);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzbbS) && !appMetadata.zzbbS.equals(zzfk.zzEd())) {
            zzfk.zzeY(appMetadata.zzbbS);
            z2 = true;
        }
        if (!(appMetadata.zzbbM == 0 || appMetadata.zzbbM == zzfk.zzEi())) {
            zzfk.zzU(appMetadata.zzbbM);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzaUf) && !appMetadata.zzaUf.equals(zzfk.zzkV())) {
            zzfk.setAppVersion(appMetadata.zzaUf);
            z2 = true;
        }
        if (appMetadata.zzbbR != zzfk.zzEg()) {
            zzfk.zzT(appMetadata.zzbbR);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzbbL) && !appMetadata.zzbbL.equals(zzfk.zzEh())) {
            zzfk.zzeZ(appMetadata.zzbbL);
            z2 = true;
        }
        if (appMetadata.zzbbN != zzfk.zzEj()) {
            zzfk.zzV(appMetadata.zzbbN);
            z2 = true;
        }
        if (appMetadata.zzbbP != zzfk.zzEk()) {
            zzfk.setMeasurementEnabled(appMetadata.zzbbP);
        } else {
            z = z2;
        }
        if (z) {
            zzFh().zza(zzfk);
        }
    }

    /* JADX INFO: finally extract failed */
    private boolean zzg(String str, long j) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        zzFh().beginTransaction();
        try {
            zza zza2 = new zza();
            zzFh().zza(str, j, (zze.zzb) zza2);
            if (!zza2.isEmpty()) {
                zzsp.zze zze = zza2.zzbeY;
                zze.zzbhe = new zzsp.zzb[zza2.zzqD.size()];
                int i3 = 0;
                int i4 = 0;
                while (i4 < zza2.zzqD.size()) {
                    if (zzFj().zzV(zza2.zzbeY.appId, zza2.zzqD.get(i4).name)) {
                        zzFm().zzFG().zzj("Dropping blacklisted raw event", zza2.zzqD.get(i4).name);
                        zzFi().zze(11, "_ev", zza2.zzqD.get(i4).name);
                        i = i3;
                    } else {
                        if (zzFj().zzW(zza2.zzbeY.appId, zza2.zzqD.get(i4).name)) {
                            if (zza2.zzqD.get(i4).zzbgW == null) {
                                zza2.zzqD.get(i4).zzbgW = new zzsp.zzc[0];
                            }
                            zzsp.zzc[] zzcArr = zza2.zzqD.get(i4).zzbgW;
                            int length = zzcArr.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length) {
                                    z = false;
                                    break;
                                }
                                zzsp.zzc zzc = zzcArr[i5];
                                if ("_c".equals(zzc.name)) {
                                    zzc.zzbha = 1L;
                                    z = true;
                                    break;
                                }
                                i5++;
                            }
                            if (!z) {
                                zzFm().zzFL().zzj("Marking event as conversion", zza2.zzqD.get(i4).name);
                                zzsp.zzc[] zzcArr2 = (zzsp.zzc[]) Arrays.copyOf(zza2.zzqD.get(i4).zzbgW, zza2.zzqD.get(i4).zzbgW.length + 1);
                                zzsp.zzc zzc2 = new zzsp.zzc();
                                zzc2.name = "_c";
                                zzc2.zzbha = 1L;
                                zzcArr2[zzcArr2.length - 1] = zzc2;
                                zza2.zzqD.get(i4).zzbgW = zzcArr2;
                            }
                            boolean zzfG = zzal.zzfG(zza2.zzqD.get(i4).name);
                            if (zzfG && zzFh().zza(zzGi(), zza2.zzbeY.appId, false, zzfG, false).zzbbZ - ((long) zzFo().zzfc(zza2.zzbeY.appId)) > 0) {
                                zzFm().zzFG().log("Too many conversions. Not logging as conversion.");
                                zzsp.zzb zzb = zza2.zzqD.get(i4);
                                boolean z3 = false;
                                zzsp.zzc zzc3 = null;
                                zzsp.zzc[] zzcArr3 = zza2.zzqD.get(i4).zzbgW;
                                int length2 = zzcArr3.length;
                                int i6 = 0;
                                while (i6 < length2) {
                                    zzsp.zzc zzc4 = zzcArr3[i6];
                                    if ("_c".equals(zzc4.name)) {
                                        z2 = z3;
                                    } else if ("_err".equals(zzc4.name)) {
                                        zzsp.zzc zzc5 = zzc3;
                                        z2 = true;
                                        zzc4 = zzc5;
                                    } else {
                                        zzc4 = zzc3;
                                        z2 = z3;
                                    }
                                    i6++;
                                    z3 = z2;
                                    zzc3 = zzc4;
                                }
                                if (z3 && zzc3 != null) {
                                    zzsp.zzc[] zzcArr4 = new zzsp.zzc[(zzb.zzbgW.length - 1)];
                                    int i7 = 0;
                                    zzsp.zzc[] zzcArr5 = zzb.zzbgW;
                                    int length3 = zzcArr5.length;
                                    int i8 = 0;
                                    while (i8 < length3) {
                                        zzsp.zzc zzc6 = zzcArr5[i8];
                                        if (zzc6 != zzc3) {
                                            i2 = i7 + 1;
                                            zzcArr4[i7] = zzc6;
                                        } else {
                                            i2 = i7;
                                        }
                                        i8++;
                                        i7 = i2;
                                    }
                                    zza2.zzqD.get(i4).zzbgW = zzcArr4;
                                } else if (zzc3 != null) {
                                    zzc3.name = "_err";
                                    zzc3.zzbha = 10L;
                                } else {
                                    zzFm().zzFE().log("Did not find conversion parameter. Error not tracked");
                                }
                            }
                        }
                        zze.zzbhe[i3] = zza2.zzqD.get(i4);
                        i = i3 + 1;
                    }
                    i4++;
                    i3 = i;
                }
                if (i3 < zza2.zzqD.size()) {
                    zze.zzbhe = (zzsp.zzb[]) Arrays.copyOf(zze.zzbhe, i3);
                }
                zze.zzbhx = zza(zza2.zzbeY.appId, zza2.zzbeY.zzbhf, zze.zzbhe);
                zze.zzbhh = zze.zzbhe[0].zzbgX;
                zze.zzbhi = zze.zzbhe[0].zzbgX;
                for (int i9 = 1; i9 < zze.zzbhe.length; i9++) {
                    zzsp.zzb zzb2 = zze.zzbhe[i9];
                    if (zzb2.zzbgX.longValue() < zze.zzbhh.longValue()) {
                        zze.zzbhh = zzb2.zzbgX;
                    }
                    if (zzb2.zzbgX.longValue() > zze.zzbhi.longValue()) {
                        zze.zzbhi = zzb2.zzbgX;
                    }
                }
                String str2 = zza2.zzbeY.appId;
                zza zzfk = zzFh().zzfk(str2);
                if (zzfk == null) {
                    zzFm().zzFE().log("Bundling raw events w/o app info");
                } else {
                    long zzEf = zzfk.zzEf();
                    zze.zzbhk = zzEf != 0 ? Long.valueOf(zzEf) : null;
                    long zzEe = zzfk.zzEe();
                    if (zzEe != 0) {
                        zzEf = zzEe;
                    }
                    zze.zzbhj = zzEf != 0 ? Long.valueOf(zzEf) : null;
                    zzfk.zzEo();
                    zze.zzbhv = Integer.valueOf((int) zzfk.zzEl());
                    zzfk.zzR(zze.zzbhh.longValue());
                    zzfk.zzS(zze.zzbhi.longValue());
                    zzFh().zza(zzfk);
                }
                zze.zzbbO = zzFm().zzFM();
                zzFh().zza(zze);
                zzFh().zzC(zza2.zzbeZ);
                zzFh().zzfq(str2);
                zzFh().setTransactionSuccessful();
                zzFh().endTransaction();
                return true;
            }
            zzFh().setTransactionSuccessful();
            zzFh().endTransaction();
            return false;
        } catch (Throwable th) {
            zzFh().endTransaction();
            throw th;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    public boolean isEnabled() {
        boolean z = false;
        zzkN();
        zzma();
        if (zzFo().zzEM()) {
            return false;
        }
        Boolean zzEN = zzFo().zzEN();
        if (zzEN != null) {
            z = zzEN.booleanValue();
        } else if (!zzFo().zzsB()) {
            z = true;
        }
        return zzFn().zzax(z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void start() {
        zzkN();
        if (!zzGh() || (this.zzbeB.isInitialized() && !this.zzbeB.zzGu())) {
            zzFh().zzFq();
            if (zzFX()) {
                if (!zzFo().zzmW() && !TextUtils.isEmpty(zzFe().zzEb())) {
                    String zzFR = zzFn().zzFR();
                    if (zzFR == null) {
                        zzFn().zzfw(zzFe().zzEb());
                    } else if (!zzFR.equals(zzFe().zzEb())) {
                        zzFm().zzFJ().log("Rechecking which service to use due to a GMP App Id change");
                        zzFn().zzFT();
                        this.zzbeI.disconnect();
                        this.zzbeI.zzmC();
                        zzFn().zzfw(zzFe().zzEb());
                    }
                }
                if (!zzFo().zzmW() && !zzGh() && !TextUtils.isEmpty(zzFe().zzEb())) {
                    zzFd().zzGx();
                }
            } else if (isEnabled()) {
                if (!zzFi().zzbN("android.permission.INTERNET")) {
                    zzFm().zzFE().log("App is missing INTERNET permission");
                }
                if (!zzFi().zzbN("android.permission.ACCESS_NETWORK_STATE")) {
                    zzFm().zzFE().log("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!zzu.zzU(getContext())) {
                    zzFm().zzFE().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzae.zzV(getContext())) {
                    zzFm().zzFE().log("AppMeasurementService not registered/enabled");
                }
                zzFm().zzFE().log("Uploading is not possible. App measurement disabled");
            }
            zzGn();
            return;
        }
        zzFm().zzFE().log("Scheduler shutting down before Scion.start() called");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzFX() {
        zzma();
        zzkN();
        if (this.zzbeR == null) {
            this.zzbeR = Boolean.valueOf(zzFi().zzbN("android.permission.INTERNET") && zzFi().zzbN("android.permission.ACCESS_NETWORK_STATE") && zzu.zzU(getContext()) && zzae.zzV(getContext()));
            if (this.zzbeR.booleanValue() && !zzFo().zzmW()) {
                this.zzbeR = Boolean.valueOf(zzFi().zzfN(zzFe().zzEb()));
            }
        }
        return this.zzbeR.booleanValue();
    }

    public zzp zzFY() {
        if (this.zzbeA == null || !this.zzbeA.isInitialized()) {
            return null;
        }
        return this.zzbeA;
    }

    /* access modifiers changed from: package-private */
    public zzw zzFZ() {
        return this.zzbeB;
    }

    public zzc zzFc() {
        zza((zzaa) this.zzbeO);
        return this.zzbeO;
    }

    public zzac zzFd() {
        zza((zzaa) this.zzbeK);
        return this.zzbeK;
    }

    public zzn zzFe() {
        zza((zzaa) this.zzbeL);
        return this.zzbeL;
    }

    public zzg zzFf() {
        zza((zzaa) this.zzbeJ);
        return this.zzbeJ;
    }

    public zzad zzFg() {
        zza((zzaa) this.zzbeI);
        return this.zzbeI;
    }

    public zze zzFh() {
        zza((zzaa) this.zzbeG);
        return this.zzbeG;
    }

    public zzal zzFi() {
        zza((zzz) this.zzbeF);
        return this.zzbeF;
    }

    public zzv zzFj() {
        zza((zzaa) this.zzbeD);
        return this.zzbeD;
    }

    public zzaf zzFk() {
        zza((zzaa) this.zzbeC);
        return this.zzbeC;
    }

    public zzw zzFl() {
        zza((zzaa) this.zzbeB);
        return this.zzbeB;
    }

    public zzp zzFm() {
        zza((zzaa) this.zzbeA);
        return this.zzbeA;
    }

    public zzt zzFn() {
        zza((zzz) this.zzbez);
        return this.zzbez;
    }

    public zzd zzFo() {
        return this.zzbey;
    }

    public AppMeasurement zzGa() {
        return this.zzbeE;
    }

    public zzq zzGb() {
        zza((zzaa) this.zzbeH);
        return this.zzbeH;
    }

    public zzr zzGc() {
        if (this.zzbeM != null) {
            return this.zzbeM;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzai zzGd() {
        zza((zzaa) this.zzbeN);
        return this.zzbeN;
    }

    /* access modifiers changed from: package-private */
    public FileChannel zzGe() {
        return this.zzbeT;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzGf() {
        zzkN();
        zzma();
        if (zzGr() && zzGg()) {
            zzv(zza(zzGe()), zzFe().zzFC());
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzGg() {
        zzkN();
        try {
            this.zzbeT = new RandomAccessFile(new File(getContext().getFilesDir(), this.zzbeG.zzmv()), "rw").getChannel();
            this.zzbeS = this.zzbeT.tryLock();
            if (this.zzbeS != null) {
                zzFm().zzFL().log("Storage concurrent access okay");
                return true;
            }
            zzFm().zzFE().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzFm().zzFE().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Failed to access storage lock file", e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzGh() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public long zzGi() {
        return ((((zzlQ().currentTimeMillis() + zzFn().zzFP()) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public void zzGj() {
        if (!zzFo().zzmW()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    @WorkerThread
    public void zzGl() {
        zza zzfk;
        String str;
        List<Pair<zzsp.zze, Long>> list;
        ArrayMap arrayMap = null;
        zzkN();
        zzma();
        if (!zzFo().zzmW()) {
            Boolean zzFS = zzFn().zzFS();
            if (zzFS == null) {
                zzFm().zzFG().log("Upload data called on the client side before use of service was decided");
                return;
            } else if (zzFS.booleanValue()) {
                zzFm().zzFE().log("Upload called in the client side when service should be used");
                return;
            }
        }
        if (zzGk()) {
            zzFm().zzFG().log("Uploading requested multiple times");
        } else if (!zzGb().zzod()) {
            zzFm().zzFG().log("Network not connected, ignoring upload request");
            zzGn();
        } else {
            long currentTimeMillis = zzlQ().currentTimeMillis();
            zzai(currentTimeMillis - zzFo().zzEU());
            long j = zzFn().zzbdG.get();
            if (j != 0) {
                zzFm().zzFK().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String zzFp = zzFh().zzFp();
            if (!TextUtils.isEmpty(zzFp)) {
                List<Pair<zzsp.zze, Long>> zzn = zzFh().zzn(zzFp, zzFo().zzfg(zzFp), zzFo().zzfh(zzFp));
                if (!zzn.isEmpty()) {
                    Iterator<Pair<zzsp.zze, Long>> it = zzn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        zzsp.zze zze = (zzsp.zze) it.next().first;
                        if (!TextUtils.isEmpty(zze.zzbhr)) {
                            str = zze.zzbhr;
                            break;
                        }
                    }
                    if (str != null) {
                        int i = 0;
                        while (true) {
                            if (i >= zzn.size()) {
                                break;
                            }
                            zzsp.zze zze2 = (zzsp.zze) zzn.get(i).first;
                            if (!TextUtils.isEmpty(zze2.zzbhr) && !zze2.zzbhr.equals(str)) {
                                list = zzn.subList(0, i);
                                break;
                            }
                            i++;
                        }
                    }
                    list = zzn;
                    zzsp.zzd zzd = new zzsp.zzd();
                    zzd.zzbhb = new zzsp.zze[list.size()];
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i2 = 0; i2 < zzd.zzbhb.length; i2++) {
                        zzd.zzbhb[i2] = (zzsp.zze) list.get(i2).first;
                        arrayList.add((Long) list.get(i2).second);
                        zzd.zzbhb[i2].zzbhq = Long.valueOf(zzFo().zzEi());
                        zzd.zzbhb[i2].zzbhg = Long.valueOf(currentTimeMillis);
                        zzd.zzbhb[i2].zzbhw = Boolean.valueOf(zzFo().zzmW());
                    }
                    String zzb = zzFm().zzX(2) ? zzal.zzb(zzd) : null;
                    byte[] zza2 = zzFi().zza(zzd);
                    String zzET = zzFo().zzET();
                    try {
                        URL url = new URL(zzET);
                        zzD(arrayList);
                        zzFn().zzbdH.set(currentTimeMillis);
                        String str2 = "?";
                        if (zzd.zzbhb.length > 0) {
                            str2 = zzd.zzbhb[0].appId;
                        }
                        zzFm().zzFL().zzd("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zza2.length), zzb);
                        zzGb().zza(zzFp, url, zza2, (Map<String, String>) null, new zzq.zza() {
                            public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
                                zzx.this.zza(i, th, bArr);
                            }
                        });
                    } catch (MalformedURLException e) {
                        zzFm().zzFE().zzj("Failed to parse upload URL. Not uploading", zzET);
                    }
                }
            } else {
                String zzaf = zzFh().zzaf(currentTimeMillis - zzFo().zzEU());
                if (!TextUtils.isEmpty(zzaf) && (zzfk = zzFh().zzfk(zzaf)) != null) {
                    String zzN = zzFo().zzN(zzfk.zzEb(), zzfk.zzvx());
                    try {
                        URL url2 = new URL(zzN);
                        zzFm().zzFL().zzj("Fetching remote configuration", zzfk.zziC());
                        zzso.zzb zzfy = zzFj().zzfy(zzfk.zziC());
                        String zzfz = zzFj().zzfz(zzfk.zziC());
                        if (zzfy != null && !TextUtils.isEmpty(zzfz)) {
                            arrayMap = new ArrayMap();
                            arrayMap.put("If-Modified-Since", zzfz);
                        }
                        zzGb().zza(zzaf, url2, arrayMap, new zzq.zza() {
                            public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
                                zzx.this.zzb(str, i, th, bArr, map);
                            }
                        });
                    } catch (MalformedURLException e2) {
                        zzFm().zzFE().zzj("Failed to parse config URL. Not fetching", zzN);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzGp() {
        this.zzbeW++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzGq() {
        zzkN();
        zzma();
        if (!this.zzbeQ) {
            zzFm().zzFJ().log("This instance being marked as an uploader");
            zzGf();
        }
        this.zzbeQ = true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzGr() {
        zzkN();
        zzma();
        return this.zzbeQ || zzGh();
    }

    public void zzR(boolean z) {
        zzGn();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public int zza(FileChannel fileChannel) {
        zzkN();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzFm().zzFE().log("Bad chanel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                zzFm().zzFG().zzj("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzFm().zzFE().zzj("Failed to read from channel", e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zza(AppMetadata appMetadata, long j) {
        zza zzfk = zzFh().zzfk(appMetadata.packageName);
        if (!(zzfk == null || zzfk.zzEb() == null || zzfk.zzEb().equals(appMetadata.zzbbK))) {
            zzFm().zzFG().log("New GMP App Id passed in. Removing cached database data.");
            zzFh().zzfp(zzfk.zziC());
            zzfk = null;
        }
        if (zzfk != null && zzfk.zzkV() != null && !zzfk.zzkV().equals(appMetadata.zzaUf)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", zzfk.zzkV());
            zzb(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzh zzh, AppMetadata appMetadata) {
        zzkN();
        zzma();
        zzaa.zzz(zzh);
        zzaa.zzz(appMetadata);
        zzaa.zzdl(zzh.zzPx);
        zzaa.zzaj(zzh.zzPx.equals(appMetadata.packageName));
        zzsp.zze zze = new zzsp.zze();
        zze.zzbhd = 1;
        zze.zzbhl = "android";
        zze.appId = appMetadata.packageName;
        zze.zzbbL = appMetadata.zzbbL;
        zze.zzaUf = appMetadata.zzaUf;
        zze.zzbhy = Integer.valueOf((int) appMetadata.zzbbR);
        zze.zzbhp = Long.valueOf(appMetadata.zzbbM);
        zze.zzbbK = appMetadata.zzbbK;
        zze.zzbhu = appMetadata.zzbbN == 0 ? null : Long.valueOf(appMetadata.zzbbN);
        Pair<String, Boolean> zzfu = zzFn().zzfu(appMetadata.packageName);
        if (zzfu != null && !TextUtils.isEmpty((CharSequence) zzfu.first)) {
            zze.zzbhr = (String) zzfu.first;
            zze.zzbhs = (Boolean) zzfu.second;
        } else if (!zzFf().zzbc(this.mContext)) {
            String string = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
            if (string == null) {
                zzFm().zzFG().log("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                zzFm().zzFG().log("empty secure ID");
            }
            zze.zzbhB = string;
        }
        zze.zzbhm = zzFf().zzjb();
        zze.osVersion = zzFf().zzFx();
        zze.zzbho = Integer.valueOf((int) zzFf().zzFy());
        zze.zzbhn = zzFf().zzFz();
        zze.zzbhq = null;
        zze.zzbhg = null;
        zze.zzbhh = null;
        zze.zzbhi = null;
        zza zzfk = zzFh().zzfk(appMetadata.packageName);
        if (zzfk == null) {
            zzfk = new zza(this, appMetadata.packageName);
            zzfk.zzeV(zzFn().zzFO());
            zzfk.zzeY(appMetadata.zzbbS);
            zzfk.zzeW(appMetadata.zzbbK);
            zzfk.zzeX(zzFn().zzfv(appMetadata.packageName));
            zzfk.zzW(0);
            zzfk.zzR(0);
            zzfk.zzS(0);
            zzfk.setAppVersion(appMetadata.zzaUf);
            zzfk.zzT(appMetadata.zzbbR);
            zzfk.zzeZ(appMetadata.zzbbL);
            zzfk.zzU(appMetadata.zzbbM);
            zzfk.zzV(appMetadata.zzbbN);
            zzfk.setMeasurementEnabled(appMetadata.zzbbP);
            zzFh().zza(zzfk);
        }
        zze.zzbht = zzfk.zzvx();
        zze.zzbbS = zzfk.zzEd();
        List<zzak> zzfj = zzFh().zzfj(appMetadata.packageName);
        zze.zzbhf = new zzsp.zzg[zzfj.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < zzfj.size()) {
                zzsp.zzg zzg = new zzsp.zzg();
                zze.zzbhf[i2] = zzg;
                zzg.name = zzfj.get(i2).mName;
                zzg.zzbhF = Long.valueOf(zzfj.get(i2).zzbgg);
                zzFi().zza(zzg, zzfj.get(i2).zzRF);
                i = i2 + 1;
            } else {
                try {
                    zzFh().zza(zzh, zzFh().zzb(zze));
                    return;
                } catch (IOException e) {
                    zzFm().zzFE().zzj("Data loss. Failed to insert raw event metadata", e);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zza(int i, FileChannel fileChannel) {
        zzkN();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzFm().zzFE().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzFm().zzFE().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzFm().zzFE().zzj("Failed to write to channel", e);
            return false;
        }
    }

    @WorkerThread
    public byte[] zza(@NonNull EventParcel eventParcel, @Size(min = 1) String str) {
        long j;
        zzma();
        zzkN();
        zzGj();
        zzaa.zzz(eventParcel);
        zzaa.zzdl(str);
        zzsp.zzd zzd = new zzsp.zzd();
        zzFh().beginTransaction();
        try {
            zza zzfk = zzFh().zzfk(str);
            if (zzfk == null) {
                zzFm().zzFK().zzj("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzfk.zzEk()) {
                zzFm().zzFK().zzj("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzFh().endTransaction();
                return bArr;
            } else {
                zzsp.zze zze = new zzsp.zze();
                zzd.zzbhb = new zzsp.zze[]{zze};
                zze.zzbhd = 1;
                zze.zzbhl = "android";
                zze.appId = zzfk.zziC();
                zze.zzbbL = zzfk.zzEh();
                zze.zzaUf = zzfk.zzkV();
                zze.zzbhy = Integer.valueOf((int) zzfk.zzEg());
                zze.zzbhp = Long.valueOf(zzfk.zzEi());
                zze.zzbbK = zzfk.zzEb();
                zze.zzbhu = Long.valueOf(zzfk.zzEj());
                Pair<String, Boolean> zzfu = zzFn().zzfu(zzfk.zziC());
                if (zzfu != null && !TextUtils.isEmpty((CharSequence) zzfu.first)) {
                    zze.zzbhr = (String) zzfu.first;
                    zze.zzbhs = (Boolean) zzfu.second;
                }
                zze.zzbhm = zzFf().zzjb();
                zze.osVersion = zzFf().zzFx();
                zze.zzbho = Integer.valueOf((int) zzFf().zzFy());
                zze.zzbhn = zzFf().zzFz();
                zze.zzbht = zzfk.zzvx();
                zze.zzbbS = zzfk.zzEd();
                List<zzak> zzfj = zzFh().zzfj(zzfk.zziC());
                zze.zzbhf = new zzsp.zzg[zzfj.size()];
                for (int i = 0; i < zzfj.size(); i++) {
                    zzsp.zzg zzg = new zzsp.zzg();
                    zze.zzbhf[i] = zzg;
                    zzg.name = zzfj.get(i).mName;
                    zzg.zzbhF = Long.valueOf(zzfj.get(i).zzbgg);
                    zzFi().zza(zzg, zzfj.get(i).zzRF);
                }
                Bundle zzFB = eventParcel.zzbcq.zzFB();
                if ("_iap".equals(eventParcel.name)) {
                    zzFB.putLong("_c", 1);
                }
                zzFB.putString("_o", eventParcel.zzbcr);
                zzi zzO = zzFh().zzO(str, eventParcel.name);
                if (zzO == null) {
                    zzFh().zza(new zzi(str, eventParcel.name, 1, 0, eventParcel.zzbcs));
                    j = 0;
                } else {
                    j = zzO.zzbcm;
                    zzFh().zza(zzO.zzag(eventParcel.zzbcs).zzFA());
                }
                zzh zzh = new zzh(this, eventParcel.zzbcr, str, eventParcel.name, eventParcel.zzbcs, j, zzFB);
                zzsp.zzb zzb = new zzsp.zzb();
                zze.zzbhe = new zzsp.zzb[]{zzb};
                zzb.zzbgX = Long.valueOf(zzh.zzajg);
                zzb.name = zzh.mName;
                zzb.zzbgY = Long.valueOf(zzh.zzbci);
                zzb.zzbgW = new zzsp.zzc[zzh.zzbcj.size()];
                Iterator<String> it = zzh.zzbcj.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    zzsp.zzc zzc = new zzsp.zzc();
                    zzb.zzbgW[i2] = zzc;
                    zzc.name = next;
                    zzFi().zza(zzc, zzh.zzbcj.get(next));
                    i2++;
                }
                zze.zzbhx = zza(zzfk.zziC(), zze.zzbhf, zze.zzbhe);
                zze.zzbhh = zzb.zzbgX;
                zze.zzbhi = zzb.zzbgX;
                long zzEf = zzfk.zzEf();
                zze.zzbhk = zzEf != 0 ? Long.valueOf(zzEf) : null;
                long zzEe = zzfk.zzEe();
                if (zzEe != 0) {
                    zzEf = zzEe;
                }
                zze.zzbhj = zzEf != 0 ? Long.valueOf(zzEf) : null;
                zzfk.zzEo();
                zze.zzbhv = Integer.valueOf((int) zzfk.zzEl());
                zze.zzbhq = Long.valueOf(zzFo().zzEi());
                zze.zzbhg = Long.valueOf(zzlQ().currentTimeMillis());
                zze.zzbhw = Boolean.TRUE;
                zzfk.zzR(zze.zzbhh.longValue());
                zzfk.zzS(zze.zzbhi.longValue());
                zzFh().zza(zzfk);
                zzFh().setTransactionSuccessful();
                zzFh().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzd.getSerializedSize()];
                    zzamc zzO2 = zzamc.zzO(bArr2);
                    zzd.writeTo(zzO2);
                    zzO2.zzWU();
                    return zzFi().zzh(bArr2);
                } catch (IOException e) {
                    zzFm().zzFE().zzj("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            }
        } finally {
            zzFh().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzai(long j) {
        return zzg((String) null, j);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        zzb(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x01d3=Splitter:B:49:0x01d3, B:78:0x02b4=Splitter:B:78:0x02b4} */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzb(com.google.android.gms.measurement.internal.EventParcel r19, com.google.android.gms.measurement.internal.AppMetadata r20) {
        /*
            r18 = this;
            long r16 = java.lang.System.nanoTime()
            r18.zzkN()
            r18.zzma()
            r0 = r20
            java.lang.String r4 = r0.packageName
            com.google.android.gms.common.internal.zzaa.zzdl(r4)
            r0 = r20
            java.lang.String r2 = r0.zzbbK
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x001c
        L_0x001b:
            return
        L_0x001c:
            r0 = r20
            boolean r2 = r0.zzbbP
            if (r2 != 0) goto L_0x002a
            r0 = r18
            r1 = r20
            r0.zze(r1)
            goto L_0x001b
        L_0x002a:
            com.google.android.gms.measurement.internal.zzv r2 = r18.zzFj()
            r0 = r19
            java.lang.String r3 = r0.name
            boolean r2 = r2.zzV(r4, r3)
            if (r2 == 0) goto L_0x0059
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFG()
            java.lang.String r3 = "Dropping blacklisted event"
            r0 = r19
            java.lang.String r4 = r0.name
            r2.zzj(r3, r4)
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzFi()
            r3 = 11
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name
            r2.zze(r3, r4, r5)
            goto L_0x001b
        L_0x0059:
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()
            r3 = 2
            boolean r2 = r2.zzX(r3)
            if (r2 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFL()
            java.lang.String r3 = "Logging event"
            r0 = r19
            r2.zzj(r3, r0)
        L_0x0073:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.beginTransaction()
            r0 = r19
            com.google.android.gms.measurement.internal.EventParams r2 = r0.zzbcq     // Catch:{ all -> 0x0204 }
            android.os.Bundle r14 = r2.zzFB()     // Catch:{ all -> 0x0204 }
            r0 = r18
            r1 = r20
            r0.zze(r1)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "_iap"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x00a1
            java.lang.String r2 = "ecommerce_purchase"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x0163
        L_0x00a1:
            java.lang.String r2 = "currency"
            java.lang.String r5 = r14.getString(r2)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "ecommerce_purchase"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x01f4
            java.lang.String r2 = "value"
            double r2 = r14.getDouble(r2)     // Catch:{ all -> 0x0204 }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 * r6
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x00d2
            java.lang.String r2 = "value"
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0204 }
            double r2 = (double) r2     // Catch:{ all -> 0x0204 }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 * r6
        L_0x00d2:
            r6 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x01d3
            r6 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x01d3
            long r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x0204 }
            r8 = r2
        L_0x00e3:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x0163
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "[A-Z]{3}"
            boolean r3 = r2.matches(r3)     // Catch:{ all -> 0x0204 }
            if (r3 == 0) goto L_0x0163
            java.lang.String r3 = "_ltv_"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0204 }
            int r5 = r2.length()     // Catch:{ all -> 0x0204 }
            if (r5 == 0) goto L_0x01fd
            java.lang.String r5 = r3.concat(r2)     // Catch:{ all -> 0x0204 }
        L_0x010b:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzak r2 = r2.zzQ(r4, r5)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x011b
            java.lang.Object r3 = r2.zzRF     // Catch:{ all -> 0x0204 }
            boolean r3 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0204 }
            if (r3 != 0) goto L_0x020d
        L_0x011b:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzFo()     // Catch:{ all -> 0x0204 }
            int r3 = r3.zzfe(r4)     // Catch:{ all -> 0x0204 }
            int r3 = r3 + -1
            r2.zzy(r4, r3)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzak r3 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0204 }
            com.google.android.gms.common.util.zze r2 = r18.zzlQ()     // Catch:{ all -> 0x0204 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x0204 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0204 }
            r3.<init>(r4, r5, r6, r8)     // Catch:{ all -> 0x0204 }
        L_0x013d:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzak) r3)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x0163
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x0204 }
            java.lang.String r5 = "Too many unique user properties are set. Ignoring user property."
            java.lang.String r6 = r3.mName     // Catch:{ all -> 0x0204 }
            java.lang.Object r3 = r3.zzRF     // Catch:{ all -> 0x0204 }
            r2.zze(r5, r6, r3)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzFi()     // Catch:{ all -> 0x0204 }
            r3 = 9
            r5 = 0
            r6 = 0
            r2.zze(r3, r5, r6)     // Catch:{ all -> 0x0204 }
        L_0x0163:
            r0 = r19
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r9 = com.google.android.gms.measurement.internal.zzal.zzfG(r2)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzal.zzK(r14)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "_err"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r11 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r5 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            long r6 = r18.zzGi()     // Catch:{ all -> 0x0204 }
            r10 = 0
            r8 = r4
            com.google.android.gms.measurement.internal.zze$zza r2 = r5.zza(r6, r8, r9, r10, r11)     // Catch:{ all -> 0x0204 }
            long r6 = r2.zzbbY     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzFo()     // Catch:{ all -> 0x0204 }
            long r12 = r3.zzEE()     // Catch:{ all -> 0x0204 }
            long r6 = r6 - r12
            r12 = 0
            int r3 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0229
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r6 % r4
            r6 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x01b4
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFE()     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "Data loss. Too many events logged. count"
            long r6 = r2.zzbbY     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0204 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0204 }
        L_0x01b4:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzFi()     // Catch:{ all -> 0x0204 }
            r3 = 16
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0204 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.endTransaction()
            goto L_0x001b
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzp r4 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzFG()     // Catch:{ all -> 0x0204 }
            java.lang.String r5 = "Data lost. Currency value is too big"
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0204 }
            r4.zzj(r5, r2)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.endTransaction()
            goto L_0x001b
        L_0x01f4:
            java.lang.String r2 = "value"
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0204 }
            r8 = r2
            goto L_0x00e3
        L_0x01fd:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0204 }
            r5.<init>(r3)     // Catch:{ all -> 0x0204 }
            goto L_0x010b
        L_0x0204:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zze r3 = r18.zzFh()
            r3.endTransaction()
            throw r2
        L_0x020d:
            java.lang.Object r2 = r2.zzRF     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0204 }
            long r10 = r2.longValue()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzak r3 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0204 }
            com.google.android.gms.common.util.zze r2 = r18.zzlQ()     // Catch:{ all -> 0x0204 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x0204 }
            long r8 = r8 + r10
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0204 }
            r3.<init>(r4, r5, r6, r8)     // Catch:{ all -> 0x0204 }
            goto L_0x013d
        L_0x0229:
            if (r9 == 0) goto L_0x0278
            long r6 = r2.zzbbX     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzFo()     // Catch:{ all -> 0x0204 }
            long r8 = r3.zzEF()     // Catch:{ all -> 0x0204 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x0278
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r6 % r4
            r6 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0259
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFE()     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "Data loss. Too many public events logged. count"
            long r6 = r2.zzbbX     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0204 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0204 }
        L_0x0259:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzFi()     // Catch:{ all -> 0x0204 }
            r3 = 16
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0204 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.endTransaction()
            goto L_0x001b
        L_0x0278:
            if (r11 == 0) goto L_0x02b4
            long r6 = r2.zzbca     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzFo()     // Catch:{ all -> 0x0204 }
            long r8 = r3.zzEG()     // Catch:{ all -> 0x0204 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x02b4
            r4 = 1
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x02a4
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFE()     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "Too many error events logged. count"
            long r6 = r2.zzbca     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0204 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0204 }
        L_0x02a4:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.endTransaction()
            goto L_0x001b
        L_0x02b4:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzFi()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "_o"
            r0 = r19
            java.lang.String r5 = r0.zzbcr     // Catch:{ all -> 0x0204 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            long r2 = r2.zzfl(r4)     // Catch:{ all -> 0x0204 }
            r6 = 0
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x02e0
            com.google.android.gms.measurement.internal.zzp r5 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r5 = r5.zzFG()     // Catch:{ all -> 0x0204 }
            java.lang.String r6 = "Data lost. Too many events stored on disk, deleted"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0204 }
            r5.zzj(r6, r2)     // Catch:{ all -> 0x0204 }
        L_0x02e0:
            com.google.android.gms.measurement.internal.zzh r5 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0204 }
            r0 = r19
            java.lang.String r7 = r0.zzbcr     // Catch:{ all -> 0x0204 }
            r0 = r19
            java.lang.String r9 = r0.name     // Catch:{ all -> 0x0204 }
            r0 = r19
            long r10 = r0.zzbcs     // Catch:{ all -> 0x0204 }
            r12 = 0
            r6 = r18
            r8 = r4
            r5.<init>((com.google.android.gms.measurement.internal.zzx) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (long) r10, (long) r12, (android.os.Bundle) r14)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r5.mName     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzi r2 = r2.zzO(r4, r3)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x03ac
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            long r2 = r2.zzfr(r4)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r6 = r18.zzFo()     // Catch:{ all -> 0x0204 }
            int r6 = r6.zzED()     // Catch:{ all -> 0x0204 }
            long r6 = (long) r6     // Catch:{ all -> 0x0204 }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0346
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "Too many event names used, ignoring event. name, supported count"
            java.lang.String r4 = r5.mName     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r5 = r18.zzFo()     // Catch:{ all -> 0x0204 }
            int r5 = r5.zzED()     // Catch:{ all -> 0x0204 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0204 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzFi()     // Catch:{ all -> 0x0204 }
            r3 = 8
            r4 = 0
            r5 = 0
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.endTransaction()
            goto L_0x001b
        L_0x0346:
            com.google.android.gms.measurement.internal.zzi r7 = new com.google.android.gms.measurement.internal.zzi     // Catch:{ all -> 0x0204 }
            java.lang.String r9 = r5.mName     // Catch:{ all -> 0x0204 }
            r10 = 0
            r12 = 0
            long r14 = r5.zzajg     // Catch:{ all -> 0x0204 }
            r8 = r4
            r7.<init>(r8, r9, r10, r12, r14)     // Catch:{ all -> 0x0204 }
        L_0x0354:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            r2.zza((com.google.android.gms.measurement.internal.zzi) r7)     // Catch:{ all -> 0x0204 }
            r0 = r18
            r1 = r20
            r0.zza((com.google.android.gms.measurement.internal.zzh) r5, (com.google.android.gms.measurement.internal.AppMetadata) r1)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()     // Catch:{ all -> 0x0204 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            r3 = 2
            boolean r2 = r2.zzX(r3)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFL()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "Event recorded"
            r2.zzj(r3, r5)     // Catch:{ all -> 0x0204 }
        L_0x0381:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzFh()
            r2.endTransaction()
            r18.zzGn()
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzFm()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFL()
            java.lang.String r3 = "Background event processing time, ms"
            long r4 = java.lang.System.nanoTime()
            long r4 = r4 - r16
            r6 = 500000(0x7a120, double:2.47033E-318)
            long r4 = r4 + r6
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.zzj(r3, r4)
            goto L_0x001b
        L_0x03ac:
            long r6 = r2.zzbcm     // Catch:{ all -> 0x0204 }
            r0 = r18
            com.google.android.gms.measurement.internal.zzh r5 = r5.zza((com.google.android.gms.measurement.internal.zzx) r0, (long) r6)     // Catch:{ all -> 0x0204 }
            long r6 = r5.zzajg     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzi r7 = r2.zzag(r6)     // Catch:{ all -> 0x0204 }
            goto L_0x0354
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzb(com.google.android.gms.measurement.internal.EventParcel, com.google.android.gms.measurement.internal.AppMetadata):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(EventParcel eventParcel, String str) {
        zza zzfk = zzFh().zzfk(str);
        if (zzfk == null || TextUtils.isEmpty(zzfk.zzkV())) {
            zzFm().zzFK().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (zzfk.zzkV() != null && !zzfk.zzkV().equals(str2)) {
                zzFm().zzFG().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.name)) {
                zzFm().zzFG().zzj("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        zzb(eventParcel2, new AppMetadata(str, zzfk.zzEb(), zzfk.zzkV(), zzfk.zzEg(), zzfk.zzEh(), zzfk.zzEi(), zzfk.zzEj(), (String) null, zzfk.zzEk(), false, zzfk.zzEd()));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzkN();
        zzma();
        if (!TextUtils.isEmpty(appMetadata.zzbbK)) {
            if (!appMetadata.zzbbP) {
                zze(appMetadata);
                return;
            }
            int zzfK = zzFi().zzfK(userAttributeParcel.name);
            if (zzfK != 0) {
                zzFi().zze(zzfK, "_ev", zzFi().zza(userAttributeParcel.name, zzFo().zzEx(), true));
                return;
            }
            int zzm = zzFi().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzm != 0) {
                zzFi().zze(zzm, "_ev", zzFi().zza(userAttributeParcel.name, zzFo().zzEx(), true));
                return;
            }
            Object zzn = zzFi().zzn(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzn != null) {
                zzak zzak = new zzak(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.zzbgc, zzn);
                zzFm().zzFK().zze("Setting user property", zzak.mName, zzn);
                zzFh().beginTransaction();
                try {
                    zze(appMetadata);
                    boolean zza2 = zzFh().zza(zzak);
                    zzFh().setTransactionSuccessful();
                    if (zza2) {
                        zzFm().zzFK().zze("User property set", zzak.mName, zzak.zzRF);
                    } else {
                        zzFm().zzFE().zze("Too many unique user properties are set. Ignoring user property.", zzak.mName, zzak.zzRF);
                        zzFi().zze(9, (String) null, (String) null);
                    }
                } finally {
                    zzFh().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzaa zzaa) {
        this.zzbeV++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = false;
        zzkN();
        zzma();
        zzaa.zzdl(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzFh().beginTransaction();
        try {
            zza zzfk = zzFh().zzfk(str);
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzfk == null) {
                zzFm().zzFG().zzj("App does not exist in onConfigFetched", str);
            } else if (z2 || i == 404) {
                List list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (zzFj().zzfy(str) == null && !zzFj().zzb(str, (byte[]) null, (String) null)) {
                        zzFh().endTransaction();
                        return;
                    }
                } else if (!zzFj().zzb(str, bArr, str2)) {
                    zzFh().endTransaction();
                    return;
                }
                zzfk.zzX(zzlQ().currentTimeMillis());
                zzFh().zza(zzfk);
                if (i == 404) {
                    zzFm().zzFG().log("Config not found. Using empty config");
                } else {
                    zzFm().zzFL().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (!zzGb().zzod() || !zzGm()) {
                    zzGn();
                } else {
                    zzGl();
                }
            } else {
                zzfk.zzY(zzlQ().currentTimeMillis());
                zzFh().zza(zzfk);
                zzFm().zzFL().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzFj().zzfA(str);
                zzFn().zzbdH.set(zzlQ().currentTimeMillis());
                if (i == 503 || i == 429) {
                    z = true;
                }
                if (z) {
                    zzFn().zzbdI.set(zzlQ().currentTimeMillis());
                }
                zzGn();
            }
            zzFh().setTransactionSuccessful();
        } finally {
            zzFh().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzc(AppMetadata appMetadata) {
        zzkN();
        zzma();
        zzaa.zzdl(appMetadata.packageName);
        zze(appMetadata);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzc(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        zzb(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzc(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzkN();
        zzma();
        if (!TextUtils.isEmpty(appMetadata.zzbbK)) {
            if (!appMetadata.zzbbP) {
                zze(appMetadata);
                return;
            }
            zzFm().zzFK().zzj("Removing user property", userAttributeParcel.name);
            zzFh().beginTransaction();
            try {
                zze(appMetadata);
                zzFh().zzP(appMetadata.packageName, userAttributeParcel.name);
                zzFh().setTransactionSuccessful();
                zzFm().zzFK().zzj("User property removed", userAttributeParcel.name);
            } finally {
                zzFh().endTransaction();
            }
        }
    }

    @WorkerThread
    public void zzd(AppMetadata appMetadata) {
        zzkN();
        zzma();
        zzaa.zzz(appMetadata);
        zzaa.zzdl(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.zzbbK)) {
            if (!appMetadata.zzbbP) {
                zze(appMetadata);
                return;
            }
            long currentTimeMillis = zzlQ().currentTimeMillis();
            zzFh().beginTransaction();
            try {
                zza(appMetadata, currentTimeMillis);
                zze(appMetadata);
                if (zzFh().zzO(appMetadata.packageName, "_f") == null) {
                    zzb(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf((1 + (currentTimeMillis / 3600000)) * 3600000), "auto"), appMetadata);
                    zzb(appMetadata, currentTimeMillis);
                    zzc(appMetadata, currentTimeMillis);
                } else if (appMetadata.zzbbQ) {
                    zzd(appMetadata, currentTimeMillis);
                }
                zzFh().setTransactionSuccessful();
            } finally {
                zzFh().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzd(AppMetadata appMetadata, long j) {
        zzb(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    @WorkerThread
    public void zzkN() {
        zzFl().zzkN();
    }

    /* access modifiers changed from: package-private */
    public void zzlP() {
        if (zzFo().zzmW()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public com.google.android.gms.common.util.zze zzlQ() {
        return this.zzsd;
    }

    /* access modifiers changed from: package-private */
    public void zzma() {
        if (!this.zzWh) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzv(int i, int i2) {
        zzkN();
        if (i > i2) {
            zzFm().zzFE().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (zza(i2, zzGe())) {
                zzFm().zzFL().zze("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zzFm().zzFE().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }
}
