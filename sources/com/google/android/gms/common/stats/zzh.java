package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzj;
import java.util.List;

public class zzh {
    private static String TAG = "WakeLockTracker";
    private static zzh zzatX = new zzh();
    private static Boolean zzatY;

    private static boolean zzaA(Context context) {
        try {
            if (!zzd.zzmW()) {
                return false;
            }
            return zzc.zzb.zzatx.get().intValue() != zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return false;
        }
    }

    private static boolean zzaz(Context context) {
        if (zzatY == null) {
            zzatY = Boolean.valueOf(zzaA(context));
        }
        return zzatY.booleanValue();
    }

    public static zzh zzuS() {
        return zzatX;
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        zza(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (zzaz(context)) {
            if (TextUtils.isEmpty(str)) {
                String str5 = TAG;
                String valueOf = String.valueOf(str);
                Log.e(str5, valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.zzatD).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, zzf.zzx(list), str, SystemClock.elapsedRealtime(), zzj.zzaD(context), str3, zzf.zzdt(context.getPackageName()), zzj.zzaE(context), j, str4)));
                } catch (Exception e) {
                    Log.wtf(TAG, e);
                }
            }
        }
    }
}
