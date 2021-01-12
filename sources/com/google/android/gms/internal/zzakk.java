package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class zzakk {
    public zzakf zza(Reader reader) throws zzakg, zzako {
        try {
            zzalw zzalw = new zzalw(reader);
            zzakf zzh = zzh(zzalw);
            if (zzh.zzVI() || zzalw.zzWa() == zzalx.END_DOCUMENT) {
                return zzh;
            }
            throw new zzako("Did not consume the entire document.");
        } catch (zzalz e) {
            throw new zzako((Throwable) e);
        } catch (IOException e2) {
            throw new zzakg((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new zzako((Throwable) e3);
        }
    }

    public zzakf zzh(zzalw zzalw) throws zzakg, zzako {
        boolean isLenient = zzalw.isLenient();
        zzalw.setLenient(true);
        try {
            zzakf zzh = zzalg.zzh(zzalw);
            zzalw.setLenient(isLenient);
            return zzh;
        } catch (StackOverflowError e) {
            String valueOf = String.valueOf(zzalw);
            throw new zzakj(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e);
        } catch (OutOfMemoryError e2) {
            String valueOf2 = String.valueOf(zzalw);
            throw new zzakj(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("Failed parsing JSON source: ").append(valueOf2).append(" to Json").toString(), e2);
        } catch (Throwable th) {
            zzalw.setLenient(isLenient);
            throw th;
        }
    }

    public zzakf zziR(String str) throws zzako {
        return zza(new StringReader(str));
    }
}
