package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class zzalg {

    private static final class zza extends Writer {
        private final Appendable zzbXw;
        private final C0770zza zzbXx;

        /* renamed from: com.google.android.gms.internal.zzalg$zza$zza  reason: collision with other inner class name */
        static class C0770zza implements CharSequence {
            char[] zzbXy;

            C0770zza() {
            }

            public char charAt(int i) {
                return this.zzbXy[i];
            }

            public int length() {
                return this.zzbXy.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.zzbXy, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.zzbXx = new C0770zza();
            this.zzbXw = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) throws IOException {
            this.zzbXw.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            this.zzbXx.zzbXy = cArr;
            this.zzbXw.append(this.zzbXx, i, i + i2);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzakf zzakf, zzaly zzaly) throws IOException {
        zzalu.zzbYV.zza(zzaly, zzakf);
    }

    public static zzakf zzh(zzalw zzalw) throws zzakj {
        boolean z = true;
        try {
            zzalw.zzWa();
            z = false;
            return zzalu.zzbYV.zzb(zzalw);
        } catch (EOFException e) {
            if (z) {
                return zzakh.zzbWr;
            }
            throw new zzako((Throwable) e);
        } catch (zzalz e2) {
            throw new zzako((Throwable) e2);
        } catch (IOException e3) {
            throw new zzakg((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new zzako((Throwable) e4);
        }
    }
}
