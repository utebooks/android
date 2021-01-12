package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzqi {
    private static zzqj zzaCm;
    private static final zzb.zza zzaCn = new zzb.zza() {
        public int zzd(Context context, String str, boolean z) {
            return zzqi.zzd(context, str, z);
        }

        public int zzo(Context context, String str) {
            return zzqi.zzo(context, str);
        }
    };
    public static final zzb zzaCo = new zzb() {
        public zzb.C0778zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0778zzb zzb = new zzb.C0778zzb();
            zzb.zzaCw = zza.zzd(context, str, true);
            if (zzb.zzaCw != 0) {
                zzb.zzaCx = 1;
            } else {
                zzb.zzaCv = zza.zzo(context, str);
                if (zzb.zzaCv != 0) {
                    zzb.zzaCx = -1;
                }
            }
            return zzb;
        }
    };
    public static final zzb zzaCp = new zzb() {
        public zzb.C0778zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0778zzb zzb = new zzb.C0778zzb();
            zzb.zzaCv = zza.zzo(context, str);
            if (zzb.zzaCv != 0) {
                zzb.zzaCx = -1;
            } else {
                zzb.zzaCw = zza.zzd(context, str, true);
                if (zzb.zzaCw != 0) {
                    zzb.zzaCx = 1;
                }
            }
            return zzb;
        }
    };
    public static final zzb zzaCq = new zzb() {
        public zzb.C0778zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0778zzb zzb = new zzb.C0778zzb();
            zzb.zzaCv = zza.zzo(context, str);
            zzb.zzaCw = zza.zzd(context, str, true);
            if (zzb.zzaCv == 0 && zzb.zzaCw == 0) {
                zzb.zzaCx = 0;
            } else if (zzb.zzaCv >= zzb.zzaCw) {
                zzb.zzaCx = -1;
            } else {
                zzb.zzaCx = 1;
            }
            return zzb;
        }
    };
    public static final zzb zzaCr = new zzb() {
        public zzb.C0778zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0778zzb zzb = new zzb.C0778zzb();
            zzb.zzaCv = zza.zzo(context, str);
            zzb.zzaCw = zza.zzd(context, str, true);
            if (zzb.zzaCv == 0 && zzb.zzaCw == 0) {
                zzb.zzaCx = 0;
            } else if (zzb.zzaCw >= zzb.zzaCv) {
                zzb.zzaCx = 1;
            } else {
                zzb.zzaCx = -1;
            }
            return zzb;
        }
    };
    public static final zzb zzaCs = new zzb() {
        public zzb.C0778zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0778zzb zzb = new zzb.C0778zzb();
            zzb.zzaCv = zza.zzo(context, str);
            if (zzb.zzaCv != 0) {
                zzb.zzaCw = zza.zzd(context, str, false);
            } else {
                zzb.zzaCw = zza.zzd(context, str, true);
            }
            if (zzb.zzaCv == 0 && zzb.zzaCw == 0) {
                zzb.zzaCx = 0;
            } else if (zzb.zzaCw >= zzb.zzaCv) {
                zzb.zzaCx = 1;
            } else {
                zzb.zzaCx = -1;
            }
            return zzb;
        }
    };
    private final Context zzaCt;

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzo(Context context, String str);
        }

        /* renamed from: com.google.android.gms.internal.zzqi$zzb$zzb  reason: collision with other inner class name */
        public static class C0778zzb {
            public int zzaCv = 0;
            public int zzaCw = 0;
            public int zzaCx = 0;
        }

        C0778zzb zza(Context context, String str, zza zza2);
    }

    private zzqi(Context context) {
        this.zzaCt = (Context) zzaa.zzz(context);
    }

    public static zzqi zza(Context context, zzb zzb2, String str) throws zza {
        zzb.C0778zzb zza2 = zzb2.zza(context, str, zzaCn);
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza2.zzaCv).append(" and remote module ").append(str).append(":").append(zza2.zzaCw).toString());
        if (zza2.zzaCx == 0 || ((zza2.zzaCx == -1 && zza2.zzaCv == 0) || (zza2.zzaCx == 1 && zza2.zzaCw == 0))) {
            throw new zza(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza2.zzaCv).append(" and remote version is ").append(zza2.zzaCw).append(".").toString());
        } else if (zza2.zzaCx == -1) {
            return zzq(context, str);
        } else {
            if (zza2.zzaCx == 1) {
                try {
                    return zza(context, str, zza2.zzaCw);
                } catch (zza e) {
                    zza zza3 = e;
                    String valueOf = String.valueOf(zza3.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (zza2.zzaCv != 0) {
                        final int i = zza2.zzaCv;
                        if (zzb2.zza(context, str, new zzb.zza() {
                            public int zzd(Context context, String str, boolean z) {
                                return 0;
                            }

                            public int zzo(Context context, String str) {
                                return i;
                            }
                        }).zzaCx == -1) {
                            return zzq(context, str);
                        }
                    }
                    throw new zza("Remote load failed. No local fallback found.", zza3);
                }
            } else {
                throw new zza(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza2.zzaCx).toString());
            }
        }
    }

    private static zzqi zza(Context context, String str, int i) throws zza {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzqj zzaJ = zzaJ(context);
        if (zzaJ == null) {
            throw new zza("Failed to create IDynamiteLoader.");
        }
        try {
            zzd zza2 = zzaJ.zza(zze.zzD(context), str, i);
            if (zze.zzx(zza2) != null) {
                return new zzqi((Context) zze.zzx(zza2));
            }
            throw new zza("Failed to load remote module.");
        } catch (RemoteException e) {
            throw new zza("Failed to load remote module.", e);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.zzqj zzaJ(android.content.Context r6) {
        /*
            r1 = 0
            java.lang.Class<com.google.android.gms.internal.zzqi> r2 = com.google.android.gms.internal.zzqi.class
            monitor-enter(r2)
            com.google.android.gms.internal.zzqj r0 = zzaCm     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x000c
            com.google.android.gms.internal.zzqj r0 = zzaCm     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
        L_0x000b:
            return r0
        L_0x000c:
            com.google.android.gms.common.zzc r0 = com.google.android.gms.common.zzc.zzqV()     // Catch:{ all -> 0x003a }
            int r0 = r0.isGooglePlayServicesAvailable(r6)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0019
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            r0 = r1
            goto L_0x000b
        L_0x0019:
            java.lang.String r0 = "com.google.android.gms"
            r3 = 3
            android.content.Context r0 = r6.createPackageContext(r0, r3)     // Catch:{ Exception -> 0x003d }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
            java.lang.Class r0 = r0.loadClass(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x003d }
            android.os.IBinder r0 = (android.os.IBinder) r0     // Catch:{ Exception -> 0x003d }
            com.google.android.gms.internal.zzqj r0 = com.google.android.gms.internal.zzqj.zza.zzbA(r0)     // Catch:{ Exception -> 0x003d }
            if (r0 == 0) goto L_0x0057
            zzaCm = r0     // Catch:{ Exception -> 0x003d }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            goto L_0x000b
        L_0x003a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r0
        L_0x003d:
            r0 = move-exception
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r4 = "Failed to load IDynamiteLoader from GmsCore: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x003a }
            int r5 = r0.length()     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x005a
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x003a }
        L_0x0054:
            android.util.Log.e(r3, r0)     // Catch:{ all -> 0x003a }
        L_0x0057:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            r0 = r1
            goto L_0x000b
        L_0x005a:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x003a }
            r0.<init>(r4)     // Catch:{ all -> 0x003a }
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqi.zzaJ(android.content.Context):com.google.android.gms.internal.zzqj");
    }

    public static int zzd(Context context, String str, boolean z) {
        zzqj zzaJ = zzaJ(context);
        if (zzaJ == null) {
            return 0;
        }
        try {
            return zzaJ.zza(zze.zzD(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    public static int zzo(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            String valueOf2 = String.valueOf("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length() + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf3 = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", new StringBuilder(String.valueOf(valueOf3).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf3).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (Exception e) {
            String valueOf4 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf4.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf4) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzp(Context context, String str) {
        return zzd(context, str, false);
    }

    private static zzqi zzq(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new zzqi(context.getApplicationContext());
    }

    public IBinder zzdM(String str) throws zza {
        try {
            return (IBinder) this.zzaCt.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e);
        }
    }

    public Context zzxi() {
        return this.zzaCt;
    }
}
