package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class zzaln extends zzaly {
    private static final Writer zzbXL = new Writer() {
        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    private static final zzakl zzbXM = new zzakl("closed");
    private final List<zzakf> zzbXK = new ArrayList();
    private String zzbXN;
    private zzakf zzbXO = zzakh.zzbWr;

    public zzaln() {
        super(zzbXL);
    }

    private zzakf zzWf() {
        return this.zzbXK.get(this.zzbXK.size() - 1);
    }

    private void zzd(zzakf zzakf) {
        if (this.zzbXN != null) {
            if (!zzakf.zzVI() || zzWx()) {
                ((zzaki) zzWf()).zza(this.zzbXN, zzakf);
            }
            this.zzbXN = null;
        } else if (this.zzbXK.isEmpty()) {
            this.zzbXO = zzakf;
        } else {
            zzakf zzWf = zzWf();
            if (zzWf instanceof zzakc) {
                ((zzakc) zzWf).zzc(zzakf);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void close() throws IOException {
        if (!this.zzbXK.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.zzbXK.add(zzbXM);
    }

    public void flush() throws IOException {
    }

    public zzakf zzWe() {
        if (this.zzbXK.isEmpty()) {
            return this.zzbXO;
        }
        String valueOf = String.valueOf(this.zzbXK);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Expected one JSON element but was ").append(valueOf).toString());
    }

    public zzaly zzWg() throws IOException {
        zzakc zzakc = new zzakc();
        zzd(zzakc);
        this.zzbXK.add(zzakc);
        return this;
    }

    public zzaly zzWh() throws IOException {
        if (this.zzbXK.isEmpty() || this.zzbXN != null) {
            throw new IllegalStateException();
        } else if (zzWf() instanceof zzakc) {
            this.zzbXK.remove(this.zzbXK.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaly zzWi() throws IOException {
        zzaki zzaki = new zzaki();
        zzd(zzaki);
        this.zzbXK.add(zzaki);
        return this;
    }

    public zzaly zzWj() throws IOException {
        if (this.zzbXK.isEmpty() || this.zzbXN != null) {
            throw new IllegalStateException();
        } else if (zzWf() instanceof zzaki) {
            this.zzbXK.remove(this.zzbXK.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaly zzWk() throws IOException {
        zzd(zzakh.zzbWr);
        return this;
    }

    public zzaly zza(Number number) throws IOException {
        if (number == null) {
            return zzWk();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(valueOf).toString());
            }
        }
        zzd(new zzakl(number));
        return this;
    }

    public zzaly zzaN(long j) throws IOException {
        zzd(new zzakl((Number) Long.valueOf(j)));
        return this;
    }

    public zzaly zzaX(boolean z) throws IOException {
        zzd(new zzakl(Boolean.valueOf(z)));
        return this;
    }

    public zzaly zziT(String str) throws IOException {
        if (this.zzbXK.isEmpty() || this.zzbXN != null) {
            throw new IllegalStateException();
        } else if (zzWf() instanceof zzaki) {
            this.zzbXN = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaly zziU(String str) throws IOException {
        if (str == null) {
            return zzWk();
        }
        zzd(new zzakl(str));
        return this;
    }
}
