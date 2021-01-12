package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzg;

public final class zzacv {
    public static final Api.zzf<zzaco> zzaaz = new Api.zzf<>();
    private static final Api.zza<zzaco, zza> zzbFy = new Api.zza<zzaco, zza>() {
        public zzaco zza(Context context, Looper looper, zzg zzg, zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzacp(context, looper, zzg, zza, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<zza> zzbFz = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzbFy, zzaaz);

    public static final class zza implements Api.ApiOptions.HasOptions {
        private final String zzaoh;

        /* renamed from: com.google.android.gms.internal.zzacv$zza$zza  reason: collision with other inner class name */
        public static final class C0769zza {
            private String zzaoh;

            public C0769zza(@NonNull String str) {
                this.zzaoh = zzaa.zzdl(str);
            }

            public zza zzOw() {
                return new zza(this.zzaoh);
            }
        }

        private zza(@NonNull String str) {
            this.zzaoh = zzaa.zzh(str, "A valid API key must be provided");
        }

        public String getApiKey() {
            return this.zzaoh;
        }
    }

    public static zzacn zza(Context context, zza zza2) {
        return new zzacn(context, zza2);
    }
}
