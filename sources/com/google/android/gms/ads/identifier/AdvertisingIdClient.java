package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzbu;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzpE;
    zzbu zzpF;
    boolean zzpG;
    Object zzpH;
    zza zzpI;
    final long zzpJ;

    public static final class Info {
        private final String zzpO;
        private final boolean zzpP;

        public Info(String str, boolean z) {
            this.zzpO = str;
            this.zzpP = z;
        }

        public String getId() {
            return this.zzpO;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzpP;
        }

        public String toString() {
            String str = this.zzpO;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzpP).toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzpK;
        private long zzpL;
        CountDownLatch zzpM = new CountDownLatch(1);
        boolean zzpN = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzpK = new WeakReference<>(advertisingIdClient);
            this.zzpL = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzpK.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzpN = true;
            }
        }

        public void cancel() {
            this.zzpM.countDown();
        }

        public void run() {
            try {
                if (!this.zzpM.await(this.zzpL, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzbe() {
            return this.zzpN;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzpH = new Object();
        zzaa.zzz(context);
        this.mContext = context;
        this.zzpG = false;
        this.zzpJ = j;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzd(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static zzbu zza(Context context, com.google.android.gms.common.zza zza2) throws IOException {
        try {
            return zzbu.zza.zzf(zza2.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private void zzbd() {
        synchronized (this.zzpH) {
            if (this.zzpI != null) {
                this.zzpI.cancel();
                try {
                    this.zzpI.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzpJ > 0) {
                this.zzpI = new zza(this, this.zzpJ);
            }
        }
    }

    static com.google.android.gms.common.zza zzh(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzc.zzqV().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    com.google.android.gms.common.zza zza2 = new com.google.android.gms.common.zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzuH().zza(context, intent, (ServiceConnection) zza2, 1)) {
                            return zza2;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.zzaa.zzdd(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.common.zza r0 = r3.zzpE     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r3.zzpG     // Catch:{ IllegalArgumentException -> 0x002d }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzuH()     // Catch:{ IllegalArgumentException -> 0x002d }
            android.content.Context r1 = r3.mContext     // Catch:{ IllegalArgumentException -> 0x002d }
            com.google.android.gms.common.zza r2 = r3.zzpE     // Catch:{ IllegalArgumentException -> 0x002d }
            r0.zza((android.content.Context) r1, (android.content.ServiceConnection) r2)     // Catch:{ IllegalArgumentException -> 0x002d }
        L_0x001f:
            r0 = 0
            r3.zzpG = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzpF = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzpE = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            goto L_0x000f
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x002a }
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzaa.zzdd("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzpG) {
                synchronized (this.zzpH) {
                    if (this.zzpI == null || !this.zzpI.zzbe()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzd(false);
                    if (!this.zzpG) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzaa.zzz(this.zzpE);
            zzaa.zzz(this.zzpF);
            info = new Info(this.zzpF.getId(), this.zzpF.zze(true));
        }
        zzbd();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzd(true);
    }

    /* access modifiers changed from: protected */
    public void zzd(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzaa.zzdd("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzpG) {
                finish();
            }
            this.zzpE = zzh(this.mContext);
            this.zzpF = zza(this.mContext, this.zzpE);
            this.zzpG = true;
            if (z) {
                zzbd();
            }
        }
    }
}
