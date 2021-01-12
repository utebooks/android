package com.google.firebase.auth;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzacn;
import com.google.android.gms.internal.zzacq;
import com.google.android.gms.internal.zzacs;
import com.google.android.gms.internal.zzacv;
import com.google.android.gms.internal.zzadc;
import com.google.android.gms.internal.zzade;
import com.google.android.gms.internal.zzadg;
import com.google.android.gms.internal.zzadh;
import com.google.android.gms.internal.zzadk;
import com.google.android.gms.internal.zzadl;
import com.google.android.gms.internal.zzadm;
import com.google.android.gms.internal.zzaja;
import com.google.android.gms.internal.zzajz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.api.model.GetTokenResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FirebaseAuth implements zzaja {
    private static Map<String, FirebaseAuth> zzaTZ = new ArrayMap();
    private static FirebaseAuth zzbFf;
    /* access modifiers changed from: private */
    public List<AuthStateListener> mListeners;
    /* access modifiers changed from: private */
    public FirebaseApp zzbEZ;
    private zzacn zzbFa;
    /* access modifiers changed from: private */
    public FirebaseUser zzbFb;
    private zzadl zzbFc;
    /* access modifiers changed from: private */
    public zzajz zzbFd;
    private zzadm zzbFe;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    class zza implements zzadc {
        zza() {
        }

        public void zza(@NonNull GetTokenResponse getTokenResponse, @NonNull FirebaseUser firebaseUser) {
            zzaa.zzz(getTokenResponse);
            zzaa.zzz(firebaseUser);
            firebaseUser.zzhG(FirebaseAuth.this.zzbFd.zzaH(getTokenResponse));
            FirebaseAuth.this.zza(firebaseUser, getTokenResponse, true);
            FirebaseAuth.this.zza(firebaseUser, true, true);
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zza(firebaseApp), new zzadl(firebaseApp.getApplicationContext(), firebaseApp.zzNV(), zzacs.zzOt()));
    }

    FirebaseAuth(FirebaseApp firebaseApp, zzacn zzacn, zzadl zzadl) {
        this.zzbEZ = (FirebaseApp) zzaa.zzz(firebaseApp);
        this.zzbFa = (zzacn) zzaa.zzz(zzacn);
        this.zzbFc = (zzadl) zzaa.zzz(zzadl);
        this.mListeners = new CopyOnWriteArrayList();
        this.zzbFd = zzacs.zzOt();
        this.zzbFe = zzadm.zzOV();
        zzbw(firebaseApp.getApplicationContext());
        zzOj();
    }

    public static FirebaseAuth getInstance() {
        return zzb(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return zzb(firebaseApp);
    }

    static zzacn zza(FirebaseApp firebaseApp) {
        return zzacv.zza(firebaseApp.getApplicationContext(), new zzacv.zza.C0769zza(firebaseApp.getOptions().getApiKey()).zzOw());
    }

    private static FirebaseAuth zzb(@NonNull FirebaseApp firebaseApp) {
        return zzc(firebaseApp);
    }

    private void zzbw(Context context) {
        int i = 0;
        try {
            ComponentName componentName = new ComponentName("com.google.android.gms", "com.google.firebase.auth.api.gms.service.FirebaseAuthService");
            while (i < 5) {
                try {
                    context.getPackageManager().getServiceInfo(componentName, 0);
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    context.sendBroadcast(new Intent("com.google.android.chimera.container.IntentOperationService.MODULE_SPECIFIC").putExtra("moduleid", "com.google.android.gms.firebase_auth").putExtra("intent", new Intent("com.google.android.chimera.IntentOperation.NEW_MODULE").putExtra("containerUpdated", false)).setClassName("com.google.android.gms", "com.google.android.gms.chimera.GmsIntentOperationService$GmsExternalReceiver"));
                    Thread.sleep(25);
                    i++;
                }
            }
        } catch (Exception e2) {
        }
    }

    private static synchronized FirebaseAuth zzc(@NonNull FirebaseApp firebaseApp) {
        FirebaseAuth firebaseAuth;
        synchronized (FirebaseAuth.class) {
            firebaseAuth = zzaTZ.get(firebaseApp.zzNV());
            if (firebaseAuth == null) {
                firebaseAuth = new zzadg(firebaseApp);
                firebaseApp.zza((zzaja) firebaseAuth);
                if (zzbFf == null) {
                    zzbFf = firebaseAuth;
                }
                zzaTZ.put(firebaseApp.zzNV(), firebaseAuth);
            }
        }
        return firebaseAuth;
    }

    public void addAuthStateListener(@NonNull final AuthStateListener authStateListener) {
        this.mListeners.add(authStateListener);
        this.zzbFe.execute(new Runnable() {
            public void run() {
                authStateListener.onAuthStateChanged(FirebaseAuth.this);
            }
        });
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        zzaa.zzdl(str);
        zzaa.zzdl(str2);
        return this.zzbFa.zza(this.zzbEZ, str, str2, (zzadc) new zza());
    }

    @NonNull
    public Task<ProviderQueryResult> fetchProvidersForEmail(@NonNull String str) {
        zzaa.zzdl(str);
        return this.zzbFa.zza(this.zzbEZ, str);
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzbFb;
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.mListeners.remove(authStateListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        zzaa.zzdl(str);
        return this.zzbFa.zzb(this.zzbEZ, str);
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        return (this.zzbFb == null || !this.zzbFb.isAnonymous()) ? this.zzbFa.zza(this.zzbEZ, (zzadc) new zza()) : Tasks.forResult(new zzade((zzadh) this.zzbFb));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        zzaa.zzz(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return this.zzbFa.zza(this.zzbEZ, authCredential, (zzadc) new zza());
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
        return this.zzbFa.zzb(this.zzbEZ, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), (zzadc) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        zzaa.zzdl(str);
        return this.zzbFa.zza(this.zzbEZ, str, (zzadc) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        zzaa.zzdl(str);
        zzaa.zzdl(str2);
        return this.zzbFa.zzb(this.zzbEZ, str, str2, (zzadc) new zza());
    }

    public void signOut() {
        zzOi();
    }

    public void zzOi() {
        if (this.zzbFb != null) {
            this.zzbFc.zzg(this.zzbFb);
            this.zzbFb = null;
        }
        this.zzbFc.zzOU();
        zza((FirebaseUser) null);
    }

    /* access modifiers changed from: protected */
    public void zzOj() {
        this.zzbFb = this.zzbFc.zzOT();
        if (this.zzbFb != null) {
            zza(this.zzbFb, false, true);
            GetTokenResponse zzf = this.zzbFc.zzf(this.zzbFb);
            if (zzf != null) {
                zza(this.zzbFb, zzf, false);
            }
        }
    }

    @NonNull
    public Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzaa.zzz(firebaseUser);
        zzaa.zzz(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return this.zzbFa.zza(this.zzbEZ, firebaseUser, authCredential, (zzadc) new zza());
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
        return this.zzbFa.zza(this.zzbEZ, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), new zza());
    }

    @NonNull
    public Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        zzaa.zzz(firebaseUser);
        zzaa.zzz(userProfileChangeRequest);
        return this.zzbFa.zza(this.zzbEZ, firebaseUser, userProfileChangeRequest, (zzadc) new zza());
    }

    @NonNull
    public Task<AuthResult> zza(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzaa.zzdl(str);
        zzaa.zzz(firebaseUser);
        return this.zzbFa.zzd(this.zzbEZ, firebaseUser, str, new zza());
    }

    @NonNull
    public Task<GetTokenResult> zza(@Nullable FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzacq.zzbN(new Status(17495)));
        }
        GetTokenResponse getTokenResponse = (GetTokenResponse) this.zzbFd.zzf(this.zzbFb.zzOm(), GetTokenResponse.class);
        return (!getTokenResponse.isValid() || z) ? this.zzbFa.zza(this.zzbEZ, firebaseUser, getTokenResponse.zzOG(), (zzadc) new zzadc() {
            public void zza(@NonNull GetTokenResponse getTokenResponse, @NonNull FirebaseUser firebaseUser) {
                FirebaseAuth.this.zza(firebaseUser, getTokenResponse, true);
            }
        }) : Tasks.forResult(new GetTokenResult(getTokenResponse.getAccessToken()));
    }

    public void zza(@Nullable final FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String valueOf = String.valueOf(firebaseUser.getUid());
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(valueOf).length() + 36).append("Notifying listeners about user ( ").append(valueOf).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying listeners about a sign-out event.");
        }
        this.zzbFe.execute(new Runnable() {
            public void run() {
                FirebaseAuth.this.zzbEZ.zza(FirebaseAuth.this, firebaseUser);
                for (AuthStateListener onAuthStateChanged : FirebaseAuth.this.mListeners) {
                    onAuthStateChanged.onAuthStateChanged(FirebaseAuth.this);
                }
            }
        });
    }

    public void zza(@NonNull FirebaseUser firebaseUser, @NonNull GetTokenResponse getTokenResponse, boolean z) {
        boolean z2 = true;
        zzaa.zzz(firebaseUser);
        zzaa.zzz(getTokenResponse);
        if (this.zzbFb != null) {
            String accessToken = ((GetTokenResponse) this.zzbFd.zzf(this.zzbFb.zzOm(), GetTokenResponse.class)).getAccessToken();
            z2 = this.zzbFb.getUid().equalsIgnoreCase(firebaseUser.getUid()) && accessToken != null && !accessToken.equals(getTokenResponse.getAccessToken());
        }
        if (z2) {
            if (this.zzbFb != null) {
                this.zzbFb.zzhG(this.zzbFd.zzaH(getTokenResponse));
            }
            zza(this.zzbFb);
        }
        if (z) {
            this.zzbFc.zza(firebaseUser, getTokenResponse);
        }
    }

    public void zza(@NonNull FirebaseUser firebaseUser, boolean z, boolean z2) {
        zzaa.zzz(firebaseUser);
        if (this.zzbFb == null) {
            this.zzbFb = firebaseUser;
        } else {
            this.zzbFb.zzaK(firebaseUser.isAnonymous());
            this.zzbFb.zzN(firebaseUser.getProviderData());
        }
        if (z) {
            this.zzbFc.zze(this.zzbFb);
        }
        if (z2) {
            zza(this.zzbFb);
        }
    }

    @NonNull
    public Task<Void> zzb(@NonNull FirebaseUser firebaseUser) {
        zzaa.zzz(firebaseUser);
        return this.zzbFa.zzb(this.zzbEZ, firebaseUser, (zzadc) new zza());
    }

    @NonNull
    public Task<AuthResult> zzb(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzaa.zzz(authCredential);
        zzaa.zzz(firebaseUser);
        return this.zzbFa.zzb(this.zzbEZ, firebaseUser, authCredential, (zzadc) new zza());
    }

    @NonNull
    public Task<Void> zzb(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzaa.zzz(firebaseUser);
        zzaa.zzdl(str);
        return this.zzbFa.zzb(this.zzbEZ, firebaseUser, str, (zzadc) new zza());
    }

    @NonNull
    public Task<Void> zzc(@NonNull final FirebaseUser firebaseUser) {
        zzaa.zzz(firebaseUser);
        return this.zzbFa.zza(firebaseUser, (zzadk) new zzadk() {
            public void zzOk() {
                if (FirebaseAuth.this.zzbFb.getUid().equalsIgnoreCase(firebaseUser.getUid())) {
                    FirebaseAuth.this.zzOi();
                }
            }
        });
    }

    @NonNull
    public Task<Void> zzc(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzaa.zzz(firebaseUser);
        zzaa.zzdl(str);
        return this.zzbFa.zzc(this.zzbEZ, firebaseUser, str, new zza());
    }
}
