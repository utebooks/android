package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzaps = false;
    private ArrayList<Integer> zzapt;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zzsX() {
        synchronized (this) {
            if (!this.zzaps) {
                int count = this.zzamz.getCount();
                this.zzapt = new ArrayList<>();
                if (count > 0) {
                    this.zzapt.add(0);
                    String zzsW = zzsW();
                    String zzd = this.zzamz.zzd(zzsW, 0, this.zzamz.zzbP(0));
                    int i = 1;
                    while (i < count) {
                        int zzbP = this.zzamz.zzbP(i);
                        String zzd2 = this.zzamz.zzd(zzsW, i, zzbP);
                        if (zzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(zzsW).length() + 78).append("Missing value for markerColumn: ").append(zzsW).append(", at row: ").append(i).append(", for window: ").append(zzbP).toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.zzapt.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.zzaps = true;
            }
        }
    }

    public final T get(int i) {
        zzsX();
        return zzm(zzbT(i), zzbU(i));
    }

    public int getCount() {
        zzsX();
        return this.zzapt.size();
    }

    /* access modifiers changed from: package-private */
    public int zzbT(int i) {
        if (i >= 0 && i < this.zzapt.size()) {
            return this.zzapt.get(i).intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
    }

    /* access modifiers changed from: protected */
    public int zzbU(int i) {
        if (i < 0 || i == this.zzapt.size()) {
            return 0;
        }
        int count = i == this.zzapt.size() + -1 ? this.zzamz.getCount() - this.zzapt.get(i).intValue() : this.zzapt.get(i + 1).intValue() - this.zzapt.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int zzbT = zzbT(i);
        int zzbP = this.zzamz.zzbP(zzbT);
        String zzsY = zzsY();
        if (zzsY == null || this.zzamz.zzd(zzsY, zzbT, zzbP) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T zzm(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zzsW();

    /* access modifiers changed from: protected */
    public String zzsY() {
        return null;
    }
}
