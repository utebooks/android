package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzom;
import com.google.android.gms.measurement.internal.zzl;

public class zzd extends zzz {
    static final String zzbbT = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean zzXt;

    zzd(zzx zzx) {
        super(zzx);
    }

    @Nullable
    private Boolean zzff(@Size(min = 1) String str) {
        zzaa.zzdl(str);
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager == null) {
                zzFm().zzFE().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzFm().zzFE().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzFm().zzFE().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (applicationInfo.metaData.containsKey(str)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzFm().zzFE().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    public int zzEA() {
        return 256;
    }

    public int zzEB() {
        return 36;
    }

    public int zzEC() {
        return 2048;
    }

    /* access modifiers changed from: package-private */
    public int zzED() {
        return 500;
    }

    public long zzEE() {
        return (long) zzl.zzbcF.get().intValue();
    }

    public long zzEF() {
        return (long) zzl.zzbcG.get().intValue();
    }

    public long zzEG() {
        return 1000;
    }

    /* access modifiers changed from: package-private */
    public int zzEH() {
        return 25;
    }

    /* access modifiers changed from: package-private */
    public int zzEI() {
        return 50;
    }

    /* access modifiers changed from: package-private */
    public long zzEJ() {
        return 3600000;
    }

    /* access modifiers changed from: package-private */
    public long zzEK() {
        return 60000;
    }

    /* access modifiers changed from: package-private */
    public long zzEL() {
        return 61000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = zzff("firebase_analytics_collection_deactivated");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzEM() {
        /*
            r2 = this;
            r0 = 0
            boolean r1 = r2.zzmW()
            if (r1 == 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.lang.String r1 = "firebase_analytics_collection_deactivated"
            java.lang.Boolean r1 = r2.zzff(r1)
            if (r1 == 0) goto L_0x0007
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0007
            r0 = 1
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzd.zzEM():boolean");
    }

    public Boolean zzEN() {
        if (zzmW()) {
            return null;
        }
        return zzff("firebase_analytics_collection_enabled");
    }

    public long zzEO() {
        return zzl.zzbcR.get().longValue();
    }

    public long zzEP() {
        return zzl.zzbcN.get().longValue();
    }

    public long zzEQ() {
        return 1000;
    }

    public int zzER() {
        return Math.max(0, zzl.zzbcD.get().intValue());
    }

    public int zzES() {
        return Math.max(1, zzl.zzbcE.get().intValue());
    }

    public String zzET() {
        return zzl.zzbcJ.get();
    }

    public long zzEU() {
        return zzl.zzbcy.get().longValue();
    }

    public long zzEV() {
        return Math.max(0, zzl.zzbcK.get().longValue());
    }

    public long zzEW() {
        return Math.max(0, zzl.zzbcM.get().longValue());
    }

    public long zzEX() {
        return zzl.zzbcL.get().longValue();
    }

    public long zzEY() {
        return Math.max(0, zzl.zzbcO.get().longValue());
    }

    public long zzEZ() {
        return Math.max(0, zzl.zzbcP.get().longValue());
    }

    public long zzEi() {
        return 9080;
    }

    /* access modifiers changed from: package-private */
    public String zzEu() {
        return zzl.zzbcv.get();
    }

    public int zzEv() {
        return 25;
    }

    public int zzEw() {
        return 32;
    }

    public int zzEx() {
        return 24;
    }

    /* access modifiers changed from: package-private */
    public int zzEy() {
        return 24;
    }

    /* access modifiers changed from: package-private */
    public int zzEz() {
        return 36;
    }

    public int zzFa() {
        return Math.min(20, Math.max(0, zzl.zzbcQ.get().intValue()));
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

    public String zzN(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzl.zzbcz.get()).encodedAuthority(zzl.zzbcA.get());
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzEi()));
        return builder.build().toString();
    }

    public long zza(String str, zzl.zza<Long> zza) {
        if (str == null) {
            return zza.get().longValue();
        }
        String zzU = zzFj().zzU(str, zza.getKey());
        if (TextUtils.isEmpty(zzU)) {
            return zza.get().longValue();
        }
        try {
            return zza.get(Long.valueOf(Long.valueOf(zzU).longValue())).longValue();
        } catch (NumberFormatException e) {
            return zza.get().longValue();
        }
    }

    public int zzb(String str, zzl.zza<Integer> zza) {
        if (str == null) {
            return zza.get().intValue();
        }
        String zzU = zzFj().zzU(str, zza.getKey());
        if (TextUtils.isEmpty(zzU)) {
            return zza.get().intValue();
        }
        try {
            return zza.get(Integer.valueOf(Integer.valueOf(zzU).intValue())).intValue();
        } catch (NumberFormatException e) {
            return zza.get().intValue();
        }
    }

    public int zzfc(@Size(min = 1) String str) {
        return zzb(str, zzl.zzbcH);
    }

    /* access modifiers changed from: package-private */
    public long zzfd(String str) {
        return zza(str, zzl.zzbcw);
    }

    /* access modifiers changed from: package-private */
    public int zzfe(String str) {
        return zzb(str, zzl.zzbcS);
    }

    public int zzfg(String str) {
        return zzb(str, zzl.zzbcB);
    }

    public int zzfh(String str) {
        return Math.max(0, zzb(str, zzl.zzbcC));
    }

    public int zzfi(String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.zzbcI)));
    }

    public /* bridge */ /* synthetic */ void zzkN() {
        super.zzkN();
    }

    public /* bridge */ /* synthetic */ void zzlP() {
        super.zzlP();
    }

    public /* bridge */ /* synthetic */ zze zzlQ() {
        return super.zzlQ();
    }

    public boolean zzmW() {
        return false;
    }

    public boolean zzmX() {
        if (this.zzXt == null) {
            synchronized (this) {
                if (this.zzXt == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzvj = zzt.zzvj();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzXt = Boolean.valueOf(str != null && str.equals(zzvj));
                    }
                    if (this.zzXt == null) {
                        this.zzXt = Boolean.TRUE;
                        zzFm().zzFE().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzXt.booleanValue();
    }

    public long zznC() {
        return Math.max(0, zzl.zzbcx.get().longValue());
    }

    /* access modifiers changed from: package-private */
    public long zznr() {
        return zzl.zzbcT.get().longValue();
    }

    public String zznw() {
        return "google_app_measurement.db";
    }

    public String zznx() {
        return "google_app_measurement2.db";
    }

    public boolean zzsB() {
        return zzom.zzsB();
    }
}
