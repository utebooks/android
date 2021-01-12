package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;

public class EmailAuthCredential extends AuthCredential {
    private String zzabx;
    private String zzacn;

    EmailAuthCredential(@NonNull String str, @NonNull String str2) {
        this.zzacn = zzaa.zzdl(str);
        this.zzabx = zzaa.zzdl(str2);
    }

    @NonNull
    public String getEmail() {
        return this.zzacn;
    }

    @NonNull
    public String getPassword() {
        return this.zzabx;
    }

    @NonNull
    public String getProvider() {
        return EmailAuthProvider.PROVIDER_ID;
    }
}
