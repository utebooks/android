package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class zzade implements AuthResult {
    private zzadh zzbGe;

    public zzade(@NonNull zzadh zzadh) {
        this.zzbGe = (zzadh) zzaa.zzz(zzadh);
    }

    @Nullable
    public FirebaseUser getUser() {
        return this.zzbGe;
    }
}
