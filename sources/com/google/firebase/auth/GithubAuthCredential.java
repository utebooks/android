package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class GithubAuthCredential extends AuthCredential {
    private String zzabf;

    GithubAuthCredential(@NonNull String str) {
        this.zzabf = zzaa.zzdl(str);
    }

    public static VerifyAssertionRequest zza(@NonNull GithubAuthCredential githubAuthCredential) {
        zzaa.zzz(githubAuthCredential);
        return new VerifyAssertionRequest((String) null, githubAuthCredential.getToken(), githubAuthCredential.getProvider(), (String) null, (String) null);
    }

    public String getProvider() {
        return GithubAuthProvider.PROVIDER_ID;
    }

    public String getToken() {
        return this.zzabf;
    }
}
