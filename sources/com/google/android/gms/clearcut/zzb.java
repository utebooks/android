package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzamo;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzb {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", zzaaA, zzaaz);
    public static final Api.zza<zznm, Api.ApiOptions.NoOptions> zzaaA = new Api.zza<zznm, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzd */
        public zznm zza(Context context, Looper looper, zzg zzg, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznm(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api.zzf<zznm> zzaaz = new Api.zzf<>();
    public static final zzc zzajv = new zznl();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzZC;
    /* access modifiers changed from: private */
    public String zzajA;
    /* access modifiers changed from: private */
    public final boolean zzajB;
    private int zzajC;
    /* access modifiers changed from: private */
    public final zzc zzajD;
    /* access modifiers changed from: private */
    public final zza zzajE;
    /* access modifiers changed from: private */
    public zzc zzajF;
    /* access modifiers changed from: private */
    public final int zzajw;
    /* access modifiers changed from: private */
    public String zzajx;
    /* access modifiers changed from: private */
    public int zzajy;
    /* access modifiers changed from: private */
    public String zzajz;
    /* access modifiers changed from: private */
    public final zze zzsd;

    public class zza {
        private String zzajA;
        private int zzajC;
        private final C0751zzb zzajG;
        private ArrayList<Integer> zzajH;
        private final zzamo.zzd zzajI;
        private boolean zzajJ;
        private String zzajx;
        private int zzajy;
        private String zzajz;

        private zza(zzb zzb, byte[] bArr) {
            this(bArr, (C0751zzb) null);
        }

        private zza(byte[] bArr, C0751zzb zzb) {
            this.zzajy = zzb.this.zzajy;
            this.zzajx = zzb.this.zzajx;
            this.zzajz = zzb.this.zzajz;
            this.zzajA = zzb.this.zzajA;
            this.zzajC = zzb.zze(zzb.this);
            this.zzajH = null;
            this.zzajI = new zzamo.zzd();
            this.zzajJ = false;
            this.zzajz = zzb.this.zzajz;
            this.zzajA = zzb.this.zzajA;
            this.zzajI.zzcaG = zzb.this.zzsd.currentTimeMillis();
            this.zzajI.zzcaH = zzb.this.zzsd.elapsedRealtime();
            this.zzajI.zzcaW = (long) zzb.this.zzajE.zzac(zzb.this.mContext);
            this.zzajI.zzcaR = zzb.this.zzajF.zzE(this.zzajI.zzcaG);
            if (bArr != null) {
                this.zzajI.zzcaM = bArr;
            }
            this.zzajG = zzb;
        }

        public zza zzbx(int i) {
            this.zzajI.zzcaJ = i;
            return this;
        }

        public zza zzby(int i) {
            this.zzajI.zzoZ = i;
            return this;
        }

        public PendingResult<Status> zzd(GoogleApiClient googleApiClient) {
            if (this.zzajJ) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzajJ = true;
            return zzb.this.zzajD.zza(googleApiClient, zzqO());
        }

        public LogEventParcelable zzqO() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.zzZC, zzb.this.zzajw, this.zzajy, this.zzajx, this.zzajz, this.zzajA, zzb.this.zzajB, this.zzajC), this.zzajI, this.zzajG, (C0751zzb) null, zzb.zzb((ArrayList<Integer>) null));
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb  reason: collision with other inner class name */
    public interface C0751zzb {
        byte[] zzqP();
    }

    public static class zzc {
        public long zzE(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zze zze, zzc zzc3, zza zza2) {
        this.zzajy = -1;
        this.zzajC = 0;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext == null ? context : applicationContext;
        this.zzZC = context.getPackageName();
        this.zzajw = zzad(context);
        this.zzajy = i;
        this.zzajx = str;
        this.zzajz = str2;
        this.zzajA = str3;
        this.zzajB = z;
        this.zzajD = zzc2;
        this.zzsd = zze;
        this.zzajF = zzc3 == null ? new zzc() : zzc3;
        this.zzajE = zza2;
        this.zzajC = 0;
        if (this.zzajB) {
            zzaa.zzb(this.zzajz == null, (Object) "can't be anonymous with an upload account");
        }
    }

    public zzb(Context context, String str, String str2) {
        this(context, -1, str, str2, (String) null, false, zzajv, zzh.zzuW(), (zzc) null, zza.zzaju);
    }

    private int zzad(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator<Integer> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            i = i2 + 1;
            iArr[i2] = it.next().intValue();
        }
    }

    static /* synthetic */ int zze(zzb zzb) {
        return 0;
    }

    public zza zzj(byte[] bArr) {
        return new zza(bArr);
    }
}
