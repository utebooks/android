package com.google.android.gms.internal;

import android.support.p003v7.widget.helper.ItemTouchHelper;
import java.util.Map;

public class zzi {
    public final byte[] data;
    public final int statusCode;
    public final boolean zzA;
    public final long zzB;
    public final Map<String, String> zzz;

    public zzi(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzz = map;
        this.zzA = z;
        this.zzB = j;
    }

    public zzi(byte[] bArr, Map<String, String> map) {
        this(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false, 0);
    }
}
