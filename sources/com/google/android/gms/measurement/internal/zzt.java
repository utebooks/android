package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.zzaa;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class zzt extends zzaa {
    static final Pair<String, Long> zzbdE = new Pair<>("", 0L);
    /* access modifiers changed from: private */
    public SharedPreferences zzYX;
    public final zzc zzbdF = new zzc("health_monitor", zzFo().zznC());
    public final zzb zzbdG = new zzb("last_upload", 0);
    public final zzb zzbdH = new zzb("last_upload_attempt", 0);
    public final zzb zzbdI = new zzb("backoff", 0);
    public final zzb zzbdJ = new zzb("last_delete_stale", 0);
    public final zzb zzbdK = new zzb("midnight_offset", 0);
    private String zzbdL;
    private boolean zzbdM;
    private long zzbdN;
    private SecureRandom zzbdO;
    public final zzb zzbdP = new zzb("time_before_start", 10000);
    public final zzb zzbdQ = new zzb("session_timeout", 1800000);
    public final zza zzbdR = new zza("start_new_session", true);
    public final zzb zzbdS = new zzb("last_pause_time", 0);
    public final zzb zzbdT = new zzb("time_active", 0);
    public boolean zzbdU;

    public final class zza {
        private boolean zzakR;
        private final boolean zzbdV;
        private boolean zzbdW;
        private final String zzwQ;

        public zza(String str, boolean z) {
            zzaa.zzdl(str);
            this.zzwQ = str;
            this.zzbdV = z;
        }

        @WorkerThread
        private void zzFV() {
            if (!this.zzbdW) {
                this.zzbdW = true;
                this.zzakR = zzt.this.zzYX.getBoolean(this.zzwQ, this.zzbdV);
            }
        }

        @WorkerThread
        public boolean get() {
            zzFV();
            return this.zzakR;
        }

        @WorkerThread
        public void set(boolean z) {
            SharedPreferences.Editor edit = zzt.this.zzYX.edit();
            edit.putBoolean(this.zzwQ, z);
            edit.apply();
            this.zzakR = z;
        }
    }

    public final class zzb {
        private long zzVv;
        private boolean zzbdW;
        private final long zzbdY;
        private final String zzwQ;

        public zzb(String str, long j) {
            zzaa.zzdl(str);
            this.zzwQ = str;
            this.zzbdY = j;
        }

        @WorkerThread
        private void zzFV() {
            if (!this.zzbdW) {
                this.zzbdW = true;
                this.zzVv = zzt.this.zzYX.getLong(this.zzwQ, this.zzbdY);
            }
        }

        @WorkerThread
        public long get() {
            zzFV();
            return this.zzVv;
        }

        @WorkerThread
        public void set(long j) {
            SharedPreferences.Editor edit = zzt.this.zzYX.edit();
            edit.putLong(this.zzwQ, j);
            edit.apply();
            this.zzVv = j;
        }
    }

    public final class zzc {
        private final long zzZb;
        final String zzbdZ;
        private final String zzbea;
        private final String zzbeb;

        private zzc(String str, long j) {
            zzaa.zzdl(str);
            zzaa.zzaj(j > 0);
            this.zzbdZ = String.valueOf(str).concat(":start");
            this.zzbea = String.valueOf(str).concat(":count");
            this.zzbeb = String.valueOf(str).concat(":value");
            this.zzZb = j;
        }

        @WorkerThread
        private void zzon() {
            zzt.this.zzkN();
            long currentTimeMillis = zzt.this.zzlQ().currentTimeMillis();
            SharedPreferences.Editor edit = zzt.this.zzYX.edit();
            edit.remove(this.zzbea);
            edit.remove(this.zzbeb);
            edit.putLong(this.zzbdZ, currentTimeMillis);
            edit.apply();
        }

        @WorkerThread
        private long zzoo() {
            zzt.this.zzkN();
            long zzoq = zzoq();
            if (zzoq != 0) {
                return Math.abs(zzoq - zzt.this.zzlQ().currentTimeMillis());
            }
            zzon();
            return 0;
        }

        @WorkerThread
        private long zzoq() {
            return zzt.this.zzFQ().getLong(this.zzbdZ, 0);
        }

        @WorkerThread
        public void zzbU(String str) {
            zzf(str, 1);
        }

        @WorkerThread
        public void zzf(String str, long j) {
            zzt.this.zzkN();
            if (zzoq() == 0) {
                zzon();
            }
            if (str == null) {
                str = "";
            }
            long j2 = zzt.this.zzYX.getLong(this.zzbea, 0);
            if (j2 <= 0) {
                SharedPreferences.Editor edit = zzt.this.zzYX.edit();
                edit.putString(this.zzbeb, str);
                edit.putLong(this.zzbea, j);
                edit.apply();
                return;
            }
            boolean z = (zzt.this.zzFN().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j;
            SharedPreferences.Editor edit2 = zzt.this.zzYX.edit();
            if (z) {
                edit2.putString(this.zzbeb, str);
            }
            edit2.putLong(this.zzbea, j2 + j);
            edit2.apply();
        }

        @WorkerThread
        public Pair<String, Long> zzop() {
            zzt.this.zzkN();
            long zzoo = zzoo();
            if (zzoo < this.zzZb) {
                return null;
            }
            if (zzoo > this.zzZb * 2) {
                zzon();
                return null;
            }
            String string = zzt.this.zzFQ().getString(this.zzbeb, (String) null);
            long j = zzt.this.zzFQ().getLong(this.zzbea, 0);
            zzon();
            return (string == null || j <= 0) ? zzt.zzbdE : new Pair<>(string, Long.valueOf(j));
        }
    }

    zzt(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public SecureRandom zzFN() {
        zzkN();
        if (this.zzbdO == null) {
            this.zzbdO = new SecureRandom();
        }
        return this.zzbdO;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public SharedPreferences zzFQ() {
        zzkN();
        zzma();
        return this.zzYX;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void setMeasurementEnabled(boolean z) {
        zzkN();
        zzFm().zzFL().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzFQ().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzEd() {
        zzkN();
        return com.google.firebase.iid.zzc.zzUl().getId();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzFO() {
        byte[] bArr = new byte[16];
        zzFN().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public long zzFP() {
        zzma();
        zzkN();
        long j = this.zzbdK.get();
        if (j != 0) {
            return j;
        }
        long nextInt = (long) (zzFN().nextInt(86400000) + 1);
        this.zzbdK.set(nextInt);
        return nextInt;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzFR() {
        zzkN();
        return zzFQ().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public Boolean zzFS() {
        zzkN();
        if (!zzFQ().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzFQ().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzFT() {
        boolean z = true;
        zzkN();
        zzFm().zzFL().log("Clearing collection preferences.");
        boolean contains = zzFQ().contains("measurement_enabled");
        if (contains) {
            z = zzax(true);
        }
        SharedPreferences.Editor edit = zzFQ().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public String zzFU() {
        zzkN();
        String string = zzFQ().getString("previous_os_version", (String) null);
        String zzFx = zzFf().zzFx();
        if (!TextUtils.isEmpty(zzFx) && !zzFx.equals(string)) {
            SharedPreferences.Editor edit = zzFQ().edit();
            edit.putString("previous_os_version", zzFx);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzaw(boolean z) {
        zzkN();
        zzFm().zzFL().zzj("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzFQ().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzax(boolean z) {
        zzkN();
        return zzFQ().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public Pair<String, Boolean> zzfu(String str) {
        zzkN();
        long elapsedRealtime = zzlQ().elapsedRealtime();
        if (this.zzbdL != null && elapsedRealtime < this.zzbdN) {
            return new Pair<>(this.zzbdL, Boolean.valueOf(this.zzbdM));
        }
        this.zzbdN = elapsedRealtime + zzFo().zzfd(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.zzbdL = advertisingIdInfo.getId();
            if (this.zzbdL == null) {
                this.zzbdL = "";
            }
            this.zzbdM = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzFm().zzFK().zzj("Unable to get advertising id", th);
            this.zzbdL = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzbdL, Boolean.valueOf(this.zzbdM));
    }

    /* access modifiers changed from: package-private */
    public String zzfv(String str) {
        String str2 = (String) zzfu(str).first;
        MessageDigest zzbZ = zzal.zzbZ("MD5");
        if (zzbZ == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzbZ.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzfw(String str) {
        zzkN();
        SharedPreferences.Editor edit = zzFQ().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public void zzkO() {
        this.zzYX = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzbdU = this.zzYX.getBoolean("has_been_opened", false);
        if (!this.zzbdU) {
            SharedPreferences.Editor edit = this.zzYX.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }
}
