package com.google.android.gms.internal;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzalu {
    public static final zzakr<String> zzbYA = new zzakr<String>() {
        public void zza(zzaly zzaly, String str) throws IOException {
            zzaly.zziU(str);
        }

        /* renamed from: zzq */
        public String zzb(zzalw zzalw) throws IOException {
            zzalx zzWa = zzalw.zzWa();
            if (zzWa != zzalx.NULL) {
                return zzWa == zzalx.BOOLEAN ? Boolean.toString(zzalw.nextBoolean()) : zzalw.nextString();
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzakr<BigDecimal> zzbYB = new zzakr<BigDecimal>() {
        public void zza(zzaly zzaly, BigDecimal bigDecimal) throws IOException {
            zzaly.zza(bigDecimal);
        }

        /* renamed from: zzr */
        public BigDecimal zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return new BigDecimal(zzalw.nextString());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzakr<BigInteger> zzbYC = new zzakr<BigInteger>() {
        public void zza(zzaly zzaly, BigInteger bigInteger) throws IOException {
            zzaly.zza(bigInteger);
        }

        /* renamed from: zzs */
        public BigInteger zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return new BigInteger(zzalw.nextString());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYD = zza(String.class, zzbYA);
    public static final zzakr<StringBuilder> zzbYE = new zzakr<StringBuilder>() {
        public void zza(zzaly zzaly, StringBuilder sb) throws IOException {
            zzaly.zziU(sb == null ? null : sb.toString());
        }

        /* renamed from: zzt */
        public StringBuilder zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return new StringBuilder(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYF = zza(StringBuilder.class, zzbYE);
    public static final zzakr<StringBuffer> zzbYG = new zzakr<StringBuffer>() {
        public void zza(zzaly zzaly, StringBuffer stringBuffer) throws IOException {
            zzaly.zziU(stringBuffer == null ? null : stringBuffer.toString());
        }

        /* renamed from: zzu */
        public StringBuffer zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return new StringBuffer(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYH = zza(StringBuffer.class, zzbYG);
    public static final zzakr<URL> zzbYI = new zzakr<URL>() {
        public void zza(zzaly zzaly, URL url) throws IOException {
            zzaly.zziU(url == null ? null : url.toExternalForm());
        }

        /* renamed from: zzv */
        public URL zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            String nextString = zzalw.nextString();
            if (!"null".equals(nextString)) {
                return new URL(nextString);
            }
            return null;
        }
    };
    public static final zzaks zzbYJ = zza(URL.class, zzbYI);
    public static final zzakr<URI> zzbYK = new zzakr<URI>() {
        public void zza(zzaly zzaly, URI uri) throws IOException {
            zzaly.zziU(uri == null ? null : uri.toASCIIString());
        }

        /* renamed from: zzw */
        public URI zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                String nextString = zzalw.nextString();
                if (!"null".equals(nextString)) {
                    return new URI(nextString);
                }
                return null;
            } catch (URISyntaxException e) {
                throw new zzakg((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYL = zza(URI.class, zzbYK);
    public static final zzakr<InetAddress> zzbYM = new zzakr<InetAddress>() {
        public void zza(zzaly zzaly, InetAddress inetAddress) throws IOException {
            zzaly.zziU(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        /* renamed from: zzy */
        public InetAddress zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return InetAddress.getByName(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYN = zzb(InetAddress.class, zzbYM);
    public static final zzakr<UUID> zzbYO = new zzakr<UUID>() {
        public void zza(zzaly zzaly, UUID uuid) throws IOException {
            zzaly.zziU(uuid == null ? null : uuid.toString());
        }

        /* renamed from: zzz */
        public UUID zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return UUID.fromString(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYP = zza(UUID.class, zzbYO);
    public static final zzaks zzbYQ = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() != Timestamp.class) {
                return null;
            }
            final zzakr<Date> zzk = zzajz.zzk(Date.class);
            return new zzakr<Timestamp>() {
                /* renamed from: zzA */
                public Timestamp zzb(zzalw zzalw) throws IOException {
                    Date date = (Date) zzk.zzb(zzalw);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                public void zza(zzaly zzaly, Timestamp timestamp) throws IOException {
                    zzk.zza(zzaly, timestamp);
                }
            };
        }
    };
    public static final zzakr<Calendar> zzbYR = new zzakr<Calendar>() {
        /* renamed from: zzB */
        public Calendar zzb(zzalw zzalw) throws IOException {
            int i = 0;
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            zzalw.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (zzalw.zzWa() != zzalx.END_OBJECT) {
                String nextName = zzalw.nextName();
                int nextInt = zzalw.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i3 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i2 = nextInt;
                } else if ("second".equals(nextName)) {
                    i = nextInt;
                }
            }
            zzalw.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        public void zza(zzaly zzaly, Calendar calendar) throws IOException {
            if (calendar == null) {
                zzaly.zzWk();
                return;
            }
            zzaly.zzWi();
            zzaly.zziT("year");
            zzaly.zzaN((long) calendar.get(1));
            zzaly.zziT("month");
            zzaly.zzaN((long) calendar.get(2));
            zzaly.zziT("dayOfMonth");
            zzaly.zzaN((long) calendar.get(5));
            zzaly.zziT("hourOfDay");
            zzaly.zzaN((long) calendar.get(11));
            zzaly.zziT("minute");
            zzaly.zzaN((long) calendar.get(12));
            zzaly.zziT("second");
            zzaly.zzaN((long) calendar.get(13));
            zzaly.zzWj();
        }
    };
    public static final zzaks zzbYS = zzb(Calendar.class, GregorianCalendar.class, zzbYR);
    public static final zzakr<Locale> zzbYT = new zzakr<Locale>() {
        /* renamed from: zzC */
        public Locale zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(zzalw.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        public void zza(zzaly zzaly, Locale locale) throws IOException {
            zzaly.zziU(locale == null ? null : locale.toString());
        }
    };
    public static final zzaks zzbYU = zza(Locale.class, zzbYT);
    public static final zzakr<zzakf> zzbYV = new zzakr<zzakf>() {
        /* renamed from: zzD */
        public zzakf zzb(zzalw zzalw) throws IOException {
            switch (C048626.zzbXT[zzalw.zzWa().ordinal()]) {
                case 1:
                    return new zzakl((Number) new zzalc(zzalw.nextString()));
                case 2:
                    return new zzakl(Boolean.valueOf(zzalw.nextBoolean()));
                case 3:
                    return new zzakl(zzalw.nextString());
                case 4:
                    zzalw.nextNull();
                    return zzakh.zzbWr;
                case 5:
                    zzakc zzakc = new zzakc();
                    zzalw.beginArray();
                    while (zzalw.hasNext()) {
                        zzakc.zzc((zzakf) zzb(zzalw));
                    }
                    zzalw.endArray();
                    return zzakc;
                case 6:
                    zzaki zzaki = new zzaki();
                    zzalw.beginObject();
                    while (zzalw.hasNext()) {
                        zzaki.zza(zzalw.nextName(), (zzakf) zzb(zzalw));
                    }
                    zzalw.endObject();
                    return zzaki;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void zza(zzaly zzaly, zzakf zzakf) throws IOException {
            if (zzakf == null || zzakf.zzVI()) {
                zzaly.zzWk();
            } else if (zzakf.zzVH()) {
                zzakl zzVL = zzakf.zzVL();
                if (zzVL.zzVO()) {
                    zzaly.zza(zzVL.zzVz());
                } else if (zzVL.zzVN()) {
                    zzaly.zzaX(zzVL.zzVE());
                } else {
                    zzaly.zziU(zzVL.zzVA());
                }
            } else if (zzakf.zzVF()) {
                zzaly.zzWg();
                Iterator<zzakf> it = zzakf.zzVK().iterator();
                while (it.hasNext()) {
                    zza(zzaly, it.next());
                }
                zzaly.zzWh();
            } else if (zzakf.zzVG()) {
                zzaly.zzWi();
                for (Map.Entry next : zzakf.zzVJ().entrySet()) {
                    zzaly.zziT((String) next.getKey());
                    zza(zzaly, (zzakf) next.getValue());
                }
                zzaly.zzWj();
            } else {
                String valueOf = String.valueOf(zzakf.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
            }
        }
    };
    public static final zzaks zzbYW = zzb(zzakf.class, zzbYV);
    public static final zzaks zzbYX = new zzaks() {
        /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.zzalv<T>, com.google.android.gms.internal.zzalv] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> com.google.android.gms.internal.zzakr<T> zza(com.google.android.gms.internal.zzajz r3, com.google.android.gms.internal.zzalv<T> r4) {
            /*
                r2 = this;
                java.lang.Class r0 = r4.zzWl()
                java.lang.Class<java.lang.Enum> r1 = java.lang.Enum.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0010
                java.lang.Class<java.lang.Enum> r1 = java.lang.Enum.class
                if (r0 != r1) goto L_0x0012
            L_0x0010:
                r0 = 0
            L_0x0011:
                return r0
            L_0x0012:
                boolean r1 = r0.isEnum()
                if (r1 != 0) goto L_0x001c
                java.lang.Class r0 = r0.getSuperclass()
            L_0x001c:
                com.google.android.gms.internal.zzalu$zza r1 = new com.google.android.gms.internal.zzalu$zza
                r1.<init>(r0)
                r0 = r1
                goto L_0x0011
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalu.C047819.zza(com.google.android.gms.internal.zzajz, com.google.android.gms.internal.zzalv):com.google.android.gms.internal.zzakr");
        }
    };
    public static final zzakr<Class> zzbYg = new zzakr<Class>() {
        public void zza(zzaly zzaly, Class cls) throws IOException {
            if (cls == null) {
                zzaly.zzWk();
            } else {
                String valueOf = String.valueOf(cls.getName());
                throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
            }
        }

        /* renamed from: zzo */
        public Class zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final zzaks zzbYh = zza(Class.class, zzbYg);
    public static final zzakr<BitSet> zzbYi = new zzakr<BitSet>() {
        public void zza(zzaly zzaly, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                zzaly.zzWk();
                return;
            }
            zzaly.zzWg();
            for (int i = 0; i < bitSet.length(); i++) {
                zzaly.zzaN((long) (bitSet.get(i) ? 1 : 0));
            }
            zzaly.zzWh();
        }

        /* renamed from: zzx */
        public BitSet zzb(zzalw zzalw) throws IOException {
            boolean z;
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            zzalw.beginArray();
            zzalx zzWa = zzalw.zzWa();
            int i = 0;
            while (zzWa != zzalx.END_ARRAY) {
                switch (C048626.zzbXT[zzWa.ordinal()]) {
                    case 1:
                        if (zzalw.nextInt() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = zzalw.nextBoolean();
                        break;
                    case 3:
                        String nextString = zzalw.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            String valueOf = String.valueOf(nextString);
                            throw new zzako(valueOf.length() != 0 ? "Error: Expecting: bitset number value (1, 0), Found: ".concat(valueOf) : new String("Error: Expecting: bitset number value (1, 0), Found: "));
                        }
                    default:
                        String valueOf2 = String.valueOf(zzWa);
                        throw new zzako(new StringBuilder(String.valueOf(valueOf2).length() + 27).append("Invalid bitset value type: ").append(valueOf2).toString());
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                zzWa = zzalw.zzWa();
            }
            zzalw.endArray();
            return bitSet;
        }
    };
    public static final zzaks zzbYj = zza(BitSet.class, zzbYi);
    public static final zzakr<Boolean> zzbYk = new zzakr<Boolean>() {
        /* renamed from: zzE */
        public Boolean zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return zzalw.zzWa() == zzalx.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzalw.nextString())) : Boolean.valueOf(zzalw.nextBoolean());
            }
            zzalw.nextNull();
            return null;
        }

        public void zza(zzaly zzaly, Boolean bool) throws IOException {
            if (bool == null) {
                zzaly.zzWk();
            } else {
                zzaly.zzaX(bool.booleanValue());
            }
        }
    };
    public static final zzakr<Boolean> zzbYl = new zzakr<Boolean>() {
        /* renamed from: zzE */
        public Boolean zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return Boolean.valueOf(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }

        public void zza(zzaly zzaly, Boolean bool) throws IOException {
            zzaly.zziU(bool == null ? "null" : bool.toString());
        }
    };
    public static final zzaks zzbYm = zza(Boolean.TYPE, Boolean.class, zzbYk);
    public static final zzakr<Number> zzbYn = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) zzalw.nextInt());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYo = zza(Byte.TYPE, Byte.class, zzbYn);
    public static final zzakr<Number> zzbYp = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) zzalw.nextInt());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYq = zza(Short.TYPE, Short.class, zzbYp);
    public static final zzakr<Number> zzbYr = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(zzalw.nextInt());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYs = zza(Integer.TYPE, Integer.class, zzbYr);
    public static final zzakr<Number> zzbYt = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Long.valueOf(zzalw.nextLong());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzakr<Number> zzbYu = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return Float.valueOf((float) zzalw.nextDouble());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzakr<Number> zzbYv = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return Double.valueOf(zzalw.nextDouble());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzakr<Number> zzbYw = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            zzalx zzWa = zzalw.zzWa();
            switch (zzWa) {
                case NUMBER:
                    return new zzalc(zzalw.nextString());
                case NULL:
                    zzalw.nextNull();
                    return null;
                default:
                    String valueOf = String.valueOf(zzWa);
                    throw new zzako(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
            }
        }
    };
    public static final zzaks zzbYx = zza(Number.class, zzbYw);
    public static final zzakr<Character> zzbYy = new zzakr<Character>() {
        public void zza(zzaly zzaly, Character ch) throws IOException {
            zzaly.zziU(ch == null ? null : String.valueOf(ch));
        }

        /* renamed from: zzp */
        public Character zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            String nextString = zzalw.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            String valueOf = String.valueOf(nextString);
            throw new zzako(valueOf.length() != 0 ? "Expecting character, got: ".concat(valueOf) : new String("Expecting character, got: "));
        }
    };
    public static final zzaks zzbYz = zza(Character.TYPE, Character.class, zzbYy);

    private static final class zza<T extends Enum<T>> extends zzakr<T> {
        private final Map<String, T> zzbZh = new HashMap();
        private final Map<T, String> zzbZi = new HashMap();

        public zza(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    zzaku zzaku = (zzaku) cls.getField(name).getAnnotation(zzaku.class);
                    if (zzaku != null) {
                        name = zzaku.value();
                        for (String put : zzaku.zzVR()) {
                            this.zzbZh.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.zzbZh.put(str, enumR);
                    this.zzbZi.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        /* renamed from: zzF */
        public T zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return (Enum) this.zzbZh.get(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }

        public void zza(zzaly zzaly, T t) throws IOException {
            zzaly.zziU(t == null ? null : this.zzbZi.get(t));
        }
    }

    public static <TT> zzaks zza(final zzalv<TT> zzalv, final zzakr<TT> zzakr) {
        return new zzaks() {
            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                if (zzalv.equals(zzalv)) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zza(final Class<TT> cls, final zzakr<TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzakr);
                return new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                if (zzalv.zzWl() == cls) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zza(final Class<TT> cls, final Class<TT> cls2, final zzakr<? super TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls2.getName());
                String valueOf2 = String.valueOf(cls.getName());
                String valueOf3 = String.valueOf(zzakr);
                return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                Class<? super T> zzWl = zzalv.zzWl();
                if (zzWl == cls || zzWl == cls2) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zzb(final Class<TT> cls, final zzakr<TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzakr);
                return new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                if (cls.isAssignableFrom(zzalv.zzWl())) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzakr<? super TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(cls2.getName());
                String valueOf3 = String.valueOf(zzakr);
                return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                Class<? super T> zzWl = zzalv.zzWl();
                if (zzWl == cls || zzWl == cls2) {
                    return zzakr;
                }
                return null;
            }
        };
    }
}
