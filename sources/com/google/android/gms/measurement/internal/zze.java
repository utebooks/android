package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class zze extends zzaa {
    /* access modifiers changed from: private */
    public static final Map<String, String> zzbbU = new ArrayMap(16);
    private final zzc zzbbV = new zzc(getContext(), zzmv());
    /* access modifiers changed from: private */
    public final zzah zzbbW = new zzah(zzlQ());

    public static class zza {
        long zzbbX;
        long zzbbY;
        long zzbbZ;
        long zzbca;
    }

    interface zzb {
        boolean zza(long j, zzsp.zzb zzb);

        void zzc(zzsp.zze zze);
    }

    private class zzc extends SQLiteOpenHelper {
        zzc(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
            if (!zza(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                zze.this.zzFm().zzFE().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
            Set<String> zzb = zzb(sQLiteDatabase, str);
            for (String str3 : str2.split(",")) {
                if (!zzb.remove(str3)) {
                    throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    if (!zzb.remove(next.getKey())) {
                        sQLiteDatabase.execSQL((String) next.getValue());
                    }
                }
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
        @android.support.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zza(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                r0 = 0
                r4[r0] = r12     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0048 }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r1 = r9
            L_0x0028:
                com.google.android.gms.measurement.internal.zze r2 = com.google.android.gms.measurement.internal.zze.this     // Catch:{ all -> 0x0045 }
                com.google.android.gms.measurement.internal.zzp r2 = r2.zzFm()     // Catch:{ all -> 0x0045 }
                com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFG()     // Catch:{ all -> 0x0045 }
                java.lang.String r3 = "Error querying for table"
                r2.zze(r3, r12, r0)     // Catch:{ all -> 0x0045 }
                if (r1 == 0) goto L_0x003c
                r1.close()
            L_0x003c:
                r0 = r8
                goto L_0x0025
            L_0x003e:
                r0 = move-exception
            L_0x003f:
                if (r9 == 0) goto L_0x0044
                r9.close()
            L_0x0044:
                throw r0
            L_0x0045:
                r0 = move-exception
                r9 = r1
                goto L_0x003f
            L_0x0048:
                r0 = move-exception
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzc.zza(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        @WorkerThread
        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), (String[]) null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            if (!zze.this.zzbbW.zzx(zze.this.zzFo().zzEJ())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zze.this.zzbbW.start();
                zze.this.zzFm().zzFE().log("Opening the database failed, dropping and recreating it");
                zze.this.getContext().getDatabasePath(zze.this.zzmv()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zze.this.zzbbW.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zze.this.zzFm().zzFE().zzj("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[]) null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            zza(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", (Map<String, String>) null);
            zza(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", (Map<String, String>) null);
            zza(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.zzbbU);
            zza(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", (Map<String, String>) null);
            zza(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", (Map<String, String>) null);
            zza(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", (Map<String, String>) null);
            zza(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", (Map<String, String>) null);
            zza(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", (Map<String, String>) null);
            zza(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", (Map<String, String>) null);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        zzbbU.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        zzbbU.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        zzbbU.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        zzbbU.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        zzbbU.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        zzbbU.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        zzbbU.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        zzbbU.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        zzbbU.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        zzbbU.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        zzbbU.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        zzbbU.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        zzbbU.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        zzbbU.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        zzbbU.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        zzbbU.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    zze(zzx zzx) {
        super(zzx);
    }

    private boolean zzFv() {
        return getContext().getDatabasePath(zzmv()).exists();
    }

    @WorkerThread
    @TargetApi(11)
    static int zza(Cursor cursor, int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    @WorkerThread
    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzFm().zzFE().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(java.lang.String r8, com.google.android.gms.internal.zzsn.zza r9) {
        /*
            r7 = this;
            r0 = 0
            r7.zzma()
            r7.zzkN()
            com.google.android.gms.common.internal.zzaa.zzdl(r8)
            com.google.android.gms.common.internal.zzaa.zzz(r9)
            com.google.android.gms.internal.zzsn$zzb[] r1 = r9.zzbgk
            com.google.android.gms.common.internal.zzaa.zzz(r1)
            com.google.android.gms.internal.zzsn$zze[] r1 = r9.zzbgj
            com.google.android.gms.common.internal.zzaa.zzz(r1)
            java.lang.Integer r1 = r9.zzbgi
            if (r1 != 0) goto L_0x0029
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzFm()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFG()
            java.lang.String r1 = "Audience with no ID"
            r0.log(r1)
        L_0x0028:
            return
        L_0x0029:
            java.lang.Integer r1 = r9.zzbgi
            int r3 = r1.intValue()
            com.google.android.gms.internal.zzsn$zzb[] r2 = r9.zzbgk
            int r4 = r2.length
            r1 = r0
        L_0x0033:
            if (r1 >= r4) goto L_0x004e
            r5 = r2[r1]
            java.lang.Integer r5 = r5.zzbgm
            if (r5 != 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzFm()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFG()
            java.lang.String r1 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Integer r2 = r9.zzbgi
            r0.zze(r1, r8, r2)
            goto L_0x0028
        L_0x004b:
            int r1 = r1 + 1
            goto L_0x0033
        L_0x004e:
            com.google.android.gms.internal.zzsn$zze[] r2 = r9.zzbgj
            int r4 = r2.length
            r1 = r0
        L_0x0052:
            if (r1 >= r4) goto L_0x006d
            r5 = r2[r1]
            java.lang.Integer r5 = r5.zzbgm
            if (r5 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzFm()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFG()
            java.lang.String r1 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Integer r2 = r9.zzbgi
            r0.zze(r1, r8, r2)
            goto L_0x0028
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x0052
        L_0x006d:
            r1 = 1
            com.google.android.gms.internal.zzsn$zzb[] r4 = r9.zzbgk
            int r5 = r4.length
            r2 = r0
        L_0x0072:
            if (r2 >= r5) goto L_0x007d
            r6 = r4[r2]
            boolean r6 = r7.zza((java.lang.String) r8, (int) r3, (com.google.android.gms.internal.zzsn.zzb) r6)
            if (r6 != 0) goto L_0x0093
            r1 = r0
        L_0x007d:
            if (r1 == 0) goto L_0x0099
            com.google.android.gms.internal.zzsn$zze[] r4 = r9.zzbgj
            int r5 = r4.length
            r2 = r0
        L_0x0083:
            if (r2 >= r5) goto L_0x0099
            r6 = r4[r2]
            boolean r6 = r7.zza((java.lang.String) r8, (int) r3, (com.google.android.gms.internal.zzsn.zze) r6)
            if (r6 != 0) goto L_0x0096
        L_0x008d:
            if (r0 != 0) goto L_0x0028
            r7.zzz(r8, r3)
            goto L_0x0028
        L_0x0093:
            int r2 = r2 + 1
            goto L_0x0072
        L_0x0096:
            int r2 = r2 + 1
            goto L_0x0083
        L_0x0099:
            r0 = r1
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(java.lang.String, com.google.android.gms.internal.zzsn$zza):void");
    }

    @WorkerThread
    private boolean zza(String str, int i, zzsn.zzb zzb2) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        zzaa.zzz(zzb2);
        if (TextUtils.isEmpty(zzb2.zzbgn)) {
            zzFm().zzFG().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zzb2.zzbgm));
            return false;
        }
        try {
            byte[] bArr = new byte[zzb2.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zzb2.writeTo(zzO);
            zzO.zzWU();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzb2.zzbgm);
            contentValues.put("event_name", zzb2.zzbgn);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", (String) null, contentValues, 5) == -1) {
                    zzFm().zzFE().log("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzFm().zzFE().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, zzsn.zze zze) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        zzaa.zzz(zze);
        if (TextUtils.isEmpty(zze.zzbgC)) {
            zzFm().zzFG().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zze.zzbgm));
            return false;
        }
        try {
            byte[] bArr = new byte[zze.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zze.writeTo(zzO);
            zzO.zzWU();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zze.zzbgm);
            contentValues.put("property_name", zze.zzbgC);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                    return true;
                }
                zzFm().zzFE().log("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzFm().zzFE().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    @WorkerThread
    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzFm().zzFE().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public void beginTransaction() {
        zzma();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public void endTransaction() {
        zzma();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public SQLiteDatabase getWritableDatabase() {
        zzkN();
        try {
            return this.zzbbV.getWritableDatabase();
        } catch (SQLiteException e) {
            zzFm().zzFG().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public void setTransactionSuccessful() {
        zzma();
        getWritableDatabase().setTransactionSuccessful();
    }

    public void zzC(List<Long> list) {
        zzaa.zzz(list);
        zzkN();
        zzma();
        StringBuilder sb = new StringBuilder("rowid in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(list.get(i2).longValue());
            i = i2 + 1;
        }
        sb.append(")");
        int delete = getWritableDatabase().delete("raw_events", sb.toString(), (String[]) null);
        if (delete != list.size()) {
            zzFm().zzFE().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zzFp() {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()
            java.lang.String r2 = "select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0023, all -> 0x0038 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0043 }
            if (r1 == 0) goto L_0x001d
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0043 }
            if (r2 == 0) goto L_0x001c
            r2.close()
        L_0x001c:
            return r0
        L_0x001d:
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0023:
            r1 = move-exception
            r2 = r0
        L_0x0025:
            com.google.android.gms.measurement.internal.zzp r3 = r5.zzFm()     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFE()     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzj(r4, r1)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0038:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            throw r0
        L_0x0041:
            r0 = move-exception
            goto L_0x003b
        L_0x0043:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzFp():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzFq() {
        zzkN();
        zzma();
        if (zzFv()) {
            long j = zzFn().zzbdJ.get();
            long elapsedRealtime = zzlQ().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzFo().zzEP()) {
                zzFn().zzbdJ.set(elapsedRealtime);
                zzFr();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzFr() {
        int delete;
        zzkN();
        zzma();
        if (zzFv() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzlQ().currentTimeMillis()), String.valueOf(zzFo().zzEO())})) > 0) {
            zzFm().zzFL().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
        }
    }

    @WorkerThread
    public long zzFs() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @WorkerThread
    public long zzFt() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public boolean zzFu() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zzi zzO(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzaa.zzdl(r13)
            com.google.android.gms.common.internal.zzaa.zzdl(r14)
            r12.zzkN()
            r12.zzma()
            android.database.sqlite.SQLiteDatabase r0 = r12.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            java.lang.String r1 = "events"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 0
            java.lang.String r4 = "lifetime_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 1
            java.lang.String r4 = "current_bundle_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 2
            java.lang.String r4 = "last_fire_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 0
            r4[r5] = r13     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 1
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            if (r0 != 0) goto L_0x0044
            if (r11 == 0) goto L_0x0042
            r11.close()
        L_0x0042:
            r1 = r10
        L_0x0043:
            return r1
        L_0x0044:
            r0 = 0
            long r4 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r0 = 1
            long r6 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r0 = 2
            long r8 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzi r1 = new com.google.android.gms.measurement.internal.zzi     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r6, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzp r0 = r12.zzFm()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFE()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one"
            r0.log(r2)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
        L_0x006d:
            if (r11 == 0) goto L_0x0043
            r11.close()
            goto L_0x0043
        L_0x0073:
            r0 = move-exception
            r1 = r10
        L_0x0075:
            com.google.android.gms.measurement.internal.zzp r2 = r12.zzFm()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "Error querying events"
            r2.zzd(r3, r13, r14, r0)     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0087
            r1.close()
        L_0x0087:
            r1 = r10
            goto L_0x0043
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            if (r10 == 0) goto L_0x008f
            r10.close()
        L_0x008f:
            throw r0
        L_0x0090:
            r0 = move-exception
            r10 = r11
            goto L_0x008a
        L_0x0093:
            r0 = move-exception
            r10 = r1
            goto L_0x008a
        L_0x0096:
            r0 = move-exception
            r1 = r11
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzO(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzi");
    }

    @WorkerThread
    public void zzP(String str, String str2) {
        zzaa.zzdl(str);
        zzaa.zzdl(str2);
        zzkN();
        zzma();
        try {
            zzFm().zzFL().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzFm().zzFE().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zzak zzQ(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzaa.zzdl(r10)
            com.google.android.gms.common.internal.zzaa.zzdl(r11)
            r9.zzkN()
            r9.zzma()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            java.lang.String r1 = "user_attributes"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r3 = 0
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r3 = 1
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 1
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            if (r0 != 0) goto L_0x003f
            if (r7 == 0) goto L_0x003d
            r7.close()
        L_0x003d:
            r1 = r8
        L_0x003e:
            return r1
        L_0x003f:
            r0 = 0
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            r0 = 1
            java.lang.Object r6 = r9.zzb((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzak r1 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzp r0 = r9.zzFm()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFE()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            java.lang.String r2 = "Got multiple records for user property, expected one"
            r0.log(r2)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
        L_0x0063:
            if (r7 == 0) goto L_0x003e
            r7.close()
            goto L_0x003e
        L_0x0069:
            r0 = move-exception
            r1 = r8
        L_0x006b:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzFm()     // Catch:{ all -> 0x0089 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "Error querying user property"
            r2.zzd(r3, r10, r11, r0)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            r1 = r8
            goto L_0x003e
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            if (r8 == 0) goto L_0x0085
            r8.close()
        L_0x0085:
            throw r0
        L_0x0086:
            r0 = move-exception
            r8 = r7
            goto L_0x0080
        L_0x0089:
            r0 = move-exception
            r8 = r1
            goto L_0x0080
        L_0x008c:
            r0 = move-exception
            r1 = r7
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzQ(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzak");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzsn.zzb>> zzR(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzma()
            r10.zzkN()
            com.google.android.gms.common.internal.zzaa.zzdl(r11)
            com.google.android.gms.common.internal.zzaa.zzdl(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "event_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            java.lang.String r3 = "app_id=? AND event_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0097 }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzamb r0 = com.google.android.gms.internal.zzamb.zzN(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzsn$zzb r2 = new com.google.android.gms.internal.zzsn$zzb     // Catch:{ SQLiteException -> 0x0097 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzamj r0 = r2.mergeFrom(r0)     // Catch:{ IOException -> 0x0088 }
            com.google.android.gms.internal.zzsn$zzb r0 = (com.google.android.gms.internal.zzsn.zzb) r0     // Catch:{ IOException -> 0x0088 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0078
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0097 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x0078:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x007b:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            r0 = r8
            goto L_0x0046
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzFm()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch:{ SQLiteException -> 0x0097 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzFm()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00aa
            r1.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0046
        L_0x00ac:
            r0 = move-exception
            r1 = r9
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()
        L_0x00b3:
            throw r0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00b6:
            r0 = move-exception
            r1 = r9
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzR(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzsn.zze>> zzS(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzma()
            r10.zzkN()
            com.google.android.gms.common.internal.zzaa.zzdl(r11)
            com.google.android.gms.common.internal.zzaa.zzdl(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "property_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            java.lang.String r3 = "app_id=? AND property_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0097 }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzamb r0 = com.google.android.gms.internal.zzamb.zzN(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzsn$zze r2 = new com.google.android.gms.internal.zzsn$zze     // Catch:{ SQLiteException -> 0x0097 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzamj r0 = r2.mergeFrom(r0)     // Catch:{ IOException -> 0x0088 }
            com.google.android.gms.internal.zzsn$zze r0 = (com.google.android.gms.internal.zzsn.zze) r0     // Catch:{ IOException -> 0x0088 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0078
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0097 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x0078:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x007b:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            r0 = r8
            goto L_0x0046
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzFm()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch:{ SQLiteException -> 0x0097 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzFm()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00aa
            r1.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0046
        L_0x00ac:
            r0 = move-exception
            r1 = r9
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()
        L_0x00b3:
            throw r0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00b6:
            r0 = move-exception
            r1 = r9
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzS(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x010b  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zze.zza zza(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.zzaa.zzdl(r14)
            r11.zzkN()
            r11.zzma()
            r0 = 1
            java.lang.String[] r10 = new java.lang.String[r0]
            r0 = 0
            r10[r0] = r14
            com.google.android.gms.measurement.internal.zze$zza r8 = new com.google.android.gms.measurement.internal.zze$zza
            r8.<init>()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            java.lang.String r1 = "apps"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 0
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 1
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 2
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 3
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 4
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r5 = 0
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0111 }
            if (r2 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzFm()     // Catch:{ SQLiteException -> 0x0111 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFG()     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r2 = "Not updating daily counts, app is not known"
            r0.zzj(r2, r14)     // Catch:{ SQLiteException -> 0x0111 }
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            r0 = r8
        L_0x005f:
            return r0
        L_0x0060:
            r2 = 0
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0085
            r2 = 1
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.zzbbY = r2     // Catch:{ SQLiteException -> 0x0111 }
            r2 = 2
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.zzbbX = r2     // Catch:{ SQLiteException -> 0x0111 }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.zzbbZ = r2     // Catch:{ SQLiteException -> 0x0111 }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.zzbca = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x0085:
            long r2 = r8.zzbbY     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.zzbbY = r2     // Catch:{ SQLiteException -> 0x0111 }
            if (r15 == 0) goto L_0x0095
            long r2 = r8.zzbbX     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.zzbbX = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x0095:
            if (r16 == 0) goto L_0x009e
            long r2 = r8.zzbbZ     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.zzbbZ = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x009e:
            if (r17 == 0) goto L_0x00a7
            long r2 = r8.zzbca     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.zzbca = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x00a7:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0111 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "day"
            java.lang.Long r4 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_public_events_count"
            long r4 = r8.zzbbX     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_events_count"
            long r4 = r8.zzbbY     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_conversions_count"
            long r4 = r8.zzbbZ     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_error_events_count"
            long r4 = r8.zzbca     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "apps"
            java.lang.String r4 = "app_id=?"
            r0.update(r3, r2, r4, r10)     // Catch:{ SQLiteException -> 0x0111 }
            if (r1 == 0) goto L_0x00ed
            r1.close()
        L_0x00ed:
            r0 = r8
            goto L_0x005f
        L_0x00f0:
            r0 = move-exception
            r1 = r9
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzFm()     // Catch:{ all -> 0x010f }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x010f }
            java.lang.String r3 = "Error updating daily counts"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x010f }
            if (r1 == 0) goto L_0x0104
            r1.close()
        L_0x0104:
            r0 = r8
            goto L_0x005f
        L_0x0107:
            r0 = move-exception
            r1 = r9
        L_0x0109:
            if (r1 == 0) goto L_0x010e
            r1.close()
        L_0x010e:
            throw r0
        L_0x010f:
            r0 = move-exception
            goto L_0x0109
        L_0x0111:
            r0 = move-exception
            goto L_0x00f2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(long, java.lang.String, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zze$zza");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zza(ContentValues contentValues, String str, Object obj) {
        zzaa.zzdl(str);
        zzaa.zzz(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public void zza(zzsp.zze zze) {
        zzkN();
        zzma();
        zzaa.zzz(zze);
        zzaa.zzdl(zze.appId);
        zzaa.zzz(zze.zzbhi);
        zzFq();
        long currentTimeMillis = zzlQ().currentTimeMillis();
        if (zze.zzbhi.longValue() < currentTimeMillis - zzFo().zzEO() || zze.zzbhi.longValue() > zzFo().zzEO() + currentTimeMillis) {
            zzFm().zzFG().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), zze.zzbhi);
        }
        try {
            byte[] bArr = new byte[zze.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zze.writeTo(zzO);
            zzO.zzWU();
            byte[] zzh = zzFi().zzh(bArr);
            zzFm().zzFL().zzj("Saving bundle, size", Integer.valueOf(zzh.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.appId);
            contentValues.put("bundle_end_timestamp", zze.zzbhi);
            contentValues.put("data", zzh);
            try {
                if (getWritableDatabase().insert("queue", (String) null, contentValues) == -1) {
                    zzFm().zzFE().log("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzFm().zzFE().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    @WorkerThread
    public void zza(zza zza2) {
        zzaa.zzz(zza2);
        zzkN();
        zzma();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zza2.zziC());
        contentValues.put("app_instance_id", zza2.zzvx());
        contentValues.put("gmp_app_id", zza2.zzEb());
        contentValues.put("resettable_device_id_hash", zza2.zzEc());
        contentValues.put("last_bundle_index", Long.valueOf(zza2.zzEl()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zza2.zzEe()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zza2.zzEf()));
        contentValues.put("app_version", zza2.zzkV());
        contentValues.put("app_store", zza2.zzEh());
        contentValues.put("gmp_version", Long.valueOf(zza2.zzEi()));
        contentValues.put("dev_cert_hash", Long.valueOf(zza2.zzEj()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zza2.zzEk()));
        contentValues.put("day", Long.valueOf(zza2.zzEp()));
        contentValues.put("daily_public_events_count", Long.valueOf(zza2.zzEq()));
        contentValues.put("daily_events_count", Long.valueOf(zza2.zzEr()));
        contentValues.put("daily_conversions_count", Long.valueOf(zza2.zzEs()));
        contentValues.put("config_fetched_time", Long.valueOf(zza2.zzEm()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zza2.zzEn()));
        contentValues.put("app_version_int", Long.valueOf(zza2.zzEg()));
        contentValues.put("firebase_instance_id", zza2.zzEd());
        contentValues.put("daily_error_events_count", Long.valueOf(zza2.zzEt()));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzFm().zzFE().log("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzFm().zzFE().zzj("Error storing app", e);
        }
    }

    public void zza(zzh zzh, long j) {
        zzkN();
        zzma();
        zzaa.zzz(zzh);
        zzaa.zzdl(zzh.zzPx);
        zzsp.zzb zzb2 = new zzsp.zzb();
        zzb2.zzbgY = Long.valueOf(zzh.zzbci);
        zzb2.zzbgW = new zzsp.zzc[zzh.zzbcj.size()];
        Iterator<String> it = zzh.zzbcj.iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            zzsp.zzc zzc2 = new zzsp.zzc();
            zzb2.zzbgW[i] = zzc2;
            zzc2.name = next;
            zzFi().zza(zzc2, zzh.zzbcj.get(next));
            i++;
        }
        try {
            byte[] bArr = new byte[zzb2.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zzb2.writeTo(zzO);
            zzO.zzWU();
            zzFm().zzFL().zze("Saving event, name, data size", zzh.mName, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzh.zzPx);
            contentValues.put("name", zzh.mName);
            contentValues.put("timestamp", Long.valueOf(zzh.zzajg));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insert("raw_events", (String) null, contentValues) == -1) {
                    zzFm().zzFE().log("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzFm().zzFE().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    @WorkerThread
    public void zza(zzi zzi) {
        zzaa.zzz(zzi);
        zzkN();
        zzma();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzi.zzPx);
        contentValues.put("name", zzi.mName);
        contentValues.put("lifetime_count", Long.valueOf(zzi.zzbck));
        contentValues.put("current_bundle_count", Long.valueOf(zzi.zzbcl));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzi.zzbcm));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzFm().zzFE().log("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzFm().zzFE().zzj("Error storing event aggregates", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(String str, int i, zzsp.zzf zzf) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        zzaa.zzz(zzf);
        try {
            byte[] bArr = new byte[zzf.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zzf.writeTo(zzO);
            zzO.zzWU();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                    zzFm().zzFE().log("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzFm().zzFE().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017a A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(java.lang.String r15, long r16, com.google.android.gms.measurement.internal.zze.zzb r18) {
        /*
            r14 = this;
            r3 = 0
            com.google.android.gms.common.internal.zzaa.zzz(r18)
            r14.zzkN()
            r14.zzma()
            android.database.sqlite.SQLiteDatabase r2 = r14.getWritableDatabase()     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = android.text.TextUtils.isEmpty(r15)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            if (r4 == 0) goto L_0x0077
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            android.database.Cursor r3 = r2.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r4 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x002f
            r3.close()
        L_0x002f:
            return
        L_0x0030:
            r4 = 0
            java.lang.String r15 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r3.close()     // Catch:{ SQLiteException -> 0x017a }
            r12 = r4
            r11 = r3
        L_0x003f:
            java.lang.String r3 = "raw_events_metadata"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 0
            java.lang.String r6 = "metadata"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "app_id=? and metadata_fingerprint=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r6[r7] = r15     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 1
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "2"
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            boolean r3 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r3 != 0) goto L_0x009a
            com.google.android.gms.measurement.internal.zzp r2 = r14.zzFm()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "Raw event metadata record is missing"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r11 == 0) goto L_0x002f
            r11.close()
            goto L_0x002f
        L_0x0077:
            java.lang.String r4 = "select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r6 = 0
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            android.database.Cursor r3 = r2.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r4 != 0) goto L_0x008f
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x008f:
            r4 = 0
            java.lang.String r4 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r3.close()     // Catch:{ SQLiteException -> 0x017a }
            r12 = r4
            r11 = r3
            goto L_0x003f
        L_0x009a:
            r3 = 0
            byte[] r3 = r11.getBlob(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzamb r3 = com.google.android.gms.internal.zzamb.zzN(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzsp$zze r4 = new com.google.android.gms.internal.zzsp$zze     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzamj r3 = r4.mergeFrom(r3)     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.zzsp$zze r3 = (com.google.android.gms.internal.zzsp.zze) r3     // Catch:{ IOException -> 0x0110 }
            boolean r3 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r3 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzp r3 = r14.zzFm()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFG()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "Get multiple raw event metadata records, expected one"
            r3.log(r5)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
        L_0x00c1:
            r11.close()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r0 = r18
            r0.zzc(r4)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "raw_events"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 0
            java.lang.String r6 = "rowid"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 1
            java.lang.String r6 = "name"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 2
            java.lang.String r6 = "timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 3
            java.lang.String r6 = "data"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "app_id=? and metadata_fingerprint=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r6[r7] = r15     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 1
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            r10 = 0
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            boolean r2 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x0125
            com.google.android.gms.measurement.internal.zzp r2 = r14.zzFm()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFG()     // Catch:{ SQLiteException -> 0x017a }
            java.lang.String r4 = "Raw event data disappeared while in transaction"
            r2.log(r4)     // Catch:{ SQLiteException -> 0x017a }
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x0110:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r3 = r14.zzFm()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFE()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata"
            r3.zze(r4, r15, r2)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r11 == 0) goto L_0x002f
            r11.close()
            goto L_0x002f
        L_0x0125:
            r2 = 0
            long r4 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x017a }
            r2 = 3
            byte[] r2 = r3.getBlob(r2)     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzamb r2 = com.google.android.gms.internal.zzamb.zzN(r2)     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzsp$zzb r6 = new com.google.android.gms.internal.zzsp$zzb     // Catch:{ SQLiteException -> 0x017a }
            r6.<init>()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzamj r2 = r6.mergeFrom(r2)     // Catch:{ IOException -> 0x015f }
            com.google.android.gms.internal.zzsp$zzb r2 = (com.google.android.gms.internal.zzsp.zzb) r2     // Catch:{ IOException -> 0x015f }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ SQLiteException -> 0x017a }
            r6.name = r2     // Catch:{ SQLiteException -> 0x017a }
            r2 = 2
            long r8 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x017a }
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x017a }
            r6.zzbgX = r2     // Catch:{ SQLiteException -> 0x017a }
            r0 = r18
            boolean r2 = r0.zza(r4, r6)     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x016d
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x015f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r14.zzFm()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzFE()     // Catch:{ SQLiteException -> 0x017a }
            java.lang.String r5 = "Data loss. Failed to merge raw event"
            r4.zze(r5, r15, r2)     // Catch:{ SQLiteException -> 0x017a }
        L_0x016d:
            boolean r2 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x0125
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x017a:
            r2 = move-exception
        L_0x017b:
            com.google.android.gms.measurement.internal.zzp r4 = r14.zzFm()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzFE()     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = "Data loss. Error selecting raw event"
            r4.zzj(r5, r2)     // Catch:{ all -> 0x0197 }
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x018f:
            r2 = move-exception
            r11 = r3
        L_0x0191:
            if (r11 == 0) goto L_0x0196
            r11.close()
        L_0x0196:
            throw r2
        L_0x0197:
            r2 = move-exception
            r11 = r3
            goto L_0x0191
        L_0x019a:
            r2 = move-exception
            goto L_0x0191
        L_0x019c:
            r2 = move-exception
            r3 = r11
            goto L_0x017b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(java.lang.String, long, com.google.android.gms.measurement.internal.zze$zzb):void");
    }

    @WorkerThread
    public boolean zza(zzak zzak) {
        zzaa.zzz(zzak);
        zzkN();
        zzma();
        if (zzQ(zzak.zzPx, zzak.mName) == null) {
            if (zzal.zzfG(zzak.mName)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzak.zzPx}) >= ((long) zzFo().zzEH())) {
                    return false;
                }
            } else {
                if (zzb("select count(1) from user_attributes where app_id=?", new String[]{zzak.zzPx}) >= ((long) zzFo().zzEI())) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zzPx);
        contentValues.put("name", zzak.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzak.zzbgg));
        zza(contentValues, FirebaseAnalytics.Param.VALUE, zzak.zzRF);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzFm().zzFE().log("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzFm().zzFE().zzj("Error storing user property", e);
        }
        return true;
    }

    @WorkerThread
    public void zzae(long j) {
        zzkN();
        zzma();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzFm().zzFE().log("Deleted fewer rows from queue than expected");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zzaf(long r8) {
        /*
            r7 = this;
            r0 = 0
            r7.zzkN()
            r7.zzma()
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x005f }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzp r1 = r7.zzFm()     // Catch:{ SQLiteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzFL()     // Catch:{ SQLiteException -> 0x005f }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r1.log(r3)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
        L_0x0033:
            return r0
        L_0x0034:
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x003f:
            r1 = move-exception
            r2 = r0
        L_0x0041:
            com.google.android.gms.measurement.internal.zzp r3 = r7.zzFm()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzFE()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "Error selecting expired configs"
            r3.zzj(r4, r1)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x0054:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.close()
        L_0x005c:
            throw r0
        L_0x005d:
            r0 = move-exception
            goto L_0x0057
        L_0x005f:
            r1 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzaf(long):java.lang.String");
    }

    public long zzb(zzsp.zze zze) throws IOException {
        zzkN();
        zzma();
        zzaa.zzz(zze);
        zzaa.zzdl(zze.appId);
        try {
            byte[] bArr = new byte[zze.getSerializedSize()];
            zzamc zzO = zzamc.zzO(bArr);
            zze.writeTo(zzO);
            zzO.zzWU();
            long zzt = zzFi().zzt(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.appId);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzt));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
                return zzt;
            } catch (SQLiteException e) {
                zzFm().zzFE().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzFm().zzFE().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public Object zzb(Cursor cursor, int i) {
        int zza2 = zza(cursor, i);
        switch (zza2) {
            case 0:
                zzFm().zzFE().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzFm().zzFE().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzFm().zzFE().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(zza2));
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(String str, zzsn.zza[] zzaArr) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        zzaa.zzz(zzaArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzfn(str);
            for (zzsn.zza zza2 : zzaArr) {
                zza(str, zza2);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public void zzd(String str, byte[] bArr) {
        zzaa.zzdl(str);
        zzkN();
        zzma();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzFm().zzFE().log("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzFm().zzFE().zzj("Error storing remote config", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.measurement.internal.zzak> zzfj(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzaa.zzdl(r12)
            r11.zzkN()
            r11.zzma()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 1
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 2
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            com.google.android.gms.measurement.internal.zzd r8 = r11.zzFo()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            int r8 = r8.zzEI()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0050
            if (r7 == 0) goto L_0x004e
            r7.close()
        L_0x004e:
            r0 = r9
        L_0x004f:
            return r0
        L_0x0050:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r0 = 1
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r0 = 2
            java.lang.Object r6 = r11.zzb((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r6 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzFm()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFE()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            java.lang.String r1 = "Read invalid user property value, ignoring it"
            r0.log(r1)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
        L_0x006e:
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0050
            if (r7 == 0) goto L_0x0079
            r7.close()
        L_0x0079:
            r0 = r9
            goto L_0x004f
        L_0x007b:
            com.google.android.gms.measurement.internal.zzak r1 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r2 = r12
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r9.add(r1)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            goto L_0x006e
        L_0x0085:
            r0 = move-exception
            r1 = r7
        L_0x0087:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzFm()     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Error querying user properties"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            r0 = r10
            goto L_0x004f
        L_0x009b:
            r0 = move-exception
        L_0x009c:
            if (r10 == 0) goto L_0x00a1
            r10.close()
        L_0x00a1:
            throw r0
        L_0x00a2:
            r0 = move-exception
            r10 = r7
            goto L_0x009c
        L_0x00a5:
            r0 = move-exception
            r10 = r1
            goto L_0x009c
        L_0x00a8:
            r0 = move-exception
            r1 = r10
            goto L_0x0087
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzfj(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01a9  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zza zzfk(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            r9 = 1
            r8 = 0
            com.google.android.gms.common.internal.zzaa.zzdl(r12)
            r11.zzkN()
            r11.zzma()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            java.lang.String r1 = "apps"
            r2 = 20
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 0
            java.lang.String r4 = "app_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 1
            java.lang.String r4 = "gmp_app_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 2
            java.lang.String r4 = "resettable_device_id_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 3
            java.lang.String r4 = "last_bundle_index"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 4
            java.lang.String r4 = "last_bundle_start_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 5
            java.lang.String r4 = "last_bundle_end_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 6
            java.lang.String r4 = "app_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 7
            java.lang.String r4 = "app_store"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 8
            java.lang.String r4 = "gmp_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 9
            java.lang.String r4 = "dev_cert_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 10
            java.lang.String r4 = "measurement_enabled"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 11
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 12
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 13
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 14
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 15
            java.lang.String r4 = "config_fetched_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 16
            java.lang.String r4 = "failed_config_fetch_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 17
            java.lang.String r4 = "app_version_int"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 18
            java.lang.String r4 = "firebase_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 19
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x01af }
            if (r0 != 0) goto L_0x00a2
            if (r1 == 0) goto L_0x00a0
            r1.close()
        L_0x00a0:
            r0 = r8
        L_0x00a1:
            return r0
        L_0x00a2:
            com.google.android.gms.measurement.internal.zza r0 = new com.google.android.gms.measurement.internal.zza     // Catch:{ SQLiteException -> 0x01af }
            com.google.android.gms.measurement.internal.zzx r2 = r11.zzbbl     // Catch:{ SQLiteException -> 0x01af }
            r0.<init>(r2, r12)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzeV(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzeW(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 2
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzeX(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzW(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzR(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 5
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzS(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 6
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.setAppVersion(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 7
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzeZ(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 8
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzU(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 9
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzV(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 10
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x01af }
            if (r2 == 0) goto L_0x017d
            r2 = r9
        L_0x0104:
            if (r2 == 0) goto L_0x0184
            r2 = r9
        L_0x0107:
            r0.setMeasurementEnabled(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 11
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzZ(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 12
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzaa(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 13
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzab(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 14
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzac(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 15
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzX(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 16
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzY(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 17
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x01af }
            if (r2 == 0) goto L_0x0186
            r2 = -2147483648(0xffffffff80000000, double:NaN)
        L_0x014b:
            r0.zzT(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 18
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzeY(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 19
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzad(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.zzEa()     // Catch:{ SQLiteException -> 0x01af }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x01af }
            if (r2 == 0) goto L_0x0176
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzFm()     // Catch:{ SQLiteException -> 0x01af }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ SQLiteException -> 0x01af }
            java.lang.String r3 = "Got multiple records for app, expected one"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x01af }
        L_0x0176:
            if (r1 == 0) goto L_0x00a1
            r1.close()
            goto L_0x00a1
        L_0x017d:
            r2 = 10
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x01af }
            goto L_0x0104
        L_0x0184:
            r2 = r10
            goto L_0x0107
        L_0x0186:
            r2 = 17
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x01af }
            long r2 = (long) r2
            goto L_0x014b
        L_0x018e:
            r0 = move-exception
            r1 = r8
        L_0x0190:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzFm()     // Catch:{ all -> 0x01ad }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x01ad }
            java.lang.String r3 = "Error querying app"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x01ad }
            if (r1 == 0) goto L_0x01a2
            r1.close()
        L_0x01a2:
            r0 = r8
            goto L_0x00a1
        L_0x01a5:
            r0 = move-exception
            r1 = r8
        L_0x01a7:
            if (r1 == 0) goto L_0x01ac
            r1.close()
        L_0x01ac:
            throw r0
        L_0x01ad:
            r0 = move-exception
            goto L_0x01a7
        L_0x01af:
            r0 = move-exception
            goto L_0x0190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzfk(java.lang.String):com.google.android.gms.measurement.internal.zza");
    }

    public long zzfl(String str) {
        zzaa.zzdl(str);
        zzkN();
        zzma();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(zzFo().zzfi(str))});
        } catch (SQLiteException e) {
            zzFm().zzFE().zzj("Error deleting over the limit events", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] zzfm(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzaa.zzdl(r10)
            r9.zzkN()
            r9.zzma()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            java.lang.String r1 = "apps"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r3 = 0
            java.lang.String r4 = "remote_config"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r0 != 0) goto L_0x0034
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            r0 = r8
        L_0x0033:
            return r0
        L_0x0034:
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0072 }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0072 }
            if (r2 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzFm()     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r3 = "Got multiple records for app config, expected one"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x0072 }
        L_0x004c:
            if (r1 == 0) goto L_0x0033
            r1.close()
            goto L_0x0033
        L_0x0052:
            r0 = move-exception
            r1 = r8
        L_0x0054:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzFm()     // Catch:{ all -> 0x0070 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "Error querying remote config"
            r2.zze(r3, r10, r0)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0066
            r1.close()
        L_0x0066:
            r0 = r8
            goto L_0x0033
        L_0x0068:
            r0 = move-exception
            r1 = r8
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            throw r0
        L_0x0070:
            r0 = move-exception
            goto L_0x006a
        L_0x0072:
            r0 = move-exception
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzfm(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzfn(String str) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=?", new String[]{str});
        writableDatabase.delete("event_filters", "app_id=?", new String[]{str});
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzsp.zzf> zzfo(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            r9.zzma()
            r9.zzkN()
            com.google.android.gms.common.internal.zzaa.zzdl(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r3 = 1
            java.lang.String r4 = "current_results"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            if (r0 != 0) goto L_0x0039
            if (r2 == 0) goto L_0x0037
            r2.close()
        L_0x0037:
            r0 = r8
        L_0x0038:
            return r0
        L_0x0039:
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r1.<init>()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
        L_0x003e:
            r0 = 0
            int r3 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r0 = 1
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzamb r0 = com.google.android.gms.internal.zzamb.zzN(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzsp$zzf r4 = new com.google.android.gms.internal.zzsp$zzf     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r4.<init>()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzamj r0 = r4.mergeFrom(r0)     // Catch:{ IOException -> 0x006b }
            com.google.android.gms.internal.zzsp$zzf r0 = (com.google.android.gms.internal.zzsp.zzf) r0     // Catch:{ IOException -> 0x006b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r1.put(r0, r4)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
        L_0x005e:
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            if (r0 != 0) goto L_0x003e
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            r0 = r1
            goto L_0x0038
        L_0x006b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r9.zzFm()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzFE()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r4.zzd(r5, r10, r3, r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            goto L_0x005e
        L_0x007e:
            r0 = move-exception
            r1 = r2
        L_0x0080:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzFm()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = "Database error querying filter results"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0092
            r1.close()
        L_0x0092:
            r0 = r8
            goto L_0x0038
        L_0x0094:
            r0 = move-exception
            r2 = r8
        L_0x0096:
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            throw r0
        L_0x009c:
            r0 = move-exception
            goto L_0x0096
        L_0x009e:
            r0 = move-exception
            r2 = r1
            goto L_0x0096
        L_0x00a1:
            r0 = move-exception
            r1 = r8
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzfo(java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzfp(String str) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr);
            if (delete > 0) {
                zzFm().zzFL().zze("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzFm().zzFE().zze("Error deleting application data. appId, error", str, e);
        }
    }

    public void zzfq(String str) {
        try {
            getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzFm().zzFE().zzj("Failed to remove unused event metadata", e);
        }
    }

    public long zzfr(String str) {
        zzaa.zzdl(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* access modifiers changed from: protected */
    public void zzkO() {
    }

    /* access modifiers changed from: package-private */
    public String zzmv() {
        if (!zzFo().zzmW()) {
            return zzFo().zznw();
        }
        if (zzFo().zzmX()) {
            return zzFo().zznw();
        }
        zzFm().zzFH().log("Using secondary database");
        return zzFo().zznx();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Pair<com.google.android.gms.internal.zzsp.zze, java.lang.Long>> zzn(java.lang.String r12, int r13, int r14) {
        /*
            r11 = this;
            r10 = 0
            r1 = 1
            r9 = 0
            r11.zzkN()
            r11.zzma()
            if (r13 <= 0) goto L_0x004e
            r0 = r1
        L_0x000c:
            com.google.android.gms.common.internal.zzaa.zzaj(r0)
            if (r14 <= 0) goto L_0x0050
        L_0x0011:
            com.google.android.gms.common.internal.zzaa.zzaj(r1)
            com.google.android.gms.common.internal.zzaa.zzdl(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            java.lang.String r1 = "queue"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r3 = 0
            java.lang.String r4 = "rowid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0052
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r2 == 0) goto L_0x004d
            r2.close()
        L_0x004d:
            return r0
        L_0x004e:
            r0 = r9
            goto L_0x000c
        L_0x0050:
            r1 = r9
            goto L_0x0011
        L_0x0052:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r3 = r9
        L_0x0058:
            r0 = 0
            long r4 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = 1
            byte[] r0 = r2.getBlob(r0)     // Catch:{ IOException -> 0x007b }
            com.google.android.gms.measurement.internal.zzal r6 = r11.zzFi()     // Catch:{ IOException -> 0x007b }
            byte[] r6 = r6.zzr(r0)     // Catch:{ IOException -> 0x007b }
            boolean r0 = r1.isEmpty()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0094
            int r0 = r6.length     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            int r0 = r0 + r3
            if (r0 <= r14) goto L_0x0094
        L_0x0074:
            if (r2 == 0) goto L_0x0079
            r2.close()
        L_0x0079:
            r0 = r1
            goto L_0x004d
        L_0x007b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r11.zzFm()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzFE()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            java.lang.String r5 = "Failed to unzip queued bundle"
            r4.zze(r5, r12, r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = r3
        L_0x008a:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r3 == 0) goto L_0x0074
            if (r0 > r14) goto L_0x0074
            r3 = r0
            goto L_0x0058
        L_0x0094:
            com.google.android.gms.internal.zzamb r0 = com.google.android.gms.internal.zzamb.zzN(r6)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.internal.zzsp$zze r7 = new com.google.android.gms.internal.zzsp$zze     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.internal.zzamj r0 = r7.mergeFrom(r0)     // Catch:{ IOException -> 0x00ca }
            com.google.android.gms.internal.zzsp$zze r0 = (com.google.android.gms.internal.zzsp.zze) r0     // Catch:{ IOException -> 0x00ca }
            int r0 = r6.length     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            int r0 = r0 + r3
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            android.util.Pair r3 = android.util.Pair.create(r7, r3)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            goto L_0x008a
        L_0x00b1:
            r0 = move-exception
            r1 = r2
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzFm()     // Catch:{ all -> 0x00e4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "Error querying bundles"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x00e4 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x004d
            r1.close()
            goto L_0x004d
        L_0x00ca:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r11.zzFm()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzFE()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            java.lang.String r5 = "Failed to merge queued bundle"
            r4.zze(r5, r12, r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = r3
            goto L_0x008a
        L_0x00da:
            r0 = move-exception
            r2 = r10
        L_0x00dc:
            if (r2 == 0) goto L_0x00e1
            r2.close()
        L_0x00e1:
            throw r0
        L_0x00e2:
            r0 = move-exception
            goto L_0x00dc
        L_0x00e4:
            r0 = move-exception
            r2 = r1
            goto L_0x00dc
        L_0x00e7:
            r0 = move-exception
            r1 = r10
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzn(java.lang.String, int, int):java.util.List");
    }

    @WorkerThread
    public void zzy(String str, int i) {
        zzaa.zzdl(str);
        zzkN();
        zzma();
        try {
            getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzFm().zzFE().zze("Error pruning currencies", str, e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzz(String str, int i) {
        zzma();
        zzkN();
        zzaa.zzdl(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        writableDatabase.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }
}
