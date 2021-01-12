package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class zzg {
    SharedPreferences zzaUD;
    Context zzov;

    public zzg(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public zzg(Context context, String str) {
        this.zzov = context;
        this.zzaUD = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        zzeC(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private void zzeC(String str) {
        File file = new File(zzx.getNoBackupFilesDir(this.zzov), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.zza(this.zzov, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("InstanceID/Store", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private String zzh(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(valueOf).length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    /* access modifiers changed from: package-private */
    public synchronized String get(String str) {
        return this.zzaUD.getString(str, (String) null);
    }

    /* access modifiers changed from: package-private */
    public synchronized String get(String str, String str2) {
        SharedPreferences sharedPreferences;
        String valueOf;
        sharedPreferences = this.zzaUD;
        valueOf = String.valueOf("|S|");
        return sharedPreferences.getString(new StringBuilder(String.valueOf(str).length() + 0 + String.valueOf(valueOf).length() + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), (String) null);
    }

    public boolean isEmpty() {
        return this.zzaUD.getAll().isEmpty();
    }

    public synchronized void zzCk() {
        this.zzaUD.edit().clear().commit();
    }

    public SharedPreferences zzUv() {
        return this.zzaUD;
    }

    /* access modifiers changed from: package-private */
    public synchronized void zza(SharedPreferences.Editor editor, String str, String str2, String str3) {
        String valueOf = String.valueOf("|S|");
        editor.putString(new StringBuilder(String.valueOf(str).length() + 0 + String.valueOf(valueOf).length() + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString(), str3);
    }

    public synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zzh = zzh(str, str2, str3);
        SharedPreferences.Editor edit = this.zzaUD.edit();
        edit.putString(zzh, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized KeyPair zzd(String str, long j) {
        KeyPair zzCc;
        zzCc = zza.zzCc();
        SharedPreferences.Editor edit = this.zzaUD.edit();
        zza(edit, str, "|P|", FirebaseInstanceId.zzp(zzCc.getPublic().getEncoded()));
        zza(edit, str, "|K|", FirebaseInstanceId.zzp(zzCc.getPrivate().getEncoded()));
        zza(edit, str, "cre", Long.toString(j));
        edit.commit();
        return zzCc;
    }

    public synchronized void zzeD(String str) {
        SharedPreferences.Editor edit = this.zzaUD.edit();
        for (String next : this.zzaUD.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    public KeyPair zzeE(String str) {
        return zzeH(str);
    }

    /* access modifiers changed from: package-private */
    public void zzeF(String str) {
        zzeD(String.valueOf(str).concat("|"));
    }

    public void zzeG(String str) {
        zzeD(String.valueOf(str).concat("|T|"));
    }

    /* access modifiers changed from: package-private */
    public KeyPair zzeH(String str) {
        String str2 = get(str, "|P|");
        String str3 = get(str, "|K|");
        if (str3 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str2, 8);
            byte[] decode2 = Base64.decode(str3, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
            FirebaseInstanceId.zza(this.zzov, this);
            return null;
        }
    }

    public synchronized String zzi(String str, String str2, String str3) {
        return this.zzaUD.getString(zzh(str, str2, str3), (String) null);
    }

    public synchronized void zzj(String str, String str2, String str3) {
        String zzh = zzh(str, str2, str3);
        SharedPreferences.Editor edit = this.zzaUD.edit();
        edit.remove(zzh);
        edit.commit();
    }
}
