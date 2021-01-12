package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzac extends zzaa {
    private zza zzbfh;
    private AppMeasurement.zzb zzbfi;
    private final Set<AppMeasurement.zzc> zzbfj = new HashSet();
    private boolean zzbfk;

    @MainThread
    @TargetApi(14)
    private class zza implements Application.ActivityLifecycleCallbacks {
        private zza() {
        }

        private boolean zzfE(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzac.this.zzc("auto", "_ldl", str);
            return true;
        }

        private boolean zzq(Uri uri) {
            String queryParameter = uri.getQueryParameter("utm_campaign");
            String queryParameter2 = uri.getQueryParameter("utm_source");
            String queryParameter3 = uri.getQueryParameter("utm_medium");
            String queryParameter4 = uri.getQueryParameter("gclid");
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return false;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("term", queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("content", queryParameter6);
            }
            String queryParameter7 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("aclid", queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("cp1", queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("anid", queryParameter9);
            }
            zzac.this.zze("auto", "_cmp", bundle);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Uri data;
            try {
                zzac.this.zzFm().zzFL().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    if (bundle == null) {
                        zzq(data);
                    }
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (!queryParameter.contains("gclid")) {
                            zzac.this.zzFm().zzFK().log("Activity created with data 'referrer' param without gclid");
                            return;
                        }
                        zzac.this.zzFm().zzFK().zzj("Activity created with referrer", queryParameter);
                        zzfE(queryParameter);
                    }
                }
            } catch (Throwable th) {
                zzac.this.zzFm().zzFE().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            zzac.this.zzFk().zzGI();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            zzac.this.zzFk().zzGG();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzac(zzx zzx) {
        super(zzx);
    }

    @WorkerThread
    private void zzGy() {
        try {
            zzg(Class.forName(zzGz()));
        } catch (ClassNotFoundException e) {
            zzFm().zzFJ().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzGz() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzlQ().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(String str, String str2, Object obj, long j) {
        zzaa.zzdl(str);
        zzaa.zzdl(str2);
        zzkN();
        zzlP();
        zzma();
        if (!this.zzbbl.isEnabled()) {
            zzFm().zzFK().log("User property not set since app measurement is disabled");
        } else if (this.zzbbl.zzFX()) {
            zzFm().zzFK().zze("Setting user property (FE)", str2, obj);
            zzFg().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzay(boolean z) {
        zzkN();
        zzlP();
        zzma();
        zzFm().zzFK().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzFn().setMeasurementEnabled(z);
        zzFg().zzGA();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzaa.zzdl(str);
        zzaa.zzdl(str2);
        zzaa.zzz(bundle);
        zzkN();
        zzma();
        if (!this.zzbbl.isEnabled()) {
            zzFm().zzFK().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zzbfk) {
            this.zzbfk = true;
            zzGy();
        }
        boolean zzfQ = zzal.zzfQ(str2);
        if (z && this.zzbfi != null && !zzfQ) {
            zzFm().zzFK().zze("Passing event to registered event handler (FE)", str2, bundle);
            this.zzbfi.zzb(str, str2, bundle, j);
        } else if (this.zzbbl.zzFX()) {
            int zzfI = zzFi().zzfI(str2);
            if (zzfI != 0) {
                this.zzbbl.zzFi().zze(zzfI, "_ev", zzFi().zza(str2, zzFo().zzEw(), true));
                return;
            }
            bundle.putString("_o", str);
            Bundle zza2 = zzFi().zza(str2, bundle, (List<String>) zzf.zzA("_o"), z3);
            Bundle zzJ = z2 ? zzJ(zza2) : zza2;
            zzFm().zzFK().zze("Logging event (FE)", str2, zzJ);
            zzFg().zzc(new EventParcel(str2, new EventParams(zzJ), str, j), str3);
            for (AppMeasurement.zzc zzc : this.zzbfj) {
                zzc.zzc(str, str2, zzJ, j);
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean z) {
        zzma();
        zzlP();
        zzFl().zzg(new Runnable() {
            public void run() {
                zzac.this.zzay(z);
            }
        });
    }

    public void setMinimumSessionDuration(final long j) {
        zzlP();
        zzFl().zzg(new Runnable() {
            public void run() {
                zzac.this.zzFn().zzbdP.set(j);
                zzac.this.zzFm().zzFK().zzj("Minimum session duration set", Long.valueOf(j));
            }
        });
    }

    public void setSessionTimeoutDuration(final long j) {
        zzlP();
        zzFl().zzg(new Runnable() {
            public void run() {
                zzac.this.zzFn().zzbdQ.set(j);
                zzac.this.zzFm().zzFK().zzj("Session timeout duration set", Long.valueOf(j));
            }
        });
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

    @TargetApi(14)
    public void zzGw() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzbfh == null) {
                this.zzbfh = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzbfh);
            application.registerActivityLifecycleCallbacks(this.zzbfh);
            zzFm().zzFL().log("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzGx() {
        zzkN();
        zzlP();
        zzma();
        if (this.zzbbl.zzFX()) {
            zzFg().zzGx();
            String zzFU = zzFn().zzFU();
            if (!TextUtils.isEmpty(zzFU) && !zzFU.equals(zzFf().zzFx())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzFU);
                zze("auto", "_ou", bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle zzJ(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzFi().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzFm().zzFG().zzj("Param value can't be null", str);
                } else if ((!(zzl instanceof String) && !(zzl instanceof Character) && !(zzl instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(zzl))) {
                    zzFi().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
    }

    @WorkerThread
    public void zza(AppMeasurement.zzb zzb) {
        zzkN();
        zzlP();
        zzma();
        if (!(zzb == null || zzb == this.zzbfi)) {
            zzaa.zza(this.zzbfi == null, (Object) "EventInterceptor already set.");
        }
        this.zzbfi = zzb;
    }

    @WorkerThread
    public void zza(AppMeasurement.zzc zzc) {
        zzkN();
        zzlP();
        zzma();
        zzaa.zzz(zzc);
        if (this.zzbfj.contains(zzc)) {
            throw new IllegalStateException("OnEventListener already registered.");
        }
        this.zzbfj.add(zzc);
    }

    /* access modifiers changed from: protected */
    public void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        final Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final String str6 = str3;
        zzFl().zzg(new Runnable() {
            public void run() {
                zzac.this.zzb(str4, str5, j2, bundle2, z4, z5, z6, str6);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void zza(String str, String str2, long j, Object obj) {
        final String str3 = str;
        final String str4 = str2;
        final Object obj2 = obj;
        final long j2 = j;
        zzFl().zzg(new Runnable() {
            public void run() {
                zzac.this.zza(str3, str4, obj2, j2);
            }
        });
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzlP();
        zza(str, str2, bundle, true, this.zzbfi == null || zzal.zzfQ(str2), z, (String) null);
    }

    @Nullable
    @WorkerThread
    public List<UserAttributeParcel> zzaz(final boolean z) {
        zzlP();
        zzma();
        zzFm().zzFK().log("Fetching user attributes (FE)");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzFm().zzFG().log("getUserProperties called from main thread.");
            return null;
        }
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzbbl.zzFl().zzg(new Runnable() {
                public void run() {
                    zzac.this.zzFg().zza((AtomicReference<List<UserAttributeParcel>>) atomicReference, z);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzFm().zzFG().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<UserAttributeParcel> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzFm().zzFG().log("Timed out waiting for get user properties");
        return null;
    }

    public void zzc(String str, String str2, Object obj) {
        zzaa.zzdl(str);
        long currentTimeMillis = zzlQ().currentTimeMillis();
        int zzfK = zzFi().zzfK(str2);
        if (zzfK != 0) {
            this.zzbbl.zzFi().zze(zzfK, "_ev", zzFi().zza(str2, zzFo().zzEx(), true));
        } else if (obj != null) {
            int zzm = zzFi().zzm(str2, obj);
            if (zzm != 0) {
                this.zzbbl.zzFi().zze(zzm, "_ev", zzFi().zza(str2, zzFo().zzEx(), true));
                return;
            }
            Object zzn = zzFi().zzn(str2, obj);
            if (zzn != null) {
                zza(str, str2, currentTimeMillis, zzn);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzlP();
        zza(str, str2, j, bundle, false, true, true, (String) null);
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzlP();
        zza(str, str2, bundle, true, this.zzbfi == null || zzal.zzfQ(str2), false, (String) null);
    }

    @WorkerThread
    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{getContext()});
        } catch (Exception e) {
            zzFm().zzFG().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
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
}
