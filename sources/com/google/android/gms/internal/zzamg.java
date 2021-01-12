package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzamg implements Cloneable {
    private Object zzbIu;
    private zzame<?, ?> zzcag;
    private List<zzaml> zzcah;

    zzamg() {
        this.zzcah = new ArrayList();
    }

    <T> zzamg(zzame<?, T> zzame, T t) {
        this.zzcag = zzame;
        this.zzbIu = t;
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        writeTo(zzamc.zzO(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzamg)) {
            return false;
        }
        zzamg zzamg = (zzamg) obj;
        if (this.zzbIu == null || zzamg.zzbIu == null) {
            if (this.zzcah != null && zzamg.zzcah != null) {
                return this.zzcah.equals(zzamg.zzcah);
            }
            try {
                return Arrays.equals(toByteArray(), zzamg.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzcag == zzamg.zzcag) {
            return !this.zzcag.zzbSs.isArray() ? this.zzbIu.equals(zzamg.zzbIu) : this.zzbIu instanceof byte[] ? Arrays.equals((byte[]) this.zzbIu, (byte[]) zzamg.zzbIu) : this.zzbIu instanceof int[] ? Arrays.equals((int[]) this.zzbIu, (int[]) zzamg.zzbIu) : this.zzbIu instanceof long[] ? Arrays.equals((long[]) this.zzbIu, (long[]) zzamg.zzbIu) : this.zzbIu instanceof float[] ? Arrays.equals((float[]) this.zzbIu, (float[]) zzamg.zzbIu) : this.zzbIu instanceof double[] ? Arrays.equals((double[]) this.zzbIu, (double[]) zzamg.zzbIu) : this.zzbIu instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbIu, (boolean[]) zzamg.zzbIu) : Arrays.deepEquals((Object[]) this.zzbIu, (Object[]) zzamg.zzbIu);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeTo(zzamc zzamc) throws IOException {
        if (this.zzbIu != null) {
            this.zzcag.zza(this.zzbIu, zzamc);
            return;
        }
        for (zzaml writeTo : this.zzcah) {
            writeTo.writeTo(zzamc);
        }
    }

    /* renamed from: zzWW */
    public final zzamg clone() {
        int i = 0;
        zzamg zzamg = new zzamg();
        try {
            zzamg.zzcag = this.zzcag;
            if (this.zzcah == null) {
                zzamg.zzcah = null;
            } else {
                zzamg.zzcah.addAll(this.zzcah);
            }
            if (this.zzbIu != null) {
                if (this.zzbIu instanceof zzamj) {
                    zzamg.zzbIu = (zzamj) ((zzamj) this.zzbIu).clone();
                } else if (this.zzbIu instanceof byte[]) {
                    zzamg.zzbIu = ((byte[]) this.zzbIu).clone();
                } else if (this.zzbIu instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbIu;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzamg.zzbIu = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.zzbIu instanceof boolean[]) {
                    zzamg.zzbIu = ((boolean[]) this.zzbIu).clone();
                } else if (this.zzbIu instanceof int[]) {
                    zzamg.zzbIu = ((int[]) this.zzbIu).clone();
                } else if (this.zzbIu instanceof long[]) {
                    zzamg.zzbIu = ((long[]) this.zzbIu).clone();
                } else if (this.zzbIu instanceof float[]) {
                    zzamg.zzbIu = ((float[]) this.zzbIu).clone();
                } else if (this.zzbIu instanceof double[]) {
                    zzamg.zzbIu = ((double[]) this.zzbIu).clone();
                } else if (this.zzbIu instanceof zzamj[]) {
                    zzamj[] zzamjArr = (zzamj[]) this.zzbIu;
                    zzamj[] zzamjArr2 = new zzamj[zzamjArr.length];
                    zzamg.zzbIu = zzamjArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzamjArr.length) {
                            break;
                        }
                        zzamjArr2[i3] = (zzamj) zzamjArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzamg;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T zza(zzame<?, T> zzame) {
        if (this.zzbIu == null) {
            this.zzcag = zzame;
            this.zzbIu = zzame.zzV(this.zzcah);
            this.zzcah = null;
        } else if (!this.zzcag.equals(zzame)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.zzbIu;
    }

    /* access modifiers changed from: package-private */
    public <T> void zza(zzame<?, T> zzame, T t) {
        this.zzcag = zzame;
        this.zzbIu = t;
        this.zzcah = null;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzaml zzaml) {
        this.zzcah.add(zzaml);
    }

    /* access modifiers changed from: package-private */
    public int zzy() {
        int i = 0;
        if (this.zzbIu != null) {
            return this.zzcag.zzaP(this.zzbIu);
        }
        Iterator<zzaml> it = this.zzcah.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().zzy() + i2;
        }
    }
}
