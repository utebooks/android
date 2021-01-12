package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzajz {
    private final ThreadLocal<Map<zzalv<?>, zza<?>>> zzbVX;
    private final Map<zzalv<?>, zzakr<?>> zzbVY;
    private final List<zzaks> zzbVZ;
    private final zzakz zzbWa;
    private final boolean zzbWb;
    private final boolean zzbWc;
    private final boolean zzbWd;
    private final boolean zzbWe;
    final zzakd zzbWf;
    final zzakm zzbWg;

    static class zza<T> extends zzakr<T> {
        private zzakr<T> zzbWi;

        zza() {
        }

        public void zza(zzakr<T> zzakr) {
            if (this.zzbWi != null) {
                throw new AssertionError();
            }
            this.zzbWi = zzakr;
        }

        public void zza(zzaly zzaly, T t) throws IOException {
            if (this.zzbWi == null) {
                throw new IllegalStateException();
            }
            this.zzbWi.zza(zzaly, t);
        }

        public T zzb(zzalw zzalw) throws IOException {
            if (this.zzbWi != null) {
                return this.zzbWi.zzb(zzalw);
            }
            throw new IllegalStateException();
        }
    }

    public zzajz() {
        this(zzala.zzbWT, zzajx.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, zzakp.DEFAULT, Collections.emptyList());
    }

    zzajz(zzala zzala, zzajy zzajy, Map<Type, zzakb<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzakp zzakp, List<zzaks> list) {
        this.zzbVX = new ThreadLocal<>();
        this.zzbVY = Collections.synchronizedMap(new HashMap());
        this.zzbWf = new zzakd() {
        };
        this.zzbWg = new zzakm() {
        };
        this.zzbWa = new zzakz(map);
        this.zzbWb = z;
        this.zzbWd = z3;
        this.zzbWc = z4;
        this.zzbWe = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzalu.zzbYW);
        arrayList.add(zzalp.zzbXD);
        arrayList.add(zzala);
        arrayList.addAll(list);
        arrayList.add(zzalu.zzbYD);
        arrayList.add(zzalu.zzbYs);
        arrayList.add(zzalu.zzbYm);
        arrayList.add(zzalu.zzbYo);
        arrayList.add(zzalu.zzbYq);
        arrayList.add(zzalu.zza(Long.TYPE, Long.class, zza(zzakp)));
        arrayList.add(zzalu.zza(Double.TYPE, Double.class, zzaV(z6)));
        arrayList.add(zzalu.zza(Float.TYPE, Float.class, zzaW(z6)));
        arrayList.add(zzalu.zzbYx);
        arrayList.add(zzalu.zzbYz);
        arrayList.add(zzalu.zzbYF);
        arrayList.add(zzalu.zzbYH);
        arrayList.add(zzalu.zza(BigDecimal.class, zzalu.zzbYB));
        arrayList.add(zzalu.zza(BigInteger.class, zzalu.zzbYC));
        arrayList.add(zzalu.zzbYJ);
        arrayList.add(zzalu.zzbYL);
        arrayList.add(zzalu.zzbYP);
        arrayList.add(zzalu.zzbYU);
        arrayList.add(zzalu.zzbYN);
        arrayList.add(zzalu.zzbYj);
        arrayList.add(zzalk.zzbXD);
        arrayList.add(zzalu.zzbYS);
        arrayList.add(zzals.zzbXD);
        arrayList.add(zzalr.zzbXD);
        arrayList.add(zzalu.zzbYQ);
        arrayList.add(zzali.zzbXD);
        arrayList.add(zzalu.zzbYh);
        arrayList.add(new zzalj(this.zzbWa));
        arrayList.add(new zzalo(this.zzbWa, z2));
        arrayList.add(new zzall(this.zzbWa));
        arrayList.add(zzalu.zzbYX);
        arrayList.add(new zzalq(this.zzbWa, zzajy, zzala));
        this.zzbVZ = Collections.unmodifiableList(arrayList);
    }

    private zzakr<Number> zza(zzakp zzakp) {
        return zzakp == zzakp.DEFAULT ? zzalu.zzbYt : new zzakr<Number>() {
            public void zza(zzaly zzaly, Number number) throws IOException {
                if (number == null) {
                    zzaly.zzWk();
                } else {
                    zzaly.zziU(number.toString());
                }
            }

            /* renamed from: zzg */
            public Number zzb(zzalw zzalw) throws IOException {
                if (zzalw.zzWa() != zzalx.NULL) {
                    return Long.valueOf(zzalw.nextLong());
                }
                zzalw.nextNull();
                return null;
            }
        };
    }

    private static void zza(Object obj, zzalw zzalw) {
        if (obj != null) {
            try {
                if (zzalw.zzWa() != zzalx.END_DOCUMENT) {
                    throw new zzakg("JSON document was not fully consumed.");
                }
            } catch (zzalz e) {
                throw new zzako((Throwable) e);
            } catch (IOException e2) {
                throw new zzakg((Throwable) e2);
            }
        }
    }

    private zzakr<Number> zzaV(boolean z) {
        return z ? zzalu.zzbYv : new zzakr<Number>() {
            public void zza(zzaly zzaly, Number number) throws IOException {
                if (number == null) {
                    zzaly.zzWk();
                    return;
                }
                zzajz.this.zzo(number.doubleValue());
                zzaly.zza(number);
            }

            /* renamed from: zze */
            public Double zzb(zzalw zzalw) throws IOException {
                if (zzalw.zzWa() != zzalx.NULL) {
                    return Double.valueOf(zzalw.nextDouble());
                }
                zzalw.nextNull();
                return null;
            }
        };
    }

    private zzakr<Number> zzaW(boolean z) {
        return z ? zzalu.zzbYu : new zzakr<Number>() {
            public void zza(zzaly zzaly, Number number) throws IOException {
                if (number == null) {
                    zzaly.zzWk();
                    return;
                }
                zzajz.this.zzo((double) number.floatValue());
                zzaly.zza(number);
            }

            /* renamed from: zzf */
            public Float zzb(zzalw zzalw) throws IOException {
                if (zzalw.zzWa() != zzalx.NULL) {
                    return Float.valueOf((float) zzalw.nextDouble());
                }
                zzalw.nextNull();
                return null;
            }
        };
    }

    /* access modifiers changed from: private */
    public void zzo(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(new StringBuilder(168).append(d).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.zzbWb + "factories:" + this.zzbVZ + ",instanceCreators:" + this.zzbWa + "}";
    }

    public <T> zzakr<T> zza(zzaks zzaks, zzalv<T> zzalv) {
        boolean z = false;
        if (!this.zzbVZ.contains(zzaks)) {
            z = true;
        }
        boolean z2 = z;
        for (zzaks next : this.zzbVZ) {
            if (z2) {
                zzakr<T> zza2 = next.zza(this, zzalv);
                if (zza2 != null) {
                    return zza2;
                }
            } else if (next == zzaks) {
                z2 = true;
            }
        }
        String valueOf = String.valueOf(zzalv);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("GSON cannot serialize ").append(valueOf).toString());
    }

    public <T> zzakr<T> zza(zzalv<T> zzalv) {
        HashMap hashMap;
        zzakr<T> zzakr = this.zzbVY.get(zzalv);
        if (zzakr == null) {
            Map map = this.zzbVX.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.zzbVX.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            zzakr = (zza) hashMap.get(zzalv);
            if (zzakr == null) {
                try {
                    zza zza2 = new zza();
                    hashMap.put(zzalv, zza2);
                    for (zzaks zza3 : this.zzbVZ) {
                        zzakr = zza3.zza(this, zzalv);
                        if (zzakr != null) {
                            zza2.zza(zzakr);
                            this.zzbVY.put(zzalv, zzakr);
                            hashMap.remove(zzalv);
                            if (z) {
                                this.zzbVX.remove();
                            }
                        }
                    }
                    String valueOf = String.valueOf(zzalv);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("GSON cannot handle ").append(valueOf).toString());
                } catch (Throwable th) {
                    hashMap.remove(zzalv);
                    if (z) {
                        this.zzbVX.remove();
                    }
                    throw th;
                }
            }
        }
        return zzakr;
    }

    public zzaly zza(Writer writer) throws IOException {
        if (this.zzbWd) {
            writer.write(")]}'\n");
        }
        zzaly zzaly = new zzaly(writer);
        if (this.zzbWe) {
            zzaly.setIndent("  ");
        }
        zzaly.zzba(this.zzbWb);
        return zzaly;
    }

    public <T> T zza(zzakf zzakf, Class<T> cls) throws zzako {
        return zzalf.zzp(cls).cast(zza(zzakf, (Type) cls));
    }

    public <T> T zza(zzakf zzakf, Type type) throws zzako {
        if (zzakf == null) {
            return null;
        }
        return zza((zzalw) new zzalm(zzakf), type);
    }

    public <T> T zza(zzalw zzalw, Type type) throws zzakg, zzako {
        boolean z = true;
        boolean isLenient = zzalw.isLenient();
        zzalw.setLenient(true);
        try {
            zzalw.zzWa();
            z = false;
            T zzb = zza(zzalv.zzl(type)).zzb(zzalw);
            zzalw.setLenient(isLenient);
            return zzb;
        } catch (EOFException e) {
            if (z) {
                zzalw.setLenient(isLenient);
                return null;
            }
            throw new zzako((Throwable) e);
        } catch (IllegalStateException e2) {
            throw new zzako((Throwable) e2);
        } catch (IOException e3) {
            throw new zzako((Throwable) e3);
        } catch (Throwable th) {
            zzalw.setLenient(isLenient);
            throw th;
        }
    }

    public <T> T zza(Reader reader, Type type) throws zzakg, zzako {
        zzalw zzalw = new zzalw(reader);
        T zza2 = zza(zzalw, type);
        zza((Object) zza2, zzalw);
        return zza2;
    }

    public <T> T zza(String str, Type type) throws zzako {
        if (str == null) {
            return null;
        }
        return zza((Reader) new StringReader(str), type);
    }

    public void zza(zzakf zzakf, zzaly zzaly) throws zzakg {
        boolean isLenient = zzaly.isLenient();
        zzaly.setLenient(true);
        boolean zzWw = zzaly.zzWw();
        zzaly.zzaZ(this.zzbWc);
        boolean zzWx = zzaly.zzWx();
        zzaly.zzba(this.zzbWb);
        try {
            zzalg.zzb(zzakf, zzaly);
            zzaly.setLenient(isLenient);
            zzaly.zzaZ(zzWw);
            zzaly.zzba(zzWx);
        } catch (IOException e) {
            throw new zzakg((Throwable) e);
        } catch (Throwable th) {
            zzaly.setLenient(isLenient);
            zzaly.zzaZ(zzWw);
            zzaly.zzba(zzWx);
            throw th;
        }
    }

    public void zza(zzakf zzakf, Appendable appendable) throws zzakg {
        try {
            zza(zzakf, zza(zzalg.zza(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaly zzaly) throws zzakg {
        zzakr<?> zza2 = zza(zzalv.zzl(type));
        boolean isLenient = zzaly.isLenient();
        zzaly.setLenient(true);
        boolean zzWw = zzaly.zzWw();
        zzaly.zzaZ(this.zzbWc);
        boolean zzWx = zzaly.zzWx();
        zzaly.zzba(this.zzbWb);
        try {
            zza2.zza(zzaly, obj);
            zzaly.setLenient(isLenient);
            zzaly.zzaZ(zzWw);
            zzaly.zzba(zzWx);
        } catch (IOException e) {
            throw new zzakg((Throwable) e);
        } catch (Throwable th) {
            zzaly.setLenient(isLenient);
            zzaly.zzaZ(zzWw);
            zzaly.zzba(zzWx);
            throw th;
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) throws zzakg {
        try {
            zza(obj, type, zza(zzalg.zza(appendable)));
        } catch (IOException e) {
            throw new zzakg((Throwable) e);
        }
    }

    public String zzaH(Object obj) {
        return obj == null ? zzb(zzakh.zzbWr) : zzc(obj, obj.getClass());
    }

    public String zzb(zzakf zzakf) {
        StringWriter stringWriter = new StringWriter();
        zza(zzakf, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        zza(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public <T> T zzf(String str, Class<T> cls) throws zzako {
        return zzalf.zzp(cls).cast(zza(str, (Type) cls));
    }

    public <T> zzakr<T> zzk(Class<T> cls) {
        return zza(zzalv.zzr(cls));
    }
}
