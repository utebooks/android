package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.StringList;
import java.io.IOException;
import java.util.List;

public class zzada extends zzakr<StringList> {
    private zzajz zzbFd;

    public void zza(@NonNull zzajz zzajz) {
        this.zzbFd = (zzajz) zzaa.zzz(zzajz);
    }

    public void zza(zzaly zzaly, StringList stringList) throws IOException {
        if (stringList == null) {
            zzaly.zzWk();
            return;
        }
        zzakr<String> zzk = this.zzbFd.zzk(String.class);
        zzaly.zzWg();
        List<String> zzOM = stringList.zzOM();
        int size = zzOM != null ? zzOM.size() : 0;
        for (int i = 0; i < size; i++) {
            zzk.zza(zzaly, zzOM.get(i));
        }
        zzaly.zzWh();
    }

    /* renamed from: zzd */
    public StringList zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() == zzalx.NULL) {
            zzalw.nextNull();
            return null;
        }
        StringList stringList = new StringList();
        zzakr<String> zzk = this.zzbFd.zzk(String.class);
        zzalw.beginArray();
        while (zzalw.hasNext()) {
            stringList.zzOM().add(zzk.zzb(zzalw));
        }
        zzalw.endArray();
        return stringList;
    }
}
