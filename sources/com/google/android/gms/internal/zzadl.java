package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

public class zzadl {
    private Context mContext;
    private zzajz zzbFd;
    private String zzbGn;
    private zzakk zzbGo = new zzakk();
    private SharedPreferences zzwV;

    public zzadl(@NonNull Context context, @NonNull String str, @NonNull zzajz zzajz) {
        zzaa.zzz(context);
        this.zzbGn = zzaa.zzdl(str);
        this.mContext = context.getApplicationContext();
        String format = String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzbGn});
        this.zzbFd = (zzajz) zzaa.zzz(zzajz);
        this.zzwV = this.mContext.getSharedPreferences(format, 0);
    }

    public void clear(String str) {
        this.zzwV.edit().remove(str).apply();
    }

    @Nullable
    public String get(String str) {
        return this.zzwV.getString(str, (String) null);
    }

    @Nullable
    public FirebaseUser zzOT() {
        String str = get("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            zzaki zzVJ = this.zzbGo.zziR(str).zzVJ();
            if (zzVJ.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(zzVJ.zziQ("type").zzVA())) {
                return (FirebaseUser) this.zzbFd.zza((zzakf) zzVJ, zzadh.class);
            }
        } catch (zzako e) {
        }
        return null;
    }

    public void zzOU() {
        clear("com.google.firebase.auth.FIREBASE_USER");
    }

    public void zza(@NonNull FirebaseUser firebaseUser, @NonNull GetTokenResponse getTokenResponse) {
        zzaa.zzz(firebaseUser);
        zzaa.zzz(getTokenResponse);
        zzp(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), getTokenResponse);
    }

    @Nullable
    public <T> T zze(String str, Class<T> cls) {
        String str2 = get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return this.zzbFd.zzf(str2, cls);
    }

    public void zze(@NonNull FirebaseUser firebaseUser) {
        zzaa.zzz(firebaseUser);
        zzp("com.google.firebase.auth.FIREBASE_USER", firebaseUser);
    }

    public GetTokenResponse zzf(@NonNull FirebaseUser firebaseUser) {
        zzaa.zzz(firebaseUser);
        return (GetTokenResponse) zze(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), GetTokenResponse.class);
    }

    public void zzg(@NonNull FirebaseUser firebaseUser) {
        zzaa.zzz(firebaseUser);
        clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
    }

    public void zzp(String str, Object obj) {
        this.zzwV.edit().putString(str, this.zzbFd.zzaH(obj)).apply();
    }
}
