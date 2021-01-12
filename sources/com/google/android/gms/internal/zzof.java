package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzpf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzof extends GoogleApiClient implements zzoo.zza {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Looper zzakW;
    private final int zzall;
    private final GoogleApiAvailability zzaln;
    final Api.zza<? extends zztv, zztw> zzalo;
    final zzg zzamS;
    final Map<Api<?>, Integer> zzamT;
    private final Lock zzamw;
    private final zzl zzanf;
    private zzoo zzang = null;
    final Queue<zznt.zza<?, ?>> zzanh = new LinkedList();
    private volatile boolean zzani;
    private long zzanj = 120000;
    private long zzank = 5000;
    private final zza zzanl;
    zzol zzanm;
    final Map<Api.zzc<?>, Api.zze> zzann;
    Set<Scope> zzano = new HashSet();
    private final zzov zzanp = new zzov();
    private final ArrayList<zznw> zzanq;
    private Integer zzanr = null;
    Set<zzpe> zzans = null;
    final zzpf zzant;
    private final zzl.zza zzanu = new zzl.zza() {
        public boolean isConnected() {
            return zzof.this.isConnected();
        }

        public Bundle zzqr() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzof.this.zzsh();
                    return;
                case 2:
                    zzof.this.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                    return;
            }
        }
    }

    static class zzb extends zzol.zza {
        private WeakReference<zzof> zzanz;

        zzb(zzof zzof) {
            this.zzanz = new WeakReference<>(zzof);
        }

        public void zzrG() {
            zzof zzof = (zzof) this.zzanz.get();
            if (zzof != null) {
                zzof.resume();
            }
        }
    }

    public zzof(Context context, Lock lock, Looper looper, zzg zzg, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zztv, zztw> zza2, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zze> map2, int i, int i2, ArrayList<zznw> arrayList) {
        this.mContext = context;
        this.zzamw = lock;
        this.zzanf = new zzl(looper, this.zzanu);
        this.zzakW = looper;
        this.zzanl = new zza(looper);
        this.zzaln = googleApiAvailability;
        this.zzall = i;
        if (this.zzall >= 0) {
            this.zzanr = Integer.valueOf(i2);
        }
        this.zzamT = map;
        this.zzann = map2;
        this.zzanq = arrayList;
        this.zzant = new zzpf(this.zzann);
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzanf.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzanf.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzamS = zzg;
        this.zzalo = zza2;
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.zzamw.lock();
        try {
            if (zzsf()) {
                zzsg();
            }
        } finally {
            this.zzamw.unlock();
        }
    }

    public static int zza(Iterable<Api.zze> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zze next : iterable) {
            if (next.zzpd()) {
                z3 = true;
            }
            z2 = next.zzps() ? true : z2;
        }
        if (z3) {
            return (!z2 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzpb zzpb, final boolean z) {
        zzpl.zzasx.zzf(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzo */
            public void onResult(@NonNull Status status) {
                zzk.zzab(zzof.this.mContext).zzpE();
                if (status.isSuccess() && zzof.this.isConnected()) {
                    zzof.this.reconnect();
                }
                zzpb.zzb(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void zzb(@NonNull zzop zzop) {
        if (this.zzall >= 0) {
            zznr.zza(zzop).zzbG(this.zzall);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    private void zzbJ(int i) {
        if (this.zzanr == null) {
            this.zzanr = Integer.valueOf(i);
        } else if (this.zzanr.intValue() != i) {
            String valueOf = String.valueOf(zzbK(i));
            String valueOf2 = String.valueOf(zzbK(this.zzanr.intValue()));
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.zzang == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.zze next : this.zzann.values()) {
                if (next.zzpd()) {
                    z2 = true;
                }
                z = next.zzps() ? true : z;
            }
            switch (this.zzanr.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        this.zzang = zznx.zza(this.mContext, this, this.zzamw, this.zzakW, this.zzaln, this.zzann, this.zzamS, this.zzamT, this.zzalo, this.zzanq);
                        return;
                    }
                    break;
            }
            this.zzang = new zzoh(this.mContext, this, this.zzamw, this.zzakW, this.zzaln, this.zzann, this.zzamS, this.zzamT, this.zzalo, this.zzanq, this);
        }
    }

    static String zzbK(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzsg() {
        this.zzanf.zztJ();
        this.zzang.connect();
    }

    /* access modifiers changed from: private */
    public void zzsh() {
        this.zzamw.lock();
        try {
            if (zzsj()) {
                zzsg();
            }
        } finally {
            this.zzamw.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzaa.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzamw.lock();
        try {
            if (this.zzall >= 0) {
                if (this.zzanr == null) {
                    z = false;
                }
                zzaa.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzanr == null) {
                this.zzanr = Integer.valueOf(zza(this.zzann.values(), false));
            } else if (this.zzanr.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbJ(this.zzanr.intValue());
            this.zzanf.zztJ();
            return this.zzang.blockingConnect();
        } finally {
            this.zzamw.unlock();
        }
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzaa.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzaa.zzb(timeUnit, (Object) "TimeUnit must not be null");
        this.zzamw.lock();
        try {
            if (this.zzanr == null) {
                this.zzanr = Integer.valueOf(zza(this.zzann.values(), false));
            } else if (this.zzanr.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbJ(this.zzanr.intValue());
            this.zzanf.zztJ();
            return this.zzang.blockingConnect(j, timeUnit);
        } finally {
            this.zzamw.unlock();
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzaa.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzaa.zza(this.zzanr.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzpb zzpb = new zzpb((GoogleApiClient) this);
        if (this.zzann.containsKey(zzpl.zzaaz)) {
            zza(this, zzpb, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzpl.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                public void onConnected(Bundle bundle) {
                    zzof.this.zza((GoogleApiClient) atomicReference.get(), zzpb, true);
                }

                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    zzpb.zzb(new Status(8));
                }
            }).setHandler(this.zzanl).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzpb;
    }

    public void connect() {
        boolean z = false;
        this.zzamw.lock();
        try {
            if (this.zzall >= 0) {
                if (this.zzanr != null) {
                    z = true;
                }
                zzaa.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzanr == null) {
                this.zzanr = Integer.valueOf(zza(this.zzann.values(), false));
            } else if (this.zzanr.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzanr.intValue());
        } finally {
            this.zzamw.unlock();
        }
    }

    public void connect(int i) {
        boolean z = true;
        this.zzamw.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzaa.zzb(z, (Object) new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            zzbJ(i);
            zzsg();
        } finally {
            this.zzamw.unlock();
        }
    }

    public void disconnect() {
        this.zzamw.lock();
        try {
            this.zzant.release();
            if (this.zzang != null) {
                this.zzang.disconnect();
            }
            this.zzanp.release();
            for (zznt.zza zza2 : this.zzanh) {
                zza2.zza((zzpf.zzb) null);
                zza2.cancel();
            }
            this.zzanh.clear();
            if (this.zzang != null) {
                zzsj();
                this.zzanf.zztI();
                this.zzamw.unlock();
            }
        } finally {
            this.zzamw.unlock();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.zzani);
        printWriter.append(" mWorkQueue.size()=").print(this.zzanh.size());
        this.zzant.dump(printWriter);
        if (this.zzang != null) {
            this.zzang.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzamw.lock();
        try {
            if (!isConnected() && !zzsf()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzann.containsKey(api.zzre())) {
                ConnectionResult connectionResult = this.zzang.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzamw.unlock();
                } else if (zzsf()) {
                    connectionResult = ConnectionResult.zzakj;
                } else {
                    Log.i("GoogleApiClientImpl", zzsl());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    this.zzamw.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.zzamw.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzakW;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zze zze = this.zzann.get(api.zzre());
        return zze != null && zze.isConnected();
    }

    public boolean isConnected() {
        return this.zzang != null && this.zzang.isConnected();
    }

    public boolean isConnecting() {
        return this.zzang != null && this.zzang.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zzanf.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzanf.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzanf.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzanf.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzb(new zzop(fragmentActivity));
    }

    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzanf.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzanf.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzc) {
        C c = (Api.zze) this.zzann.get(zzc);
        zzaa.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public void zza(zzpe zzpe) {
        this.zzamw.lock();
        try {
            if (this.zzans == null) {
                this.zzans = new HashSet();
            }
            this.zzans.add(zzpe);
        } finally {
            this.zzamw.unlock();
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.zzann.containsKey(api.zzre());
    }

    public boolean zza(zzpa zzpa) {
        return this.zzang != null && this.zzang.zza(zzpa);
    }

    /* access modifiers changed from: package-private */
    public <C extends Api.zze> C zzb(Api.zzc<?> zzc) {
        C c = (Api.zze) this.zzann.get(zzc);
        zzaa.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public void zzb(zzpe zzpe) {
        this.zzamw.lock();
        try {
            if (this.zzans == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zzans.remove(zzpe)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzsk()) {
                this.zzang.zzrN();
            }
        } finally {
            this.zzamw.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(@NonNull T t) {
        zzaa.zzb(t.zzre() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzann.containsKey(t.zzre());
        String name = t.zzrl() != null ? t.zzrl().getName() : "the API";
        zzaa.zzb(containsKey, (Object) new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzamw.lock();
        try {
            if (this.zzang == null) {
                this.zzanh.add(t);
            } else {
                t = this.zzang.zzc(t);
                this.zzamw.unlock();
            }
            return t;
        } finally {
            this.zzamw.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzsi();
        }
        this.zzant.zzsL();
        this.zzanf.zzcc(i);
        this.zzanf.zztI();
        if (i == 2) {
            zzsg();
        }
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(@NonNull T t) {
        zzaa.zzb(t.zzre() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzann.containsKey(t.zzre());
        String name = t.zzrl() != null ? t.zzrl().getName() : "the API";
        zzaa.zzb(containsKey, (Object) new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzamw.lock();
        try {
            if (this.zzang == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzsf()) {
                this.zzanh.add(t);
                while (!this.zzanh.isEmpty()) {
                    zznt.zza remove = this.zzanh.remove();
                    this.zzant.zzg(remove);
                    remove.zzx(Status.zzaly);
                }
            } else {
                t = this.zzang.zzd(t);
                this.zzamw.unlock();
            }
            return t;
        } finally {
            this.zzamw.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.zzaln.zzc(this.mContext, connectionResult.getErrorCode())) {
            zzsj();
        }
        if (!zzsf()) {
            this.zzanf.zzm(connectionResult);
            this.zzanf.zztI();
        }
    }

    public void zzk(Bundle bundle) {
        while (!this.zzanh.isEmpty()) {
            zzd(this.zzanh.remove());
        }
        this.zzanf.zzm(bundle);
    }

    public void zzrr() {
        if (this.zzang != null) {
            this.zzang.zzrr();
        }
    }

    public <L> zzou<L> zzs(@NonNull L l) {
        this.zzamw.lock();
        try {
            return this.zzanp.zza(l, this.zzakW);
        } finally {
            this.zzamw.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzsf() {
        return this.zzani;
    }

    /* access modifiers changed from: package-private */
    public void zzsi() {
        if (!zzsf()) {
            this.zzani = true;
            if (this.zzanm == null) {
                this.zzanm = this.zzaln.zza(this.mContext.getApplicationContext(), (zzol.zza) new zzb(this));
            }
            this.zzanl.sendMessageDelayed(this.zzanl.obtainMessage(1), this.zzanj);
            this.zzanl.sendMessageDelayed(this.zzanl.obtainMessage(2), this.zzank);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzsj() {
        if (!zzsf()) {
            return false;
        }
        this.zzani = false;
        this.zzanl.removeMessages(2);
        this.zzanl.removeMessages(1);
        if (this.zzanm != null) {
            this.zzanm.unregister();
            this.zzanm = null;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean zzsk() {
        boolean z = false;
        this.zzamw.lock();
        try {
            if (this.zzans != null) {
                if (!this.zzans.isEmpty()) {
                    z = true;
                }
                this.zzamw.unlock();
            }
            return z;
        } finally {
            this.zzamw.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public String zzsl() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }
}
