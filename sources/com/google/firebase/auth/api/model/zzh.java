package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<VerifyAssertionRequest> {
    static void zza(VerifyAssertionRequest verifyAssertionRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, verifyAssertionRequest.mVersionCode);
        zzb.zza(parcel, 2, verifyAssertionRequest.zzOO(), false);
        zzb.zza(parcel, 3, verifyAssertionRequest.zzOP(), false);
        zzb.zza(parcel, 4, verifyAssertionRequest.getIdToken(), false);
        zzb.zza(parcel, 5, verifyAssertionRequest.getAccessToken(), false);
        zzb.zza(parcel, 6, verifyAssertionRequest.getProviderId(), false);
        zzb.zza(parcel, 7, verifyAssertionRequest.getEmail(), false);
        zzb.zza(parcel, 8, verifyAssertionRequest.zzfb(), false);
        zzb.zza(parcel, 9, verifyAssertionRequest.zzOQ(), false);
        zzb.zza(parcel, 10, verifyAssertionRequest.zzOR());
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjs */
    public VerifyAssertionRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaq = zza.zzaq(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel, zzap);
                    break;
                case 2:
                    str8 = zza.zzq(parcel, zzap);
                    break;
                case 3:
                    str7 = zza.zzq(parcel, zzap);
                    break;
                case 4:
                    str6 = zza.zzq(parcel, zzap);
                    break;
                case 5:
                    str5 = zza.zzq(parcel, zzap);
                    break;
                case 6:
                    str4 = zza.zzq(parcel, zzap);
                    break;
                case 7:
                    str3 = zza.zzq(parcel, zzap);
                    break;
                case 8:
                    str2 = zza.zzq(parcel, zzap);
                    break;
                case 9:
                    str = zza.zzq(parcel, zzap);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzap);
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new VerifyAssertionRequest(i, str8, str7, str6, str5, str4, str3, str2, str, z);
        }
        throw new zza.C0753zza(new StringBuilder(37).append("Overread allowed size end=").append(zzaq).toString(), parcel);
    }

    /* renamed from: zznu */
    public VerifyAssertionRequest[] newArray(int i) {
        return new VerifyAssertionRequest[i];
    }
}
