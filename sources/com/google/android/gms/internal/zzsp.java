package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;

public interface zzsp {

    public static final class zza extends zzamj {
        private static volatile zza[] zzbgR;
        public zzf zzbgS;
        public zzf zzbgT;
        public Boolean zzbgU;
        public Integer zzbgi;

        public zza() {
            zzHc();
        }

        public static zza[] zzHb() {
            if (zzbgR == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgR == null) {
                        zzbgR = new zza[0];
                    }
                }
            }
            return zzbgR;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.zzbgi == null) {
                if (zza.zzbgi != null) {
                    return false;
                }
            } else if (!this.zzbgi.equals(zza.zzbgi)) {
                return false;
            }
            if (this.zzbgS == null) {
                if (zza.zzbgS != null) {
                    return false;
                }
            } else if (!this.zzbgS.equals(zza.zzbgS)) {
                return false;
            }
            if (this.zzbgT == null) {
                if (zza.zzbgT != null) {
                    return false;
                }
            } else if (!this.zzbgT.equals(zza.zzbgT)) {
                return false;
            }
            return this.zzbgU == null ? zza.zzbgU == null : this.zzbgU.equals(zza.zzbgU);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbgT == null ? 0 : this.zzbgT.hashCode()) + (((this.zzbgS == null ? 0 : this.zzbgS.hashCode()) + (((this.zzbgi == null ? 0 : this.zzbgi.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.zzbgU != null) {
                i = this.zzbgU.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbgi != null) {
                zzamc.zzE(1, this.zzbgi.intValue());
            }
            if (this.zzbgS != null) {
                zzamc.zza(2, (zzamj) this.zzbgS);
            }
            if (this.zzbgT != null) {
                zzamc.zza(3, (zzamj) this.zzbgT);
            }
            if (this.zzbgU != null) {
                zzamc.zzj(4, this.zzbgU.booleanValue());
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzC */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        this.zzbgi = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 18:
                        if (this.zzbgS == null) {
                            this.zzbgS = new zzf();
                        }
                        zzamb.zza(this.zzbgS);
                        continue;
                    case 26:
                        if (this.zzbgT == null) {
                            this.zzbgT = new zzf();
                        }
                        zzamb.zza(this.zzbgT);
                        continue;
                    case 32:
                        this.zzbgU = Boolean.valueOf(zzamb.zzWI());
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

        public zza zzHc() {
            this.zzbgi = null;
            this.zzbgS = null;
            this.zzbgT = null;
            this.zzbgU = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzbgi != null) {
                zzy += zzamc.zzG(1, this.zzbgi.intValue());
            }
            if (this.zzbgS != null) {
                zzy += zzamc.zzc(2, (zzamj) this.zzbgS);
            }
            if (this.zzbgT != null) {
                zzy += zzamc.zzc(3, (zzamj) this.zzbgT);
            }
            return this.zzbgU != null ? zzy + zzamc.zzk(4, this.zzbgU.booleanValue()) : zzy;
        }
    }

    public static final class zzb extends zzamj {
        private static volatile zzb[] zzbgV;
        public Integer count;
        public String name;
        public zzc[] zzbgW;
        public Long zzbgX;
        public Long zzbgY;

        public zzb() {
            zzHe();
        }

        public static zzb[] zzHd() {
            if (zzbgV == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgV == null) {
                        zzbgV = new zzb[0];
                    }
                }
            }
            return zzbgV;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!zzamh.equals((Object[]) this.zzbgW, (Object[]) zzb.zzbgW)) {
                return false;
            }
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.zzbgX == null) {
                if (zzb.zzbgX != null) {
                    return false;
                }
            } else if (!this.zzbgX.equals(zzb.zzbgX)) {
                return false;
            }
            if (this.zzbgY == null) {
                if (zzb.zzbgY != null) {
                    return false;
                }
            } else if (!this.zzbgY.equals(zzb.zzbgY)) {
                return false;
            }
            return this.count == null ? zzb.count == null : this.count.equals(zzb.count);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbgY == null ? 0 : this.zzbgY.hashCode()) + (((this.zzbgX == null ? 0 : this.zzbgX.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzbgW)) * 31)) * 31)) * 31)) * 31;
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbgW != null && this.zzbgW.length > 0) {
                for (zzc zzc : this.zzbgW) {
                    if (zzc != null) {
                        zzamc.zza(1, (zzamj) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzamc.zzq(2, this.name);
            }
            if (this.zzbgX != null) {
                zzamc.zzb(3, this.zzbgX.longValue());
            }
            if (this.zzbgY != null) {
                zzamc.zzb(4, this.zzbgY.longValue());
            }
            if (this.count != null) {
                zzamc.zzE(5, this.count.intValue());
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzD */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzamm.zzc(zzamb, 10);
                        int length = this.zzbgW == null ? 0 : this.zzbgW.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbgW, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzamb.zza(zzcArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzamb.zza(zzcArr[length]);
                        this.zzbgW = zzcArr;
                        continue;
                    case 18:
                        this.name = zzamb.readString();
                        continue;
                    case 24:
                        this.zzbgX = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 32:
                        this.zzbgY = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 40:
                        this.count = Integer.valueOf(zzamb.zzWG());
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

        public zzb zzHe() {
            this.zzbgW = zzc.zzHf();
            this.name = null;
            this.zzbgX = null;
            this.zzbgY = null;
            this.count = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzbgW != null && this.zzbgW.length > 0) {
                for (zzc zzc : this.zzbgW) {
                    if (zzc != null) {
                        zzy += zzamc.zzc(1, (zzamj) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzy += zzamc.zzr(2, this.name);
            }
            if (this.zzbgX != null) {
                zzy += zzamc.zze(3, this.zzbgX.longValue());
            }
            if (this.zzbgY != null) {
                zzy += zzamc.zze(4, this.zzbgY.longValue());
            }
            return this.count != null ? zzy + zzamc.zzG(5, this.count.intValue()) : zzy;
        }
    }

    public static final class zzc extends zzamj {
        private static volatile zzc[] zzbgZ;
        public String name;
        public String zzasH;
        public Float zzbge;
        public Double zzbgf;
        public Long zzbha;

        public zzc() {
            zzHg();
        }

        public static zzc[] zzHf() {
            if (zzbgZ == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgZ == null) {
                        zzbgZ = new zzc[0];
                    }
                }
            }
            return zzbgZ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.name == null) {
                if (zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzc.name)) {
                return false;
            }
            if (this.zzasH == null) {
                if (zzc.zzasH != null) {
                    return false;
                }
            } else if (!this.zzasH.equals(zzc.zzasH)) {
                return false;
            }
            if (this.zzbha == null) {
                if (zzc.zzbha != null) {
                    return false;
                }
            } else if (!this.zzbha.equals(zzc.zzbha)) {
                return false;
            }
            if (this.zzbge == null) {
                if (zzc.zzbge != null) {
                    return false;
                }
            } else if (!this.zzbge.equals(zzc.zzbge)) {
                return false;
            }
            return this.zzbgf == null ? zzc.zzbgf == null : this.zzbgf.equals(zzc.zzbgf);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbge == null ? 0 : this.zzbge.hashCode()) + (((this.zzbha == null ? 0 : this.zzbha.hashCode()) + (((this.zzasH == null ? 0 : this.zzasH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzbgf != null) {
                i = this.zzbgf.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.name != null) {
                zzamc.zzq(1, this.name);
            }
            if (this.zzasH != null) {
                zzamc.zzq(2, this.zzasH);
            }
            if (this.zzbha != null) {
                zzamc.zzb(3, this.zzbha.longValue());
            }
            if (this.zzbge != null) {
                zzamc.zzb(4, this.zzbge.floatValue());
            }
            if (this.zzbgf != null) {
                zzamc.zza(5, this.zzbgf.doubleValue());
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzE */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzamb.readString();
                        continue;
                    case 18:
                        this.zzasH = zzamb.readString();
                        continue;
                    case 24:
                        this.zzbha = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 37:
                        this.zzbge = Float.valueOf(zzamb.readFloat());
                        continue;
                    case 41:
                        this.zzbgf = Double.valueOf(zzamb.readDouble());
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

        public zzc zzHg() {
            this.name = null;
            this.zzasH = null;
            this.zzbha = null;
            this.zzbge = null;
            this.zzbgf = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.name != null) {
                zzy += zzamc.zzr(1, this.name);
            }
            if (this.zzasH != null) {
                zzy += zzamc.zzr(2, this.zzasH);
            }
            if (this.zzbha != null) {
                zzy += zzamc.zze(3, this.zzbha.longValue());
            }
            if (this.zzbge != null) {
                zzy += zzamc.zzc(4, this.zzbge.floatValue());
            }
            return this.zzbgf != null ? zzy + zzamc.zzb(5, this.zzbgf.doubleValue()) : zzy;
        }
    }

    public static final class zzd extends zzamj {
        public zze[] zzbhb;

        public zzd() {
            zzHh();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            return zzamh.equals((Object[]) this.zzbhb, (Object[]) ((zzd) obj).zzbhb);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzbhb);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbhb != null && this.zzbhb.length > 0) {
                for (zze zze : this.zzbhb) {
                    if (zze != null) {
                        zzamc.zza(1, (zzamj) zze);
                    }
                }
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzF */
        public zzd mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzamm.zzc(zzamb, 10);
                        int length = this.zzbhb == null ? 0 : this.zzbhb.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbhb, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzamb.zza(zzeArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzamb.zza(zzeArr[length]);
                        this.zzbhb = zzeArr;
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

        public zzd zzHh() {
            this.zzbhb = zze.zzHi();
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzbhb != null && this.zzbhb.length > 0) {
                for (zze zze : this.zzbhb) {
                    if (zze != null) {
                        zzy += zzamc.zzc(1, (zzamj) zze);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzamj {
        private static volatile zze[] zzbhc;
        public String appId;
        public String osVersion;
        public String zzaUf;
        public String zzbbK;
        public String zzbbL;
        public String zzbbO;
        public String zzbbS;
        public Integer zzbhA;
        public String zzbhB;
        public Integer zzbhd;
        public zzb[] zzbhe;
        public zzg[] zzbhf;
        public Long zzbhg;
        public Long zzbhh;
        public Long zzbhi;
        public Long zzbhj;
        public Long zzbhk;
        public String zzbhl;
        public String zzbhm;
        public String zzbhn;
        public Integer zzbho;
        public Long zzbhp;
        public Long zzbhq;
        public String zzbhr;
        public Boolean zzbhs;
        public String zzbht;
        public Long zzbhu;
        public Integer zzbhv;
        public Boolean zzbhw;
        public zza[] zzbhx;
        public Integer zzbhy;
        public Integer zzbhz;

        public zze() {
            zzHj();
        }

        public static zze[] zzHi() {
            if (zzbhc == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbhc == null) {
                        zzbhc = new zze[0];
                    }
                }
            }
            return zzbhc;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.zzbhd == null) {
                if (zze.zzbhd != null) {
                    return false;
                }
            } else if (!this.zzbhd.equals(zze.zzbhd)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbhe, (Object[]) zze.zzbhe)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbhf, (Object[]) zze.zzbhf)) {
                return false;
            }
            if (this.zzbhg == null) {
                if (zze.zzbhg != null) {
                    return false;
                }
            } else if (!this.zzbhg.equals(zze.zzbhg)) {
                return false;
            }
            if (this.zzbhh == null) {
                if (zze.zzbhh != null) {
                    return false;
                }
            } else if (!this.zzbhh.equals(zze.zzbhh)) {
                return false;
            }
            if (this.zzbhi == null) {
                if (zze.zzbhi != null) {
                    return false;
                }
            } else if (!this.zzbhi.equals(zze.zzbhi)) {
                return false;
            }
            if (this.zzbhj == null) {
                if (zze.zzbhj != null) {
                    return false;
                }
            } else if (!this.zzbhj.equals(zze.zzbhj)) {
                return false;
            }
            if (this.zzbhk == null) {
                if (zze.zzbhk != null) {
                    return false;
                }
            } else if (!this.zzbhk.equals(zze.zzbhk)) {
                return false;
            }
            if (this.zzbhl == null) {
                if (zze.zzbhl != null) {
                    return false;
                }
            } else if (!this.zzbhl.equals(zze.zzbhl)) {
                return false;
            }
            if (this.osVersion == null) {
                if (zze.osVersion != null) {
                    return false;
                }
            } else if (!this.osVersion.equals(zze.osVersion)) {
                return false;
            }
            if (this.zzbhm == null) {
                if (zze.zzbhm != null) {
                    return false;
                }
            } else if (!this.zzbhm.equals(zze.zzbhm)) {
                return false;
            }
            if (this.zzbhn == null) {
                if (zze.zzbhn != null) {
                    return false;
                }
            } else if (!this.zzbhn.equals(zze.zzbhn)) {
                return false;
            }
            if (this.zzbho == null) {
                if (zze.zzbho != null) {
                    return false;
                }
            } else if (!this.zzbho.equals(zze.zzbho)) {
                return false;
            }
            if (this.zzbbL == null) {
                if (zze.zzbbL != null) {
                    return false;
                }
            } else if (!this.zzbbL.equals(zze.zzbbL)) {
                return false;
            }
            if (this.appId == null) {
                if (zze.appId != null) {
                    return false;
                }
            } else if (!this.appId.equals(zze.appId)) {
                return false;
            }
            if (this.zzaUf == null) {
                if (zze.zzaUf != null) {
                    return false;
                }
            } else if (!this.zzaUf.equals(zze.zzaUf)) {
                return false;
            }
            if (this.zzbhp == null) {
                if (zze.zzbhp != null) {
                    return false;
                }
            } else if (!this.zzbhp.equals(zze.zzbhp)) {
                return false;
            }
            if (this.zzbhq == null) {
                if (zze.zzbhq != null) {
                    return false;
                }
            } else if (!this.zzbhq.equals(zze.zzbhq)) {
                return false;
            }
            if (this.zzbhr == null) {
                if (zze.zzbhr != null) {
                    return false;
                }
            } else if (!this.zzbhr.equals(zze.zzbhr)) {
                return false;
            }
            if (this.zzbhs == null) {
                if (zze.zzbhs != null) {
                    return false;
                }
            } else if (!this.zzbhs.equals(zze.zzbhs)) {
                return false;
            }
            if (this.zzbht == null) {
                if (zze.zzbht != null) {
                    return false;
                }
            } else if (!this.zzbht.equals(zze.zzbht)) {
                return false;
            }
            if (this.zzbhu == null) {
                if (zze.zzbhu != null) {
                    return false;
                }
            } else if (!this.zzbhu.equals(zze.zzbhu)) {
                return false;
            }
            if (this.zzbhv == null) {
                if (zze.zzbhv != null) {
                    return false;
                }
            } else if (!this.zzbhv.equals(zze.zzbhv)) {
                return false;
            }
            if (this.zzbbO == null) {
                if (zze.zzbbO != null) {
                    return false;
                }
            } else if (!this.zzbbO.equals(zze.zzbbO)) {
                return false;
            }
            if (this.zzbbK == null) {
                if (zze.zzbbK != null) {
                    return false;
                }
            } else if (!this.zzbbK.equals(zze.zzbbK)) {
                return false;
            }
            if (this.zzbhw == null) {
                if (zze.zzbhw != null) {
                    return false;
                }
            } else if (!this.zzbhw.equals(zze.zzbhw)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbhx, (Object[]) zze.zzbhx)) {
                return false;
            }
            if (this.zzbbS == null) {
                if (zze.zzbbS != null) {
                    return false;
                }
            } else if (!this.zzbbS.equals(zze.zzbbS)) {
                return false;
            }
            if (this.zzbhy == null) {
                if (zze.zzbhy != null) {
                    return false;
                }
            } else if (!this.zzbhy.equals(zze.zzbhy)) {
                return false;
            }
            if (this.zzbhz == null) {
                if (zze.zzbhz != null) {
                    return false;
                }
            } else if (!this.zzbhz.equals(zze.zzbhz)) {
                return false;
            }
            if (this.zzbhA == null) {
                if (zze.zzbhA != null) {
                    return false;
                }
            } else if (!this.zzbhA.equals(zze.zzbhA)) {
                return false;
            }
            return this.zzbhB == null ? zze.zzbhB == null : this.zzbhB.equals(zze.zzbhB);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbhA == null ? 0 : this.zzbhA.hashCode()) + (((this.zzbhz == null ? 0 : this.zzbhz.hashCode()) + (((this.zzbhy == null ? 0 : this.zzbhy.hashCode()) + (((this.zzbbS == null ? 0 : this.zzbbS.hashCode()) + (((((this.zzbhw == null ? 0 : this.zzbhw.hashCode()) + (((this.zzbbK == null ? 0 : this.zzbbK.hashCode()) + (((this.zzbbO == null ? 0 : this.zzbbO.hashCode()) + (((this.zzbhv == null ? 0 : this.zzbhv.hashCode()) + (((this.zzbhu == null ? 0 : this.zzbhu.hashCode()) + (((this.zzbht == null ? 0 : this.zzbht.hashCode()) + (((this.zzbhs == null ? 0 : this.zzbhs.hashCode()) + (((this.zzbhr == null ? 0 : this.zzbhr.hashCode()) + (((this.zzbhq == null ? 0 : this.zzbhq.hashCode()) + (((this.zzbhp == null ? 0 : this.zzbhp.hashCode()) + (((this.zzaUf == null ? 0 : this.zzaUf.hashCode()) + (((this.appId == null ? 0 : this.appId.hashCode()) + (((this.zzbbL == null ? 0 : this.zzbbL.hashCode()) + (((this.zzbho == null ? 0 : this.zzbho.hashCode()) + (((this.zzbhn == null ? 0 : this.zzbhn.hashCode()) + (((this.zzbhm == null ? 0 : this.zzbhm.hashCode()) + (((this.osVersion == null ? 0 : this.osVersion.hashCode()) + (((this.zzbhl == null ? 0 : this.zzbhl.hashCode()) + (((this.zzbhk == null ? 0 : this.zzbhk.hashCode()) + (((this.zzbhj == null ? 0 : this.zzbhj.hashCode()) + (((this.zzbhi == null ? 0 : this.zzbhi.hashCode()) + (((this.zzbhh == null ? 0 : this.zzbhh.hashCode()) + (((this.zzbhg == null ? 0 : this.zzbhg.hashCode()) + (((((((this.zzbhd == null ? 0 : this.zzbhd.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzamh.hashCode((Object[]) this.zzbhe)) * 31) + zzamh.hashCode((Object[]) this.zzbhf)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzamh.hashCode((Object[]) this.zzbhx)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzbhB != null) {
                i = this.zzbhB.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbhd != null) {
                zzamc.zzE(1, this.zzbhd.intValue());
            }
            if (this.zzbhe != null && this.zzbhe.length > 0) {
                for (zzb zzb : this.zzbhe) {
                    if (zzb != null) {
                        zzamc.zza(2, (zzamj) zzb);
                    }
                }
            }
            if (this.zzbhf != null && this.zzbhf.length > 0) {
                for (zzg zzg : this.zzbhf) {
                    if (zzg != null) {
                        zzamc.zza(3, (zzamj) zzg);
                    }
                }
            }
            if (this.zzbhg != null) {
                zzamc.zzb(4, this.zzbhg.longValue());
            }
            if (this.zzbhh != null) {
                zzamc.zzb(5, this.zzbhh.longValue());
            }
            if (this.zzbhi != null) {
                zzamc.zzb(6, this.zzbhi.longValue());
            }
            if (this.zzbhk != null) {
                zzamc.zzb(7, this.zzbhk.longValue());
            }
            if (this.zzbhl != null) {
                zzamc.zzq(8, this.zzbhl);
            }
            if (this.osVersion != null) {
                zzamc.zzq(9, this.osVersion);
            }
            if (this.zzbhm != null) {
                zzamc.zzq(10, this.zzbhm);
            }
            if (this.zzbhn != null) {
                zzamc.zzq(11, this.zzbhn);
            }
            if (this.zzbho != null) {
                zzamc.zzE(12, this.zzbho.intValue());
            }
            if (this.zzbbL != null) {
                zzamc.zzq(13, this.zzbbL);
            }
            if (this.appId != null) {
                zzamc.zzq(14, this.appId);
            }
            if (this.zzaUf != null) {
                zzamc.zzq(16, this.zzaUf);
            }
            if (this.zzbhp != null) {
                zzamc.zzb(17, this.zzbhp.longValue());
            }
            if (this.zzbhq != null) {
                zzamc.zzb(18, this.zzbhq.longValue());
            }
            if (this.zzbhr != null) {
                zzamc.zzq(19, this.zzbhr);
            }
            if (this.zzbhs != null) {
                zzamc.zzj(20, this.zzbhs.booleanValue());
            }
            if (this.zzbht != null) {
                zzamc.zzq(21, this.zzbht);
            }
            if (this.zzbhu != null) {
                zzamc.zzb(22, this.zzbhu.longValue());
            }
            if (this.zzbhv != null) {
                zzamc.zzE(23, this.zzbhv.intValue());
            }
            if (this.zzbbO != null) {
                zzamc.zzq(24, this.zzbbO);
            }
            if (this.zzbbK != null) {
                zzamc.zzq(25, this.zzbbK);
            }
            if (this.zzbhj != null) {
                zzamc.zzb(26, this.zzbhj.longValue());
            }
            if (this.zzbhw != null) {
                zzamc.zzj(28, this.zzbhw.booleanValue());
            }
            if (this.zzbhx != null && this.zzbhx.length > 0) {
                for (zza zza : this.zzbhx) {
                    if (zza != null) {
                        zzamc.zza(29, (zzamj) zza);
                    }
                }
            }
            if (this.zzbbS != null) {
                zzamc.zzq(30, this.zzbbS);
            }
            if (this.zzbhy != null) {
                zzamc.zzE(31, this.zzbhy.intValue());
            }
            if (this.zzbhz != null) {
                zzamc.zzE(32, this.zzbhz.intValue());
            }
            if (this.zzbhA != null) {
                zzamc.zzE(33, this.zzbhA.intValue());
            }
            if (this.zzbhB != null) {
                zzamc.zzq(34, this.zzbhB);
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzG */
        public zze mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        this.zzbhd = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 18:
                        int zzc = zzamm.zzc(zzamb, 18);
                        int length = this.zzbhe == null ? 0 : this.zzbhe.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbhe, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzamb.zza(zzbArr[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzamb.zza(zzbArr[length]);
                        this.zzbhe = zzbArr;
                        continue;
                    case 26:
                        int zzc2 = zzamm.zzc(zzamb, 26);
                        int length2 = this.zzbhf == null ? 0 : this.zzbhf.length;
                        zzg[] zzgArr = new zzg[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbhf, 0, zzgArr, 0, length2);
                        }
                        while (length2 < zzgArr.length - 1) {
                            zzgArr[length2] = new zzg();
                            zzamb.zza(zzgArr[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzgArr[length2] = new zzg();
                        zzamb.zza(zzgArr[length2]);
                        this.zzbhf = zzgArr;
                        continue;
                    case 32:
                        this.zzbhg = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 40:
                        this.zzbhh = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 48:
                        this.zzbhi = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 56:
                        this.zzbhk = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 66:
                        this.zzbhl = zzamb.readString();
                        continue;
                    case 74:
                        this.osVersion = zzamb.readString();
                        continue;
                    case 82:
                        this.zzbhm = zzamb.readString();
                        continue;
                    case 90:
                        this.zzbhn = zzamb.readString();
                        continue;
                    case 96:
                        this.zzbho = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 106:
                        this.zzbbL = zzamb.readString();
                        continue;
                    case 114:
                        this.appId = zzamb.readString();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        this.zzaUf = zzamb.readString();
                        continue;
                    case 136:
                        this.zzbhp = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 144:
                        this.zzbhq = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 154:
                        this.zzbhr = zzamb.readString();
                        continue;
                    case 160:
                        this.zzbhs = Boolean.valueOf(zzamb.zzWI());
                        continue;
                    case 170:
                        this.zzbht = zzamb.readString();
                        continue;
                    case 176:
                        this.zzbhu = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 184:
                        this.zzbhv = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 194:
                        this.zzbbO = zzamb.readString();
                        continue;
                    case 202:
                        this.zzbbK = zzamb.readString();
                        continue;
                    case 208:
                        this.zzbhj = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 224:
                        this.zzbhw = Boolean.valueOf(zzamb.zzWI());
                        continue;
                    case 234:
                        int zzc3 = zzamm.zzc(zzamb, 234);
                        int length3 = this.zzbhx == null ? 0 : this.zzbhx.length;
                        zza[] zzaArr = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbhx, 0, zzaArr, 0, length3);
                        }
                        while (length3 < zzaArr.length - 1) {
                            zzaArr[length3] = new zza();
                            zzamb.zza(zzaArr[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzaArr[length3] = new zza();
                        zzamb.zza(zzaArr[length3]);
                        this.zzbhx = zzaArr;
                        continue;
                    case 242:
                        this.zzbbS = zzamb.readString();
                        continue;
                    case 248:
                        this.zzbhy = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 256:
                        this.zzbhz = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 264:
                        this.zzbhA = Integer.valueOf(zzamb.zzWG());
                        continue;
                    case 274:
                        this.zzbhB = zzamb.readString();
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

        public zze zzHj() {
            this.zzbhd = null;
            this.zzbhe = zzb.zzHd();
            this.zzbhf = zzg.zzHl();
            this.zzbhg = null;
            this.zzbhh = null;
            this.zzbhi = null;
            this.zzbhj = null;
            this.zzbhk = null;
            this.zzbhl = null;
            this.osVersion = null;
            this.zzbhm = null;
            this.zzbhn = null;
            this.zzbho = null;
            this.zzbbL = null;
            this.appId = null;
            this.zzaUf = null;
            this.zzbhp = null;
            this.zzbhq = null;
            this.zzbhr = null;
            this.zzbhs = null;
            this.zzbht = null;
            this.zzbhu = null;
            this.zzbhv = null;
            this.zzbbO = null;
            this.zzbbK = null;
            this.zzbhw = null;
            this.zzbhx = zza.zzHb();
            this.zzbbS = null;
            this.zzbhy = null;
            this.zzbhz = null;
            this.zzbhA = null;
            this.zzbhB = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzbhd != null) {
                zzy += zzamc.zzG(1, this.zzbhd.intValue());
            }
            if (this.zzbhe != null && this.zzbhe.length > 0) {
                int i = zzy;
                for (zzb zzb : this.zzbhe) {
                    if (zzb != null) {
                        i += zzamc.zzc(2, (zzamj) zzb);
                    }
                }
                zzy = i;
            }
            if (this.zzbhf != null && this.zzbhf.length > 0) {
                int i2 = zzy;
                for (zzg zzg : this.zzbhf) {
                    if (zzg != null) {
                        i2 += zzamc.zzc(3, (zzamj) zzg);
                    }
                }
                zzy = i2;
            }
            if (this.zzbhg != null) {
                zzy += zzamc.zze(4, this.zzbhg.longValue());
            }
            if (this.zzbhh != null) {
                zzy += zzamc.zze(5, this.zzbhh.longValue());
            }
            if (this.zzbhi != null) {
                zzy += zzamc.zze(6, this.zzbhi.longValue());
            }
            if (this.zzbhk != null) {
                zzy += zzamc.zze(7, this.zzbhk.longValue());
            }
            if (this.zzbhl != null) {
                zzy += zzamc.zzr(8, this.zzbhl);
            }
            if (this.osVersion != null) {
                zzy += zzamc.zzr(9, this.osVersion);
            }
            if (this.zzbhm != null) {
                zzy += zzamc.zzr(10, this.zzbhm);
            }
            if (this.zzbhn != null) {
                zzy += zzamc.zzr(11, this.zzbhn);
            }
            if (this.zzbho != null) {
                zzy += zzamc.zzG(12, this.zzbho.intValue());
            }
            if (this.zzbbL != null) {
                zzy += zzamc.zzr(13, this.zzbbL);
            }
            if (this.appId != null) {
                zzy += zzamc.zzr(14, this.appId);
            }
            if (this.zzaUf != null) {
                zzy += zzamc.zzr(16, this.zzaUf);
            }
            if (this.zzbhp != null) {
                zzy += zzamc.zze(17, this.zzbhp.longValue());
            }
            if (this.zzbhq != null) {
                zzy += zzamc.zze(18, this.zzbhq.longValue());
            }
            if (this.zzbhr != null) {
                zzy += zzamc.zzr(19, this.zzbhr);
            }
            if (this.zzbhs != null) {
                zzy += zzamc.zzk(20, this.zzbhs.booleanValue());
            }
            if (this.zzbht != null) {
                zzy += zzamc.zzr(21, this.zzbht);
            }
            if (this.zzbhu != null) {
                zzy += zzamc.zze(22, this.zzbhu.longValue());
            }
            if (this.zzbhv != null) {
                zzy += zzamc.zzG(23, this.zzbhv.intValue());
            }
            if (this.zzbbO != null) {
                zzy += zzamc.zzr(24, this.zzbbO);
            }
            if (this.zzbbK != null) {
                zzy += zzamc.zzr(25, this.zzbbK);
            }
            if (this.zzbhj != null) {
                zzy += zzamc.zze(26, this.zzbhj.longValue());
            }
            if (this.zzbhw != null) {
                zzy += zzamc.zzk(28, this.zzbhw.booleanValue());
            }
            if (this.zzbhx != null && this.zzbhx.length > 0) {
                for (zza zza : this.zzbhx) {
                    if (zza != null) {
                        zzy += zzamc.zzc(29, (zzamj) zza);
                    }
                }
            }
            if (this.zzbbS != null) {
                zzy += zzamc.zzr(30, this.zzbbS);
            }
            if (this.zzbhy != null) {
                zzy += zzamc.zzG(31, this.zzbhy.intValue());
            }
            if (this.zzbhz != null) {
                zzy += zzamc.zzG(32, this.zzbhz.intValue());
            }
            if (this.zzbhA != null) {
                zzy += zzamc.zzG(33, this.zzbhA.intValue());
            }
            return this.zzbhB != null ? zzy + zzamc.zzr(34, this.zzbhB) : zzy;
        }
    }

    public static final class zzf extends zzamj {
        public long[] zzbhC;
        public long[] zzbhD;

        public zzf() {
            zzHk();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzamh.equals(this.zzbhC, zzf.zzbhC)) {
                return false;
            }
            return zzamh.equals(this.zzbhD, zzf.zzbhD);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zzbhC)) * 31) + zzamh.hashCode(this.zzbhD);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbhC != null && this.zzbhC.length > 0) {
                for (long zza : this.zzbhC) {
                    zzamc.zza(1, zza);
                }
            }
            if (this.zzbhD != null && this.zzbhD.length > 0) {
                for (long zza2 : this.zzbhD) {
                    zzamc.zza(2, zza2);
                }
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzH */
        public zzf mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzamm.zzc(zzamb, 8);
                        int length = this.zzbhC == null ? 0 : this.zzbhC.length;
                        long[] jArr = new long[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbhC, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzamb.zzWE();
                            zzamb.zzWC();
                            length++;
                        }
                        jArr[length] = zzamb.zzWE();
                        this.zzbhC = jArr;
                        continue;
                    case 10:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWE();
                            i++;
                        }
                        zzamb.zznY(position);
                        int length2 = this.zzbhC == null ? 0 : this.zzbhC.length;
                        long[] jArr2 = new long[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbhC, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzamb.zzWE();
                            length2++;
                        }
                        this.zzbhC = jArr2;
                        zzamb.zznX(zznW);
                        continue;
                    case 16:
                        int zzc2 = zzamm.zzc(zzamb, 16);
                        int length3 = this.zzbhD == null ? 0 : this.zzbhD.length;
                        long[] jArr3 = new long[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbhD, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzamb.zzWE();
                            zzamb.zzWC();
                            length3++;
                        }
                        jArr3[length3] = zzamb.zzWE();
                        this.zzbhD = jArr3;
                        continue;
                    case 18:
                        int zznW2 = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWE();
                            i2++;
                        }
                        zzamb.zznY(position2);
                        int length4 = this.zzbhD == null ? 0 : this.zzbhD.length;
                        long[] jArr4 = new long[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbhD, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzamb.zzWE();
                            length4++;
                        }
                        this.zzbhD = jArr4;
                        zzamb.zznX(zznW2);
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

        public zzf zzHk() {
            this.zzbhC = zzamm.zzcam;
            this.zzbhD = zzamm.zzcam;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int i;
            int zzy = super.zzy();
            if (this.zzbhC == null || this.zzbhC.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                for (long zzaT : this.zzbhC) {
                    i2 += zzamc.zzaT(zzaT);
                }
                i = zzy + i2 + (this.zzbhC.length * 1);
            }
            if (this.zzbhD == null || this.zzbhD.length <= 0) {
                return i;
            }
            int i3 = 0;
            for (long zzaT2 : this.zzbhD) {
                i3 += zzamc.zzaT(zzaT2);
            }
            return i + i3 + (this.zzbhD.length * 1);
        }
    }

    public static final class zzg extends zzamj {
        private static volatile zzg[] zzbhE;
        public String name;
        public String zzasH;
        public Float zzbge;
        public Double zzbgf;
        public Long zzbhF;
        public Long zzbha;

        public zzg() {
            zzHm();
        }

        public static zzg[] zzHl() {
            if (zzbhE == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbhE == null) {
                        zzbhE = new zzg[0];
                    }
                }
            }
            return zzbhE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (this.zzbhF == null) {
                if (zzg.zzbhF != null) {
                    return false;
                }
            } else if (!this.zzbhF.equals(zzg.zzbhF)) {
                return false;
            }
            if (this.name == null) {
                if (zzg.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzg.name)) {
                return false;
            }
            if (this.zzasH == null) {
                if (zzg.zzasH != null) {
                    return false;
                }
            } else if (!this.zzasH.equals(zzg.zzasH)) {
                return false;
            }
            if (this.zzbha == null) {
                if (zzg.zzbha != null) {
                    return false;
                }
            } else if (!this.zzbha.equals(zzg.zzbha)) {
                return false;
            }
            if (this.zzbge == null) {
                if (zzg.zzbge != null) {
                    return false;
                }
            } else if (!this.zzbge.equals(zzg.zzbge)) {
                return false;
            }
            return this.zzbgf == null ? zzg.zzbgf == null : this.zzbgf.equals(zzg.zzbgf);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbge == null ? 0 : this.zzbge.hashCode()) + (((this.zzbha == null ? 0 : this.zzbha.hashCode()) + (((this.zzasH == null ? 0 : this.zzasH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzbhF == null ? 0 : this.zzbhF.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzbgf != null) {
                i = this.zzbgf.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (this.zzbhF != null) {
                zzamc.zzb(1, this.zzbhF.longValue());
            }
            if (this.name != null) {
                zzamc.zzq(2, this.name);
            }
            if (this.zzasH != null) {
                zzamc.zzq(3, this.zzasH);
            }
            if (this.zzbha != null) {
                zzamc.zzb(4, this.zzbha.longValue());
            }
            if (this.zzbge != null) {
                zzamc.zzb(5, this.zzbge.floatValue());
            }
            if (this.zzbgf != null) {
                zzamc.zza(6, this.zzbgf.doubleValue());
            }
            super.writeTo(zzamc);
        }

        public zzg zzHm() {
            this.zzbhF = null;
            this.name = null;
            this.zzasH = null;
            this.zzbha = null;
            this.zzbge = null;
            this.zzbgf = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzI */
        public zzg mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        break;
                    case 8:
                        this.zzbhF = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 18:
                        this.name = zzamb.readString();
                        continue;
                    case 26:
                        this.zzasH = zzamb.readString();
                        continue;
                    case 32:
                        this.zzbha = Long.valueOf(zzamb.zzWF());
                        continue;
                    case 45:
                        this.zzbge = Float.valueOf(zzamb.readFloat());
                        continue;
                    case 49:
                        this.zzbgf = Double.valueOf(zzamb.readDouble());
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

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzbhF != null) {
                zzy += zzamc.zze(1, this.zzbhF.longValue());
            }
            if (this.name != null) {
                zzy += zzamc.zzr(2, this.name);
            }
            if (this.zzasH != null) {
                zzy += zzamc.zzr(3, this.zzasH);
            }
            if (this.zzbha != null) {
                zzy += zzamc.zze(4, this.zzbha.longValue());
            }
            if (this.zzbge != null) {
                zzy += zzamc.zzc(5, this.zzbge.floatValue());
            }
            return this.zzbgf != null ? zzy + zzamc.zzb(6, this.zzbgf.doubleValue()) : zzy;
        }
    }
}
