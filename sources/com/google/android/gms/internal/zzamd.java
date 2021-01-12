package com.google.android.gms.internal;

import com.google.android.gms.internal.zzamd;
import java.io.IOException;

public abstract class zzamd<M extends zzamd<M>> extends zzamj {
    protected zzamf zzcaa;

    public M clone() throws CloneNotSupportedException {
        M m = (zzamd) super.clone();
        zzamh.zza(this, (zzamd) m);
        return m;
    }

    public final <T> T getExtension(zzame<M, T> zzame) {
        zzamg zzok;
        if (this.zzcaa == null || (zzok = this.zzcaa.zzok(zzamm.zzoo(zzame.tag))) == null) {
            return null;
        }
        return zzok.zza(zzame);
    }

    public final zzamf getUnknownFieldArray() {
        return this.zzcaa;
    }

    public final boolean hasExtension(zzame<M, ?> zzame) {
        return (this.zzcaa == null || this.zzcaa.zzok(zzamm.zzoo(zzame.tag)) == null) ? false : true;
    }

    public final <T> M setExtension(zzame<M, T> zzame, T t) {
        zzamg zzamg = null;
        int zzoo = zzamm.zzoo(zzame.tag);
        if (t != null) {
            if (this.zzcaa == null) {
                this.zzcaa = new zzamf();
            } else {
                zzamg = this.zzcaa.zzok(zzoo);
            }
            if (zzamg == null) {
                this.zzcaa.zza(zzoo, new zzamg(zzame, t));
            } else {
                zzamg.zza(zzame, t);
            }
        } else if (this.zzcaa != null) {
            this.zzcaa.remove(zzoo);
            if (this.zzcaa.isEmpty()) {
                this.zzcaa = null;
            }
        }
        return this;
    }

    public void writeTo(zzamc zzamc) throws IOException {
        if (this.zzcaa != null) {
            for (int i = 0; i < this.zzcaa.size(); i++) {
                this.zzcaa.zzol(i).writeTo(zzamc);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzamb zzamb, int i) throws IOException {
        int position = zzamb.getPosition();
        if (!zzamb.zznU(i)) {
            return false;
        }
        int zzoo = zzamm.zzoo(i);
        zzaml zzaml = new zzaml(i, zzamb.zzD(position, zzamb.getPosition() - position));
        zzamg zzamg = null;
        if (this.zzcaa == null) {
            this.zzcaa = new zzamf();
        } else {
            zzamg = this.zzcaa.zzok(zzoo);
        }
        if (zzamg == null) {
            zzamg = new zzamg();
            this.zzcaa.zza(zzoo, zzamg);
        }
        zzamg.zza(zzaml);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzy() {
        if (this.zzcaa == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzcaa.size(); i2++) {
            i += this.zzcaa.zzol(i2).zzy();
        }
        return i;
    }
}
