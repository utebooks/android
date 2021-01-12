package com.google.firebase.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzaku;
import java.util.List;

public class CreateAuthUriResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CreateAuthUriResponse> CREATOR = new zza();
    @zzacw
    public final int mVersionCode;
    @zzaku("registered")
    private boolean zzYQ;
    @zzaku("authUri")
    private String zzbFN;
    @zzaku("providerId")
    private String zzbFO;
    @zzaku("forExistingProvider")
    private boolean zzbFP;
    @zzaku("allProviders")
    private StringList zzbFQ;

    public CreateAuthUriResponse() {
        this.mVersionCode = 1;
    }

    CreateAuthUriResponse(int i, String str, boolean z, String str2, boolean z2, StringList stringList) {
        this.mVersionCode = i;
        this.zzbFN = str;
        this.zzYQ = z;
        this.zzbFO = str2;
        this.zzbFP = z2;
        this.zzbFQ = stringList == null ? StringList.zzON() : StringList.zza(stringList);
    }

    @Nullable
    public List<String> getAllProviders() {
        return this.zzbFQ.zzOM();
    }

    @Nullable
    public String getProviderId() {
        return this.zzbFO;
    }

    public boolean isRegistered() {
        return this.zzYQ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public boolean zzOA() {
        return this.zzbFP;
    }

    public StringList zzOB() {
        return this.zzbFQ;
    }

    @Nullable
    public String zzOz() {
        return this.zzbFN;
    }
}
