package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class zzc extends zzaa {
    zzc(zzx zzx) {
        super(zzx);
    }

    private Boolean zza(zzsn.zzb zzb, zzsp.zzb zzb2, long j) {
        if (zzb.zzbgq != null) {
            Boolean zzah = new zzs(zzb.zzbgq).zzah(j);
            if (zzah == null) {
                return null;
            }
            if (!zzah.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzsn.zzc zzc : zzb.zzbgo) {
            if (TextUtils.isEmpty(zzc.zzbgv)) {
                zzFm().zzFG().zzj("null or empty param name in filter. event", zzb2.name);
                return null;
            }
            hashSet.add(zzc.zzbgv);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzsp.zzc zzc2 : zzb2.zzbgW) {
            if (hashSet.contains(zzc2.name)) {
                if (zzc2.zzbha != null) {
                    arrayMap.put(zzc2.name, zzc2.zzbha);
                } else if (zzc2.zzbgf != null) {
                    arrayMap.put(zzc2.name, zzc2.zzbgf);
                } else if (zzc2.zzasH != null) {
                    arrayMap.put(zzc2.name, zzc2.zzasH);
                } else {
                    zzFm().zzFG().zze("Unknown value for param. event, param", zzb2.name, zzc2.name);
                    return null;
                }
            }
        }
        for (zzsn.zzc zzc3 : zzb.zzbgo) {
            boolean equals = Boolean.TRUE.equals(zzc3.zzbgu);
            String str = zzc3.zzbgv;
            if (TextUtils.isEmpty(str)) {
                zzFm().zzFG().zzj("Event has empty param name. event", zzb2.name);
                return null;
            }
            Object obj = arrayMap.get(str);
            if (obj instanceof Long) {
                if (zzc3.zzbgt == null) {
                    zzFm().zzFG().zze("No number filter for long param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzah2 = new zzs(zzc3.zzbgt).zzah(((Long) obj).longValue());
                if (zzah2 == null) {
                    return null;
                }
                if ((!zzah2.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (zzc3.zzbgt == null) {
                    zzFm().zzFG().zze("No number filter for double param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzk = new zzs(zzc3.zzbgt).zzk(((Double) obj).doubleValue());
                if (zzk == null) {
                    return null;
                }
                if ((!zzk.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (zzc3.zzbgs == null) {
                    zzFm().zzFG().zze("No string filter for String param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzfF = new zzag(zzc3.zzbgs).zzfF((String) obj);
                if (zzfF == null) {
                    return null;
                }
                if ((!zzfF.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj == null) {
                zzFm().zzFL().zze("Missing param for filter. event, param", zzb2.name, str);
                return false;
            } else {
                zzFm().zzFG().zze("Unknown param type. event, param", zzb2.name, str);
                return null;
            }
        }
        return true;
    }

    private Boolean zza(zzsn.zze zze, zzsp.zzg zzg) {
        zzsn.zzc zzc = zze.zzbgD;
        if (zzc == null) {
            zzFm().zzFG().zzj("Missing property filter. property", zzg.name);
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzc.zzbgu);
        if (zzg.zzbha != null) {
            if (zzc.zzbgt != null) {
                return zza(new zzs(zzc.zzbgt).zzah(zzg.zzbha.longValue()), equals);
            }
            zzFm().zzFG().zzj("No number filter for long property. property", zzg.name);
            return null;
        } else if (zzg.zzbgf != null) {
            if (zzc.zzbgt != null) {
                return zza(new zzs(zzc.zzbgt).zzk(zzg.zzbgf.doubleValue()), equals);
            }
            zzFm().zzFG().zzj("No number filter for double property. property", zzg.name);
            return null;
        } else if (zzg.zzasH == null) {
            zzFm().zzFG().zzj("User property has no value, property", zzg.name);
            return null;
        } else if (zzc.zzbgs != null) {
            return zza(new zzag(zzc.zzbgs).zzfF(zzg.zzasH), equals);
        } else {
            if (zzc.zzbgt == null) {
                zzFm().zzFG().zzj("No string or number filter defined. property", zzg.name);
                return null;
            }
            zzs zzs = new zzs(zzc.zzbgt);
            if (zzc.zzbgt.zzbgx == null || !zzc.zzbgt.zzbgx.booleanValue()) {
                if (zzfa(zzg.zzasH)) {
                    try {
                        return zza(zzs.zzah(Long.parseLong(zzg.zzasH)), equals);
                    } catch (NumberFormatException e) {
                        zzFm().zzFG().zze("User property value exceeded Long value range. property, value", zzg.name, zzg.zzasH);
                        return null;
                    }
                } else {
                    zzFm().zzFG().zze("Invalid user property value for Long number filter. property, value", zzg.name, zzg.zzasH);
                    return null;
                }
            } else if (zzfb(zzg.zzasH)) {
                try {
                    double parseDouble = Double.parseDouble(zzg.zzasH);
                    if (!Double.isInfinite(parseDouble)) {
                        return zza(zzs.zzk(parseDouble), equals);
                    }
                    zzFm().zzFG().zze("User property value exceeded Double value range. property, value", zzg.name, zzg.zzasH);
                    return null;
                } catch (NumberFormatException e2) {
                    zzFm().zzFG().zze("User property value exceeded Double value range. property, value", zzg.name, zzg.zzasH);
                    return null;
                }
            } else {
                zzFm().zzFG().zze("Invalid user property value for Double number filter. property, value", zzg.name, zzg.zzasH);
                return null;
            }
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zza(String str, zzsn.zza[] zzaArr) {
        zzaa.zzz(zzaArr);
        for (zzsn.zza zza : zzaArr) {
            for (zzsn.zzb zzb : zza.zzbgk) {
                String str2 = AppMeasurement.zza.zzbbm.get(zzb.zzbgn);
                if (str2 != null) {
                    zzb.zzbgn = str2;
                }
                for (zzsn.zzc zzc : zzb.zzbgo) {
                    String str3 = AppMeasurement.zzd.zzbbn.get(zzc.zzbgv);
                    if (str3 != null) {
                        zzc.zzbgv = str3;
                    }
                }
            }
            for (zzsn.zze zze : zza.zzbgj) {
                String str4 = AppMeasurement.zze.zzbbo.get(zze.zzbgC);
                if (str4 != null) {
                    zze.zzbgC = str4;
                }
            }
        }
        zzFh().zzb(str, zzaArr);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public zzsp.zza[] zza(String str, zzsp.zzb[] zzbArr, zzsp.zzg[] zzgArr) {
        Map map;
        zzsn.zze zze;
        zzi zzFA;
        Map map2;
        zzaa.zzdl(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map<Integer, zzsp.zzf> zzfo = zzFh().zzfo(str);
        if (zzfo != null) {
            for (Integer intValue : zzfo.keySet()) {
                int intValue2 = intValue.intValue();
                zzsp.zzf zzf = zzfo.get(Integer.valueOf(intValue2));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue2));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue2));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue2), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue2), bitSet2);
                }
                for (int i = 0; i < zzf.zzbhC.length * 64; i++) {
                    if (zzal.zza(zzf.zzbhC, i)) {
                        zzFm().zzFL().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzal.zza(zzf.zzbhD, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzsp.zza zza = new zzsp.zza();
                arrayMap.put(Integer.valueOf(intValue2), zza);
                zza.zzbgU = false;
                zza.zzbgT = zzf;
                zza.zzbgS = new zzsp.zzf();
                zza.zzbgS.zzbhD = zzal.zza(bitSet);
                zza.zzbgS.zzbhC = zzal.zza(bitSet2);
            }
        }
        if (zzbArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzbArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                zzsp.zzb zzb = zzbArr[i3];
                zzi zzO = zzFh().zzO(str, zzb.name);
                if (zzO == null) {
                    zzFm().zzFG().zzj("Event aggregate wasn't created during raw event logging. event", zzb.name);
                    zzFA = new zzi(str, zzb.name, 1, 1, zzb.zzbgX.longValue());
                } else {
                    zzFA = zzO.zzFA();
                }
                zzFh().zza(zzFA);
                long j = zzFA.zzbck;
                Map map3 = (Map) arrayMap4.get(zzb.name);
                if (map3 == null) {
                    Map zzR = zzFh().zzR(str, zzb.name);
                    if (zzR == null) {
                        zzR = new ArrayMap();
                    }
                    arrayMap4.put(zzb.name, zzR);
                    map2 = zzR;
                } else {
                    map2 = map3;
                }
                zzFm().zzFL().zze("event, affected audience count", zzb.name, Integer.valueOf(map2.size()));
                for (Integer intValue3 : map2.keySet()) {
                    int intValue4 = intValue3.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        zzFm().zzFL().zzj("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        zzsp.zza zza2 = (zzsp.zza) arrayMap.get(Integer.valueOf(intValue4));
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(intValue4));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(intValue4));
                        if (zza2 == null) {
                            zzsp.zza zza3 = new zzsp.zza();
                            arrayMap.put(Integer.valueOf(intValue4), zza3);
                            zza3.zzbgU = true;
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue4), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue4), bitSet4);
                        }
                        for (zzsn.zzb zzb2 : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (zzFm().zzX(2)) {
                                zzFm().zzFL().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue4), zzb2.zzbgm, zzb2.zzbgn);
                                zzFm().zzFL().zzj("Filter definition", zzal.zza(zzb2));
                            }
                            if (zzb2.zzbgm == null || zzb2.zzbgm.intValue() > 256) {
                                zzFm().zzFG().zzj("Invalid event filter ID. id", String.valueOf(zzb2.zzbgm));
                            } else if (bitSet3.get(zzb2.zzbgm.intValue())) {
                                zzFm().zzFL().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), zzb2.zzbgm);
                            } else {
                                Boolean zza4 = zza(zzb2, zzb, j);
                                zzFm().zzFL().zzj("Event filter result", zza4 == null ? "null" : zza4);
                                if (zza4 == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet4.set(zzb2.zzbgm.intValue());
                                    if (zza4.booleanValue()) {
                                        bitSet3.set(zzb2.zzbgm.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        if (zzgArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzsp.zzg zzg : zzgArr) {
                Map map4 = (Map) arrayMap5.get(zzg.name);
                if (map4 == null) {
                    Map zzS = zzFh().zzS(str, zzg.name);
                    if (zzS == null) {
                        zzS = new ArrayMap();
                    }
                    arrayMap5.put(zzg.name, zzS);
                    map = zzS;
                } else {
                    map = map4;
                }
                zzFm().zzFL().zze("property, affected audience count", zzg.name, Integer.valueOf(map.size()));
                for (Integer intValue5 : map.keySet()) {
                    int intValue6 = intValue5.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue6))) {
                        zzFm().zzFL().zzj("Skipping failed audience ID", Integer.valueOf(intValue6));
                    } else {
                        zzsp.zza zza5 = (zzsp.zza) arrayMap.get(Integer.valueOf(intValue6));
                        BitSet bitSet5 = (BitSet) arrayMap2.get(Integer.valueOf(intValue6));
                        BitSet bitSet6 = (BitSet) arrayMap3.get(Integer.valueOf(intValue6));
                        if (zza5 == null) {
                            zzsp.zza zza6 = new zzsp.zza();
                            arrayMap.put(Integer.valueOf(intValue6), zza6);
                            zza6.zzbgU = true;
                            bitSet5 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue6), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue6), bitSet6);
                        }
                        Iterator it = ((List) map.get(Integer.valueOf(intValue6))).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zze = (zzsn.zze) it.next();
                            if (zzFm().zzX(2)) {
                                zzFm().zzFL().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue6), zze.zzbgm, zze.zzbgC);
                                zzFm().zzFL().zzj("Filter definition", zzal.zza(zze));
                            }
                            if (zze.zzbgm == null || zze.zzbgm.intValue() > 256) {
                                zzFm().zzFG().zzj("Invalid property filter ID. id", String.valueOf(zze.zzbgm));
                                hashSet.add(Integer.valueOf(intValue6));
                            } else if (bitSet5.get(zze.zzbgm.intValue())) {
                                zzFm().zzFL().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue6), zze.zzbgm);
                            } else {
                                Boolean zza7 = zza(zze, zzg);
                                zzFm().zzFL().zzj("Property filter result", zza7 == null ? "null" : zza7);
                                if (zza7 == null) {
                                    hashSet.add(Integer.valueOf(intValue6));
                                } else {
                                    bitSet6.set(zze.zzbgm.intValue());
                                    if (zza7.booleanValue()) {
                                        bitSet5.set(zze.zzbgm.intValue());
                                    }
                                }
                            }
                        }
                        zzFm().zzFG().zzj("Invalid property filter ID. id", String.valueOf(zze.zzbgm));
                        hashSet.add(Integer.valueOf(intValue6));
                    }
                }
            }
        }
        zzsp.zza[] zzaArr = new zzsp.zza[arrayMap2.size()];
        int i4 = 0;
        for (Integer intValue7 : arrayMap2.keySet()) {
            int intValue8 = intValue7.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue8))) {
                zzsp.zza zza8 = (zzsp.zza) arrayMap.get(Integer.valueOf(intValue8));
                if (zza8 == null) {
                    zza8 = new zzsp.zza();
                }
                zzsp.zza zza9 = zza8;
                zzaArr[i4] = zza9;
                zza9.zzbgi = Integer.valueOf(intValue8);
                zza9.zzbgS = new zzsp.zzf();
                zza9.zzbgS.zzbhD = zzal.zza((BitSet) arrayMap2.get(Integer.valueOf(intValue8)));
                zza9.zzbgS.zzbhC = zzal.zza((BitSet) arrayMap3.get(Integer.valueOf(intValue8)));
                zzFh().zza(str, intValue8, zza9.zzbgS);
                i4++;
            }
        }
        return (zzsp.zza[]) Arrays.copyOf(zzaArr, i4);
    }

    /* access modifiers changed from: package-private */
    public boolean zzfa(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    /* access modifiers changed from: package-private */
    public boolean zzfb(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    /* access modifiers changed from: protected */
    public void zzkO() {
    }
}
