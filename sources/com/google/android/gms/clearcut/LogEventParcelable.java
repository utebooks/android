package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.internal.zzamo;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int versionCode;
    public PlayLoggerContext zzajL;
    public byte[] zzajM;
    public int[] zzajN;
    public final zzamo.zzd zzajO;
    public final zzb.C0751zzb zzajP;
    public final zzb.C0751zzb zzajQ;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.versionCode = i;
        this.zzajL = playLoggerContext;
        this.zzajM = bArr;
        this.zzajN = iArr;
        this.zzajO = null;
        this.zzajP = null;
        this.zzajQ = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzamo.zzd zzd, zzb.C0751zzb zzb, zzb.C0751zzb zzb2, int[] iArr) {
        this.versionCode = 1;
        this.zzajL = playLoggerContext;
        this.zzajO = zzd;
        this.zzajP = zzb;
        this.zzajQ = zzb2;
        this.zzajN = iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzz.equal(this.zzajL, logEventParcelable.zzajL) && Arrays.equals(this.zzajM, logEventParcelable.zzajM) && Arrays.equals(this.zzajN, logEventParcelable.zzajN) && zzz.equal(this.zzajO, logEventParcelable.zzajO) && zzz.equal(this.zzajP, logEventParcelable.zzajP) && zzz.equal(this.zzajQ, logEventParcelable.zzajQ);
    }

    public int hashCode() {
        return zzz.hashCode(Integer.valueOf(this.versionCode), this.zzajL, this.zzajM, this.zzajN, this.zzajO, this.zzajP, this.zzajQ);
    }

    public String toString() {
        String str = null;
        StringBuilder append = new StringBuilder("LogEventParcelable[").append(this.versionCode).append(", ").append(this.zzajL).append(", ").append("LogEventBytes: ").append(this.zzajM == null ? null : new String(this.zzajM)).append(", ").append("TestCodes: ");
        if (this.zzajN != null) {
            str = zzx.zzdk(", ").zza(Arrays.asList(new int[][]{this.zzajN}));
        }
        return append.append(str).append(", ").append("LogEvent: ").append(this.zzajO).append(", ").append("ExtensionProducer: ").append(this.zzajP).append(", ").append("VeProducer: ").append(this.zzajQ).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
