package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzf {
    static String zzaUq = null;
    static int zzaUr = 0;
    static int zzaUs = 0;
    static int zzaUt = 0;
    PendingIntent zzaTa;
    Messenger zzaTe;
    int zzaUA;
    long zzaUB;
    Map<String, Object> zzaUu = new HashMap();
    Messenger zzaUv;
    MessengerCompat zzaUw;
    long zzaUx;
    long zzaUy;
    int zzaUz;
    Context zzov;

    public zzf(Context context) {
        this.zzov = context;
    }

    public static synchronized String zzCj() {
        String num;
        synchronized (zzf.class) {
            int i = zzaUt;
            zzaUt = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private void zzF(Object obj) {
        synchronized (getClass()) {
            for (String next : this.zzaUu.keySet()) {
                Object obj2 = this.zzaUu.get(next);
                this.zzaUu.put(next, obj);
                zzh(obj2, obj);
            }
        }
    }

    static String zza(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return FirebaseInstanceId.zzp(instance.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    public static String zzaX(Context context) {
        if (zzaUq != null) {
            return zzaUq;
        }
        zzaUr = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo next : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", next.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(next.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", new StringBuilder(17).append("Found ").append(applicationInfo.uid).toString());
                    zzaUs = applicationInfo.uid;
                    zzaUq = next.serviceInfo.packageName;
                    return zzaUq;
                } catch (PackageManager.NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(next.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            zzaUq = applicationInfo2.packageName;
            zzaUs = applicationInfo2.uid;
            return zzaUq;
        } catch (PackageManager.NameNotFoundException e2) {
            try {
                ApplicationInfo applicationInfo3 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                zzaUq = applicationInfo3.packageName;
                zzaUs = applicationInfo3.uid;
                return zzaUq;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    private static int zzaY(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzaX(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    private Intent zzb(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzCj = zzCj();
        synchronized (getClass()) {
            this.zzaUu.put(zzCj, conditionVariable);
        }
        zza(bundle, keyPair, zzCj);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.zzaUu.remove(zzCj);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    private void zzeB(String str) {
        if ("com.google.android.gsf".equals(zzaUq)) {
            this.zzaUz++;
            if (this.zzaUz >= 3) {
                if (this.zzaUz == 3) {
                    this.zzaUA = new Random().nextInt(1000) + 1000;
                }
                this.zzaUA *= 2;
                this.zzaUB = SystemClock.elapsedRealtime() + ((long) this.zzaUA);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.zzaUA).toString());
            }
        }
    }

    private void zzh(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void zzi(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzaUu.get(str);
            this.zzaUu.put(str, obj);
            zzh(obj2, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzCi() {
        if (this.zzaTe == null) {
            zzaX(this.zzov);
            this.zzaTe = new Messenger(new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    zzf.this.zze(message);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public Intent zza(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent zzb = zzb(bundle, keyPair);
        return (zzb == null || !zzb.hasExtra("google.messenger")) ? zzb : zzb(bundle, keyPair);
    }

    public void zza(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzaUB == 0 || elapsedRealtime > this.zzaUB) {
            zzCi();
            if (zzaUq == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.zzaUx = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaUq);
            bundle.putString("gmsv", Integer.toString(zzaY(this.zzov)));
            bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.zzaU(this.zzov)));
            bundle.putString("app_ver_name", FirebaseInstanceId.zzaV(this.zzov));
            bundle.putString("cliv", "1");
            bundle.putString("appid", FirebaseInstanceId.zza(keyPair));
            String zzbx = FirebaseInstanceId.zzbx(this.zzov);
            if (zzbx != null) {
                bundle.putString("gmp_app_id", zzbx);
            }
            String zzp = FirebaseInstanceId.zzp(keyPair.getPublic().getEncoded());
            bundle.putString("pub2", zzp);
            bundle.putString("sig", zza(keyPair, this.zzov.getPackageName(), zzp));
            intent.putExtras(bundle);
            zzr(intent);
            zzb(intent, str);
            return;
        }
        long j = this.zzaUB - elapsedRealtime;
        Log.w("InstanceID/Rpc", new StringBuilder(78).append("Backoff mode, next request attempt: ").append(j).append(" interval: ").append(this.zzaUA).toString());
        throw new IOException("RETRY_LATER");
    }

    /* access modifiers changed from: protected */
    public void zzb(Intent intent, String str) {
        this.zzaUx = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(zzaUq);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.zzov.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.zzaTe);
        if (!(this.zzaUv == null && this.zzaUw == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.zzaUv != null) {
                    this.zzaUv.send(obtain);
                    return;
                } else {
                    this.zzaUw.send(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.zzov.startService(intent);
    }

    public void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzaUw = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzaUv = (Messenger) parcelableExtra;
                    }
                }
                zzu((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void zzr(Intent intent) {
        if (this.zzaTa == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaTa = PendingIntent.getBroadcast(this.zzov, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzaTa);
    }

    /* access modifiers changed from: package-private */
    public String zzs(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* access modifiers changed from: package-private */
    public void zzt(Intent intent) {
        String str;
        String str2;
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf2 = String.valueOf(stringExtra);
            Log.d("InstanceID/Rpc", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String valueOf3 = String.valueOf(stringExtra);
                Log.w("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
            }
            if (split.length > 2) {
                str = split[2];
                str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
            } else {
                str2 = "UNKNOWN";
                str = null;
            }
            intent.putExtra("error", str2);
        } else {
            str = null;
            str2 = stringExtra;
        }
        if (str == null) {
            zzF(str2);
        } else {
            zzi(str, str2);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.zzaUy = SystemClock.elapsedRealtime();
            this.zzaUA = ((int) longExtra) * 1000;
            this.zzaUB = SystemClock.elapsedRealtime() + ((long) this.zzaUA);
            Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(this.zzaUA).toString());
        } else if ("SERVICE_NOT_AVAILABLE".equals(str2) || "AUTHENTICATION_FAILED".equals(str2)) {
            zzeB(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzu(Intent intent) {
        String str;
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
            }
        } else if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                zzt(intent);
                return;
            }
            this.zzaUx = SystemClock.elapsedRealtime();
            this.zzaUB = 0;
            this.zzaUz = 0;
            this.zzaUA = 0;
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(stringExtra).length() + 16 + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
            }
            if (stringExtra.startsWith("|")) {
                String[] split = stringExtra.split("\\|");
                if (!"ID".equals(split[1])) {
                    String valueOf2 = String.valueOf(stringExtra);
                    Log.w("InstanceID/Rpc", valueOf2.length() != 0 ? "Unexpected structured response ".concat(valueOf2) : new String("Unexpected structured response "));
                }
                String str2 = split[2];
                if (split.length > 4) {
                    if ("SYNC".equals(split[3])) {
                        FirebaseInstanceId.zzaW(this.zzov);
                    } else if ("RST".equals(split[3])) {
                        FirebaseInstanceId.zza(this.zzov, zzd.zzb(this.zzov, (Bundle) null).zzUs());
                        intent.removeExtra("registration_id");
                        zzi(str2, intent);
                        return;
                    }
                }
                String str3 = split[split.length - 1];
                if (str3.startsWith(":")) {
                    str3 = str3.substring(1);
                }
                intent.putExtra("registration_id", str3);
                str = str2;
            } else {
                str = null;
            }
            if (str == null) {
                zzF(intent);
            } else {
                zzi(str, intent);
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf3 = String.valueOf(intent.getAction());
            Log.d("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected response ".concat(valueOf3) : new String("Unexpected response "));
        }
    }
}
