package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zze();
    private static final zza zzapm = new zza(new String[0], (String) null) {
        public zza zza(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public zza zza(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzahG;
    private final String[] zzape;
    Bundle zzapf;
    private final CursorWindow[] zzapg;
    private final Bundle zzaph;
    int[] zzapi;
    int zzapj;
    private Object zzapk;
    private boolean zzapl;

    public static class zza {
        /* access modifiers changed from: private */
        public final String[] zzape;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zzapn;
        private final String zzapo;
        private final HashMap<Object, Integer> zzapp;
        private boolean zzapq;
        private String zzapr;

        private zza(String[] strArr, String str) {
            this.zzape = (String[]) zzaa.zzz(strArr);
            this.zzapn = new ArrayList<>();
            this.zzapo = str;
            this.zzapp = new HashMap<>();
            this.zzapq = false;
            this.zzapr = null;
        }

        private int zzb(HashMap<String, Object> hashMap) {
            if (this.zzapo == null) {
                return -1;
            }
            Object obj = hashMap.get(this.zzapo);
            if (obj == null) {
                return -1;
            }
            Integer num = this.zzapp.get(obj);
            if (num != null) {
                return num.intValue();
            }
            this.zzapp.put(obj, Integer.valueOf(this.zzapn.size()));
            return -1;
        }

        public zza zza(ContentValues contentValues) {
            com.google.android.gms.common.internal.zzb.zzv(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zza((HashMap<String, Object>) hashMap);
        }

        public zza zza(HashMap<String, Object> hashMap) {
            com.google.android.gms.common.internal.zzb.zzv(hashMap);
            int zzb = zzb(hashMap);
            if (zzb == -1) {
                this.zzapn.add(hashMap);
            } else {
                this.zzapn.remove(zzb);
                this.zzapn.add(zzb, hashMap);
            }
            this.zzapq = false;
            return this;
        }

        public DataHolder zzbR(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzapl = true;
        this.mVersionCode = i;
        this.zzape = strArr;
        this.zzapg = cursorWindowArr;
        this.zzahG = i2;
        this.zzaph = bundle;
    }

    private DataHolder(zza zza2, int i, Bundle bundle) {
        this(zza2.zzape, zza(zza2, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzapl = true;
        this.mVersionCode = 1;
        this.zzape = (String[]) zzaa.zzz(strArr);
        this.zzapg = (CursorWindow[]) zzaa.zzz(cursorWindowArr);
        this.zzahG = i;
        this.zzaph = bundle;
        zzsT();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzapm, i, bundle);
    }

    private static CursorWindow[] zza(zza zza2, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zza2.zzape.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList zzb2 = (i < 0 || i >= zza2.zzapn.size()) ? zza2.zzapn : zza2.zzapn.subList(0, i);
        int size = zzb2.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zza2.zzape.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i3).append(")").toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza2.zzape.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zzb2.get(i3);
                boolean z3 = true;
                for (int i4 = 0; i4 < zza2.zzape.length && z3; i4++) {
                    String str = zza2.zzape[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z3 = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z3 = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z3 = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z3 = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z3 = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z3 = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        z3 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else if (obj instanceof Float) {
                        z3 = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i3, i4);
                    } else {
                        String valueOf = String.valueOf(obj);
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(valueOf).toString());
                    }
                }
                if (z3) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else if (z2) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", new StringBuilder(74).append("Couldn't populate window data for row ").append(i3).append(" - allocating new window.").toString());
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zza2.zzape.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static zza zzb(String[] strArr) {
        return new zza(strArr, (String) null);
    }

    public static DataHolder zzbQ(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzg(String str, int i) {
        if (this.zzapf == null || !this.zzapf.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzapj) {
            throw new CursorIndexOutOfBoundsException(i, this.zzapj);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzapg) {
                    close.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        String obj;
        try {
            if (this.zzapl && this.zzapg.length > 0 && !isClosed()) {
                if (this.zzapk == null) {
                    String valueOf = String.valueOf(toString());
                    obj = valueOf.length() != 0 ? "internal object: ".concat(valueOf) : new String("internal object: ");
                } else {
                    obj = this.zzapk.toString();
                }
                Log.e("DataBuffer", new StringBuilder(String.valueOf(obj).length() + 161).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(obj).append(")").toString());
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzapj;
    }

    public int getStatusCode() {
        return this.zzahG;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzapg[i2].copyStringToBuffer(i, this.zzapf.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getLong(i, this.zzapf.getInt(str));
    }

    public int zzbP(int i) {
        int i2 = 0;
        zzaa.zzai(i >= 0 && i < this.zzapj);
        while (true) {
            if (i2 >= this.zzapi.length) {
                break;
            } else if (i < this.zzapi[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.zzapi.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getInt(i, this.zzapf.getInt(str));
    }

    public boolean zzcY(String str) {
        return this.zzapf.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getString(i, this.zzapf.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzapg[i2].getLong(i, this.zzapf.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getFloat(i, this.zzapf.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getBlob(i, this.zzapf.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].isNull(i, this.zzapf.getInt(str));
    }

    public Bundle zzsO() {
        return this.zzaph;
    }

    public void zzsT() {
        this.zzapf = new Bundle();
        for (int i = 0; i < this.zzape.length; i++) {
            this.zzapf.putInt(this.zzape[i], i);
        }
        this.zzapi = new int[this.zzapg.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzapg.length; i3++) {
            this.zzapi[i3] = i2;
            i2 += this.zzapg[i3].getNumRows() - (i2 - this.zzapg[i3].getStartPosition());
        }
        this.zzapj = i2;
    }

    /* access modifiers changed from: package-private */
    public String[] zzsU() {
        return this.zzape;
    }

    /* access modifiers changed from: package-private */
    public CursorWindow[] zzsV() {
        return this.zzapg;
    }

    public void zzu(Object obj) {
        this.zzapk = obj;
    }
}
