package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzacu;
import com.google.android.gms.internal.zzacv;

public class zzacp extends zzk<zzacu> implements zzaco {
    private static zzps zzbFv = new zzps("FirebaseAuth", "FirebaseAuth:");
    private final Context mContext;
    private final zzacv.zza zzbFw;

    public zzacp(Context context, Looper looper, zzg zzg, zzacv.zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, zzg, connectionCallbacks, onConnectionFailedListener);
        this.mContext = (Context) zzaa.zzz(context);
        this.zzbFw = zza;
    }

    public /* synthetic */ zzacu zzOs() throws DeadObjectException {
        return (zzacu) super.zztm();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzeG */
    public zzacu zzab(IBinder iBinder) {
        return zzacu.zza.zzeI(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzhU() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzoO() {
        Bundle zzoO = super.zzoO();
        if (zzoO == null) {
            zzoO = new Bundle();
        }
        if (this.zzbFw != null) {
            zzoO.putString("com.google.firebase.auth.API_KEY", this.zzbFw.getApiKey());
        }
        return zzoO;
    }

    public boolean zzrg() {
        return zzqi.zzo(this.mContext, "com.google.firebase.auth") == 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zztf() {
        /*
            r4 = this;
            r2 = -1
            r1 = 0
            java.lang.String r0 = "firebear.preference"
            java.lang.String r0 = com.google.android.gms.internal.zzadb.getProperty(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0010
            java.lang.String r0 = "default"
        L_0x0010:
            int r3 = r0.hashCode()
            switch(r3) {
                case 103145323: goto L_0x004f;
                case 1544803905: goto L_0x0059;
                default: goto L_0x0017;
            }
        L_0x0017:
            r3 = r2
        L_0x0018:
            switch(r3) {
                case 0: goto L_0x001d;
                case 1: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            java.lang.String r0 = "default"
        L_0x001d:
            int r3 = r0.hashCode()
            switch(r3) {
                case 103145323: goto L_0x0063;
                default: goto L_0x0024;
            }
        L_0x0024:
            r0 = r2
        L_0x0025:
            switch(r0) {
                case 0: goto L_0x006d;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.google.android.gms.internal.zzps r0 = zzbFv
            java.lang.String r2 = "Loading module via default loading order."
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r0.zza(r2, r3)
            android.content.Context r0 = r4.mContext
            java.lang.String r2 = "com.google.firebase.auth"
            int r0 = com.google.android.gms.internal.zzqi.zzo(r0, r2)
            android.content.Context r2 = r4.mContext
            java.lang.String r3 = "com.google.android.gms.firebase_auth"
            int r2 = com.google.android.gms.internal.zzqi.zzp(r2, r3)
            if (r2 < r0) goto L_0x007d
            com.google.android.gms.internal.zzps r0 = zzbFv
            java.lang.String r2 = "Loading remote module."
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.zza(r2, r1)
            java.lang.String r0 = "com.google.android.gms"
        L_0x004e:
            return r0
        L_0x004f:
            java.lang.String r3 = "local"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0017
            r3 = r1
            goto L_0x0018
        L_0x0059:
            java.lang.String r3 = "default"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0017
            r3 = 1
            goto L_0x0018
        L_0x0063:
            java.lang.String r3 = "local"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0024
            r0 = r1
            goto L_0x0025
        L_0x006d:
            com.google.android.gms.internal.zzps r0 = zzbFv
            java.lang.String r2 = "Loading fallback module override."
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.zza(r2, r1)
            android.content.Context r0 = r4.mContext
            java.lang.String r0 = r0.getPackageName()
            goto L_0x004e
        L_0x007d:
            com.google.android.gms.internal.zzps r0 = zzbFv
            java.lang.String r2 = "Loading fallback module."
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.zza(r2, r1)
            android.content.Context r0 = r4.mContext
            java.lang.String r0 = r0.getPackageName()
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacp.zztf():java.lang.String");
    }
}
