package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.firebase.FirebaseApp;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver zzbSI;
    private static final Object zzbSJ = new Object();
    private static boolean zzbSK = false;
    /* access modifiers changed from: private */
    public boolean zzbSL = false;

    private String zzC(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r3.zzUp().zzUu() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        zzby(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r3.zzUn() == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
            java.lang.Object r1 = zzbSJ
            monitor-enter(r1)
            boolean r0 = zzbSK     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
        L_0x0008:
            return
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r3.zzUn()
            if (r0 == 0) goto L_0x001a
            com.google.firebase.iid.zze r0 = r3.zzUp()
            java.lang.String r0 = r0.zzUu()
            if (r0 == 0) goto L_0x0008
        L_0x001a:
            zzby(r2)
            goto L_0x0008
        L_0x001e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zza(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087 A[Catch:{ IOException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a3 A[SYNTHETIC, Splitter:B:49:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x006a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(android.content.Intent r9, boolean r10) {
        /*
            r8 = this;
            r2 = 1
            r1 = 0
            java.lang.Object r3 = zzbSJ
            monitor-enter(r3)
            r0 = 0
            zzbSK = r0     // Catch:{ all -> 0x002f }
            monitor-exit(r3)     // Catch:{ all -> 0x002f }
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()
            com.google.firebase.iid.zze r4 = r0.zzUp()
            java.lang.String r3 = r0.zzUn()
            if (r3 != 0) goto L_0x004a
            java.lang.String r1 = r0.zzUo()     // Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
            if (r1 == 0) goto L_0x0032
            boolean r1 = r8.zzbSL     // Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "get master token succeeded"
            android.util.Log.d(r1, r2)     // Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
        L_0x0028:
            zza((android.content.Context) r8, (com.google.firebase.iid.FirebaseInstanceId) r0)     // Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
            r8.onTokenRefresh()     // Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
        L_0x002e:
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002f }
            throw r0
        L_0x0032:
            java.lang.String r0 = "returned token is null"
            r8.zzd(r9, r0)     // Catch:{ IOException -> 0x0038, SecurityException -> 0x0041 }
            goto L_0x002e
        L_0x0038:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r8.zzd(r9, r0)
            goto L_0x002e
        L_0x0041:
            r0 = move-exception
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "Unable to get master token"
            android.util.Log.e(r1, r2, r0)
            goto L_0x002e
        L_0x004a:
            java.lang.String r0 = r4.zzUu()
            r3 = r0
        L_0x004f:
            if (r3 == 0) goto L_0x00b6
            java.lang.String r0 = "!"
            java.lang.String[] r0 = r3.split(r0)
            int r5 = r0.length
            r6 = 2
            if (r5 != r6) goto L_0x006a
            r5 = r0[r1]
            r6 = r0[r2]
            r0 = -1
            int r7 = r5.hashCode()     // Catch:{ IOException -> 0x009a }
            switch(r7) {
                case 83: goto L_0x0073;
                case 84: goto L_0x0067;
                case 85: goto L_0x007d;
                default: goto L_0x0067;
            }
        L_0x0067:
            switch(r0) {
                case 0: goto L_0x0087;
                case 1: goto L_0x00a3;
                default: goto L_0x006a;
            }
        L_0x006a:
            r4.zziC(r3)
            java.lang.String r0 = r4.zzUu()
            r3 = r0
            goto L_0x004f
        L_0x0073:
            java.lang.String r7 = "S"
            boolean r5 = r5.equals(r7)     // Catch:{ IOException -> 0x009a }
            if (r5 == 0) goto L_0x0067
            r0 = r1
            goto L_0x0067
        L_0x007d:
            java.lang.String r7 = "U"
            boolean r5 = r5.equals(r7)     // Catch:{ IOException -> 0x009a }
            if (r5 == 0) goto L_0x0067
            r0 = r2
            goto L_0x0067
        L_0x0087:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ IOException -> 0x009a }
            r0.zziz(r6)     // Catch:{ IOException -> 0x009a }
            boolean r0 = r8.zzbSL     // Catch:{ IOException -> 0x009a }
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r5 = "subscribe operation succeeded"
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x009a }
            goto L_0x006a
        L_0x009a:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r8.zzd(r9, r0)
            goto L_0x002e
        L_0x00a3:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ IOException -> 0x009a }
            r0.zziA(r6)     // Catch:{ IOException -> 0x009a }
            boolean r0 = r8.zzbSL     // Catch:{ IOException -> 0x009a }
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r5 = "unsubscribe operation succeeded"
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x009a }
            goto L_0x006a
        L_0x00b6:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zza(android.content.Intent, boolean):void");
    }

    private int zzb(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !z) {
            return 30;
        }
        if (intExtra < 10) {
            return 10;
        }
        if (intExtra > 28800) {
            return 28800;
        }
        return intExtra;
    }

    static void zzby(Context context) {
        synchronized (zzbSJ) {
            if (!zzbSK) {
                context.sendBroadcast(zznF(0));
                zzbSK = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzbz(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void zzd(Intent intent, String str) {
        boolean zzbz = zzbz(this);
        final int zzb = zzb(intent, zzbz);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(zzb).append("s").toString());
        synchronized (zzbSJ) {
            zznG(zzb);
            zzbSK = true;
        }
        if (!zzbz) {
            if (this.zzbSL) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (zzbSI == null) {
                zzbSI = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.zzbz(context)) {
                            if (FirebaseInstanceIdService.this.zzbSL) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            FirebaseInstanceIdService.this.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.zznF(zzb));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(zzbSI, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private zzd zziB(String str) {
        if (str == null) {
            return zzd.zzb(this, (Bundle) null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return zzd.zzb(this, bundle);
    }

    /* access modifiers changed from: private */
    public static Intent zznF(int i) {
        Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.zzh(applicationContext, intent);
    }

    private void zznG(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), PendingIntent.getBroadcast(this, 0, zznF(i * 2), 268435456));
    }

    @WorkerThread
    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    public int zzA(Intent intent) {
        this.zzbSL = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.zzA(intent);
        }
        String zzC = zzC(intent);
        if (this.zzbSL) {
            String valueOf = String.valueOf(zzC);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Register result in service ".concat(valueOf) : new String("Register result in service "));
        }
        zziB(zzC).zzUt().zzu(intent);
        zzBL();
        return 2;
    }

    public void zzB(Intent intent) {
        String zzC = zzC(intent);
        zzd zziB = zziB(zzC);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.zzbSL) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(zzC).length() + 18 + String.valueOf(stringExtra).length() + String.valueOf(valueOf).length()).append("Service command ").append(zzC).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            zzg zzUs = zziB.zzUs();
            if (zzC == null) {
                zzC = "";
            }
            zzUs.zzeG(zzC);
            zziB.zzUt().zzu(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            zziB.zzUs().zzeG(zzC);
            zza(intent, false);
        } else if ("RST".equals(stringExtra)) {
            zziB.zzCe();
            zza(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!zziB.zzUs().isEmpty()) {
                zziB.zzUs().zzCk();
                zza(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            zziB.zzUs().zzeG(zzC);
            zza(intent, false);
        } else {
            if ("PING".equals(stringExtra)) {
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzm(android.content.Intent r5) {
        /*
            r4 = this;
            r1 = 0
            java.lang.String r0 = r5.getAction()
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = ""
        L_0x0009:
            r2 = -1
            int r3 = r0.hashCode()
            switch(r3) {
                case -1737547627: goto L_0x0019;
                default: goto L_0x0011;
            }
        L_0x0011:
            r0 = r2
        L_0x0012:
            switch(r0) {
                case 0: goto L_0x0023;
                default: goto L_0x0015;
            }
        L_0x0015:
            r4.zzB(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r3 = "ACTION_TOKEN_REFRESH_RETRY"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0011
            r0 = r1
            goto L_0x0012
        L_0x0023:
            r4.zza((android.content.Intent) r5, (boolean) r1)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zzm(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public Intent zzz(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.zzUq();
    }
}
