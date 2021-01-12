package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzalw implements Closeable {
    private static final char[] zzbZl = ")]}'\n".toCharArray();

    /* renamed from: in */
    private final Reader f45in;
    private int pos = 0;
    private int zzbQl = 0;
    private boolean zzbZm = false;
    private final char[] zzbZn = new char[1024];
    private int zzbZo = 0;
    private int zzbZp = 0;
    /* access modifiers changed from: private */
    public int zzbZq = 0;
    private long zzbZr;
    private int zzbZs;
    private String zzbZt;
    private int[] zzbZu = new int[32];
    private int zzbZv = 0;
    private String[] zzbZw;
    private int[] zzbZx;

    static {
        zzalb.zzbXe = new zzalb() {
            public void zzi(zzalw zzalw) throws IOException {
                if (zzalw instanceof zzalm) {
                    ((zzalm) zzalw).zzWd();
                    return;
                }
                int zzG = zzalw.zzbZq;
                if (zzG == 0) {
                    zzG = zzalw.zzWn();
                }
                if (zzG == 13) {
                    int unused = zzalw.zzbZq = 9;
                } else if (zzG == 12) {
                    int unused2 = zzalw.zzbZq = 8;
                } else if (zzG == 14) {
                    int unused3 = zzalw.zzbZq = 10;
                } else {
                    String valueOf = String.valueOf(zzalw.zzWa());
                    int zzI = zzalw.getLineNumber();
                    int zzJ = zzalw.getColumnNumber();
                    String path = zzalw.getPath();
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(zzI).append(" column ").append(zzJ).append(" path ").append(path).toString());
                }
            }
        };
    }

    public zzalw(Reader reader) {
        int[] iArr = this.zzbZu;
        int i = this.zzbZv;
        this.zzbZv = i + 1;
        iArr[i] = 6;
        this.zzbZw = new String[32];
        this.zzbZx = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f45in = reader;
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        return (this.pos - this.zzbZp) + 1;
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        return this.zzbZo + 1;
    }

    /* access modifiers changed from: private */
    public int zzWn() throws IOException {
        int i = this.zzbZu[this.zzbZv - 1];
        if (i == 1) {
            this.zzbZu[this.zzbZv - 1] = 2;
        } else if (i == 2) {
            switch (zzaY(true)) {
                case 44:
                    break;
                case 59:
                    zzWs();
                    break;
                case 93:
                    this.zzbZq = 4;
                    return 4;
                default:
                    throw zziW("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.zzbZu[this.zzbZv - 1] = 4;
            if (i == 5) {
                switch (zzaY(true)) {
                    case 44:
                        break;
                    case 59:
                        zzWs();
                        break;
                    case 125:
                        this.zzbZq = 2;
                        return 2;
                    default:
                        throw zziW("Unterminated object");
                }
            }
            int zzaY = zzaY(true);
            switch (zzaY) {
                case 34:
                    this.zzbZq = 13;
                    return 13;
                case 39:
                    zzWs();
                    this.zzbZq = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.zzbZq = 2;
                        return 2;
                    }
                    throw zziW("Expected name");
                default:
                    zzWs();
                    this.pos--;
                    if (zze((char) zzaY)) {
                        this.zzbZq = 14;
                        return 14;
                    }
                    throw zziW("Expected name");
            }
        } else if (i == 4) {
            this.zzbZu[this.zzbZv - 1] = 5;
            switch (zzaY(true)) {
                case 58:
                    break;
                case 61:
                    zzWs();
                    if ((this.pos < this.zzbQl || zznR(1)) && this.zzbZn[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                default:
                    throw zziW("Expected ':'");
            }
        } else if (i == 6) {
            if (this.zzbZm) {
                zzWv();
            }
            this.zzbZu[this.zzbZv - 1] = 7;
        } else if (i == 7) {
            if (zzaY(false) == -1) {
                this.zzbZq = 17;
                return 17;
            }
            zzWs();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (zzaY(true)) {
            case 34:
                if (this.zzbZv == 1) {
                    zzWs();
                }
                this.zzbZq = 9;
                return 9;
            case 39:
                zzWs();
                this.zzbZq = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.zzbZq = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.zzbZq = 4;
                    return 4;
                }
                break;
            case 123:
                this.zzbZq = 1;
                return 1;
            default:
                this.pos--;
                if (this.zzbZv == 1) {
                    zzWs();
                }
                int zzWo = zzWo();
                if (zzWo != 0) {
                    return zzWo;
                }
                int zzWp = zzWp();
                if (zzWp != 0) {
                    return zzWp;
                }
                if (!zze(this.zzbZn[this.pos])) {
                    throw zziW("Expected value");
                }
                zzWs();
                this.zzbZq = 10;
                return 10;
        }
        if (i == 1 || i == 2) {
            zzWs();
            this.pos--;
            this.zzbZq = 7;
            return 7;
        }
        throw zziW("Unexpected value");
    }

    private int zzWo() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.zzbZn[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.zzbQl && !zznR(i2 + 1)) {
                return 0;
            }
            char c2 = this.zzbZn[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.zzbQl || zznR(length + 1)) && zze(this.zzbZn[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.zzbZq = i;
        return i;
    }

    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zzWp() throws java.io.IOException {
        /*
            r15 = this;
            char[] r11 = r15.zzbZn
            int r2 = r15.pos
            int r1 = r15.zzbQl
            r6 = 0
            r5 = 0
            r4 = 1
            r3 = 0
            r0 = 0
            r10 = r0
            r0 = r1
            r1 = r2
        L_0x000f:
            int r2 = r1 + r10
            if (r2 != r0) goto L_0x003f
            int r0 = r11.length
            if (r10 != r0) goto L_0x0018
            r0 = 0
        L_0x0017:
            return r0
        L_0x0018:
            int r0 = r10 + 1
            boolean r0 = r15.zznR(r0)
            if (r0 != 0) goto L_0x003b
        L_0x0020:
            r0 = 2
            if (r3 != r0) goto L_0x00df
            if (r4 == 0) goto L_0x00df
            r0 = -9223372036854775808
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            if (r5 == 0) goto L_0x00df
        L_0x002d:
            if (r5 == 0) goto L_0x00dc
        L_0x002f:
            r15.zzbZr = r6
            int r0 = r15.pos
            int r0 = r0 + r10
            r15.pos = r0
            r0 = 15
            r15.zzbZq = r0
            goto L_0x0017
        L_0x003b:
            int r1 = r15.pos
            int r0 = r15.zzbQl
        L_0x003f:
            int r2 = r1 + r10
            char r2 = r11[r2]
            switch(r2) {
                case 43: goto L_0x006d;
                case 45: goto L_0x0056;
                case 46: goto L_0x0082;
                case 69: goto L_0x0076;
                case 101: goto L_0x0076;
                default: goto L_0x0046;
            }
        L_0x0046:
            r8 = 48
            if (r2 < r8) goto L_0x004e
            r8 = 57
            if (r2 <= r8) goto L_0x008b
        L_0x004e:
            boolean r0 = r15.zze(r2)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            goto L_0x0017
        L_0x0056:
            if (r3 != 0) goto L_0x0064
            r3 = 1
            r2 = 1
            r14 = r4
            r4 = r3
            r3 = r14
        L_0x005d:
            int r5 = r10 + 1
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x000f
        L_0x0064:
            r2 = 5
            if (r3 != r2) goto L_0x006b
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x006b:
            r0 = 0
            goto L_0x0017
        L_0x006d:
            r2 = 5
            if (r3 != r2) goto L_0x0074
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0074:
            r0 = 0
            goto L_0x0017
        L_0x0076:
            r2 = 2
            if (r3 == r2) goto L_0x007c
            r2 = 4
            if (r3 != r2) goto L_0x0080
        L_0x007c:
            r2 = 5
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0080:
            r0 = 0
            goto L_0x0017
        L_0x0082:
            r2 = 2
            if (r3 != r2) goto L_0x0089
            r2 = 3
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0089:
            r0 = 0
            goto L_0x0017
        L_0x008b:
            r8 = 1
            if (r3 == r8) goto L_0x0090
            if (r3 != 0) goto L_0x0098
        L_0x0090:
            int r2 = r2 + -48
            int r2 = -r2
            long r6 = (long) r2
            r2 = 2
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0098:
            r8 = 2
            if (r3 != r8) goto L_0x00cb
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00a4
            r0 = 0
            goto L_0x0017
        L_0x00a4:
            r8 = 10
            long r8 = r8 * r6
            int r2 = r2 + -48
            long r12 = (long) r2
            long r8 = r8 - r12
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x00c1
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00c9
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c9
        L_0x00c1:
            r2 = 1
        L_0x00c2:
            r2 = r2 & r4
            r4 = r5
            r6 = r8
            r14 = r3
            r3 = r2
            r2 = r14
            goto L_0x005d
        L_0x00c9:
            r2 = 0
            goto L_0x00c2
        L_0x00cb:
            r2 = 3
            if (r3 != r2) goto L_0x00d2
            r2 = 4
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00d2:
            r2 = 5
            if (r3 == r2) goto L_0x00d8
            r2 = 6
            if (r3 != r2) goto L_0x00f3
        L_0x00d8:
            r2 = 7
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00dc:
            long r6 = -r6
            goto L_0x002f
        L_0x00df:
            r0 = 2
            if (r3 == r0) goto L_0x00e8
            r0 = 4
            if (r3 == r0) goto L_0x00e8
            r0 = 7
            if (r3 != r0) goto L_0x00f0
        L_0x00e8:
            r15.zzbZs = r10
            r0 = 16
            r15.zzbZq = r0
            goto L_0x0017
        L_0x00f0:
            r0 = 0
            goto L_0x0017
        L_0x00f3:
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalw.zzWp():int");
    }

    private String zzWq() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.zzbQl) {
                switch (this.zzbZn[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        zzWs();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.zzbZn.length) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.zzbZn, this.pos, i);
                this.pos = i + this.pos;
                if (!zznR(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (zznR(i + 1)) {
            }
        }
        if (sb2 == null) {
            sb = new String(this.zzbZn, this.pos, i);
        } else {
            sb2.append(this.zzbZn, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    private void zzWr() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.zzbQl) {
                switch (this.zzbZn[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        zzWs();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (zznR(1));
    }

    private void zzWs() throws IOException {
        if (!this.zzbZm) {
            throw zziW("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void zzWt() throws IOException {
        char c;
        do {
            if (this.pos < this.zzbQl || zznR(1)) {
                char[] cArr = this.zzbZn;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.zzbZo++;
                    this.zzbZp = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    private char zzWu() throws IOException {
        int i;
        if (this.pos != this.zzbQl || zznR(1)) {
            char[] cArr = this.zzbZn;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char c = cArr[i2];
            switch (c) {
                case 10:
                    this.zzbZo++;
                    this.zzbZp = this.pos;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.pos + 4 <= this.zzbQl || zznR(4)) {
                        int i3 = this.pos;
                        int i4 = i3 + 4;
                        int i5 = i3;
                        char c2 = 0;
                        for (int i6 = i5; i6 < i4; i6++) {
                            char c3 = this.zzbZn[i6];
                            char c4 = (char) (c2 << 4);
                            if (c3 >= '0' && c3 <= '9') {
                                i = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i = (c3 - 'a') + 10;
                            } else if (c3 < 'A' || c3 > 'F') {
                                String valueOf = String.valueOf(new String(this.zzbZn, this.pos, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? "\\u".concat(valueOf) : new String("\\u"));
                            } else {
                                i = (c3 - 'A') + 10;
                            }
                            c2 = (char) (c4 + i);
                        }
                        this.pos += 4;
                        return c2;
                    }
                    throw zziW("Unterminated escape sequence");
                default:
                    return c;
            }
        } else {
            throw zziW("Unterminated escape sequence");
        }
    }

    private void zzWv() throws IOException {
        zzaY(true);
        this.pos--;
        if (this.pos + zzbZl.length <= this.zzbQl || zznR(zzbZl.length)) {
            int i = 0;
            while (i < zzbZl.length) {
                if (this.zzbZn[this.pos + i] == zzbZl[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += zzbZl.length;
        }
    }

    private int zzaY(boolean z) throws IOException {
        char[] cArr = this.zzbZn;
        int i = this.pos;
        int i2 = this.zzbQl;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (zznR(1)) {
                    i = this.pos;
                    i2 = this.zzbQl;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.zzbZo++;
                this.zzbZp = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean zznR = zznR(2);
                    this.pos++;
                    if (!zznR) {
                        return c;
                    }
                }
                zzWs();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (zziV("*/")) {
                            i = this.pos + 2;
                            i2 = this.zzbQl;
                            break;
                        } else {
                            throw zziW("Unterminated comment");
                        }
                    case '/':
                        this.pos++;
                        zzWt();
                        i = this.pos;
                        i2 = this.zzbQl;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                zzWs();
                zzWt();
                i = this.pos;
                i2 = this.zzbQl;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private boolean zze(char c) throws IOException {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                zzWs();
                break;
            default:
                return true;
        }
        return false;
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.zzbZn;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.zzbQl;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(zzWu());
                    i = this.pos;
                    i2 = this.zzbQl;
                    i4 = i;
                } else if (c2 == 10) {
                    this.zzbZo++;
                    this.zzbZp = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zznR(1));
        throw zziW("Unterminated string");
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.zzbZn;
        do {
            int i = this.pos;
            int i2 = this.zzbQl;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    zzWu();
                    i4 = this.pos;
                    i2 = this.zzbQl;
                } else if (c2 == 10) {
                    this.zzbZo++;
                    this.zzbZp = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (zznR(1));
        throw zziW("Unterminated string");
    }

    private boolean zziV(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.zzbQl && !zznR(str.length())) {
                return false;
            }
            if (this.zzbZn[this.pos] == 10) {
                this.zzbZo++;
                this.zzbZp = this.pos + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.zzbZn[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private IOException zziW(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new zzalz(new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length()).append(str).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    private void zznQ(int i) {
        if (this.zzbZv == this.zzbZu.length) {
            int[] iArr = new int[(this.zzbZv * 2)];
            int[] iArr2 = new int[(this.zzbZv * 2)];
            String[] strArr = new String[(this.zzbZv * 2)];
            System.arraycopy(this.zzbZu, 0, iArr, 0, this.zzbZv);
            System.arraycopy(this.zzbZx, 0, iArr2, 0, this.zzbZv);
            System.arraycopy(this.zzbZw, 0, strArr, 0, this.zzbZv);
            this.zzbZu = iArr;
            this.zzbZx = iArr2;
            this.zzbZw = strArr;
        }
        int[] iArr3 = this.zzbZu;
        int i2 = this.zzbZv;
        this.zzbZv = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean zznR(int i) throws IOException {
        char[] cArr = this.zzbZn;
        this.zzbZp -= this.pos;
        if (this.zzbQl != this.pos) {
            this.zzbQl -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.zzbQl);
        } else {
            this.zzbQl = 0;
        }
        this.pos = 0;
        do {
            int read = this.f45in.read(cArr, this.zzbQl, cArr.length - this.zzbQl);
            if (read == -1) {
                return false;
            }
            this.zzbQl = read + this.zzbQl;
            if (this.zzbZo == 0 && this.zzbZp == 0 && this.zzbQl > 0 && cArr[0] == 65279) {
                this.pos++;
                this.zzbZp++;
                i++;
            }
        } while (this.zzbQl < i);
        return true;
    }

    public void beginArray() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 3) {
            zznQ(1);
            this.zzbZx[this.zzbZv - 1] = 0;
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 74 + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginObject() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 1) {
            zznQ(3);
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 75 + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void close() throws IOException {
        this.zzbZq = 0;
        this.zzbZu[0] = 8;
        this.zzbZv = 1;
        this.f45in.close();
    }

    public void endArray() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 4) {
            this.zzbZv--;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void endObject() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 2) {
            this.zzbZv--;
            this.zzbZw[this.zzbZv] = null;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 73 + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.zzbZv;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.zzbZu[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.zzbZx[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.zzbZw[i2] == null) {
                        break;
                    } else {
                        append.append(this.zzbZw[i2]);
                        break;
                    }
            }
        }
        return append.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.zzbZm;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 5) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.zzbZq = 0;
            int[] iArr2 = this.zzbZx;
            int i3 = this.zzbZv - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 15) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.zzbZr;
        }
        if (i == 16) {
            this.zzbZt = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else if (i == 8 || i == 9) {
            this.zzbZt = zzf(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.zzbZt = zzWq();
        } else if (i != 11) {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzbZq = 11;
        double parseDouble = Double.parseDouble(this.zzbZt);
        if (this.zzbZm || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.zzbZt = null;
            this.zzbZq = 0;
            int[] iArr2 = this.zzbZx;
            int i3 = this.zzbZv - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        throw new zzalz(new StringBuilder(String.valueOf(path2).length() + 102).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
    }

    public int nextInt() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 15) {
            int i2 = (int) this.zzbZr;
            if (this.zzbZr != ((long) i2)) {
                long j = this.zzbZr;
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i3 = this.zzbZv - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.zzbZt = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else if (i == 8 || i == 9) {
            this.zzbZt = zzf(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.zzbZt);
                this.zzbZq = 0;
                int[] iArr2 = this.zzbZx;
                int i4 = this.zzbZv - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.zzbZq = 11;
        double parseDouble = Double.parseDouble(this.zzbZt);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            String str = this.zzbZt;
            int lineNumber3 = getLineNumber();
            int columnNumber3 = getColumnNumber();
            String path3 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length()).append("Expected an int but was ").append(str).append(" at line ").append(lineNumber3).append(" column ").append(columnNumber3).append(" path ").append(path3).toString());
        }
        this.zzbZt = null;
        this.zzbZq = 0;
        int[] iArr3 = this.zzbZx;
        int i6 = this.zzbZv - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 15) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.zzbZr;
        }
        if (i == 16) {
            this.zzbZt = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else if (i == 8 || i == 9) {
            this.zzbZt = zzf(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.zzbZt);
                this.zzbZq = 0;
                int[] iArr2 = this.zzbZx;
                int i3 = this.zzbZv - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzbZq = 11;
        double parseDouble = Double.parseDouble(this.zzbZt);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            String str = this.zzbZt;
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length()).append("Expected a long but was ").append(str).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.zzbZt = null;
        this.zzbZq = 0;
        int[] iArr3 = this.zzbZx;
        int i4 = this.zzbZv - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String nextName() throws IOException {
        String zzf;
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 14) {
            zzf = zzWq();
        } else if (i == 12) {
            zzf = zzf('\'');
        } else if (i == 13) {
            zzf = zzf('\"');
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzbZq = 0;
        this.zzbZw[this.zzbZv - 1] = zzf;
        return zzf;
    }

    public void nextNull() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 7) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String nextString() throws IOException {
        String str;
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 10) {
            str = zzWq();
        } else if (i == 8) {
            str = zzf('\'');
        } else if (i == 9) {
            str = zzf('\"');
        } else if (i == 11) {
            str = this.zzbZt;
            this.zzbZt = null;
        } else if (i == 15) {
            str = Long.toString(this.zzbZr);
        } else if (i == 16) {
            str = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzbZq = 0;
        int[] iArr = this.zzbZx;
        int i2 = this.zzbZv - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.zzbZm = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.zzbZq;
            if (i2 == 0) {
                i2 = zzWn();
            }
            if (i2 == 3) {
                zznQ(1);
                i++;
            } else if (i2 == 1) {
                zznQ(3);
                i++;
            } else if (i2 == 4) {
                this.zzbZv--;
                i--;
            } else if (i2 == 2) {
                this.zzbZv--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                zzWr();
            } else if (i2 == 8 || i2 == 12) {
                zzg('\'');
            } else if (i2 == 9 || i2 == 13) {
                zzg('\"');
            } else if (i2 == 16) {
                this.pos += this.zzbZs;
            }
            this.zzbZq = 0;
        } while (i != 0);
        int[] iArr = this.zzbZx;
        int i3 = this.zzbZv - 1;
        iArr[i3] = iArr[i3] + 1;
        this.zzbZw[this.zzbZv - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(getColumnNumber()).toString();
    }

    public zzalx zzWa() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        switch (i) {
            case 1:
                return zzalx.BEGIN_OBJECT;
            case 2:
                return zzalx.END_OBJECT;
            case 3:
                return zzalx.BEGIN_ARRAY;
            case 4:
                return zzalx.END_ARRAY;
            case 5:
            case 6:
                return zzalx.BOOLEAN;
            case 7:
                return zzalx.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzalx.STRING;
            case 12:
            case 13:
            case 14:
                return zzalx.NAME;
            case 15:
            case 16:
                return zzalx.NUMBER;
            case 17:
                return zzalx.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
