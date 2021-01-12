package com.google.android.gms.internal;

import java.io.IOException;

public interface zzag {

    public static final class zza extends zzamd<zza> {
        private static volatile zza[] zzjI;
        public int type;
        public String zzjJ;
        public zza[] zzjK;
        public zza[] zzjL;
        public zza[] zzjM;
        public String zzjN;
        public String zzjO;
        public long zzjP;
        public boolean zzjQ;
        public zza[] zzjR;
        public int[] zzjS;
        public boolean zzjT;

        public zza() {
            zzQ();
        }

        public static zza[] zzP() {
            if (zzjI == null) {
                synchronized (zzamh.zzcai) {
                    if (zzjI == null) {
                        zzjI = new zza[0];
                    }
                }
            }
            return zzjI;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.type != zza.type) {
                return false;
            }
            if (this.zzjJ == null) {
                if (zza.zzjJ != null) {
                    return false;
                }
            } else if (!this.zzjJ.equals(zza.zzjJ)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzjK, (Object[]) zza.zzjK) || !zzamh.equals((Object[]) this.zzjL, (Object[]) zza.zzjL) || !zzamh.equals((Object[]) this.zzjM, (Object[]) zza.zzjM)) {
                return false;
            }
            if (this.zzjN == null) {
                if (zza.zzjN != null) {
                    return false;
                }
            } else if (!this.zzjN.equals(zza.zzjN)) {
                return false;
            }
            if (this.zzjO == null) {
                if (zza.zzjO != null) {
                    return false;
                }
            } else if (!this.zzjO.equals(zza.zzjO)) {
                return false;
            }
            if (this.zzjP == zza.zzjP && this.zzjQ == zza.zzjQ && zzamh.equals((Object[]) this.zzjR, (Object[]) zza.zzjR) && zzamh.equals(this.zzjS, zza.zzjS) && this.zzjT == zza.zzjT) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zza.zzcaa == null || zza.zzcaa.isEmpty() : this.zzcaa.equals(zza.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzjQ ? 1231 : 1237) + (((((this.zzjO == null ? 0 : this.zzjO.hashCode()) + (((this.zzjN == null ? 0 : this.zzjN.hashCode()) + (((((((((this.zzjJ == null ? 0 : this.zzjJ.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzamh.hashCode((Object[]) this.zzjK)) * 31) + zzamh.hashCode((Object[]) this.zzjL)) * 31) + zzamh.hashCode((Object[]) this.zzjM)) * 31)) * 31)) * 31) + ((int) (this.zzjP ^ (this.zzjP >>> 32)))) * 31)) * 31) + zzamh.hashCode((Object[]) this.zzjR)) * 31) + zzamh.hashCode(this.zzjS)) * 31;
            if (!this.zzjT) {
                i = 1237;
            }
            int i3 = (hashCode + i) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i2 = this.zzcaa.hashCode();
            }
            return i3 + i2;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzamc.zzE(1, this.type);
            if (!this.zzjJ.equals("")) {
                zzamc.zzq(2, this.zzjJ);
            }
            if (this.zzjK != null && this.zzjK.length > 0) {
                for (zza zza : this.zzjK) {
                    if (zza != null) {
                        zzamc.zza(3, (zzamj) zza);
                    }
                }
            }
            if (this.zzjL != null && this.zzjL.length > 0) {
                for (zza zza2 : this.zzjL) {
                    if (zza2 != null) {
                        zzamc.zza(4, (zzamj) zza2);
                    }
                }
            }
            if (this.zzjM != null && this.zzjM.length > 0) {
                for (zza zza3 : this.zzjM) {
                    if (zza3 != null) {
                        zzamc.zza(5, (zzamj) zza3);
                    }
                }
            }
            if (!this.zzjN.equals("")) {
                zzamc.zzq(6, this.zzjN);
            }
            if (!this.zzjO.equals("")) {
                zzamc.zzq(7, this.zzjO);
            }
            if (this.zzjP != 0) {
                zzamc.zzb(8, this.zzjP);
            }
            if (this.zzjT) {
                zzamc.zzj(9, this.zzjT);
            }
            if (this.zzjS != null && this.zzjS.length > 0) {
                for (int zzE : this.zzjS) {
                    zzamc.zzE(10, zzE);
                }
            }
            if (this.zzjR != null && this.zzjR.length > 0) {
                for (zza zza4 : this.zzjR) {
                    if (zza4 != null) {
                        zzamc.zza(11, (zzamj) zza4);
                    }
                }
            }
            if (this.zzjQ) {
                zzamc.zzj(12, this.zzjQ);
            }
            super.writeTo(zzamc);
        }

        public zza zzQ() {
            this.type = 1;
            this.zzjJ = "";
            this.zzjK = zzP();
            this.zzjL = zzP();
            this.zzjM = zzP();
            this.zzjN = "";
            this.zzjO = "";
            this.zzjP = 0;
            this.zzjQ = false;
            this.zzjR = zzP();
            this.zzjS = zzamm.zzcal;
            this.zzjT = false;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzk */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            int i;
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        int zzWG = zzamb.zzWG();
                        switch (zzWG) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzWG;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzjJ = zzamb.readString();
                        continue;
                    case 26:
                        int zzc = zzamm.zzc(zzamb, 26);
                        int length = this.zzjK == null ? 0 : this.zzjK.length;
                        zza[] zzaArr = new zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjK, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zza();
                            zzamb.zza(zzaArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzaArr[length] = new zza();
                        zzamb.zza(zzaArr[length]);
                        this.zzjK = zzaArr;
                        continue;
                    case 34:
                        int zzc2 = zzamm.zzc(zzamb, 34);
                        int length2 = this.zzjL == null ? 0 : this.zzjL.length;
                        zza[] zzaArr2 = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjL, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zza();
                            zzamb.zza(zzaArr2[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzaArr2[length2] = new zza();
                        zzamb.zza(zzaArr2[length2]);
                        this.zzjL = zzaArr2;
                        continue;
                    case 42:
                        int zzc3 = zzamm.zzc(zzamb, 42);
                        int length3 = this.zzjM == null ? 0 : this.zzjM.length;
                        zza[] zzaArr3 = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjM, 0, zzaArr3, 0, length3);
                        }
                        while (length3 < zzaArr3.length - 1) {
                            zzaArr3[length3] = new zza();
                            zzamb.zza(zzaArr3[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzaArr3[length3] = new zza();
                        zzamb.zza(zzaArr3[length3]);
                        this.zzjM = zzaArr3;
                        continue;
                    case 50:
                        this.zzjN = zzamb.readString();
                        continue;
                    case 58:
                        this.zzjO = zzamb.readString();
                        continue;
                    case 64:
                        this.zzjP = zzamb.zzWF();
                        continue;
                    case 72:
                        this.zzjT = zzamb.zzWI();
                        continue;
                    case 80:
                        int zzc4 = zzamm.zzc(zzamb, 80);
                        int[] iArr = new int[zzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzc4) {
                            if (i2 != 0) {
                                zzamb.zzWC();
                            }
                            int zzWG2 = zzamb.zzWG();
                            switch (zzWG2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = zzWG2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzjS == null ? 0 : this.zzjS.length;
                            if (length4 != 0 || i3 != zzc4) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzjS, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzjS = iArr2;
                                break;
                            } else {
                                this.zzjS = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 82:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i4 = 0;
                        while (zzamb.zzWQ() > 0) {
                            switch (zzamb.zzWG()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzamb.zznY(position);
                            int length5 = this.zzjS == null ? 0 : this.zzjS.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzjS, 0, iArr3, 0, length5);
                            }
                            while (zzamb.zzWQ() > 0) {
                                int zzWG3 = zzamb.zzWG();
                                switch (zzWG3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        iArr3[length5] = zzWG3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzjS = iArr3;
                        }
                        zzamb.zznX(zznW);
                        continue;
                    case 90:
                        int zzc5 = zzamm.zzc(zzamb, 90);
                        int length6 = this.zzjR == null ? 0 : this.zzjR.length;
                        zza[] zzaArr4 = new zza[(zzc5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjR, 0, zzaArr4, 0, length6);
                        }
                        while (length6 < zzaArr4.length - 1) {
                            zzaArr4[length6] = new zza();
                            zzamb.zza(zzaArr4[length6]);
                            zzamb.zzWC();
                            length6++;
                        }
                        zzaArr4[length6] = new zza();
                        zzamb.zza(zzaArr4[length6]);
                        this.zzjR = zzaArr4;
                        continue;
                    case 96:
                        this.zzjQ = zzamb.zzWI();
                        continue;
                    default:
                        if (!super.zza(zzamb, zzWC)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy() + zzamc.zzG(1, this.type);
            if (!this.zzjJ.equals("")) {
                zzy += zzamc.zzr(2, this.zzjJ);
            }
            if (this.zzjK != null && this.zzjK.length > 0) {
                int i = zzy;
                for (zza zza : this.zzjK) {
                    if (zza != null) {
                        i += zzamc.zzc(3, (zzamj) zza);
                    }
                }
                zzy = i;
            }
            if (this.zzjL != null && this.zzjL.length > 0) {
                int i2 = zzy;
                for (zza zza2 : this.zzjL) {
                    if (zza2 != null) {
                        i2 += zzamc.zzc(4, (zzamj) zza2);
                    }
                }
                zzy = i2;
            }
            if (this.zzjM != null && this.zzjM.length > 0) {
                int i3 = zzy;
                for (zza zza3 : this.zzjM) {
                    if (zza3 != null) {
                        i3 += zzamc.zzc(5, (zzamj) zza3);
                    }
                }
                zzy = i3;
            }
            if (!this.zzjN.equals("")) {
                zzy += zzamc.zzr(6, this.zzjN);
            }
            if (!this.zzjO.equals("")) {
                zzy += zzamc.zzr(7, this.zzjO);
            }
            if (this.zzjP != 0) {
                zzy += zzamc.zze(8, this.zzjP);
            }
            if (this.zzjT) {
                zzy += zzamc.zzk(9, this.zzjT);
            }
            if (this.zzjS != null && this.zzjS.length > 0) {
                int i4 = 0;
                for (int zzoc : this.zzjS) {
                    i4 += zzamc.zzoc(zzoc);
                }
                zzy = zzy + i4 + (this.zzjS.length * 1);
            }
            if (this.zzjR != null && this.zzjR.length > 0) {
                for (zza zza4 : this.zzjR) {
                    if (zza4 != null) {
                        zzy += zzamc.zzc(11, (zzamj) zza4);
                    }
                }
            }
            return this.zzjQ ? zzy + zzamc.zzk(12, this.zzjQ) : zzy;
        }
    }
}
