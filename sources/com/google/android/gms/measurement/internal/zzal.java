package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zzal extends zzz {
    zzal(zzx zzx) {
        super(zzx);
    }

    public static boolean zzK(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    public static boolean zzZ(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    private Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(zzsn.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzb.zzbgm);
        zza(sb, 0, "event_name", (Object) zzb.zzbgn);
        zza(sb, 1, "event_count_filter", zzb.zzbgq);
        sb.append("  filters {\n");
        for (zzsn.zzc zza : zzb.zzbgo) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public static String zza(zzsn.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zze.zzbgm);
        zza(sb, 0, "property_name", (Object) zze.zzbgC);
        zza(sb, 1, zze.zzbgD);
        sb.append("}\n");
        return sb.toString();
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, zzsn.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzc.zzbgu);
            zza(sb, i, "param_name", (Object) zzc.zzbgv);
            zza(sb, i + 1, "string_filter", zzc.zzbgs);
            zza(sb, i + 1, "number_filter", zzc.zzbgt);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, zzsp.zze zze) {
        if (zze != null) {
            zza(sb, i);
            sb.append("bundle {\n");
            zza(sb, i, "protocol_version", (Object) zze.zzbhd);
            zza(sb, i, "platform", (Object) zze.zzbhl);
            zza(sb, i, "gmp_version", (Object) zze.zzbhp);
            zza(sb, i, "uploading_gmp_version", (Object) zze.zzbhq);
            zza(sb, i, "gmp_app_id", (Object) zze.zzbbK);
            zza(sb, i, "app_id", (Object) zze.appId);
            zza(sb, i, "app_version", (Object) zze.zzaUf);
            zza(sb, i, "app_version_major", (Object) zze.zzbhy);
            zza(sb, i, "firebase_instance_id", (Object) zze.zzbbS);
            zza(sb, i, "dev_cert_hash", (Object) zze.zzbhu);
            zza(sb, i, "app_store", (Object) zze.zzbbL);
            zza(sb, i, "upload_timestamp_millis", (Object) zze.zzbhg);
            zza(sb, i, "start_timestamp_millis", (Object) zze.zzbhh);
            zza(sb, i, "end_timestamp_millis", (Object) zze.zzbhi);
            zza(sb, i, "previous_bundle_start_timestamp_millis", (Object) zze.zzbhj);
            zza(sb, i, "previous_bundle_end_timestamp_millis", (Object) zze.zzbhk);
            zza(sb, i, "app_instance_id", (Object) zze.zzbht);
            zza(sb, i, "resettable_device_id", (Object) zze.zzbhr);
            zza(sb, i, "device_id", (Object) zze.zzbhB);
            zza(sb, i, "limited_ad_tracking", (Object) zze.zzbhs);
            zza(sb, i, "os_version", (Object) zze.osVersion);
            zza(sb, i, "device_model", (Object) zze.zzbhm);
            zza(sb, i, "user_default_language", (Object) zze.zzbhn);
            zza(sb, i, "time_zone_offset_minutes", (Object) zze.zzbho);
            zza(sb, i, "bundle_sequential_index", (Object) zze.zzbhv);
            zza(sb, i, "service_upload", (Object) zze.zzbhw);
            zza(sb, i, "health_monitor", (Object) zze.zzbbO);
            zza(sb, i, zze.zzbhf);
            zza(sb, i, zze.zzbhx);
            zza(sb, i, zze.zzbhe);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzsn.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zzbgw != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzd.zzbgw.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzd.zzbgx);
            zza(sb, i, "comparison_value", (Object) zzd.zzbgy);
            zza(sb, i, "min_comparison_value", (Object) zzd.zzbgz);
            zza(sb, i, "max_comparison_value", (Object) zzd.zzbgA);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzsn.zzf zzf) {
        if (zzf != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.zzbgE != null) {
                String str2 = "UNKNOWN_MATCH_TYPE";
                switch (zzf.zzbgE.intValue()) {
                    case 1:
                        str2 = "REGEXP";
                        break;
                    case 2:
                        str2 = "BEGINS_WITH";
                        break;
                    case 3:
                        str2 = "ENDS_WITH";
                        break;
                    case 4:
                        str2 = "PARTIAL";
                        break;
                    case 5:
                        str2 = "EXACT";
                        break;
                    case 6:
                        str2 = "IN_LIST";
                        break;
                }
                zza(sb, i, "match_type", (Object) str2);
            }
            zza(sb, i, "expression", (Object) zzf.zzbgF);
            zza(sb, i, "case_sensitive", (Object) zzf.zzbgG);
            if (zzf.zzbgH.length > 0) {
                zza(sb, i + 1);
                sb.append("expression_list {\n");
                for (String append : zzf.zzbgH) {
                    zza(sb, i + 2);
                    sb.append(append);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzsp.zzf zzf) {
        int i2 = 0;
        if (zzf != null) {
            int i3 = i + 1;
            zza(sb, i3);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.zzbhD != null) {
                zza(sb, i3 + 1);
                sb.append("results: ");
                long[] jArr = zzf.zzbhD;
                int length = jArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Long valueOf = Long.valueOf(jArr[i4]);
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i4++;
                    i5 = i6;
                }
                sb.append(10);
            }
            if (zzf.zzbhC != null) {
                zza(sb, i3 + 1);
                sb.append("status: ");
                long[] jArr2 = zzf.zzbhC;
                int length2 = jArr2.length;
                int i7 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i8 = i7 + 1;
                    if (i7 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i7 = i8;
                }
                sb.append(10);
            }
            zza(sb, i3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static void zza(StringBuilder sb, int i, zzsp.zza[] zzaArr) {
        if (zzaArr != null) {
            int i2 = i + 1;
            for (zzsp.zza zza : zzaArr) {
                if (zza != null) {
                    zza(sb, i2);
                    sb.append("audience_membership {\n");
                    zza(sb, i2, "audience_id", (Object) zza.zzbgi);
                    zza(sb, i2, "new_audience", (Object) zza.zzbgU);
                    zza(sb, i2, "current_data", zza.zzbgS);
                    zza(sb, i2, "previous_data", zza.zzbgT);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzsp.zzb[] zzbArr) {
        if (zzbArr != null) {
            int i2 = i + 1;
            for (zzsp.zzb zzb : zzbArr) {
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("event {\n");
                    zza(sb, i2, "name", (Object) zzb.name);
                    zza(sb, i2, "timestamp_millis", (Object) zzb.zzbgX);
                    zza(sb, i2, "previous_timestamp_millis", (Object) zzb.zzbgY);
                    zza(sb, i2, "count", (Object) zzb.count);
                    zza(sb, i2, zzb.zzbgW);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzsp.zzc[] zzcArr) {
        if (zzcArr != null) {
            int i2 = i + 1;
            for (zzsp.zzc zzc : zzcArr) {
                if (zzc != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    zza(sb, i2, "name", (Object) zzc.name);
                    zza(sb, i2, "string_value", (Object) zzc.zzasH);
                    zza(sb, i2, "int_value", (Object) zzc.zzbha);
                    zza(sb, i2, "double_value", (Object) zzc.zzbgf);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzsp.zzg[] zzgArr) {
        if (zzgArr != null) {
            int i2 = i + 1;
            for (zzsp.zzg zzg : zzgArr) {
                if (zzg != null) {
                    zza(sb, i2);
                    sb.append("user_property {\n");
                    zza(sb, i2, "set_timestamp_millis", (Object) zzg.zzbhF);
                    zza(sb, i2, "name", (Object) zzg.name);
                    zza(sb, i2, "string_value", (Object) zzg.zzasH);
                    zza(sb, i2, "int_value", (Object) zzg.zzbha);
                    zza(sb, i2, "double_value", (Object) zzg.zzbgf);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String zzb(zzsp.zzd zzd) {
        if (zzd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzd.zzbhb != null) {
            for (zzsp.zze zze : zzd.zzbhb) {
                if (zze != null) {
                    zza(sb, 1, zze);
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static boolean zzb(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            return receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    static MessageDigest zzbZ(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    static boolean zzfG(String str) {
        zzaa.zzdl(str);
        return str.charAt(0) != '_';
    }

    private int zzfP(String str) {
        return "_ldl".equals(str) ? zzFo().zzEC() : zzFo().zzEB();
    }

    public static boolean zzfQ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzj(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    static long zzs(byte[] bArr) {
        int i = 0;
        zzaa.zzz(bArr);
        zzaa.zzai(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzFb() {
        super.zzFb();
    }

    public /* bridge */ /* synthetic */ zzc zzFc() {
        return super.zzFc();
    }

    public /* bridge */ /* synthetic */ zzac zzFd() {
        return super.zzFd();
    }

    public /* bridge */ /* synthetic */ zzn zzFe() {
        return super.zzFe();
    }

    public /* bridge */ /* synthetic */ zzg zzFf() {
        return super.zzFf();
    }

    public /* bridge */ /* synthetic */ zzad zzFg() {
        return super.zzFg();
    }

    public /* bridge */ /* synthetic */ zze zzFh() {
        return super.zzFh();
    }

    public /* bridge */ /* synthetic */ zzal zzFi() {
        return super.zzFi();
    }

    public /* bridge */ /* synthetic */ zzv zzFj() {
        return super.zzFj();
    }

    public /* bridge */ /* synthetic */ zzaf zzFk() {
        return super.zzFk();
    }

    public /* bridge */ /* synthetic */ zzw zzFl() {
        return super.zzFl();
    }

    public /* bridge */ /* synthetic */ zzp zzFm() {
        return super.zzFm();
    }

    public /* bridge */ /* synthetic */ zzt zzFn() {
        return super.zzFn();
    }

    public /* bridge */ /* synthetic */ zzd zzFo() {
        return super.zzFo();
    }

    /* access modifiers changed from: package-private */
    public boolean zzX(String str, String str2) {
        if (str2 == null) {
            zzFm().zzFE().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzFm().zzFE().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else if (!Character.isLetter(str2.charAt(0))) {
            zzFm().zzFE().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        } else {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    zzFm().zzFE().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzY(String str, String str2) {
        if (str2 == null) {
            zzFm().zzFE().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzFm().zzFE().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        zzFm().zzFE().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzFm().zzFE().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z) {
        int i;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int zzEv = zzFo().zzEv();
        int i2 = 0;
        for (String str2 : bundle.keySet()) {
            if (list == null || !list.contains(str2)) {
                i = z ? zzfL(str2) : 0;
                if (i == 0) {
                    i = zzfM(str2);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                if (zzb(bundle2, i)) {
                    bundle2.putString("_ev", zza(str2, zzFo().zzEy(), true));
                }
                bundle2.remove(str2);
            } else if (!zzk(str2, bundle.get(str2)) && !"_ev".equals(str2)) {
                if (zzb(bundle2, 4)) {
                    bundle2.putString("_ev", zza(str2, zzFo().zzEy(), true));
                }
                bundle2.remove(str2);
            } else if (!zzfG(str2) || (i2 = i2 + 1) <= zzEv) {
                i2 = i2;
            } else {
                zzFm().zzFE().zze(new StringBuilder(48).append("Event can't contain more then ").append(zzEv).append(" params").toString(), str, bundle);
                zzb(bundle2, 5);
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String zza(String str, int i, boolean z) {
        if (str.length() <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, i)).concat("...");
        }
        return null;
    }

    public void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzFm().zzFI().zze("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void zza(zzsp.zzc zzc, Object obj) {
        zzaa.zzz(obj);
        zzc.zzasH = null;
        zzc.zzbha = null;
        zzc.zzbgf = null;
        if (obj instanceof String) {
            zzc.zzasH = (String) obj;
        } else if (obj instanceof Long) {
            zzc.zzbha = (Long) obj;
        } else if (obj instanceof Double) {
            zzc.zzbgf = (Double) obj;
        } else {
            zzFm().zzFE().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zzsp.zzg zzg, Object obj) {
        zzaa.zzz(obj);
        zzg.zzasH = null;
        zzg.zzbha = null;
        zzg.zzbgf = null;
        if (obj instanceof String) {
            zzg.zzasH = (String) obj;
        } else if (obj instanceof Long) {
            zzg.zzbha = (Long) obj;
        } else if (obj instanceof Double) {
            zzg.zzbgf = (Double) obj;
        } else {
            zzFm().zzFE().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zza(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        zzFm().zzFG().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    public byte[] zza(zzsp.zzd zzd) {
        try {
            byte[] bArr = new byte[zzd.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zzd.writeTo(zzO);
            zzO.zzWU();
            return bArr;
        } catch (IOException e) {
            zzFm().zzFE().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public boolean zzb(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    public boolean zzbN(String str) {
        zzkN();
        if (getContext().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzFm().zzFK().zzj("Permission not granted", str);
        return false;
    }

    public boolean zzc(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzlQ().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(String str, int i, String str2) {
        if (str2 == null) {
            zzFm().zzFE().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            zzFm().zzFE().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            zzFm().zzFE().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            zzFm().zzFE().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            zzFm().zzFE().zze("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public void zze(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        zzb(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.zzbbl.zzFd().zze("auto", "_err", bundle);
    }

    public int zzfH(String str) {
        if (!zzX("event", str)) {
            return 2;
        }
        if (!zzc("event", AppMeasurement.zza.zzbbm, str)) {
            return 13;
        }
        return zzc("event", zzFo().zzEw(), str) ? 0 : 2;
    }

    public int zzfI(String str) {
        if (!zzY("event", str)) {
            return 2;
        }
        if (!zzc("event", AppMeasurement.zza.zzbbm, str)) {
            return 13;
        }
        return zzc("event", zzFo().zzEw(), str) ? 0 : 2;
    }

    public int zzfJ(String str) {
        if (!zzX("user property", str)) {
            return 6;
        }
        if (!zzc("user property", AppMeasurement.zze.zzbbo, str)) {
            return 15;
        }
        return zzc("user property", zzFo().zzEx(), str) ? 0 : 6;
    }

    public int zzfK(String str) {
        if (!zzY("user property", str)) {
            return 6;
        }
        if (!zzc("user property", AppMeasurement.zze.zzbbo, str)) {
            return 15;
        }
        return zzc("user property", zzFo().zzEx(), str) ? 0 : 6;
    }

    public int zzfL(String str) {
        if (!zzX("event param", str)) {
            return 3;
        }
        if (!zzc("event param", (Map<String, String>) null, str)) {
            return 14;
        }
        return zzc("event param", zzFo().zzEy(), str) ? 0 : 3;
    }

    public int zzfM(String str) {
        if (!zzY("event param", str)) {
            return 3;
        }
        if (!zzc("event param", (Map<String, String>) null, str)) {
            return 14;
        }
        return zzc("event param", zzFo().zzEy(), str) ? 0 : 3;
    }

    public boolean zzfN(String str) {
        if (TextUtils.isEmpty(str)) {
            zzFm().zzFE().log("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            zzFm().zzFG().zzj("Measurement Service called with unknown id version", str);
            return true;
        } else if (zzfO(str)) {
            return true;
        } else {
            zzFm().zzFE().zzj("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzfO(String str) {
        zzaa.zzz(str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public byte[] zzh(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzFm().zzFE().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public boolean zzk(String str, Object obj) {
        return zzfQ(str) ? zza("param", str, zzFo().zzEA(), obj) : zza("param", str, zzFo().zzEz(), obj);
    }

    public /* bridge */ /* synthetic */ void zzkN() {
        super.zzkN();
    }

    public Object zzl(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zza(zzFo().zzEA(), obj, true);
        }
        return zza(zzfQ(str) ? zzFo().zzEA() : zzFo().zzEz(), obj, false);
    }

    public /* bridge */ /* synthetic */ void zzlP() {
        super.zzlP();
    }

    public /* bridge */ /* synthetic */ zze zzlQ() {
        return super.zzlQ();
    }

    public int zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzfP(str), obj) : zza("user property", str, zzfP(str), obj) ? 0 : 7;
    }

    public Object zzn(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzfP(str), obj, true) : zza(zzfP(str), obj, false);
    }

    public byte[] zzr(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            zzFm().zzFE().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public long zzt(byte[] bArr) {
        zzaa.zzz(bArr);
        MessageDigest zzbZ = zzbZ("MD5");
        if (zzbZ != null) {
            return zzs(zzbZ.digest(bArr));
        }
        zzFm().zzFE().log("Failed to get MD5");
        return 0;
    }
}
