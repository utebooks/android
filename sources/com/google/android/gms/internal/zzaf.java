package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import com.google.android.gms.internal.zzag;
import java.io.IOException;

public interface zzaf {

    public static final class zza extends zzamd<zza> {
        public int level;
        public int zziC;
        public int zziD;

        public zza() {
            zzA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.level == zza.level && this.zziC == zza.zziC && this.zziD == zza.zziD) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zza.zzcaa == null || zza.zzcaa.isEmpty() : this.zzcaa.equals(zza.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zziC) * 31) + this.zziD) * 31);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.level != 1) {
                zzamc.zzE(1, this.level);
            }
            if (this.zziC != 0) {
                zzamc.zzE(2, this.zziC);
            }
            if (this.zziD != 0) {
                zzamc.zzE(3, this.zziD);
            }
            super.writeTo(zzamc);
        }

        public zza zzA() {
            this.level = 1;
            this.zziC = 0;
            this.zziD = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zza */
        public zza mergeFrom(zzamb zzamb) throws IOException {
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
                                this.level = zzWG;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zziC = zzamb.zzWG();
                        continue;
                    case 24:
                        this.zziD = zzamb.zzWG();
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
            int zzy = super.zzy();
            if (this.level != 1) {
                zzy += zzamc.zzG(1, this.level);
            }
            if (this.zziC != 0) {
                zzy += zzamc.zzG(2, this.zziC);
            }
            return this.zziD != 0 ? zzy + zzamc.zzG(3, this.zziD) : zzy;
        }
    }

    public static final class zzb extends zzamd<zzb> {
        private static volatile zzb[] zziE;
        public int name;
        public int[] zziF;
        public int zziG;
        public boolean zziH;
        public boolean zziI;

        public zzb() {
            zzC();
        }

        public static zzb[] zzB() {
            if (zziE == null) {
                synchronized (zzamh.zzcai) {
                    if (zziE == null) {
                        zziE = new zzb[0];
                    }
                }
            }
            return zziE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (zzamh.equals(this.zziF, zzb.zziF) && this.zziG == zzb.zziG && this.name == zzb.name && this.zziH == zzb.zziH && this.zziI == zzb.zziI) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzb.zzcaa == null || zzb.zzcaa.isEmpty() : this.zzcaa.equals(zzb.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zziH ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zziF)) * 31) + this.zziG) * 31) + this.name) * 31)) * 31;
            if (!this.zziI) {
                i = 1237;
            }
            return ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode()) + ((hashCode + i) * 31);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zziI) {
                zzamc.zzj(1, this.zziI);
            }
            zzamc.zzE(2, this.zziG);
            if (this.zziF != null && this.zziF.length > 0) {
                for (int zzE : this.zziF) {
                    zzamc.zzE(3, zzE);
                }
            }
            if (this.name != 0) {
                zzamc.zzE(4, this.name);
            }
            if (this.zziH) {
                zzamc.zzj(6, this.zziH);
            }
            super.writeTo(zzamc);
        }

        public zzb zzC() {
            this.zziF = zzamm.zzcal;
            this.zziG = 0;
            this.name = 0;
            this.zziH = false;
            this.zziI = false;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzb */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        this.zziI = zzamb.zzWI();
                        continue;
                    case 16:
                        this.zziG = zzamb.zzWG();
                        continue;
                    case 24:
                        int zzc = zzamm.zzc(zzamb, 24);
                        int length = this.zziF == null ? 0 : this.zziF.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziF, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzamb.zzWG();
                            zzamb.zzWC();
                            length++;
                        }
                        iArr[length] = zzamb.zzWG();
                        this.zziF = iArr;
                        continue;
                    case 26:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i++;
                        }
                        zzamb.zznY(position);
                        int length2 = this.zziF == null ? 0 : this.zziF.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziF, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzamb.zzWG();
                            length2++;
                        }
                        this.zziF = iArr2;
                        zzamb.zznX(zznW);
                        continue;
                    case 32:
                        this.name = zzamb.zzWG();
                        continue;
                    case 48:
                        this.zziH = zzamb.zzWI();
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
            int i;
            int i2 = 0;
            int zzy = super.zzy();
            if (this.zziI) {
                zzy += zzamc.zzk(1, this.zziI);
            }
            int zzG = zzamc.zzG(2, this.zziG) + zzy;
            if (this.zziF == null || this.zziF.length <= 0) {
                i = zzG;
            } else {
                for (int zzoc : this.zziF) {
                    i2 += zzamc.zzoc(zzoc);
                }
                i = zzG + i2 + (this.zziF.length * 1);
            }
            if (this.name != 0) {
                i += zzamc.zzG(4, this.name);
            }
            return this.zziH ? i + zzamc.zzk(6, this.zziH) : i;
        }
    }

    public static final class zzc extends zzamd<zzc> {
        private static volatile zzc[] zziJ;
        public String zzaB;
        public long zziK;
        public long zziL;
        public boolean zziM;
        public long zziN;

        public zzc() {
            zzE();
        }

        public static zzc[] zzD() {
            if (zziJ == null) {
                synchronized (zzamh.zzcai) {
                    if (zziJ == null) {
                        zziJ = new zzc[0];
                    }
                }
            }
            return zziJ;
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
            if (this.zziK == zzc.zziK && this.zziL == zzc.zziL && this.zziM == zzc.zziM && this.zziN == zzc.zziN) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzc.zzcaa == null || zzc.zzcaa.isEmpty() : this.zzcaa.equals(zzc.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zziM ? 1231 : 1237) + (((((((this.zzaB == null ? 0 : this.zzaB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zziK ^ (this.zziK >>> 32)))) * 31) + ((int) (this.zziL ^ (this.zziL >>> 32)))) * 31)) * 31) + ((int) (this.zziN ^ (this.zziN >>> 32)))) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (!this.zzaB.equals("")) {
                zzamc.zzq(1, this.zzaB);
            }
            if (this.zziK != 0) {
                zzamc.zzb(2, this.zziK);
            }
            if (this.zziL != 2147483647L) {
                zzamc.zzb(3, this.zziL);
            }
            if (this.zziM) {
                zzamc.zzj(4, this.zziM);
            }
            if (this.zziN != 0) {
                zzamc.zzb(5, this.zziN);
            }
            super.writeTo(zzamc);
        }

        public zzc zzE() {
            this.zzaB = "";
            this.zziK = 0;
            this.zziL = 2147483647L;
            this.zziM = false;
            this.zziN = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzc */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        this.zzaB = zzamb.readString();
                        continue;
                    case 16:
                        this.zziK = zzamb.zzWF();
                        continue;
                    case 24:
                        this.zziL = zzamb.zzWF();
                        continue;
                    case 32:
                        this.zziM = zzamb.zzWI();
                        continue;
                    case 40:
                        this.zziN = zzamb.zzWF();
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
            int zzy = super.zzy();
            if (!this.zzaB.equals("")) {
                zzy += zzamc.zzr(1, this.zzaB);
            }
            if (this.zziK != 0) {
                zzy += zzamc.zze(2, this.zziK);
            }
            if (this.zziL != 2147483647L) {
                zzy += zzamc.zze(3, this.zziL);
            }
            if (this.zziM) {
                zzy += zzamc.zzk(4, this.zziM);
            }
            return this.zziN != 0 ? zzy + zzamc.zze(5, this.zziN) : zzy;
        }
    }

    public static final class zzd extends zzamd<zzd> {
        public zzag.zza[] zziO;
        public zzag.zza[] zziP;
        public zzc[] zziQ;

        public zzd() {
            zzF();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (!zzamh.equals((Object[]) this.zziO, (Object[]) zzd.zziO) || !zzamh.equals((Object[]) this.zziP, (Object[]) zzd.zziP) || !zzamh.equals((Object[]) this.zziQ, (Object[]) zzd.zziQ)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzd.zzcaa == null || zzd.zzcaa.isEmpty() : this.zzcaa.equals(zzd.zzcaa);
        }

        public int hashCode() {
            return ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zziO)) * 31) + zzamh.hashCode((Object[]) this.zziP)) * 31) + zzamh.hashCode((Object[]) this.zziQ)) * 31);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zziO != null && this.zziO.length > 0) {
                for (zzag.zza zza : this.zziO) {
                    if (zza != null) {
                        zzamc.zza(1, (zzamj) zza);
                    }
                }
            }
            if (this.zziP != null && this.zziP.length > 0) {
                for (zzag.zza zza2 : this.zziP) {
                    if (zza2 != null) {
                        zzamc.zza(2, (zzamj) zza2);
                    }
                }
            }
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (zzc zzc : this.zziQ) {
                    if (zzc != null) {
                        zzamc.zza(3, (zzamj) zzc);
                    }
                }
            }
            super.writeTo(zzamc);
        }

        public zzd zzF() {
            this.zziO = zzag.zza.zzP();
            this.zziP = zzag.zza.zzP();
            this.zziQ = zzc.zzD();
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzd */
        public zzd mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzamm.zzc(zzamb, 10);
                        int length = this.zziO == null ? 0 : this.zziO.length;
                        zzag.zza[] zzaArr = new zzag.zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziO, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zzag.zza();
                            zzamb.zza(zzaArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzaArr[length] = new zzag.zza();
                        zzamb.zza(zzaArr[length]);
                        this.zziO = zzaArr;
                        continue;
                    case 18:
                        int zzc2 = zzamm.zzc(zzamb, 18);
                        int length2 = this.zziP == null ? 0 : this.zziP.length;
                        zzag.zza[] zzaArr2 = new zzag.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziP, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zzag.zza();
                            zzamb.zza(zzaArr2[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzaArr2[length2] = new zzag.zza();
                        zzamb.zza(zzaArr2[length2]);
                        this.zziP = zzaArr2;
                        continue;
                    case 26:
                        int zzc3 = zzamm.zzc(zzamb, 26);
                        int length3 = this.zziQ == null ? 0 : this.zziQ.length;
                        zzc[] zzcArr = new zzc[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziQ, 0, zzcArr, 0, length3);
                        }
                        while (length3 < zzcArr.length - 1) {
                            zzcArr[length3] = new zzc();
                            zzamb.zza(zzcArr[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzcArr[length3] = new zzc();
                        zzamb.zza(zzcArr[length3]);
                        this.zziQ = zzcArr;
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
            int zzy = super.zzy();
            if (this.zziO != null && this.zziO.length > 0) {
                int i = zzy;
                for (zzag.zza zza : this.zziO) {
                    if (zza != null) {
                        i += zzamc.zzc(1, (zzamj) zza);
                    }
                }
                zzy = i;
            }
            if (this.zziP != null && this.zziP.length > 0) {
                int i2 = zzy;
                for (zzag.zza zza2 : this.zziP) {
                    if (zza2 != null) {
                        i2 += zzamc.zzc(2, (zzamj) zza2);
                    }
                }
                zzy = i2;
            }
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (zzc zzc : this.zziQ) {
                    if (zzc != null) {
                        zzy += zzamc.zzc(3, (zzamj) zzc);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzamd<zze> {
        private static volatile zze[] zziR;
        public int key;
        public int value;

        public zze() {
            zzH();
        }

        public static zze[] zzG() {
            if (zziR == null) {
                synchronized (zzamh.zzcai) {
                    if (zziR == null) {
                        zziR = new zze[0];
                    }
                }
            }
            return zziR;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.key == zze.key && this.value == zze.value) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zze.zzcaa == null || zze.zzcaa.isEmpty() : this.zzcaa.equals(zze.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzamc.zzE(1, this.key);
            zzamc.zzE(2, this.value);
            super.writeTo(zzamc);
        }

        public zze zzH() {
            this.key = 0;
            this.value = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zze */
        public zze mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzamb.zzWG();
                        continue;
                    case 16:
                        this.value = zzamb.zzWG();
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
            return super.zzy() + zzamc.zzG(1, this.key) + zzamc.zzG(2, this.value);
        }
    }

    public static final class zzf extends zzamd<zzf> {
        public String version;
        public String[] zziS;
        public String[] zziT;
        public zzag.zza[] zziU;
        public zze[] zziV;
        public zzb[] zziW;
        public zzb[] zziX;
        public zzb[] zziY;
        public zzg[] zziZ;
        public String zzja;
        public String zzjb;
        public String zzjc;
        public zza zzjd;
        public float zzje;
        public boolean zzjf;
        public String[] zzjg;
        public int zzjh;

        public zzf() {
            zzI();
        }

        public static zzf zzc(byte[] bArr) throws zzami {
            return (zzf) zzamj.mergeFrom(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzamh.equals((Object[]) this.zziS, (Object[]) zzf.zziS) || !zzamh.equals((Object[]) this.zziT, (Object[]) zzf.zziT) || !zzamh.equals((Object[]) this.zziU, (Object[]) zzf.zziU) || !zzamh.equals((Object[]) this.zziV, (Object[]) zzf.zziV) || !zzamh.equals((Object[]) this.zziW, (Object[]) zzf.zziW) || !zzamh.equals((Object[]) this.zziX, (Object[]) zzf.zziX) || !zzamh.equals((Object[]) this.zziY, (Object[]) zzf.zziY) || !zzamh.equals((Object[]) this.zziZ, (Object[]) zzf.zziZ)) {
                return false;
            }
            if (this.zzja == null) {
                if (zzf.zzja != null) {
                    return false;
                }
            } else if (!this.zzja.equals(zzf.zzja)) {
                return false;
            }
            if (this.zzjb == null) {
                if (zzf.zzjb != null) {
                    return false;
                }
            } else if (!this.zzjb.equals(zzf.zzjb)) {
                return false;
            }
            if (this.zzjc == null) {
                if (zzf.zzjc != null) {
                    return false;
                }
            } else if (!this.zzjc.equals(zzf.zzjc)) {
                return false;
            }
            if (this.version == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzf.version)) {
                return false;
            }
            if (this.zzjd == null) {
                if (zzf.zzjd != null) {
                    return false;
                }
            } else if (!this.zzjd.equals(zzf.zzjd)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzje) == Float.floatToIntBits(zzf.zzje) && this.zzjf == zzf.zzjf && zzamh.equals((Object[]) this.zzjg, (Object[]) zzf.zzjg) && this.zzjh == zzf.zzjh) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzf.zzcaa == null || zzf.zzcaa.isEmpty() : this.zzcaa.equals(zzf.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zzjf ? 1231 : 1237) + (((((this.zzjd == null ? 0 : this.zzjd.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzjc == null ? 0 : this.zzjc.hashCode()) + (((this.zzjb == null ? 0 : this.zzjb.hashCode()) + (((this.zzja == null ? 0 : this.zzja.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zziS)) * 31) + zzamh.hashCode((Object[]) this.zziT)) * 31) + zzamh.hashCode((Object[]) this.zziU)) * 31) + zzamh.hashCode((Object[]) this.zziV)) * 31) + zzamh.hashCode((Object[]) this.zziW)) * 31) + zzamh.hashCode((Object[]) this.zziX)) * 31) + zzamh.hashCode((Object[]) this.zziY)) * 31) + zzamh.hashCode((Object[]) this.zziZ)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzje)) * 31)) * 31) + zzamh.hashCode((Object[]) this.zzjg)) * 31) + this.zzjh) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zziT != null && this.zziT.length > 0) {
                for (String str : this.zziT) {
                    if (str != null) {
                        zzamc.zzq(1, str);
                    }
                }
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (zzag.zza zza : this.zziU) {
                    if (zza != null) {
                        zzamc.zza(2, (zzamj) zza);
                    }
                }
            }
            if (this.zziV != null && this.zziV.length > 0) {
                for (zze zze : this.zziV) {
                    if (zze != null) {
                        zzamc.zza(3, (zzamj) zze);
                    }
                }
            }
            if (this.zziW != null && this.zziW.length > 0) {
                for (zzb zzb : this.zziW) {
                    if (zzb != null) {
                        zzamc.zza(4, (zzamj) zzb);
                    }
                }
            }
            if (this.zziX != null && this.zziX.length > 0) {
                for (zzb zzb2 : this.zziX) {
                    if (zzb2 != null) {
                        zzamc.zza(5, (zzamj) zzb2);
                    }
                }
            }
            if (this.zziY != null && this.zziY.length > 0) {
                for (zzb zzb3 : this.zziY) {
                    if (zzb3 != null) {
                        zzamc.zza(6, (zzamj) zzb3);
                    }
                }
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (zzg zzg : this.zziZ) {
                    if (zzg != null) {
                        zzamc.zza(7, (zzamj) zzg);
                    }
                }
            }
            if (!this.zzja.equals("")) {
                zzamc.zzq(9, this.zzja);
            }
            if (!this.zzjb.equals("")) {
                zzamc.zzq(10, this.zzjb);
            }
            if (!this.zzjc.equals("0")) {
                zzamc.zzq(12, this.zzjc);
            }
            if (!this.version.equals("")) {
                zzamc.zzq(13, this.version);
            }
            if (this.zzjd != null) {
                zzamc.zza(14, (zzamj) this.zzjd);
            }
            if (Float.floatToIntBits(this.zzje) != Float.floatToIntBits(0.0f)) {
                zzamc.zzb(15, this.zzje);
            }
            if (this.zzjg != null && this.zzjg.length > 0) {
                for (String str2 : this.zzjg) {
                    if (str2 != null) {
                        zzamc.zzq(16, str2);
                    }
                }
            }
            if (this.zzjh != 0) {
                zzamc.zzE(17, this.zzjh);
            }
            if (this.zzjf) {
                zzamc.zzj(18, this.zzjf);
            }
            if (this.zziS != null && this.zziS.length > 0) {
                for (String str3 : this.zziS) {
                    if (str3 != null) {
                        zzamc.zzq(19, str3);
                    }
                }
            }
            super.writeTo(zzamc);
        }

        public zzf zzI() {
            this.zziS = zzamm.zzcaq;
            this.zziT = zzamm.zzcaq;
            this.zziU = zzag.zza.zzP();
            this.zziV = zze.zzG();
            this.zziW = zzb.zzB();
            this.zziX = zzb.zzB();
            this.zziY = zzb.zzB();
            this.zziZ = zzg.zzJ();
            this.zzja = "";
            this.zzjb = "";
            this.zzjc = "0";
            this.version = "";
            this.zzjd = null;
            this.zzje = 0.0f;
            this.zzjf = false;
            this.zzjg = zzamm.zzcaq;
            this.zzjh = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzf */
        public zzf mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzamm.zzc(zzamb, 10);
                        int length = this.zziT == null ? 0 : this.zziT.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziT, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzamb.readString();
                            zzamb.zzWC();
                            length++;
                        }
                        strArr[length] = zzamb.readString();
                        this.zziT = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzamm.zzc(zzamb, 18);
                        int length2 = this.zziU == null ? 0 : this.zziU.length;
                        zzag.zza[] zzaArr = new zzag.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziU, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zzag.zza();
                            zzamb.zza(zzaArr[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzaArr[length2] = new zzag.zza();
                        zzamb.zza(zzaArr[length2]);
                        this.zziU = zzaArr;
                        continue;
                    case 26:
                        int zzc3 = zzamm.zzc(zzamb, 26);
                        int length3 = this.zziV == null ? 0 : this.zziV.length;
                        zze[] zzeArr = new zze[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziV, 0, zzeArr, 0, length3);
                        }
                        while (length3 < zzeArr.length - 1) {
                            zzeArr[length3] = new zze();
                            zzamb.zza(zzeArr[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzeArr[length3] = new zze();
                        zzamb.zza(zzeArr[length3]);
                        this.zziV = zzeArr;
                        continue;
                    case 34:
                        int zzc4 = zzamm.zzc(zzamb, 34);
                        int length4 = this.zziW == null ? 0 : this.zziW.length;
                        zzb[] zzbArr = new zzb[(zzc4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziW, 0, zzbArr, 0, length4);
                        }
                        while (length4 < zzbArr.length - 1) {
                            zzbArr[length4] = new zzb();
                            zzamb.zza(zzbArr[length4]);
                            zzamb.zzWC();
                            length4++;
                        }
                        zzbArr[length4] = new zzb();
                        zzamb.zza(zzbArr[length4]);
                        this.zziW = zzbArr;
                        continue;
                    case 42:
                        int zzc5 = zzamm.zzc(zzamb, 42);
                        int length5 = this.zziX == null ? 0 : this.zziX.length;
                        zzb[] zzbArr2 = new zzb[(zzc5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziX, 0, zzbArr2, 0, length5);
                        }
                        while (length5 < zzbArr2.length - 1) {
                            zzbArr2[length5] = new zzb();
                            zzamb.zza(zzbArr2[length5]);
                            zzamb.zzWC();
                            length5++;
                        }
                        zzbArr2[length5] = new zzb();
                        zzamb.zza(zzbArr2[length5]);
                        this.zziX = zzbArr2;
                        continue;
                    case 50:
                        int zzc6 = zzamm.zzc(zzamb, 50);
                        int length6 = this.zziY == null ? 0 : this.zziY.length;
                        zzb[] zzbArr3 = new zzb[(zzc6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziY, 0, zzbArr3, 0, length6);
                        }
                        while (length6 < zzbArr3.length - 1) {
                            zzbArr3[length6] = new zzb();
                            zzamb.zza(zzbArr3[length6]);
                            zzamb.zzWC();
                            length6++;
                        }
                        zzbArr3[length6] = new zzb();
                        zzamb.zza(zzbArr3[length6]);
                        this.zziY = zzbArr3;
                        continue;
                    case 58:
                        int zzc7 = zzamm.zzc(zzamb, 58);
                        int length7 = this.zziZ == null ? 0 : this.zziZ.length;
                        zzg[] zzgArr = new zzg[(zzc7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zziZ, 0, zzgArr, 0, length7);
                        }
                        while (length7 < zzgArr.length - 1) {
                            zzgArr[length7] = new zzg();
                            zzamb.zza(zzgArr[length7]);
                            zzamb.zzWC();
                            length7++;
                        }
                        zzgArr[length7] = new zzg();
                        zzamb.zza(zzgArr[length7]);
                        this.zziZ = zzgArr;
                        continue;
                    case 74:
                        this.zzja = zzamb.readString();
                        continue;
                    case 82:
                        this.zzjb = zzamb.readString();
                        continue;
                    case 98:
                        this.zzjc = zzamb.readString();
                        continue;
                    case 106:
                        this.version = zzamb.readString();
                        continue;
                    case 114:
                        if (this.zzjd == null) {
                            this.zzjd = new zza();
                        }
                        zzamb.zza(this.zzjd);
                        continue;
                    case 125:
                        this.zzje = zzamb.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        int zzc8 = zzamm.zzc(zzamb, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zzjg == null ? 0 : this.zzjg.length;
                        String[] strArr2 = new String[(zzc8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjg, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzamb.readString();
                            zzamb.zzWC();
                            length8++;
                        }
                        strArr2[length8] = zzamb.readString();
                        this.zzjg = strArr2;
                        continue;
                    case 136:
                        this.zzjh = zzamb.zzWG();
                        continue;
                    case 144:
                        this.zzjf = zzamb.zzWI();
                        continue;
                    case 154:
                        int zzc9 = zzamm.zzc(zzamb, 154);
                        int length9 = this.zziS == null ? 0 : this.zziS.length;
                        String[] strArr3 = new String[(zzc9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zziS, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzamb.readString();
                            zzamb.zzWC();
                            length9++;
                        }
                        strArr3[length9] = zzamb.readString();
                        this.zziS = strArr3;
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
            int i;
            int zzy = super.zzy();
            if (this.zziT == null || this.zziT.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zziT) {
                    if (str != null) {
                        i3++;
                        i2 += zzamc.zziZ(str);
                    }
                }
                i = zzy + i2 + (i3 * 1);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                int i4 = i;
                for (zzag.zza zza : this.zziU) {
                    if (zza != null) {
                        i4 += zzamc.zzc(2, (zzamj) zza);
                    }
                }
                i = i4;
            }
            if (this.zziV != null && this.zziV.length > 0) {
                int i5 = i;
                for (zze zze : this.zziV) {
                    if (zze != null) {
                        i5 += zzamc.zzc(3, (zzamj) zze);
                    }
                }
                i = i5;
            }
            if (this.zziW != null && this.zziW.length > 0) {
                int i6 = i;
                for (zzb zzb : this.zziW) {
                    if (zzb != null) {
                        i6 += zzamc.zzc(4, (zzamj) zzb);
                    }
                }
                i = i6;
            }
            if (this.zziX != null && this.zziX.length > 0) {
                int i7 = i;
                for (zzb zzb2 : this.zziX) {
                    if (zzb2 != null) {
                        i7 += zzamc.zzc(5, (zzamj) zzb2);
                    }
                }
                i = i7;
            }
            if (this.zziY != null && this.zziY.length > 0) {
                int i8 = i;
                for (zzb zzb3 : this.zziY) {
                    if (zzb3 != null) {
                        i8 += zzamc.zzc(6, (zzamj) zzb3);
                    }
                }
                i = i8;
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                int i9 = i;
                for (zzg zzg : this.zziZ) {
                    if (zzg != null) {
                        i9 += zzamc.zzc(7, (zzamj) zzg);
                    }
                }
                i = i9;
            }
            if (!this.zzja.equals("")) {
                i += zzamc.zzr(9, this.zzja);
            }
            if (!this.zzjb.equals("")) {
                i += zzamc.zzr(10, this.zzjb);
            }
            if (!this.zzjc.equals("0")) {
                i += zzamc.zzr(12, this.zzjc);
            }
            if (!this.version.equals("")) {
                i += zzamc.zzr(13, this.version);
            }
            if (this.zzjd != null) {
                i += zzamc.zzc(14, (zzamj) this.zzjd);
            }
            if (Float.floatToIntBits(this.zzje) != Float.floatToIntBits(0.0f)) {
                i += zzamc.zzc(15, this.zzje);
            }
            if (this.zzjg != null && this.zzjg.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.zzjg) {
                    if (str2 != null) {
                        i11++;
                        i10 += zzamc.zziZ(str2);
                    }
                }
                i = i + i10 + (i11 * 2);
            }
            if (this.zzjh != 0) {
                i += zzamc.zzG(17, this.zzjh);
            }
            if (this.zzjf) {
                i += zzamc.zzk(18, this.zzjf);
            }
            if (this.zziS == null || this.zziS.length <= 0) {
                return i;
            }
            int i12 = 0;
            int i13 = 0;
            for (String str3 : this.zziS) {
                if (str3 != null) {
                    i13++;
                    i12 += zzamc.zziZ(str3);
                }
            }
            return i + i12 + (i13 * 2);
        }
    }

    public static final class zzg extends zzamd<zzg> {
        private static volatile zzg[] zzji;
        public int[] zzjj;
        public int[] zzjk;
        public int[] zzjl;
        public int[] zzjm;
        public int[] zzjn;
        public int[] zzjo;
        public int[] zzjp;
        public int[] zzjq;
        public int[] zzjr;
        public int[] zzjs;

        public zzg() {
            zzK();
        }

        public static zzg[] zzJ() {
            if (zzji == null) {
                synchronized (zzamh.zzcai) {
                    if (zzji == null) {
                        zzji = new zzg[0];
                    }
                }
            }
            return zzji;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (!zzamh.equals(this.zzjj, zzg.zzjj) || !zzamh.equals(this.zzjk, zzg.zzjk) || !zzamh.equals(this.zzjl, zzg.zzjl) || !zzamh.equals(this.zzjm, zzg.zzjm) || !zzamh.equals(this.zzjn, zzg.zzjn) || !zzamh.equals(this.zzjo, zzg.zzjo) || !zzamh.equals(this.zzjp, zzg.zzjp) || !zzamh.equals(this.zzjq, zzg.zzjq) || !zzamh.equals(this.zzjr, zzg.zzjr) || !zzamh.equals(this.zzjs, zzg.zzjs)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzg.zzcaa == null || zzg.zzcaa.isEmpty() : this.zzcaa.equals(zzg.zzcaa);
        }

        public int hashCode() {
            return ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode()) + ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zzjj)) * 31) + zzamh.hashCode(this.zzjk)) * 31) + zzamh.hashCode(this.zzjl)) * 31) + zzamh.hashCode(this.zzjm)) * 31) + zzamh.hashCode(this.zzjn)) * 31) + zzamh.hashCode(this.zzjo)) * 31) + zzamh.hashCode(this.zzjp)) * 31) + zzamh.hashCode(this.zzjq)) * 31) + zzamh.hashCode(this.zzjr)) * 31) + zzamh.hashCode(this.zzjs)) * 31);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzjj != null && this.zzjj.length > 0) {
                for (int zzE : this.zzjj) {
                    zzamc.zzE(1, zzE);
                }
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                for (int zzE2 : this.zzjk) {
                    zzamc.zzE(2, zzE2);
                }
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                for (int zzE3 : this.zzjl) {
                    zzamc.zzE(3, zzE3);
                }
            }
            if (this.zzjm != null && this.zzjm.length > 0) {
                for (int zzE4 : this.zzjm) {
                    zzamc.zzE(4, zzE4);
                }
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                for (int zzE5 : this.zzjn) {
                    zzamc.zzE(5, zzE5);
                }
            }
            if (this.zzjo != null && this.zzjo.length > 0) {
                for (int zzE6 : this.zzjo) {
                    zzamc.zzE(6, zzE6);
                }
            }
            if (this.zzjp != null && this.zzjp.length > 0) {
                for (int zzE7 : this.zzjp) {
                    zzamc.zzE(7, zzE7);
                }
            }
            if (this.zzjq != null && this.zzjq.length > 0) {
                for (int zzE8 : this.zzjq) {
                    zzamc.zzE(8, zzE8);
                }
            }
            if (this.zzjr != null && this.zzjr.length > 0) {
                for (int zzE9 : this.zzjr) {
                    zzamc.zzE(9, zzE9);
                }
            }
            if (this.zzjs != null && this.zzjs.length > 0) {
                for (int zzE10 : this.zzjs) {
                    zzamc.zzE(10, zzE10);
                }
            }
            super.writeTo(zzamc);
        }

        public zzg zzK() {
            this.zzjj = zzamm.zzcal;
            this.zzjk = zzamm.zzcal;
            this.zzjl = zzamm.zzcal;
            this.zzjm = zzamm.zzcal;
            this.zzjn = zzamm.zzcal;
            this.zzjo = zzamm.zzcal;
            this.zzjp = zzamm.zzcal;
            this.zzjq = zzamm.zzcal;
            this.zzjr = zzamm.zzcal;
            this.zzjs = zzamm.zzcal;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzg */
        public zzg mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzamm.zzc(zzamb, 8);
                        int length = this.zzjj == null ? 0 : this.zzjj.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjj, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzamb.zzWG();
                            zzamb.zzWC();
                            length++;
                        }
                        iArr[length] = zzamb.zzWG();
                        this.zzjj = iArr;
                        continue;
                    case 10:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i++;
                        }
                        zzamb.zznY(position);
                        int length2 = this.zzjj == null ? 0 : this.zzjj.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjj, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzamb.zzWG();
                            length2++;
                        }
                        this.zzjj = iArr2;
                        zzamb.zznX(zznW);
                        continue;
                    case 16:
                        int zzc2 = zzamm.zzc(zzamb, 16);
                        int length3 = this.zzjk == null ? 0 : this.zzjk.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzamb.zzWG();
                            zzamb.zzWC();
                            length3++;
                        }
                        iArr3[length3] = zzamb.zzWG();
                        this.zzjk = iArr3;
                        continue;
                    case 18:
                        int zznW2 = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i2++;
                        }
                        zzamb.zznY(position2);
                        int length4 = this.zzjk == null ? 0 : this.zzjk.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzamb.zzWG();
                            length4++;
                        }
                        this.zzjk = iArr4;
                        zzamb.zznX(zznW2);
                        continue;
                    case 24:
                        int zzc3 = zzamm.zzc(zzamb, 24);
                        int length5 = this.zzjl == null ? 0 : this.zzjl.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzamb.zzWG();
                            zzamb.zzWC();
                            length5++;
                        }
                        iArr5[length5] = zzamb.zzWG();
                        this.zzjl = iArr5;
                        continue;
                    case 26:
                        int zznW3 = zzamb.zznW(zzamb.zzWL());
                        int position3 = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i3++;
                        }
                        zzamb.zznY(position3);
                        int length6 = this.zzjl == null ? 0 : this.zzjl.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzamb.zzWG();
                            length6++;
                        }
                        this.zzjl = iArr6;
                        zzamb.zznX(zznW3);
                        continue;
                    case 32:
                        int zzc4 = zzamm.zzc(zzamb, 32);
                        int length7 = this.zzjm == null ? 0 : this.zzjm.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzjm, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzamb.zzWG();
                            zzamb.zzWC();
                            length7++;
                        }
                        iArr7[length7] = zzamb.zzWG();
                        this.zzjm = iArr7;
                        continue;
                    case 34:
                        int zznW4 = zzamb.zznW(zzamb.zzWL());
                        int position4 = zzamb.getPosition();
                        int i4 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i4++;
                        }
                        zzamb.zznY(position4);
                        int length8 = this.zzjm == null ? 0 : this.zzjm.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjm, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzamb.zzWG();
                            length8++;
                        }
                        this.zzjm = iArr8;
                        zzamb.zznX(zznW4);
                        continue;
                    case 40:
                        int zzc5 = zzamm.zzc(zzamb, 40);
                        int length9 = this.zzjn == null ? 0 : this.zzjn.length;
                        int[] iArr9 = new int[(zzc5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzamb.zzWG();
                            zzamb.zzWC();
                            length9++;
                        }
                        iArr9[length9] = zzamb.zzWG();
                        this.zzjn = iArr9;
                        continue;
                    case 42:
                        int zznW5 = zzamb.zznW(zzamb.zzWL());
                        int position5 = zzamb.getPosition();
                        int i5 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i5++;
                        }
                        zzamb.zznY(position5);
                        int length10 = this.zzjn == null ? 0 : this.zzjn.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzamb.zzWG();
                            length10++;
                        }
                        this.zzjn = iArr10;
                        zzamb.zznX(zznW5);
                        continue;
                    case 48:
                        int zzc6 = zzamm.zzc(zzamb, 48);
                        int length11 = this.zzjo == null ? 0 : this.zzjo.length;
                        int[] iArr11 = new int[(zzc6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zzjo, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzamb.zzWG();
                            zzamb.zzWC();
                            length11++;
                        }
                        iArr11[length11] = zzamb.zzWG();
                        this.zzjo = iArr11;
                        continue;
                    case 50:
                        int zznW6 = zzamb.zznW(zzamb.zzWL());
                        int position6 = zzamb.getPosition();
                        int i6 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i6++;
                        }
                        zzamb.zznY(position6);
                        int length12 = this.zzjo == null ? 0 : this.zzjo.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zzjo, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzamb.zzWG();
                            length12++;
                        }
                        this.zzjo = iArr12;
                        zzamb.zznX(zznW6);
                        continue;
                    case 56:
                        int zzc7 = zzamm.zzc(zzamb, 56);
                        int length13 = this.zzjp == null ? 0 : this.zzjp.length;
                        int[] iArr13 = new int[(zzc7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zzjp, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzamb.zzWG();
                            zzamb.zzWC();
                            length13++;
                        }
                        iArr13[length13] = zzamb.zzWG();
                        this.zzjp = iArr13;
                        continue;
                    case 58:
                        int zznW7 = zzamb.zznW(zzamb.zzWL());
                        int position7 = zzamb.getPosition();
                        int i7 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i7++;
                        }
                        zzamb.zznY(position7);
                        int length14 = this.zzjp == null ? 0 : this.zzjp.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zzjp, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzamb.zzWG();
                            length14++;
                        }
                        this.zzjp = iArr14;
                        zzamb.zznX(zznW7);
                        continue;
                    case 64:
                        int zzc8 = zzamm.zzc(zzamb, 64);
                        int length15 = this.zzjq == null ? 0 : this.zzjq.length;
                        int[] iArr15 = new int[(zzc8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zzjq, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzamb.zzWG();
                            zzamb.zzWC();
                            length15++;
                        }
                        iArr15[length15] = zzamb.zzWG();
                        this.zzjq = iArr15;
                        continue;
                    case 66:
                        int zznW8 = zzamb.zznW(zzamb.zzWL());
                        int position8 = zzamb.getPosition();
                        int i8 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i8++;
                        }
                        zzamb.zznY(position8);
                        int length16 = this.zzjq == null ? 0 : this.zzjq.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zzjq, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzamb.zzWG();
                            length16++;
                        }
                        this.zzjq = iArr16;
                        zzamb.zznX(zznW8);
                        continue;
                    case 72:
                        int zzc9 = zzamm.zzc(zzamb, 72);
                        int length17 = this.zzjr == null ? 0 : this.zzjr.length;
                        int[] iArr17 = new int[(zzc9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zzjr, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzamb.zzWG();
                            zzamb.zzWC();
                            length17++;
                        }
                        iArr17[length17] = zzamb.zzWG();
                        this.zzjr = iArr17;
                        continue;
                    case 74:
                        int zznW9 = zzamb.zznW(zzamb.zzWL());
                        int position9 = zzamb.getPosition();
                        int i9 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i9++;
                        }
                        zzamb.zznY(position9);
                        int length18 = this.zzjr == null ? 0 : this.zzjr.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zzjr, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzamb.zzWG();
                            length18++;
                        }
                        this.zzjr = iArr18;
                        zzamb.zznX(zznW9);
                        continue;
                    case 80:
                        int zzc10 = zzamm.zzc(zzamb, 80);
                        int length19 = this.zzjs == null ? 0 : this.zzjs.length;
                        int[] iArr19 = new int[(zzc10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zzjs, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzamb.zzWG();
                            zzamb.zzWC();
                            length19++;
                        }
                        iArr19[length19] = zzamb.zzWG();
                        this.zzjs = iArr19;
                        continue;
                    case 82:
                        int zznW10 = zzamb.zznW(zzamb.zzWL());
                        int position10 = zzamb.getPosition();
                        int i10 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i10++;
                        }
                        zzamb.zznY(position10);
                        int length20 = this.zzjs == null ? 0 : this.zzjs.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zzjs, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzamb.zzWG();
                            length20++;
                        }
                        this.zzjs = iArr20;
                        zzamb.zznX(zznW10);
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
            int i;
            int zzy = super.zzy();
            if (this.zzjj == null || this.zzjj.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                for (int zzoc : this.zzjj) {
                    i2 += zzamc.zzoc(zzoc);
                }
                i = zzy + i2 + (this.zzjj.length * 1);
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                int i3 = 0;
                for (int zzoc2 : this.zzjk) {
                    i3 += zzamc.zzoc(zzoc2);
                }
                i = i + i3 + (this.zzjk.length * 1);
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                int i4 = 0;
                for (int zzoc3 : this.zzjl) {
                    i4 += zzamc.zzoc(zzoc3);
                }
                i = i + i4 + (this.zzjl.length * 1);
            }
            if (this.zzjm != null && this.zzjm.length > 0) {
                int i5 = 0;
                for (int zzoc4 : this.zzjm) {
                    i5 += zzamc.zzoc(zzoc4);
                }
                i = i + i5 + (this.zzjm.length * 1);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                int i6 = 0;
                for (int zzoc5 : this.zzjn) {
                    i6 += zzamc.zzoc(zzoc5);
                }
                i = i + i6 + (this.zzjn.length * 1);
            }
            if (this.zzjo != null && this.zzjo.length > 0) {
                int i7 = 0;
                for (int zzoc6 : this.zzjo) {
                    i7 += zzamc.zzoc(zzoc6);
                }
                i = i + i7 + (this.zzjo.length * 1);
            }
            if (this.zzjp != null && this.zzjp.length > 0) {
                int i8 = 0;
                for (int zzoc7 : this.zzjp) {
                    i8 += zzamc.zzoc(zzoc7);
                }
                i = i + i8 + (this.zzjp.length * 1);
            }
            if (this.zzjq != null && this.zzjq.length > 0) {
                int i9 = 0;
                for (int zzoc8 : this.zzjq) {
                    i9 += zzamc.zzoc(zzoc8);
                }
                i = i + i9 + (this.zzjq.length * 1);
            }
            if (this.zzjr != null && this.zzjr.length > 0) {
                int i10 = 0;
                for (int zzoc9 : this.zzjr) {
                    i10 += zzamc.zzoc(zzoc9);
                }
                i = i + i10 + (this.zzjr.length * 1);
            }
            if (this.zzjs == null || this.zzjs.length <= 0) {
                return i;
            }
            int i11 = 0;
            for (int zzoc10 : this.zzjs) {
                i11 += zzamc.zzoc(zzoc10);
            }
            return i + i11 + (this.zzjs.length * 1);
        }
    }

    public static final class zzh extends zzamd<zzh> {
        public static final zzame<zzag.zza, zzh> zzjt = zzame.zza(11, zzh.class, 810);
        private static final zzh[] zzju = new zzh[0];
        public int zzjA;
        public int zzjB;
        public int[] zzjv;
        public int[] zzjw;
        public int[] zzjx;
        public int zzjy;
        public int[] zzjz;

        public zzh() {
            zzL();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) obj;
            if (!zzamh.equals(this.zzjv, zzh.zzjv) || !zzamh.equals(this.zzjw, zzh.zzjw) || !zzamh.equals(this.zzjx, zzh.zzjx) || this.zzjy != zzh.zzjy || !zzamh.equals(this.zzjz, zzh.zzjz) || this.zzjA != zzh.zzjA || this.zzjB != zzh.zzjB) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzh.zzcaa == null || zzh.zzcaa.isEmpty() : this.zzcaa.equals(zzh.zzcaa);
        }

        public int hashCode() {
            return ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode()) + ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zzjv)) * 31) + zzamh.hashCode(this.zzjw)) * 31) + zzamh.hashCode(this.zzjx)) * 31) + this.zzjy) * 31) + zzamh.hashCode(this.zzjz)) * 31) + this.zzjA) * 31) + this.zzjB) * 31);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzjv != null && this.zzjv.length > 0) {
                for (int zzE : this.zzjv) {
                    zzamc.zzE(1, zzE);
                }
            }
            if (this.zzjw != null && this.zzjw.length > 0) {
                for (int zzE2 : this.zzjw) {
                    zzamc.zzE(2, zzE2);
                }
            }
            if (this.zzjx != null && this.zzjx.length > 0) {
                for (int zzE3 : this.zzjx) {
                    zzamc.zzE(3, zzE3);
                }
            }
            if (this.zzjy != 0) {
                zzamc.zzE(4, this.zzjy);
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                for (int zzE4 : this.zzjz) {
                    zzamc.zzE(5, zzE4);
                }
            }
            if (this.zzjA != 0) {
                zzamc.zzE(6, this.zzjA);
            }
            if (this.zzjB != 0) {
                zzamc.zzE(7, this.zzjB);
            }
            super.writeTo(zzamc);
        }

        public zzh zzL() {
            this.zzjv = zzamm.zzcal;
            this.zzjw = zzamm.zzcal;
            this.zzjx = zzamm.zzcal;
            this.zzjy = 0;
            this.zzjz = zzamm.zzcal;
            this.zzjA = 0;
            this.zzjB = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzh */
        public zzh mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzamm.zzc(zzamb, 8);
                        int length = this.zzjv == null ? 0 : this.zzjv.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjv, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzamb.zzWG();
                            zzamb.zzWC();
                            length++;
                        }
                        iArr[length] = zzamb.zzWG();
                        this.zzjv = iArr;
                        continue;
                    case 10:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i++;
                        }
                        zzamb.zznY(position);
                        int length2 = this.zzjv == null ? 0 : this.zzjv.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjv, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzamb.zzWG();
                            length2++;
                        }
                        this.zzjv = iArr2;
                        zzamb.zznX(zznW);
                        continue;
                    case 16:
                        int zzc2 = zzamm.zzc(zzamb, 16);
                        int length3 = this.zzjw == null ? 0 : this.zzjw.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjw, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzamb.zzWG();
                            zzamb.zzWC();
                            length3++;
                        }
                        iArr3[length3] = zzamb.zzWG();
                        this.zzjw = iArr3;
                        continue;
                    case 18:
                        int zznW2 = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i2++;
                        }
                        zzamb.zznY(position2);
                        int length4 = this.zzjw == null ? 0 : this.zzjw.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzjw, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzamb.zzWG();
                            length4++;
                        }
                        this.zzjw = iArr4;
                        zzamb.zznX(zznW2);
                        continue;
                    case 24:
                        int zzc3 = zzamm.zzc(zzamb, 24);
                        int length5 = this.zzjx == null ? 0 : this.zzjx.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzjx, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzamb.zzWG();
                            zzamb.zzWC();
                            length5++;
                        }
                        iArr5[length5] = zzamb.zzWG();
                        this.zzjx = iArr5;
                        continue;
                    case 26:
                        int zznW3 = zzamb.zznW(zzamb.zzWL());
                        int position3 = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i3++;
                        }
                        zzamb.zznY(position3);
                        int length6 = this.zzjx == null ? 0 : this.zzjx.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjx, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzamb.zzWG();
                            length6++;
                        }
                        this.zzjx = iArr6;
                        zzamb.zznX(zznW3);
                        continue;
                    case 32:
                        this.zzjy = zzamb.zzWG();
                        continue;
                    case 40:
                        int zzc4 = zzamm.zzc(zzamb, 40);
                        int length7 = this.zzjz == null ? 0 : this.zzjz.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzjz, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzamb.zzWG();
                            zzamb.zzWC();
                            length7++;
                        }
                        iArr7[length7] = zzamb.zzWG();
                        this.zzjz = iArr7;
                        continue;
                    case 42:
                        int zznW4 = zzamb.zznW(zzamb.zzWL());
                        int position4 = zzamb.getPosition();
                        int i4 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i4++;
                        }
                        zzamb.zznY(position4);
                        int length8 = this.zzjz == null ? 0 : this.zzjz.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjz, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzamb.zzWG();
                            length8++;
                        }
                        this.zzjz = iArr8;
                        zzamb.zznX(zznW4);
                        continue;
                    case 48:
                        this.zzjA = zzamb.zzWG();
                        continue;
                    case 56:
                        this.zzjB = zzamb.zzWG();
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
            int i;
            int zzy = super.zzy();
            if (this.zzjv == null || this.zzjv.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                for (int zzoc : this.zzjv) {
                    i2 += zzamc.zzoc(zzoc);
                }
                i = zzy + i2 + (this.zzjv.length * 1);
            }
            if (this.zzjw != null && this.zzjw.length > 0) {
                int i3 = 0;
                for (int zzoc2 : this.zzjw) {
                    i3 += zzamc.zzoc(zzoc2);
                }
                i = i + i3 + (this.zzjw.length * 1);
            }
            if (this.zzjx != null && this.zzjx.length > 0) {
                int i4 = 0;
                for (int zzoc3 : this.zzjx) {
                    i4 += zzamc.zzoc(zzoc3);
                }
                i = i + i4 + (this.zzjx.length * 1);
            }
            if (this.zzjy != 0) {
                i += zzamc.zzG(4, this.zzjy);
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                int i5 = 0;
                for (int zzoc4 : this.zzjz) {
                    i5 += zzamc.zzoc(zzoc4);
                }
                i = i + i5 + (this.zzjz.length * 1);
            }
            if (this.zzjA != 0) {
                i += zzamc.zzG(6, this.zzjA);
            }
            return this.zzjB != 0 ? i + zzamc.zzG(7, this.zzjB) : i;
        }
    }

    public static final class zzi extends zzamd<zzi> {
        private static volatile zzi[] zzjC;
        public String name;
        public zzag.zza zzjD;
        public zzd zzjE;

        public zzi() {
            zzN();
        }

        public static zzi[] zzM() {
            if (zzjC == null) {
                synchronized (zzamh.zzcai) {
                    if (zzjC == null) {
                        zzjC = new zzi[0];
                    }
                }
            }
            return zzjC;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) obj;
            if (this.name == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzi.name)) {
                return false;
            }
            if (this.zzjD == null) {
                if (zzi.zzjD != null) {
                    return false;
                }
            } else if (!this.zzjD.equals(zzi.zzjD)) {
                return false;
            }
            if (this.zzjE == null) {
                if (zzi.zzjE != null) {
                    return false;
                }
            } else if (!this.zzjE.equals(zzi.zzjE)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzi.zzcaa == null || zzi.zzcaa.isEmpty() : this.zzcaa.equals(zzi.zzcaa);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzjE == null ? 0 : this.zzjE.hashCode()) + (((this.zzjD == null ? 0 : this.zzjD.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (!this.name.equals("")) {
                zzamc.zzq(1, this.name);
            }
            if (this.zzjD != null) {
                zzamc.zza(2, (zzamj) this.zzjD);
            }
            if (this.zzjE != null) {
                zzamc.zza(3, (zzamj) this.zzjE);
            }
            super.writeTo(zzamc);
        }

        public zzi zzN() {
            this.name = "";
            this.zzjD = null;
            this.zzjE = null;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzi */
        public zzi mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzamb.readString();
                        continue;
                    case 18:
                        if (this.zzjD == null) {
                            this.zzjD = new zzag.zza();
                        }
                        zzamb.zza(this.zzjD);
                        continue;
                    case 26:
                        if (this.zzjE == null) {
                            this.zzjE = new zzd();
                        }
                        zzamb.zza(this.zzjE);
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
            int zzy = super.zzy();
            if (!this.name.equals("")) {
                zzy += zzamc.zzr(1, this.name);
            }
            if (this.zzjD != null) {
                zzy += zzamc.zzc(2, (zzamj) this.zzjD);
            }
            return this.zzjE != null ? zzy + zzamc.zzc(3, (zzamj) this.zzjE) : zzy;
        }
    }

    public static final class zzj extends zzamd<zzj> {
        public zzi[] zzjF;
        public zzf zzjG;
        public String zzjH;

        public zzj() {
            zzO();
        }

        public static zzj zzd(byte[] bArr) throws zzami {
            return (zzj) zzamj.mergeFrom(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) obj;
            if (!zzamh.equals((Object[]) this.zzjF, (Object[]) zzj.zzjF)) {
                return false;
            }
            if (this.zzjG == null) {
                if (zzj.zzjG != null) {
                    return false;
                }
            } else if (!this.zzjG.equals(zzj.zzjG)) {
                return false;
            }
            if (this.zzjH == null) {
                if (zzj.zzjH != null) {
                    return false;
                }
            } else if (!this.zzjH.equals(zzj.zzjH)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzj.zzcaa == null || zzj.zzcaa.isEmpty() : this.zzcaa.equals(zzj.zzcaa);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzjH == null ? 0 : this.zzjH.hashCode()) + (((this.zzjG == null ? 0 : this.zzjG.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzjF)) * 31)) * 31)) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzjF != null && this.zzjF.length > 0) {
                for (zzi zzi : this.zzjF) {
                    if (zzi != null) {
                        zzamc.zza(1, (zzamj) zzi);
                    }
                }
            }
            if (this.zzjG != null) {
                zzamc.zza(2, (zzamj) this.zzjG);
            }
            if (!this.zzjH.equals("")) {
                zzamc.zzq(3, this.zzjH);
            }
            super.writeTo(zzamc);
        }

        public zzj zzO() {
            this.zzjF = zzi.zzM();
            this.zzjG = null;
            this.zzjH = "";
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzj */
        public zzj mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzamm.zzc(zzamb, 10);
                        int length = this.zzjF == null ? 0 : this.zzjF.length;
                        zzi[] zziArr = new zzi[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjF, 0, zziArr, 0, length);
                        }
                        while (length < zziArr.length - 1) {
                            zziArr[length] = new zzi();
                            zzamb.zza(zziArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zziArr[length] = new zzi();
                        zzamb.zza(zziArr[length]);
                        this.zzjF = zziArr;
                        continue;
                    case 18:
                        if (this.zzjG == null) {
                            this.zzjG = new zzf();
                        }
                        zzamb.zza(this.zzjG);
                        continue;
                    case 26:
                        this.zzjH = zzamb.readString();
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
            int zzy = super.zzy();
            if (this.zzjF != null && this.zzjF.length > 0) {
                for (zzi zzi : this.zzjF) {
                    if (zzi != null) {
                        zzy += zzamc.zzc(1, (zzamj) zzi);
                    }
                }
            }
            if (this.zzjG != null) {
                zzy += zzamc.zzc(2, (zzamj) this.zzjG);
            }
            return !this.zzjH.equals("") ? zzy + zzamc.zzr(3, this.zzjH) : zzy;
        }
    }
}
