package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzalq implements zzaks {
    private final zzakz zzbWa;
    private final zzala zzbWj;
    private final zzajy zzbWl;

    public static final class zza<T> extends zzakr<T> {
        private final zzale<T> zzbXH;
        private final Map<String, zzb> zzbYa;

        private zza(zzale<T> zzale, Map<String, zzb> map) {
            this.zzbXH = zzale;
            this.zzbYa = map;
        }

        public void zza(zzaly zzaly, T t) throws IOException {
            if (t == null) {
                zzaly.zzWk();
                return;
            }
            zzaly.zzWi();
            try {
                for (zzb next : this.zzbYa.values()) {
                    if (next.zzaO(t)) {
                        zzaly.zziT(next.name);
                        next.zza(zzaly, (Object) t);
                    }
                }
                zzaly.zzWj();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            T zzVT = this.zzbXH.zzVT();
            try {
                zzalw.beginObject();
                while (zzalw.hasNext()) {
                    zzb zzb = this.zzbYa.get(zzalw.nextName());
                    if (zzb == null || !zzb.zzbYc) {
                        zzalw.skipValue();
                    } else {
                        zzb.zza(zzalw, (Object) zzVT);
                    }
                }
                zzalw.endObject();
                return zzVT;
            } catch (IllegalStateException e) {
                throw new zzako((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static abstract class zzb {
        final String name;
        final boolean zzbYb;
        final boolean zzbYc;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.zzbYb = z;
            this.zzbYc = z2;
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzalw zzalw, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void zza(zzaly zzaly, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean zzaO(Object obj) throws IOException, IllegalAccessException;
    }

    public zzalq(zzakz zzakz, zzajy zzajy, zzala zzala) {
        this.zzbWa = zzakz;
        this.zzbWl = zzajy;
        this.zzbWj = zzala;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.google.android.gms.internal.zzall.zza(r2.zzbWa, r3, r5, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzakr<?> zza(com.google.android.gms.internal.zzajz r3, java.lang.reflect.Field r4, com.google.android.gms.internal.zzalv<?> r5) {
        /*
            r2 = this;
            java.lang.Class<com.google.android.gms.internal.zzakt> r0 = com.google.android.gms.internal.zzakt.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)
            com.google.android.gms.internal.zzakt r0 = (com.google.android.gms.internal.zzakt) r0
            if (r0 == 0) goto L_0x0013
            com.google.android.gms.internal.zzakz r1 = r2.zzbWa
            com.google.android.gms.internal.zzakr r0 = com.google.android.gms.internal.zzall.zza(r1, r3, r5, r0)
            if (r0 == 0) goto L_0x0013
        L_0x0012:
            return r0
        L_0x0013:
            com.google.android.gms.internal.zzakr r0 = r3.zza(r5)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalq.zza(com.google.android.gms.internal.zzajz, java.lang.reflect.Field, com.google.android.gms.internal.zzalv):com.google.android.gms.internal.zzakr");
    }

    private zzb zza(zzajz zzajz, Field field, String str, zzalv<?> zzalv, boolean z, boolean z2) {
        final boolean zzk = zzalf.zzk(zzalv.zzWl());
        final zzajz zzajz2 = zzajz;
        final Field field2 = field;
        final zzalv<?> zzalv2 = zzalv;
        return new zzb(str, z, z2) {
            final zzakr<?> zzbXU = zzalq.this.zza(zzajz2, field2, (zzalv<?>) zzalv2);

            /* access modifiers changed from: package-private */
            public void zza(zzalw zzalw, Object obj) throws IOException, IllegalAccessException {
                Object zzb = this.zzbXU.zzb(zzalw);
                if (zzb != null || !zzk) {
                    field2.set(obj, zzb);
                }
            }

            /* access modifiers changed from: package-private */
            public void zza(zzaly zzaly, Object obj) throws IOException, IllegalAccessException {
                new zzalt(zzajz2, this.zzbXU, zzalv2.zzWm()).zza(zzaly, field2.get(obj));
            }

            public boolean zzaO(Object obj) throws IOException, IllegalAccessException {
                return this.zzbYb && field2.get(obj) != obj;
            }
        };
    }

    static List<String> zza(zzajy zzajy, Field field) {
        zzaku zzaku = (zzaku) field.getAnnotation(zzaku.class);
        LinkedList linkedList = new LinkedList();
        if (zzaku == null) {
            linkedList.add(zzajy.zzb(field));
        } else {
            linkedList.add(zzaku.value());
            for (String add : zzaku.zzVR()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: com.google.android.gms.internal.zzalv<?>} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r20v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, com.google.android.gms.internal.zzalq.zzb> zza(com.google.android.gms.internal.zzajz r18, com.google.android.gms.internal.zzalv<?> r19, java.lang.Class r20) {
        /*
            r17 = this;
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            boolean r1 = r20.isInterface()
            if (r1 == 0) goto L_0x000d
            r1 = r10
        L_0x000c:
            return r1
        L_0x000d:
            java.lang.reflect.Type r12 = r19.zzWm()
        L_0x0011:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r0 = r20
            if (r0 == r1) goto L_0x00cd
            java.lang.reflect.Field[] r13 = r20.getDeclaredFields()
            int r14 = r13.length
            r1 = 0
            r11 = r1
        L_0x001e:
            if (r11 >= r14) goto L_0x00b5
            r3 = r13[r11]
            r1 = 1
            r0 = r17
            boolean r6 = r0.zza((java.lang.reflect.Field) r3, (boolean) r1)
            r1 = 0
            r0 = r17
            boolean r7 = r0.zza((java.lang.reflect.Field) r3, (boolean) r1)
            if (r6 != 0) goto L_0x0038
            if (r7 != 0) goto L_0x0038
        L_0x0034:
            int r1 = r11 + 1
            r11 = r1
            goto L_0x001e
        L_0x0038:
            r1 = 1
            r3.setAccessible(r1)
            java.lang.reflect.Type r1 = r19.zzWm()
            java.lang.reflect.Type r2 = r3.getGenericType()
            r0 = r20
            java.lang.reflect.Type r15 = com.google.android.gms.internal.zzaky.zza((java.lang.reflect.Type) r1, (java.lang.Class<?>) r0, (java.lang.reflect.Type) r2)
            r0 = r17
            java.util.List r16 = r0.zzc(r3)
            r8 = 0
            r1 = 0
            r9 = r1
        L_0x0053:
            int r1 = r16.size()
            if (r9 >= r1) goto L_0x007d
            r0 = r16
            java.lang.Object r4 = r0.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r9 == 0) goto L_0x0064
            r6 = 0
        L_0x0064:
            com.google.android.gms.internal.zzalv r5 = com.google.android.gms.internal.zzalv.zzl(r15)
            r1 = r17
            r2 = r18
            com.google.android.gms.internal.zzalq$zzb r1 = r1.zza(r2, r3, r4, r5, r6, r7)
            java.lang.Object r1 = r10.put(r4, r1)
            com.google.android.gms.internal.zzalq$zzb r1 = (com.google.android.gms.internal.zzalq.zzb) r1
            if (r8 != 0) goto L_0x00d0
        L_0x0078:
            int r2 = r9 + 1
            r9 = r2
            r8 = r1
            goto L_0x0053
        L_0x007d:
            if (r8 == 0) goto L_0x0034
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = java.lang.String.valueOf(r12)
            java.lang.String r3 = r8.name
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r2)
            int r5 = r5.length()
            int r5 = r5 + 37
            java.lang.String r6 = java.lang.String.valueOf(r3)
            int r6 = r6.length()
            int r5 = r5 + r6
            r4.<init>(r5)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = " declares multiple JSON fields named "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00b5:
            java.lang.reflect.Type r1 = r19.zzWm()
            java.lang.reflect.Type r2 = r20.getGenericSuperclass()
            r0 = r20
            java.lang.reflect.Type r1 = com.google.android.gms.internal.zzaky.zza((java.lang.reflect.Type) r1, (java.lang.Class<?>) r0, (java.lang.reflect.Type) r2)
            com.google.android.gms.internal.zzalv r19 = com.google.android.gms.internal.zzalv.zzl(r1)
            java.lang.Class r20 = r19.zzWl()
            goto L_0x0011
        L_0x00cd:
            r1 = r10
            goto L_0x000c
        L_0x00d0:
            r1 = r8
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalq.zza(com.google.android.gms.internal.zzajz, com.google.android.gms.internal.zzalv, java.lang.Class):java.util.Map");
    }

    static boolean zza(Field field, boolean z, zzala zzala) {
        return !zzala.zza(field.getType(), z) && !zzala.zza(field, z);
    }

    private List<String> zzc(Field field) {
        return zza(this.zzbWl, field);
    }

    public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
        Class<? super T> zzWl = zzalv.zzWl();
        if (!Object.class.isAssignableFrom(zzWl)) {
            return null;
        }
        return new zza(this.zzbWa.zzb(zzalv), zza(zzajz, (zzalv<?>) zzalv, (Class<?>) zzWl));
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.zzbWj);
    }
}
