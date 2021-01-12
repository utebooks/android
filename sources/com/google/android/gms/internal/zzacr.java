package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetAccountInfoUserList;
import java.io.IOException;
import java.util.List;

public class zzacr extends zzakr<GetAccountInfoUserList> {
    private zzajz zzbFd;

    /* renamed from: zza */
    public GetAccountInfoUserList zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() == zzalx.NULL) {
            zzalw.nextNull();
            return null;
        }
        GetAccountInfoUserList getAccountInfoUserList = new GetAccountInfoUserList();
        zzakr<GetAccountInfoUser> zzk = this.zzbFd.zzk(GetAccountInfoUser.class);
        zzalw.beginArray();
        while (zzalw.hasNext()) {
            getAccountInfoUserList.zzOF().add(zzk.zzb(zzalw));
        }
        zzalw.endArray();
        return getAccountInfoUserList;
    }

    public void zza(@NonNull zzajz zzajz) {
        this.zzbFd = (zzajz) zzaa.zzz(zzajz);
    }

    public void zza(zzaly zzaly, GetAccountInfoUserList getAccountInfoUserList) throws IOException {
        if (getAccountInfoUserList == null) {
            zzaly.zzWk();
            return;
        }
        zzakr<GetAccountInfoUser> zzk = this.zzbFd.zzk(GetAccountInfoUser.class);
        zzaly.zzWg();
        List<GetAccountInfoUser> zzOF = getAccountInfoUserList.zzOF();
        int size = zzOF != null ? zzOF.size() : 0;
        for (int i = 0; i < size; i++) {
            zzk.zza(zzaly, zzOF.get(i));
        }
        zzaly.zzWh();
    }
}
