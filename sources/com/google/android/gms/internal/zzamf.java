package com.google.android.gms.internal;

public final class zzamf implements Cloneable {
    private static final zzamg zzcac = new zzamg();
    private int mSize;
    private boolean zzcad;
    private int[] zzcae;
    private zzamg[] zzcaf;

    zzamf() {
        this(10);
    }

    zzamf(int i) {
        this.zzcad = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcae = new int[idealIntArraySize];
        this.zzcaf = new zzamg[idealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m20gc() {
        int i = this.mSize;
        int[] iArr = this.zzcae;
        zzamg[] zzamgArr = this.zzcaf;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzamg zzamg = zzamgArr[i3];
            if (zzamg != zzcac) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzamgArr[i2] = zzamg;
                    zzamgArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzcad = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzamg[] zzamgArr, zzamg[] zzamgArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzamgArr[i2].equals(zzamgArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzom(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzcae[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzamf)) {
            return false;
        }
        zzamf zzamf = (zzamf) obj;
        if (size() != zzamf.size()) {
            return false;
        }
        return zza(this.zzcae, zzamf.zzcae, this.mSize) && zza(this.zzcaf, zzamf.zzcaf, this.mSize);
    }

    public int hashCode() {
        if (this.zzcad) {
            m20gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcae[i2]) * 31) + this.zzcaf[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public void remove(int i) {
        int zzom = zzom(i);
        if (zzom >= 0 && this.zzcaf[zzom] != zzcac) {
            this.zzcaf[zzom] = zzcac;
            this.zzcad = true;
        }
    }

    /* access modifiers changed from: package-private */
    public int size() {
        if (this.zzcad) {
            m20gc();
        }
        return this.mSize;
    }

    /* renamed from: zzWV */
    public final zzamf clone() {
        int size = size();
        zzamf zzamf = new zzamf(size);
        System.arraycopy(this.zzcae, 0, zzamf.zzcae, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzcaf[i] != null) {
                zzamf.zzcaf[i] = (zzamg) this.zzcaf[i].clone();
            }
        }
        zzamf.mSize = size;
        return zzamf;
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, zzamg zzamg) {
        int zzom = zzom(i);
        if (zzom >= 0) {
            this.zzcaf[zzom] = zzamg;
            return;
        }
        int i2 = zzom ^ -1;
        if (i2 >= this.mSize || this.zzcaf[i2] != zzcac) {
            if (this.zzcad && this.mSize >= this.zzcae.length) {
                m20gc();
                i2 = zzom(i) ^ -1;
            }
            if (this.mSize >= this.zzcae.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzamg[] zzamgArr = new zzamg[idealIntArraySize];
                System.arraycopy(this.zzcae, 0, iArr, 0, this.zzcae.length);
                System.arraycopy(this.zzcaf, 0, zzamgArr, 0, this.zzcaf.length);
                this.zzcae = iArr;
                this.zzcaf = zzamgArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzcae, i2, this.zzcae, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzcaf, i2, this.zzcaf, i2 + 1, this.mSize - i2);
            }
            this.zzcae[i2] = i;
            this.zzcaf[i2] = zzamg;
            this.mSize++;
            return;
        }
        this.zzcae[i2] = i;
        this.zzcaf[i2] = zzamg;
    }

    /* access modifiers changed from: package-private */
    public zzamg zzok(int i) {
        int zzom = zzom(i);
        if (zzom < 0 || this.zzcaf[zzom] == zzcac) {
            return null;
        }
        return this.zzcaf[zzom];
    }

    /* access modifiers changed from: package-private */
    public zzamg zzol(int i) {
        if (this.zzcad) {
            m20gc();
        }
        return this.zzcaf[i];
    }
}
