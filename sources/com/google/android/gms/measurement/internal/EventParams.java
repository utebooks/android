package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable<String> {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    /* access modifiers changed from: private */
    public final Bundle zzbcn;

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.zzbcn = bundle;
    }

    EventParams(Bundle bundle) {
        zzaa.zzz(bundle);
        this.zzbcn = bundle;
        this.versionCode = 1;
    }

    /* access modifiers changed from: package-private */
    public Object get(String str) {
        return this.zzbcn.get(str);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> zzbco = EventParams.this.zzbcn.keySet().iterator();

            public boolean hasNext() {
                return this.zzbco.hasNext();
            }

            public String next() {
                return this.zzbco.next();
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    public int size() {
        return this.zzbcn.size();
    }

    public String toString() {
        return this.zzbcn.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public Bundle zzFB() {
        return new Bundle(this.zzbcn);
    }
}
