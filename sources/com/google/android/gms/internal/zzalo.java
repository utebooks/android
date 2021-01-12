package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class zzalo implements zzaks {
    private final zzakz zzbWa;
    /* access modifiers changed from: private */
    public final boolean zzbXP;

    private final class zza<K, V> extends zzakr<Map<K, V>> {
        private final zzale<? extends Map<K, V>> zzbXH;
        private final zzakr<K> zzbXQ;
        private final zzakr<V> zzbXR;

        public zza(zzajz zzajz, Type type, zzakr<K> zzakr, Type type2, zzakr<V> zzakr2, zzale<? extends Map<K, V>> zzale) {
            this.zzbXQ = new zzalt(zzajz, zzakr, type);
            this.zzbXR = new zzalt(zzajz, zzakr2, type2);
            this.zzbXH = zzale;
        }

        private String zze(zzakf zzakf) {
            if (zzakf.zzVH()) {
                zzakl zzVL = zzakf.zzVL();
                if (zzVL.zzVO()) {
                    return String.valueOf(zzVL.zzVz());
                }
                if (zzVL.zzVN()) {
                    return Boolean.toString(zzVL.zzVE());
                }
                if (zzVL.zzVP()) {
                    return zzVL.zzVA();
                }
                throw new AssertionError();
            } else if (zzakf.zzVI()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public void zza(zzaly zzaly, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                zzaly.zzWk();
            } else if (!zzalo.this.zzbXP) {
                zzaly.zzWi();
                for (Map.Entry next : map.entrySet()) {
                    zzaly.zziT(String.valueOf(next.getKey()));
                    this.zzbXR.zza(zzaly, next.getValue());
                }
                zzaly.zzWj();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry next2 : map.entrySet()) {
                    zzakf zzaJ = this.zzbXQ.zzaJ(next2.getKey());
                    arrayList.add(zzaJ);
                    arrayList2.add(next2.getValue());
                    z = (zzaJ.zzVF() || zzaJ.zzVG()) | z;
                }
                if (z) {
                    zzaly.zzWg();
                    while (i < arrayList.size()) {
                        zzaly.zzWg();
                        zzalg.zzb((zzakf) arrayList.get(i), zzaly);
                        this.zzbXR.zza(zzaly, arrayList2.get(i));
                        zzaly.zzWh();
                        i++;
                    }
                    zzaly.zzWh();
                    return;
                }
                zzaly.zzWi();
                while (i < arrayList.size()) {
                    zzaly.zziT(zze((zzakf) arrayList.get(i)));
                    this.zzbXR.zza(zzaly, arrayList2.get(i));
                    i++;
                }
                zzaly.zzWj();
            }
        }

        /* renamed from: zzl */
        public Map<K, V> zzb(zzalw zzalw) throws IOException {
            zzalx zzWa = zzalw.zzWa();
            if (zzWa == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.zzbXH.zzVT();
            if (zzWa == zzalx.BEGIN_ARRAY) {
                zzalw.beginArray();
                while (zzalw.hasNext()) {
                    zzalw.beginArray();
                    K zzb = this.zzbXQ.zzb(zzalw);
                    if (map.put(zzb, this.zzbXR.zzb(zzalw)) != null) {
                        String valueOf = String.valueOf(zzb);
                        throw new zzako(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                    }
                    zzalw.endArray();
                }
                zzalw.endArray();
                return map;
            }
            zzalw.beginObject();
            while (zzalw.hasNext()) {
                zzalb.zzbXe.zzi(zzalw);
                K zzb2 = this.zzbXQ.zzb(zzalw);
                if (map.put(zzb2, this.zzbXR.zzb(zzalw)) != null) {
                    String valueOf2 = String.valueOf(zzb2);
                    throw new zzako(new StringBuilder(String.valueOf(valueOf2).length() + 15).append("duplicate key: ").append(valueOf2).toString());
                }
            }
            zzalw.endObject();
            return map;
        }
    }

    public zzalo(zzakz zzakz, boolean z) {
        this.zzbWa = zzakz;
        this.zzbXP = z;
    }

    private zzakr<?> zza(zzajz zzajz, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzalu.zzbYl : zzajz.zza(zzalv.zzl(type));
    }

    public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
        Type zzWm = zzalv.zzWm();
        if (!Map.class.isAssignableFrom(zzalv.zzWl())) {
            return null;
        }
        Type[] zzb = zzaky.zzb(zzWm, zzaky.zzf(zzWm));
        zzakr<?> zza2 = zza(zzajz, zzb[0]);
        zzakr<?> zza3 = zzajz.zza(zzalv.zzl(zzb[1]));
        zzale<T> zzb2 = this.zzbWa.zzb(zzalv);
        return new zza(zzajz, zzb[0], zza2, zzb[1], zza3, zzb2);
    }
}
