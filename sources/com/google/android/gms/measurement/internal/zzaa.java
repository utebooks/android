package com.google.android.gms.measurement.internal;

abstract class zzaa extends zzz {
    private boolean zzWh;

    zzaa(zzx zzx) {
        super(zzx);
        this.zzbbl.zzb(this);
    }

    public final void initialize() {
        if (this.zzWh) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzkO();
        this.zzbbl.zzGp();
        this.zzWh = true;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.zzWh;
    }

    /* access modifiers changed from: package-private */
    public boolean zzGu() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void zzkO();

    /* access modifiers changed from: protected */
    public void zzma() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
