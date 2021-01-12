package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzaa;

abstract class zzf {
    private static volatile Handler zzXx;
    /* access modifiers changed from: private */
    public volatile long zzXy;
    /* access modifiers changed from: private */
    public final zzx zzbbl;
    /* access modifiers changed from: private */
    public boolean zzbcc = true;
    private final Runnable zzw = new Runnable() {
        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzf.this.zzbbl.zzFl().zzg(this);
                return;
            }
            boolean zzbW = zzf.this.zzbW();
            long unused = zzf.this.zzXy = 0;
            if (zzbW && zzf.this.zzbcc) {
                zzf.this.run();
            }
        }
    };

    zzf(zzx zzx) {
        zzaa.zzz(zzx);
        this.zzbbl = zzx;
    }

    private Handler getHandler() {
        Handler handler;
        if (zzXx != null) {
            return zzXx;
        }
        synchronized (zzf.class) {
            if (zzXx == null) {
                zzXx = new Handler(this.zzbbl.getContext().getMainLooper());
            }
            handler = zzXx;
        }
        return handler;
    }

    public void cancel() {
        this.zzXy = 0;
        getHandler().removeCallbacks(this.zzw);
    }

    public abstract void run();

    public boolean zzbW() {
        return this.zzXy != 0;
    }

    public void zzv(long j) {
        cancel();
        if (j >= 0) {
            this.zzXy = this.zzbbl.zzlQ().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzw, j)) {
                this.zzbbl.zzFm().zzFE().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
