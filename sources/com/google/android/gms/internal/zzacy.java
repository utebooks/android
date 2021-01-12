package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzact;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

abstract class zzacy<SuccessT, CallbackT> {
    protected FirebaseApp zzbEZ;
    protected final int zzbFA;
    protected final zza zzbFB = new zza();
    protected FirebaseUser zzbFC;
    protected zzacu zzbFD;
    protected CallbackT zzbFE;
    protected zzacx<SuccessT> zzbFF;
    protected GetTokenResponse zzbFG;
    protected GetAccountInfoUser zzbFH;
    protected CreateAuthUriResponse zzbFI;
    boolean zzbFJ;
    SuccessT zzbFK;
    Status zzbFL;
    private boolean zzbwA;

    private class zza extends zzact.zza {
        private zza() {
        }

        public void onFailure(@NonNull Status status) throws RemoteException {
            zzacy.this.zzbO(status);
        }

        public void zzOu() throws RemoteException {
            zzaa.zza(zzacy.this.zzbFA == 4, (Object) new StringBuilder(36).append("Unexpected response type ").append(zzacy.this.zzbFA).toString());
            zzacy.this.zzOy();
        }

        public void zzOv() throws RemoteException {
            zzaa.zza(zzacy.this.zzbFA == 5, (Object) new StringBuilder(36).append("Unexpected response type ").append(zzacy.this.zzbFA).toString());
            zzacy.this.zzOy();
        }

        public void zza(@NonNull CreateAuthUriResponse createAuthUriResponse) throws RemoteException {
            zzaa.zza(zzacy.this.zzbFA == 3, (Object) new StringBuilder(36).append("Unexpected response type ").append(zzacy.this.zzbFA).toString());
            zzacy.this.zzbFI = createAuthUriResponse;
            zzacy.this.zzOy();
        }

        public void zza(@NonNull GetTokenResponse getTokenResponse) throws RemoteException {
            boolean z = true;
            if (zzacy.this.zzbFA != 1) {
                z = false;
            }
            zzaa.zza(z, (Object) new StringBuilder(37).append("Unexpected response type: ").append(zzacy.this.zzbFA).toString());
            zzacy.this.zzbFG = getTokenResponse;
            zzacy.this.zzOy();
        }

        public void zza(@NonNull GetTokenResponse getTokenResponse, @NonNull GetAccountInfoUser getAccountInfoUser) throws RemoteException {
            zzaa.zza(zzacy.this.zzbFA == 2, (Object) new StringBuilder(37).append("Unexpected response type: ").append(zzacy.this.zzbFA).toString());
            zzacy.this.zzbFG = getTokenResponse;
            zzacy.this.zzbFH = getAccountInfoUser;
            zzacy.this.zzOy();
        }
    }

    public zzacy(int i) {
        this.zzbFA = i;
    }

    /* access modifiers changed from: private */
    public void zzOy() {
        zzOr();
        zzaa.zza(this.zzbwA, (Object) "no success or failure set on method implementation");
    }

    /* access modifiers changed from: protected */
    public abstract void dispatch() throws RemoteException;

    public abstract void zzOr();

    public void zzOx() {
        zzab((Object) null);
    }

    public zzacy<SuccessT, CallbackT> zza(zzacx<SuccessT> zzacx) {
        this.zzbFF = zzacx;
        return this;
    }

    public void zza(zzacu zzacu) throws RemoteException {
        this.zzbFD = zzacu;
        dispatch();
    }

    public zzacy<SuccessT, CallbackT> zzaa(CallbackT callbackt) {
        this.zzbFE = zzaa.zzb(callbackt, (Object) "external callback cannot be null");
        return this;
    }

    public void zzab(SuccessT successt) {
        this.zzbwA = true;
        this.zzbFJ = true;
        this.zzbFK = successt;
        this.zzbFF.zza(successt, (Status) null);
    }

    public void zzbO(Status status) {
        this.zzbwA = true;
        this.zzbFJ = false;
        this.zzbFL = status;
        this.zzbFF.zza(null, status);
    }

    public zzacy<SuccessT, CallbackT> zzd(FirebaseApp firebaseApp) {
        this.zzbEZ = (FirebaseApp) zzaa.zzb(firebaseApp, (Object) "firebaseApp cannot be null");
        return this;
    }

    public zzacy<SuccessT, CallbackT> zzd(FirebaseUser firebaseUser) {
        this.zzbFC = (FirebaseUser) zzaa.zzb(firebaseUser, (Object) "firebaseUser cannot be null");
        return this;
    }
}
