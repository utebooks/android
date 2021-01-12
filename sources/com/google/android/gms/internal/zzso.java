package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import java.io.IOException;

public interface zzso {

    public static final class zza extends zzamj {
        private static volatile zza[] zzbgI;
        public String name;
        public Boolean zzbgJ;
        public Boolean zzbgK;

        public zza() {
            zzGX();
        }

        public static zza[] zzGW() {
            if (zzbgI == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgI == null) {
                        zzbgI = new zza[0];
                    }
                }
            }
            return zzbgI;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.zzbgJ == null) {
                if (zza.zzbgJ != null) {
                    return false;
                }
            } else if (!this.zzbgJ.equals(zza.zzbgJ)) {
                return false;
            }
            return this.zzbgK == null ? zza.zzbgK == null : this.zzbgK.equals(zza.zzbgK);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbgJ == null ? 0 : this.zzbgJ.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbgK != null) {
                i = this.zzbgK.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.name != null) {
                zzamc.zzq(1, this.name);
            }
            if (this.zzbgJ != null) {
                zzamc.zzj(2, this.zzbgJ.booleanValue());
            }
            if (this.zzbgK != null) {
                zzamc.zzj(3, this.zzbgK.booleanValue());
            }
            super.writeTo(zzamc);
        }

        public zza zzGX() {
            this.name = null;
            this.zzbgJ = null;
            this.zzbgK = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.name != null) {
                zzy += zzamc.zzr(1, this.name);
            }
            if (this.zzbgJ != null) {
                zzy += zzamc.zzk(2, this.zzbgJ.booleanValue());
            }
            return this.zzbgK != null ? zzy + zzamc.zzk(3, this.zzbgK.booleanValue()) : zzy;
        }

        /* renamed from: zzz */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzamb.readString();
                        continue;
                    case 16:
                        this.zzbgJ = Boolean.valueOf(zzamb.zzWI());
                        continue;
                    case 24:
                        this.zzbgK = Boolean.valueOf(zzamb.zzWI());
                        continue;
                    default:
                        if (!zzamm.zzb(zzamb, zzWC)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }
    }

    public static final class zzb extends zzamj {
        public String zzbbK;
        public Long zzbgL;
        public Integer zzbgM;
        public zzc[] zzbgN;
        public zza[] zzbgO;
        public zzsn.zza[] zzbgP;

        public zzb() {
            zzGY();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.zzbgL == null) {
                if (zzb.zzbgL != null) {
                    return false;
                }
            } else if (!this.zzbgL.equals(zzb.zzbgL)) {
                return false;
            }
            if (this.zzbbK == null) {
                if (zzb.zzbbK != null) {
                    return false;
                }
            } else if (!this.zzbbK.equals(zzb.zzbbK)) {
                return false;
            }
            if (this.zzbgM == null) {
                if (zzb.zzbgM != null) {
                    return false;
                }
            } else if (!this.zzbgM.equals(zzb.zzbgM)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbgN, (Object[]) zzb.zzbgN)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbgO, (Object[]) zzb.zzbgO)) {
                return false;
            }
            return zzamh.equals((Object[]) this.zzbgP, (Object[]) zzb.zzbgP);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbbK == null ? 0 : this.zzbbK.hashCode()) + (((this.zzbgL == null ? 0 : this.zzbgL.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbgM != null) {
                i = this.zzbgM.hashCode();
            }
            return ((((((hashCode + i) * 31) + zzamh.hashCode((Object[]) this.zzbgN)) * 31) + zzamh.hashCode((Object[]) this.zzbgO)) * 31) + zzamh.hashCode((Object[]) this.zzbgP);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbgL != null) {
                zzamc.zzb(1, this.zzbgL.longValue());
            }
            if (this.zzbbK != null) {
                zzamc.zzq(2, this.zzbbK);
            }
            if (this.zzbgM != null) {
                zzamc.zzE(3, this.zzbgM.intValue());
            }
            if (this.zzbgN != null && this.zzbgN.length > 0) {
                for (zzc zzc : this.zzbgN) {
                    if (zzc != null) {
                        zzamc.zza(4, (zzamj) zzc);
                    }
                }
            }
            if (this.zzbgO != null && this.zzbgO.length > 0) {
                for (zza zza : this.zzbgO) {
                    if (zza != null) {
                        zzamc.zza(5, (zzamj) zza);
                    }
                }
            }
            if (this.zzbgP != null && this.zzbgP.length > 0) {
                for (zzsn.zza zza2 : this.zzbgP) {
                    if (zza2 != null) {
                        zzamc.zza(6, (zzamj) zza2);
                    }
                }
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzA */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        this.zzbgL = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 18:
                        this.zzbbK = zzamb.readString();
                        continue;
                    case 24:
                        this.zzbgM = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 34:
                        int zzc = zzamm.zzc(zzamb, 34);
                        int length = this.zzbgN == null ? 0 : this.zzbgN.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbgN, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzamb.zza(zzcArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzamb.zza(zzcArr[length]);
                        this.zzbgN = zzcArr;
                        continue;
                    case 42:
                        int zzc2 = zzamm.zzc(zzamb, 42);
                        int length2 = this.zzbgO == null ? 0 : this.zzbgO.length;
                        zza[] zzaArr = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbgO, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zza();
                            zzamb.zza(zzaArr[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzaArr[length2] = new zza();
                        zzamb.zza(zzaArr[length2]);
                        this.zzbgO = zzaArr;
                        continue;
                    case 50:
                        int zzc3 = zzamm.zzc(zzamb, 50);
                        int length3 = this.zzbgP == null ? 0 : this.zzbgP.length;
                        zzsn.zza[] zzaArr2 = new zzsn.zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbgP, 0, zzaArr2, 0, length3);
                        }
                        while (length3 < zzaArr2.length - 1) {
                            zzaArr2[length3] = new zzsn.zza();
                            zzamb.zza(zzaArr2[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzaArr2[length3] = new zzsn.zza();
                        zzamb.zza(zzaArr2[length3]);
                        this.zzbgP = zzaArr2;
                        continue;
                    default:
                        if (!zzamm.zzb(zzamb, zzWC)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzb zzGY() {
            this.zzbgL = null;
            this.zzbbK = null;
            this.zzbgM = null;
            this.zzbgN = zzc.zzGZ();
            this.zzbgO = zza.zzGW();
            this.zzbgP = zzsn.zza.zzGM();
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzbgL != null) {
                zzy += zzamc.zze(1, this.zzbgL.longValue());
            }
            if (this.zzbbK != null) {
                zzy += zzamc.zzr(2, this.zzbbK);
            }
            if (this.zzbgM != null) {
                zzy += zzamc.zzG(3, this.zzbgM.intValue());
            }
            if (this.zzbgN != null && this.zzbgN.length > 0) {
                int i = zzy;
                for (zzc zzc : this.zzbgN) {
                    if (zzc != null) {
                        i += zzamc.zzc(4, (zzamj) zzc);
                    }
                }
                zzy = i;
            }
            if (this.zzbgO != null && this.zzbgO.length > 0) {
                int i2 = zzy;
                for (zza zza : this.zzbgO) {
                    if (zza != null) {
                        i2 += zzamc.zzc(5, (zzamj) zza);
                    }
                }
                zzy = i2;
            }
            if (this.zzbgP != null && this.zzbgP.length > 0) {
                for (zzsn.zza zza2 : this.zzbgP) {
                    if (zza2 != null) {
                        zzy += zzamc.zzc(6, (zzamj) zza2);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zzc extends zzamj {
        private static volatile zzc[] zzbgQ;
        public String value;
        public String zzaB;

        public zzc() {
            zzHa();
        }

        public static zzc[] zzGZ() {
            if (zzbgQ == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgQ == null) {
                        zzbgQ = new zzc[0];
                    }
                }
            }
            return zzbgQ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.zzaB == null) {
                if (zzc.zzaB != null) {
                    return false;
                }
            } else if (!this.zzaB.equals(zzc.zzaB)) {
                return false;
            }
            return this.value == null ? zzc.value == null : this.value.equals(zzc.value);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaB == null ? 0 : this.zzaB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzaB != null) {
                zzamc.zzq(1, this.zzaB);
            }
            if (this.value != null) {
                zzamc.zzq(2, this.value);
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzB */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        this.zzaB = zzamb.readString();
                        continue;
                    case 18:
                        this.value = zzamb.readString();
                        continue;
                    default:
                        if (!zzamm.zzb(zzamb, zzWC)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzc zzHa() {
            this.zzaB = null;
            this.value = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzaB != null) {
                zzy += zzamc.zzr(1, this.zzaB);
            }
            return this.value != null ? zzy + zzamc.zzr(2, this.value) : zzy;
        }
    }
}
