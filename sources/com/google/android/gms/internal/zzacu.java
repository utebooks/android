package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public interface zzacu extends IInterface {

    public static abstract class zza extends Binder implements zzacu {

        /* renamed from: com.google.android.gms.internal.zzacu$zza$zza  reason: collision with other inner class name */
        private static class C0768zza implements zzacu {
            private IBinder zzpb;

            C0768zza(IBinder iBinder) {
                this.zzpb = iBinder;
            }

            public IBinder asBinder() {
                return this.zzpb;
            }

            public void zza(zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(VerifyAssertionRequest verifyAssertionRequest, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    if (verifyAssertionRequest != null) {
                        obtain.writeInt(1);
                        verifyAssertionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    if (userProfileChangeRequest != null) {
                        obtain.writeInt(1);
                        userProfileChangeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, VerifyAssertionRequest verifyAssertionRequest, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    if (verifyAssertionRequest != null) {
                        obtain.writeInt(1);
                        verifyAssertionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, String str3, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, String str2, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(String str, String str2, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(String str, String str2, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(String str, zzact zzact) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzact != null ? zzact.asBinder() : null);
                    this.zzpb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzacu zzeI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzacu)) ? new C0768zza(iBinder) : (zzacu) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: com.google.firebase.auth.api.model.VerifyAssertionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: com.google.firebase.auth.UserProfileChangeRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: com.google.firebase.auth.api.model.VerifyAssertionRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v62 */
        /* JADX WARNING: type inference failed for: r0v63 */
        /* JADX WARNING: type inference failed for: r0v64 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002a;
                    case 3: goto L_0x0043;
                    case 4: goto L_0x0066;
                    case 5: goto L_0x008e;
                    case 6: goto L_0x00ac;
                    case 7: goto L_0x00ca;
                    case 8: goto L_0x00e8;
                    case 9: goto L_0x0106;
                    case 10: goto L_0x0120;
                    case 11: goto L_0x013a;
                    case 12: goto L_0x015c;
                    case 13: goto L_0x0184;
                    case 14: goto L_0x019e;
                    case 15: goto L_0x01bc;
                    case 16: goto L_0x01d6;
                    case 17: goto L_0x01ec;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r8.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zza((java.lang.String) r0, (com.google.android.gms.internal.zzact) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002a:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zzb(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0043:
                java.lang.String r2 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0056
                android.os.Parcelable$Creator<com.google.firebase.auth.api.model.VerifyAssertionRequest> r0 = com.google.firebase.auth.api.model.VerifyAssertionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.firebase.auth.api.model.VerifyAssertionRequest r0 = (com.google.firebase.auth.api.model.VerifyAssertionRequest) r0
            L_0x0056:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zza((com.google.firebase.auth.api.model.VerifyAssertionRequest) r0, (com.google.android.gms.internal.zzact) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0066:
                java.lang.String r2 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r2)
                java.lang.String r2 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x007d
                android.os.Parcelable$Creator<com.google.firebase.auth.UserProfileChangeRequest> r0 = com.google.firebase.auth.UserProfileChangeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.firebase.auth.UserProfileChangeRequest r0 = (com.google.firebase.auth.UserProfileChangeRequest) r0
            L_0x007d:
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zza((java.lang.String) r2, (com.google.firebase.auth.UserProfileChangeRequest) r0, (com.google.android.gms.internal.zzact) r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x008e:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                java.lang.String r2 = r7.readString()
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zza((java.lang.String) r0, (java.lang.String) r2, (com.google.android.gms.internal.zzact) r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00ac:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                java.lang.String r2 = r7.readString()
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zzb(r0, r2, r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00ca:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                java.lang.String r2 = r7.readString()
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zzc(r0, r2, r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00e8:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                java.lang.String r2 = r7.readString()
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zzd(r0, r2, r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0106:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zzc(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0120:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zzd(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x013a:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                java.lang.String r2 = r7.readString()
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r4 = com.google.android.gms.internal.zzact.zza.zzeH(r4)
                r5.zza(r0, r2, r3, r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x015c:
                java.lang.String r2 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r2)
                java.lang.String r2 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x0173
                android.os.Parcelable$Creator<com.google.firebase.auth.api.model.VerifyAssertionRequest> r0 = com.google.firebase.auth.api.model.VerifyAssertionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.firebase.auth.api.model.VerifyAssertionRequest r0 = (com.google.firebase.auth.api.model.VerifyAssertionRequest) r0
            L_0x0173:
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zza((java.lang.String) r2, (com.google.firebase.auth.api.model.VerifyAssertionRequest) r0, (com.google.android.gms.internal.zzact) r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0184:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zze(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x019e:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                java.lang.String r2 = r7.readString()
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r3 = com.google.android.gms.internal.zzact.zza.zzeH(r3)
                r5.zze(r0, r2, r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01bc:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zzf(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01d6:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r0 = com.google.android.gms.internal.zzact.zza.zzeH(r0)
                r5.zza(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01ec:
                java.lang.String r0 = "com.google.firebase.auth.api.internal.IFirebaseAuthService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.internal.zzact r2 = com.google.android.gms.internal.zzact.zza.zzeH(r2)
                r5.zzg(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacu.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzact zzact) throws RemoteException;

    void zza(VerifyAssertionRequest verifyAssertionRequest, zzact zzact) throws RemoteException;

    void zza(String str, zzact zzact) throws RemoteException;

    void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzact zzact) throws RemoteException;

    void zza(String str, VerifyAssertionRequest verifyAssertionRequest, zzact zzact) throws RemoteException;

    void zza(String str, String str2, zzact zzact) throws RemoteException;

    void zza(String str, String str2, String str3, zzact zzact) throws RemoteException;

    void zzb(String str, zzact zzact) throws RemoteException;

    void zzb(String str, String str2, zzact zzact) throws RemoteException;

    void zzc(String str, zzact zzact) throws RemoteException;

    void zzc(String str, String str2, zzact zzact) throws RemoteException;

    void zzd(String str, zzact zzact) throws RemoteException;

    void zzd(String str, String str2, zzact zzact) throws RemoteException;

    void zze(String str, zzact zzact) throws RemoteException;

    void zze(String str, String str2, zzact zzact) throws RemoteException;

    void zzf(String str, zzact zzact) throws RemoteException;

    void zzg(String str, zzact zzact) throws RemoteException;
}
