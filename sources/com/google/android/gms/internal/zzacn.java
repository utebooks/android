package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzacv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfo;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;
import java.util.ArrayList;
import java.util.List;

public class zzacn extends com.google.android.gms.common.api.zzc<zzacv.zza> {

    static final class zza extends zzacy<AuthResult, zzadc> {
        @NonNull
        private String zzabx;
        @NonNull
        private String zzacn;

        public zza(@NonNull String str, @NonNull String str2) {
            super(2);
            this.zzacn = zzaa.zzh(str, "email cannot be null or empty");
            this.zzabx = zzaa.zzh(str2, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzc(this.zzacn, this.zzabx, this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzb extends zzacy<Void, zzadk> {
        public zzb() {
            super(5);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzg(this.zzbFC.zzOm(), this.zzbFB);
        }

        public void zzOr() {
            ((zzadk) this.zzbFE).zzOk();
            zzab(null);
        }
    }

    static final class zzc extends zzacy<ProviderQueryResult, zzadc> {
        @NonNull
        private final String zzacn;

        public zzc(@NonNull String str) {
            super(3);
            this.zzacn = zzaa.zzh(str, "email cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzc(this.zzacn, this.zzbFB);
        }

        public void zzOr() {
            zzab(new zzadi(this.zzbFI));
        }
    }

    static final class zzd extends zzacy<GetTokenResult, zzadc> {
        @NonNull
        private final String zzbFo;

        public zzd(@NonNull String str) {
            super(1);
            this.zzbFo = zzaa.zzh(str, "refresh token cannot be null");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFo, (zzact) this.zzbFB);
        }

        public void zzOr() {
            this.zzbFG.zzhH(this.zzbFo);
            ((zzadc) this.zzbFE).zza(this.zzbFG, this.zzbFC);
            zzab(new GetTokenResult(this.zzbFG.getAccessToken()));
        }
    }

    static final class zze extends zzacy<AuthResult, zzadc> {
        @NonNull
        private final EmailAuthCredential zzbFp;

        public zze(@NonNull EmailAuthCredential emailAuthCredential) {
            super(2);
            this.zzbFp = (EmailAuthCredential) zzaa.zzb(emailAuthCredential, (Object) "credential cannot be null");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFp.getEmail(), this.zzbFp.getPassword(), this.zzbFC.zzOm(), this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzf extends zzacy<AuthResult, zzadc> {
        @NonNull
        private final VerifyAssertionRequest zzbFq;

        public zzf(@NonNull AuthCredential authCredential) {
            super(2);
            zzaa.zzb(authCredential, (Object) "credential cannot be null");
            this.zzbFq = zzadd.zza(authCredential);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFC.zzOm(), this.zzbFq, (zzact) this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    private class zzg<ResultT, CallbackT> extends zzpd<zzaco, ResultT> implements zzacx<ResultT> {
        private TaskCompletionSource<ResultT> zzalF;
        private zzacy<ResultT, CallbackT> zzbFr;

        public zzg(zzacy<ResultT, CallbackT> zzacy) {
            this.zzbFr = zzacy;
            this.zzbFr.zza(this);
        }

        /* access modifiers changed from: protected */
        public void zza(zzaco zzaco, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException {
            this.zzalF = taskCompletionSource;
            this.zzbFr.zza(zzaco.zzOs());
        }

        public final void zza(ResultT resultt, Status status) {
            zzaa.zzb(this.zzalF, (Object) "doExecute must be called before onComplete");
            if (status != null) {
                this.zzalF.setException(zzacq.zzbN(status));
            } else {
                this.zzalF.setResult(resultt);
            }
        }
    }

    static final class zzh extends zzacy<Void, zzadc> {
        @NonNull
        private final VerifyAssertionRequest zzbFq;

        public zzh(@NonNull AuthCredential authCredential) {
            super(2);
            zzaa.zzb(authCredential, (Object) "credential cannot be null");
            this.zzbFq = zzadd.zza(authCredential);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFq, (zzact) this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            if (this.zzbFC.getUid().equalsIgnoreCase(zzb.getUid())) {
                ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
                zzOx();
                return;
            }
            zzbO(zzadj.zzOS());
        }
    }

    static final class zzi extends zzacy<Void, zzadc> {
        @NonNull
        private final String zzabx;
        @NonNull
        private final String zzacn;

        public zzi(@NonNull String str, @NonNull String str2) {
            super(2);
            this.zzacn = zzaa.zzh(str, "email cannot be null or empty");
            this.zzabx = zzaa.zzh(str2, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzd(this.zzacn, this.zzabx, this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            if (this.zzbFC.getUid().equalsIgnoreCase(zzb.getUid())) {
                ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
                zzOx();
                return;
            }
            zzbO(zzadj.zzOS());
        }
    }

    static final class zzj extends zzacy<Void, zzadc> {
        public zzj() {
            super(2);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzf(this.zzbFC.zzOm(), this.zzbFB);
        }

        public void zzOr() {
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzacn.zza(this.zzbEZ, this.zzbFH, this.zzbFC.isAnonymous()));
            zzab(null);
        }
    }

    static final class zzk extends zzacy<Void, zzadc> {
        @NonNull
        private String zzacn;

        public zzk(@NonNull String str) {
            super(4);
            this.zzacn = zzaa.zzh(str, "email cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzd(this.zzacn, this.zzbFB);
        }

        public void zzOr() {
            zzOx();
        }
    }

    static final class zzl extends zzacy<AuthResult, zzadc> {
        public zzl() {
            super(2);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH, true);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzm extends zzacy<AuthResult, zzadc> {
        @NonNull
        private final VerifyAssertionRequest zzbFq;

        public zzm(@NonNull AuthCredential authCredential) {
            super(2);
            zzaa.zzb(authCredential, (Object) "credential cannot be null");
            this.zzbFq = zzadd.zza(authCredential);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFq, (zzact) this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzn extends zzacy<AuthResult, zzadc> {
        @NonNull
        private final String zzabf;

        public zzn(@NonNull String str) {
            super(2);
            this.zzabf = zzaa.zzh(str, "token cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzb(this.zzabf, this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzo extends zzacy<AuthResult, zzadc> {
        @NonNull
        private String zzabx;
        @NonNull
        private String zzacn;

        public zzo(String str, String str2) {
            super(2);
            this.zzacn = zzaa.zzh(str, "email cannot be null or empty");
            this.zzabx = zzaa.zzh(str2, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzd(this.zzacn, this.zzabx, this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzp extends zzacy<AuthResult, zzadc> {
        public zzp() {
            super(2);
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zze(this.zzbFC.zzOm(), this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzq extends zzacy<AuthResult, zzadc> {
        @NonNull
        private String zzbFt;

        public zzq(@NonNull String str) {
            super(2);
            this.zzbFt = zzaa.zzh(str, "provider cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zze(this.zzbFt, this.zzbFC.zzOm(), this.zzbFB);
        }

        public void zzOr() {
            zzadh zzb = zzacn.zza(this.zzbEZ, this.zzbFH);
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzb);
            zzab(new zzade(zzb));
        }
    }

    static final class zzr extends zzacy<Void, zzadc> {
        @NonNull
        private final String zzacn;

        public zzr(String str) {
            super(2);
            this.zzacn = zzaa.zzh(str, "email cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFC.zzOm(), this.zzacn, (zzact) this.zzbFB);
        }

        public void zzOr() {
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzacn.zza(this.zzbEZ, this.zzbFH));
            zzOx();
        }
    }

    static final class zzs extends zzacy<Void, zzadc> {
        @NonNull
        private final String zzabx;

        public zzs(@NonNull String str) {
            super(2);
            this.zzabx = zzaa.zzh(str, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zzb(this.zzbFC.zzOm(), this.zzabx, this.zzbFB);
        }

        public void zzOr() {
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzacn.zza(this.zzbEZ, this.zzbFH));
            zzOx();
        }
    }

    static final class zzt extends zzacy<Void, zzadc> {
        @NonNull
        private final UserProfileChangeRequest zzbFu;

        public zzt(UserProfileChangeRequest userProfileChangeRequest) {
            super(2);
            this.zzbFu = (UserProfileChangeRequest) zzaa.zzb(userProfileChangeRequest, (Object) "request cannot be null");
        }

        public void dispatch() throws RemoteException {
            this.zzbFD.zza(this.zzbFC.zzOm(), this.zzbFu, (zzact) this.zzbFB);
        }

        public void zzOr() {
            ((zzadc) this.zzbFE).zza(this.zzbFG, zzacn.zza(this.zzbEZ, this.zzbFH));
            zzOx();
        }
    }

    zzacn(@NonNull Context context, @NonNull zzacv.zza zza2) {
        super(context, zzacv.zzbFz, zza2);
    }

    private <ResultT, CallbackT> zzg<ResultT, CallbackT> zza(zzacy<ResultT, CallbackT> zzacy) {
        return new zzg<>(zzacy);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static zzadh zza(@NonNull FirebaseApp firebaseApp, @NonNull GetAccountInfoUser getAccountInfoUser) {
        return zza(firebaseApp, getAccountInfoUser, false);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static zzadh zza(@NonNull FirebaseApp firebaseApp, @NonNull GetAccountInfoUser getAccountInfoUser, boolean z) {
        zzaa.zzz(firebaseApp);
        zzaa.zzz(getAccountInfoUser);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzadf(getAccountInfoUser, FirebaseAuthProvider.PROVIDER_ID));
        List<ProviderUserInfo> zzOD = getAccountInfoUser.zzOD();
        if (zzOD != null && !zzOD.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzOD.size()) {
                    break;
                }
                arrayList.add(new zzadf(zzOD.get(i2)));
                i = i2 + 1;
            }
        }
        zzadh zzadh = new zzadh(firebaseApp, arrayList);
        zzadh zzadh2 = (zzadh) zzadh.zzaK(z);
        if (!TextUtils.isEmpty(getAccountInfoUser.getEmail()) && !TextUtils.isEmpty(getAccountInfoUser.getPassword())) {
            zzadh.zzhI(EmailAuthProvider.PROVIDER_ID);
        }
        return zzadh;
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @NonNull FirebaseUser firebaseUser, @NonNull zzadc zzadc) {
        zzaa.zzz(firebaseApp);
        zzaa.zzz(authCredential);
        zzaa.zzz(firebaseUser);
        zzaa.zzz(zzadc);
        List<String> providers = firebaseUser.getProviders();
        return (providers == null || !providers.contains(authCredential.getProvider())) ? zzb(zza(new zzf(authCredential).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc))) : Tasks.forException(zzacq.zzbN(new Status(17015)));
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull EmailAuthCredential emailAuthCredential, @NonNull FirebaseUser firebaseUser, @NonNull zzadc zzadc) {
        return zzb(zza(new zze(emailAuthCredential).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzadc zzadc) {
        return zzb(zza(new zzp().zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull FirebaseUser firebaseUser, @NonNull zzadc zzadc) {
        return zzb(zza(new zzq(str).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull zzadc zzadc) {
        return zzb(zza(new zzl().zzd(firebaseApp).zzaa(zzadc)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @NonNull zzadc zzadc) {
        return zzb(zza(new zzm(authCredential).zzd(firebaseApp).zzaa(zzadc)));
    }

    public Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzadc zzadc) {
        return zzb(zza(new zzh(authCredential).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzadc zzadc) {
        return zzb(zza(new zzt(userProfileChangeRequest).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<GetTokenResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzadc zzadc) {
        return zza(zza(new zzd(str).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull zzadc zzadc) {
        return zzb(zza(new zzi(str, str2).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<ProviderQueryResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zza(zza(new zzc(str).zzd(firebaseApp)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull zzadc zzadc) {
        return zzb(zza(new zzn(str).zzd(firebaseApp).zzaa(zzadc)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zzadc zzadc) {
        return zzb(zza(new zza(str, str2).zzd(firebaseApp).zzaa(zzadc)));
    }

    @NonNull
    public Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull zzadk zzadk) {
        return zzb(zza(new zzb().zzd(firebaseUser).zzaa(zzadk)));
    }

    @NonNull
    public Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzadc zzadc) {
        return zza(zza(new zzj().zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzadc zzadc) {
        zzaa.zzz(firebaseApp);
        zzaa.zzz(authCredential);
        zzaa.zzz(firebaseUser);
        zzaa.zzz(zzadc);
        return EmailAuthCredential.class.isAssignableFrom(authCredential.getClass()) ? zza(firebaseApp, (EmailAuthCredential) authCredential, firebaseUser, zzadc) : zza(firebaseApp, authCredential, firebaseUser, zzadc);
    }

    public Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzadc zzadc) {
        return zzb(zza(new zzr(str).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzk(str).zzd(firebaseApp)));
    }

    public Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zzadc zzadc) {
        return zzb(zza(new zzo(str, str2).zzd(firebaseApp).zzaa(zzadc)));
    }

    public Task<Void> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzadc zzadc) {
        return zzb(zza(new zzs(str).zzd(firebaseApp).zzd(firebaseUser).zzaa(zzadc)));
    }

    public Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzadc zzadc) {
        zzaa.zzz(firebaseApp);
        zzaa.zzdl(str);
        zzaa.zzz(firebaseUser);
        zzaa.zzz(zzadc);
        List<String> providers = firebaseUser.getProviders();
        if ((providers != null && !providers.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzacq.zzbN(new Status(17016, str)));
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 1216985755:
                if (str.equals(EmailAuthProvider.PROVIDER_ID)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zza(firebaseApp, firebaseUser, zzadc);
            default:
                return zza(firebaseApp, str, firebaseUser, zzadc);
        }
    }
}
