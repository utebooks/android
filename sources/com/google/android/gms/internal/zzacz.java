package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.ProviderUserInfo;
import com.google.firebase.auth.api.model.ProviderUserInfoList;
import java.io.IOException;
import java.util.List;

public class zzacz extends zzakr<ProviderUserInfoList> {
    private zzajz zzbFd;

    public void zza(@NonNull zzajz zzajz) {
        this.zzbFd = (zzajz) zzaa.zzz(zzajz);
    }

    public void zza(zzaly zzaly, ProviderUserInfoList providerUserInfoList) throws IOException {
        if (providerUserInfoList == null) {
            zzaly.zzWk();
            return;
        }
        zzakr<ProviderUserInfo> zzk = this.zzbFd.zzk(ProviderUserInfo.class);
        zzaly.zzWg();
        List<ProviderUserInfo> zzOD = providerUserInfoList.zzOD();
        int size = zzOD != null ? zzOD.size() : 0;
        for (int i = 0; i < size; i++) {
            zzk.zza(zzaly, zzOD.get(i));
        }
        zzaly.zzWh();
    }

    /* renamed from: zzc */
    public ProviderUserInfoList zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() == zzalx.NULL) {
            zzalw.nextNull();
            return null;
        }
        ProviderUserInfoList providerUserInfoList = new ProviderUserInfoList();
        zzakr<ProviderUserInfo> zzk = this.zzbFd.zzk(ProviderUserInfo.class);
        zzalw.beginArray();
        while (zzalw.hasNext()) {
            providerUserInfoList.zzOD().add(zzk.zzb(zzalw));
        }
        zzalw.endArray();
        return providerUserInfoList;
    }
}
