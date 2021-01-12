package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.zzc;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzad extends zzaa {
    private final zzf zzbfA;
    private final zzah zzbfB;
    private final List<Runnable> zzbfC = new ArrayList();
    private final zzf zzbfD;
    /* access modifiers changed from: private */
    public final zza zzbfx;
    /* access modifiers changed from: private */
    public zzm zzbfy;
    private Boolean zzbfz;

    protected class zza implements ServiceConnection, zzd.zzb, zzd.zzc {
        /* access modifiers changed from: private */
        public volatile boolean zzbfG;
        private volatile zzo zzbfH;

        protected zza() {
        }

        @MainThread
        public void onConnected(@Nullable Bundle bundle) {
            zzaa.zzdc("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final zzm zzm = (zzm) this.zzbfH.zztm();
                    this.zzbfH = null;
                    zzad.this.zzFl().zzg(new Runnable() {
                        public void run() {
                            synchronized (zza.this) {
                                boolean unused = zza.this.zzbfG = false;
                                if (!zzad.this.isConnected()) {
                                    zzad.this.zzFm().zzFK().log("Connected to remote service");
                                    zzad.this.zza(zzm);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException | IllegalStateException e) {
                    this.zzbfH = null;
                    this.zzbfG = false;
                }
            }
        }

        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzaa.zzdc("MeasurementServiceConnection.onConnectionFailed");
            zzp zzFY = zzad.this.zzbbl.zzFY();
            if (zzFY != null) {
                zzFY.zzFG().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.zzbfG = false;
                this.zzbfH = null;
            }
        }

        @MainThread
        public void onConnectionSuspended(int i) {
            zzaa.zzdc("MeasurementServiceConnection.onConnectionSuspended");
            zzad.this.zzFm().zzFK().log("Service connection suspended");
            zzad.this.zzFl().zzg(new Runnable() {
                public void run() {
                    zzad.this.onServiceDisconnected(new ComponentName(zzad.this.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                }
            });
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzaa.zzdc("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.zzbfG = false;
                    zzad.this.zzFm().zzFE().log("Service connected with null binder");
                    return;
                }
                final zzm zzm = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzm = zzm.zza.zzdv(iBinder);
                        zzad.this.zzFm().zzFL().log("Bound to IMeasurementService interface");
                    } else {
                        zzad.this.zzFm().zzFE().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    zzad.this.zzFm().zzFE().log("Service connect failed to get IMeasurementService");
                }
                if (zzm == null) {
                    this.zzbfG = false;
                    try {
                        zzb.zzuH().zza(zzad.this.getContext(), (ServiceConnection) zzad.this.zzbfx);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    zzad.this.zzFl().zzg(new Runnable() {
                        public void run() {
                            synchronized (zza.this) {
                                boolean unused = zza.this.zzbfG = false;
                                if (!zzad.this.isConnected()) {
                                    zzad.this.zzFm().zzFL().log("Connected to service");
                                    zzad.this.zza(zzm);
                                }
                            }
                        }
                    });
                }
            }
        }

        @MainThread
        public void onServiceDisconnected(final ComponentName componentName) {
            zzaa.zzdc("MeasurementServiceConnection.onServiceDisconnected");
            zzad.this.zzFm().zzFK().log("Service disconnected");
            zzad.this.zzFl().zzg(new Runnable() {
                public void run() {
                    zzad.this.onServiceDisconnected(componentName);
                }
            });
        }

        @WorkerThread
        public void zzGF() {
            zzad.this.zzkN();
            Context context = zzad.this.getContext();
            synchronized (this) {
                if (this.zzbfG) {
                    zzad.this.zzFm().zzFL().log("Connection attempt already in progress");
                } else if (this.zzbfH != null) {
                    zzad.this.zzFm().zzFL().log("Already awaiting connection attempt");
                } else {
                    this.zzbfH = new zzo(context, Looper.getMainLooper(), this, this);
                    zzad.this.zzFm().zzFL().log("Connecting to remote service");
                    this.zzbfG = true;
                    this.zzbfH.zztj();
                }
            }
        }

        @WorkerThread
        public void zzx(Intent intent) {
            zzad.this.zzkN();
            Context context = zzad.this.getContext();
            zzb zzuH = zzb.zzuH();
            synchronized (this) {
                if (this.zzbfG) {
                    zzad.this.zzFm().zzFL().log("Connection attempt already in progress");
                    return;
                }
                this.zzbfG = true;
                zzuH.zza(context, intent, (ServiceConnection) zzad.this.zzbfx, 129);
            }
        }
    }

    protected zzad(zzx zzx) {
        super(zzx);
        this.zzbfB = new zzah(zzx.zzlQ());
        this.zzbfx = new zza();
        this.zzbfA = new zzf(zzx) {
            public void run() {
                zzad.this.zzmo();
            }
        };
        this.zzbfD = new zzf(zzx) {
            public void run() {
                zzad.this.zzFm().zzFG().log("Tasks have been queued for a long time");
            }
        };
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void onServiceDisconnected(ComponentName componentName) {
        zzkN();
        if (this.zzbfy != null) {
            this.zzbfy = null;
            zzFm().zzFL().zzj("Disconnected from device MeasurementService", componentName);
            zzGD();
        }
    }

    private boolean zzGB() {
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    @WorkerThread
    private void zzGD() {
        zzkN();
        zzmC();
    }

    @WorkerThread
    private void zzGE() {
        zzkN();
        zzFm().zzFL().zzj("Processing queued up service tasks", Integer.valueOf(this.zzbfC.size()));
        for (Runnable zzg : this.zzbfC) {
            zzFl().zzg(zzg);
        }
        this.zzbfC.clear();
        this.zzbfD.cancel();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(zzm zzm) {
        zzkN();
        zzaa.zzz(zzm);
        this.zzbfy = zzm;
        zzmn();
        zzGE();
    }

    @WorkerThread
    private void zzi(Runnable runnable) throws IllegalStateException {
        zzkN();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzbfC.size()) >= zzFo().zzEQ()) {
            zzFm().zzFE().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzbfC.add(runnable);
            if (!this.zzbbl.zzGh()) {
                this.zzbfD.zzv(60000);
            }
            zzmC();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzmn() {
        zzkN();
        this.zzbfB.start();
        if (!this.zzbbl.zzGh()) {
            this.zzbfA.zzv(zzFo().zznr());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzmo() {
        zzkN();
        if (isConnected()) {
            zzFm().zzFL().log("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    @WorkerThread
    public void disconnect() {
        zzkN();
        zzma();
        try {
            zzb.zzuH().zza(getContext(), (ServiceConnection) this.zzbfx);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.zzbfy = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzkN();
        zzma();
        return this.zzbfy != null;
    }

    public /* bridge */ /* synthetic */ void zzFb() {
        super.zzFb();
    }

    public /* bridge */ /* synthetic */ zzc zzFc() {
        return super.zzFc();
    }

    public /* bridge */ /* synthetic */ zzac zzFd() {
        return super.zzFd();
    }

    public /* bridge */ /* synthetic */ zzn zzFe() {
        return super.zzFe();
    }

    public /* bridge */ /* synthetic */ zzg zzFf() {
        return super.zzFf();
    }

    public /* bridge */ /* synthetic */ zzad zzFg() {
        return super.zzFg();
    }

    public /* bridge */ /* synthetic */ zze zzFh() {
        return super.zzFh();
    }

    public /* bridge */ /* synthetic */ zzal zzFi() {
        return super.zzFi();
    }

    public /* bridge */ /* synthetic */ zzv zzFj() {
        return super.zzFj();
    }

    public /* bridge */ /* synthetic */ zzaf zzFk() {
        return super.zzFk();
    }

    public /* bridge */ /* synthetic */ zzw zzFl() {
        return super.zzFl();
    }

    public /* bridge */ /* synthetic */ zzp zzFm() {
        return super.zzFm();
    }

    public /* bridge */ /* synthetic */ zzt zzFn() {
        return super.zzFn();
    }

    public /* bridge */ /* synthetic */ zzd zzFo() {
        return super.zzFo();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzGA() {
        zzkN();
        zzma();
        zzi(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.zzbfy;
                if (zzc == null) {
                    zzad.this.zzFm().zzFE().log("Failed to send measurementEnabled to service");
                    return;
                }
                try {
                    zzc.zzb(zzad.this.zzFe().zzfs(zzad.this.zzFm().zzFM()));
                    zzad.this.zzmn();
                } catch (RemoteException e) {
                    zzad.this.zzFm().zzFE().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzGC() {
        zzkN();
        zzma();
        if (zzFo().zzmW()) {
            return true;
        }
        zzFm().zzFL().log("Checking service availability");
        switch (zzc.zzqV().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzFm().zzFL().log("Service available");
                return true;
            case 1:
                zzFm().zzFL().log("Service missing");
                return false;
            case 2:
                zzFm().zzFK().log("Service container out of date");
                return true;
            case 3:
                zzFm().zzFG().log("Service disabled");
                return false;
            case 9:
                zzFm().zzFG().log("Service invalid");
                return false;
            case 18:
                zzFm().zzFG().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzGx() {
        zzkN();
        zzma();
        zzi(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.zzbfy;
                if (zzc == null) {
                    zzad.this.zzFm().zzFE().log("Discarding data. Failed to send app launch");
                    return;
                }
                try {
                    zzc.zza(zzad.this.zzFe().zzfs(zzad.this.zzFm().zzFM()));
                    zzad.this.zzmn();
                } catch (RemoteException e) {
                    zzad.this.zzFm().zzFE().zzj("Failed to send app launch to AppMeasurementService", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zza(final UserAttributeParcel userAttributeParcel) {
        zzkN();
        zzma();
        zzi(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.zzbfy;
                if (zzc == null) {
                    zzad.this.zzFm().zzFE().log("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    zzc.zza(userAttributeParcel, zzad.this.zzFe().zzfs(zzad.this.zzFm().zzFM()));
                    zzad.this.zzmn();
                } catch (RemoteException e) {
                    zzad.this.zzFm().zzFE().zzj("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zza(final AtomicReference<List<UserAttributeParcel>> atomicReference, final boolean z) {
        zzkN();
        zzma();
        zzi(new Runnable() {
            /* JADX INFO: finally extract failed */
            public void run() {
                synchronized (atomicReference) {
                    try {
                        zzm zzc = zzad.this.zzbfy;
                        if (zzc == null) {
                            zzad.this.zzFm().zzFE().log("Failed to get user properties");
                            atomicReference.notify();
                            return;
                        }
                        atomicReference.set(zzc.zza(zzad.this.zzFe().zzfs((String) null), z));
                        zzad.this.zzmn();
                        atomicReference.notify();
                    } catch (RemoteException e) {
                        zzad.this.zzFm().zzFE().zzj("Failed to get user properties", e);
                        atomicReference.notify();
                    } catch (Throwable th) {
                        atomicReference.notify();
                        throw th;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzc(final EventParcel eventParcel, final String str) {
        zzaa.zzz(eventParcel);
        zzkN();
        zzma();
        zzi(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.zzbfy;
                if (zzc == null) {
                    zzad.this.zzFm().zzFE().log("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        zzc.zza(eventParcel, zzad.this.zzFe().zzfs(zzad.this.zzFm().zzFM()));
                    } else {
                        zzc.zza(eventParcel, str, zzad.this.zzFm().zzFM());
                    }
                    zzad.this.zzmn();
                } catch (RemoteException e) {
                    zzad.this.zzFm().zzFE().zzj("Failed to send event to AppMeasurementService", e);
                }
            }
        });
    }

    public /* bridge */ /* synthetic */ void zzkN() {
        super.zzkN();
    }

    /* access modifiers changed from: protected */
    public void zzkO() {
    }

    public /* bridge */ /* synthetic */ void zzlP() {
        super.zzlP();
    }

    public /* bridge */ /* synthetic */ zze zzlQ() {
        return super.zzlQ();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzmC() {
        zzkN();
        zzma();
        if (!isConnected()) {
            if (this.zzbfz == null) {
                this.zzbfz = zzFn().zzFS();
                if (this.zzbfz == null) {
                    zzFm().zzFL().log("State of service unknown");
                    this.zzbfz = Boolean.valueOf(zzGC());
                    zzFn().zzaw(this.zzbfz.booleanValue());
                }
            }
            if (this.zzbfz.booleanValue()) {
                zzFm().zzFL().log("Using measurement service");
                this.zzbfx.zzGF();
            } else if (!this.zzbbl.zzGh() && zzGB()) {
                zzFm().zzFL().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzbfx.zzx(intent);
            } else if (zzFo().zzmX()) {
                zzFm().zzFL().log("Using direct local measurement implementation");
                zza((zzm) new zzy(this.zzbbl, true));
            } else {
                zzFm().zzFE().log("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }
}
