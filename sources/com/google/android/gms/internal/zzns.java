package com.google.android.gms.internal;

import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import java.util.Set;

public final class zzns extends zznv<zzb> {
    private int zzalM;
    private boolean zzalN;

    private void zza(ConnectionResult connectionResult) {
        ArrayMap arrayMap = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayMap.size()) {
                zza((zznq) arrayMap.keyAt(i2), connectionResult);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zza(zznq<?> zznq, ConnectionResult connectionResult) {
        synchronized (0) {
            ArrayMap arrayMap = null;
            try {
                arrayMap.put(zznq, connectionResult);
                this.zzalM--;
                if (!connectionResult.isSuccess()) {
                    this.zzalN = true;
                }
                if (this.zzalM == 0) {
                    Status status = this.zzalN ? new Status(13) : Status.zzalw;
                    ArrayMap arrayMap2 = null;
                    zzb(arrayMap2.size() == 1 ? new zza(status, (ArrayMap<zznq<?>, ConnectionResult>) null) : new zzb(status, (ArrayMap<zznq<?>, ConnectionResult>) null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set<zznq<?>> zzrC() {
        ArrayMap arrayMap = null;
        return arrayMap.keySet();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: zzw */
    public zzb zzc(Status status) {
        zzb zza;
        synchronized (0) {
            try {
                zza(new ConnectionResult(8));
                ArrayMap arrayMap = null;
                zza = arrayMap.size() == 1 ? new zza(status, (ArrayMap<zznq<?>, ConnectionResult>) null) : new zzb(status, (ArrayMap<zznq<?>, ConnectionResult>) null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }
}
