package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class FacebookAuthCredential extends AuthCredential {
    private final String zzbmS;

    FacebookAuthCredential(@NonNull String str) {
        this.zzbmS = zzaa.zzdl(str);
    }

    public static VerifyAssertionRequest zza(@NonNull FacebookAuthCredential facebookAuthCredential) {
        zzaa.zzz(facebookAuthCredential);
        return new VerifyAssertionRequest((String) null, facebookAuthCredential.getAccessToken(), facebookAuthCredential.getProvider(), (String) null, (String) null);
    }

    public String getAccessToken() {
        return this.zzbmS;
    }

    public String getProvider() {
        return FacebookAuthProvider.PROVIDER_ID;
    }
}
