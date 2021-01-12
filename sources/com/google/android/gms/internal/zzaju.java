package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class zzaju implements zzake<Date>, zzakn<Date> {
    private final DateFormat zzbVN;
    private final DateFormat zzbVO;
    private final DateFormat zzbVP;

    zzaju() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzaju(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzaju(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    zzaju(DateFormat dateFormat, DateFormat dateFormat2) {
        this.zzbVN = dateFormat;
        this.zzbVO = dateFormat2;
        this.zzbVP = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.zzbVP.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date zza(zzakf zzakf) {
        Date parse;
        synchronized (this.zzbVO) {
            try {
                parse = this.zzbVO.parse(zzakf.zzVA());
            } catch (ParseException e) {
                throw new zzako(zzakf.zzVA(), e);
            } catch (ParseException e2) {
                try {
                    parse = this.zzbVN.parse(zzakf.zzVA());
                } catch (ParseException e3) {
                    parse = this.zzbVP.parse(zzakf.zzVA());
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(zzaju.class.getSimpleName());
        sb.append('(').append(this.zzbVO.getClass().getSimpleName()).append(')');
        return sb.toString();
    }

    public zzakf zza(Date date, Type type, zzakm zzakm) {
        zzakl zzakl;
        synchronized (this.zzbVO) {
            zzakl = new zzakl(this.zzbVN.format(date));
        }
        return zzakl;
    }

    /* renamed from: zza */
    public Date zzb(zzakf zzakf, Type type, zzakd zzakd) throws zzakj {
        if (!(zzakf instanceof zzakl)) {
            throw new zzakj("The date should be a string value");
        }
        Date zza = zza(zzakf);
        if (type == Date.class) {
            return zza;
        }
        if (type == Timestamp.class) {
            return new Timestamp(zza.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(zza.getTime());
        }
        String valueOf = String.valueOf(getClass());
        String valueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
    }
}
