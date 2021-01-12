package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class TwitterAuthCredential extends AuthCredential {
    private String zzabf;
    private String zzbFk;

    TwitterAuthCredential(@NonNull String str, @NonNull String str2) {
        this.zzabf = zzaa.zzdl(str);
        this.zzbFk = zzaa.zzdl(str2);
    }

    public static VerifyAssertionRequest zza(@NonNull TwitterAuthCredential twitterAuthCredential) {
        zzaa.zzz(twitterAuthCredential);
        return new VerifyAssertionRequest((String) null, twitterAuthCredential.getToken(), twitterAuthCredential.getProvider(), (String) null, twitterAuthCredential.zzOn());
    }

    public String getProvider() {
        return TwitterAuthProvider.PROVIDER_ID;
    }

    @NonNull
    public String getToken() {
        return this.zzabf;
    }

    @NonNull
    public String zzOn() {
        return this.zzbFk;
    }
}
