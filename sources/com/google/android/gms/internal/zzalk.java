package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzalk extends zzakr<Date> {
    public static final zzaks zzbXD = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() == Date.class) {
                return new zzalk();
            }
            return null;
        }
    };
    private final DateFormat zzbVN = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat zzbVO = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat zzbVP = zzVZ();

    private static DateFormat zzVZ() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date zziS(String str) {
        Date parse;
        try {
            parse = this.zzbVO.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.zzbVN.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.zzbVP.parse(str);
                } catch (ParseException e3) {
                    throw new zzako(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void zza(zzaly zzaly, Date date) throws IOException {
        if (date == null) {
            zzaly.zzWk();
        } else {
            zzaly.zziU(this.zzbVN.format(date));
        }
    }

    /* renamed from: zzk */
    public Date zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() != zzalx.NULL) {
            return zziS(zzalw.nextString());
        }
        zzalw.nextNull();
        return null;
    }
}
