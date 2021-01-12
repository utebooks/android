package com.google.firebase.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class GoogleAuthCredential extends AuthCredential {
    private final String zzabK;
    private final String zzbmS;

    GoogleAuthCredential(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.zzabK = zzag(str, "idToken");
        this.zzbmS = zzag(str2, "accessToken");
    }

    public static VerifyAssertionRequest zza(@NonNull GoogleAuthCredential googleAuthCredential) {
        zzaa.zzz(googleAuthCredential);
        return new VerifyAssertionRequest(googleAuthCredential.getIdToken(), googleAuthCredential.getAccessToken(), googleAuthCredential.getProvider(), (String) null, (String) null);
    }

    private static String zzag(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    @Nullable
    public String getAccessToken() {
        return this.zzbmS;
    }

    @Nullable
    public String getIdToken() {
        return this.zzabK;
    }

    public String getProvider() {
        return GoogleAuthProvider.PROVIDER_ID;
    }
}
