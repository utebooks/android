package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzasR;
    private final Parcel zzasY;
    private final int zzasZ = 2;
    private int zzata;
    private int zzatb;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = i;
        this.zzasY = (Parcel) zzaa.zzz(parcel);
        this.zzasR = fieldMappingDictionary;
        if (this.zzasR == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzasR.zzut();
        }
        this.zzata = 2;
    }

    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzU(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(((FastJsonResponse.Field) next.getValue()).zzul()), next);
        }
        return hashMap;
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zzp.zzdu(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzc.zzk((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzc.zzl((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzq.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(i).toString());
        }
    }

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzue()) {
            case 0:
                zzb(sb, field, (Object) zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(sb, field, (Object) zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(sb, field, (Object) zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(sb, field, (Object) zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(sb, field, (Object) zza(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(sb, field, (Object) zza(field, zza.zzp(parcel, i)));
                return;
            case 6:
                zzb(sb, field, (Object) zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(sb, field, (Object) zza(field, zza.zzq(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(sb, field, (Object) zza(field, zza.zzt(parcel, i)));
                return;
            case 10:
                zzb(sb, field, (Object) zza(field, zzn(zza.zzs(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(field.zzue()).toString());
        }
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzuo()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzU = zzU(map);
        sb.append('{');
        int zzaq = zza.zzaq(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            Map.Entry entry = zzU.get(Integer.valueOf(zza.zzcj(zzap)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, (String) entry.getKey(), (FastJsonResponse.Field) entry.getValue(), parcel, zzap);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzaq) {
            throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
        }
        sb.append('}');
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzuj()) {
            sb.append("[");
            switch (field.zzue()) {
                case 0:
                    zzb.zza(sb, zza.zzw(parcel, i));
                    break;
                case 1:
                    zzb.zza(sb, (T[]) zza.zzy(parcel, i));
                    break;
                case 2:
                    zzb.zza(sb, zza.zzx(parcel, i));
                    break;
                case 3:
                    zzb.zza(sb, zza.zzz(parcel, i));
                    break;
                case 4:
                    zzb.zza(sb, zza.zzA(parcel, i));
                    break;
                case 5:
                    zzb.zza(sb, (T[]) zza.zzB(parcel, i));
                    break;
                case 6:
                    zzb.zza(sb, zza.zzv(parcel, i));
                    break;
                case 7:
                    zzb.zza(sb, zza.zzC(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzG = zza.zzG(parcel, i);
                    int length = zzG.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzG[i2].setDataPosition(0);
                        zza(sb, field.zzuq(), zzG[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzue()) {
            case 0:
                sb.append(zza.zzg(parcel, i));
                return;
            case 1:
                sb.append(zza.zzk(parcel, i));
                return;
            case 2:
                sb.append(zza.zzi(parcel, i));
                return;
            case 3:
                sb.append(zza.zzl(parcel, i));
                return;
            case 4:
                sb.append(zza.zzn(parcel, i));
                return;
            case 5:
                sb.append(zza.zzp(parcel, i));
                return;
            case 6:
                sb.append(zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zzp.zzdu(zza.zzq(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzc.zzk(zza.zzt(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzc.zzl(zza.zzt(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle zzs = zza.zzs(parcel, i);
                Set<String> keySet = zzs.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzp.zzdu(zzs.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel zzF = zza.zzF(parcel, i);
                zzF.setDataPosition(0);
                zza(sb, field.zzuq(), zzF);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzui()) {
            zzb(sb, field, (ArrayList<?>) (ArrayList) obj);
        } else {
            zza(sb, field.zzud(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzud(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzn(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzaa.zzb(this.zzasR, (Object) "Cannot convert to JSON on client side.");
        Parcel zzuv = zzuv();
        zzuv.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzasR.zzdq(this.mClassName), zzuv);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze zze = CREATOR;
        zze.zza(this, parcel, i);
    }

    public Object zzdm(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean zzdn(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzuf() {
        if (this.zzasR == null) {
            return null;
        }
        return this.zzasR.zzdq(this.mClassName);
    }

    public Parcel zzuv() {
        switch (this.zzata) {
            case 0:
                this.zzatb = com.google.android.gms.common.internal.safeparcel.zzb.zzar(this.zzasY);
                com.google.android.gms.common.internal.safeparcel.zzb.zzJ(this.zzasY, this.zzatb);
                this.zzata = 2;
                break;
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.zzJ(this.zzasY, this.zzatb);
                this.zzata = 2;
                break;
        }
        return this.zzasY;
    }

    /* access modifiers changed from: package-private */
    public FieldMappingDictionary zzuw() {
        switch (this.zzasZ) {
            case 0:
                return null;
            case 1:
                return this.zzasR;
            case 2:
                return this.zzasR;
            default:
                throw new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(this.zzasZ).toString());
        }
    }
}
