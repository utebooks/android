package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */
    public T zzaBY;
    /* access modifiers changed from: private */
    public Bundle zzaBZ;
    /* access modifiers changed from: private */
    public LinkedList<C0762zza> zzaCa;
    private final zzf<T> zzaCb = new zzf<T>() {
        public void zza(T t) {
            LifecycleDelegate unused = zza.this.zzaBY = t;
            Iterator it = zza.this.zzaCa.iterator();
            while (it.hasNext()) {
                ((C0762zza) it.next()).zzb(zza.this.zzaBY);
            }
            zza.this.zzaCa.clear();
            Bundle unused2 = zza.this.zzaBZ = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.zza$zza  reason: collision with other inner class name */
    private interface C0762zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, C0762zza zza) {
        if (this.zzaBY != null) {
            zza.zzb(this.zzaBY);
            return;
        }
        if (this.zzaCa == null) {
            this.zzaCa = new LinkedList<>();
        }
        this.zzaCa.add(zza);
        if (bundle != null) {
            if (this.zzaBZ == null) {
                this.zzaBZ = (Bundle) bundle.clone();
            } else {
                this.zzaBZ.putAll(bundle);
            }
        }
        zza(this.zzaCb);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzb = zzh.zzb(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzam(context));
        String zzh = zzh.zzh(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zzb);
        linearLayout.addView(textView);
        if (zzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzbC(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzeZ(int i) {
        while (!this.zzaCa.isEmpty() && this.zzaCa.getLast().getState() >= i) {
            this.zzaCa.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, (C0762zza) new C0762zza() {
            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzaBY.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        zza(bundle, (C0762zza) new C0762zza() {
            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.zzaBY.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.zzaBY == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzaBY != null) {
            this.zzaBY.onDestroy();
        } else {
            zzeZ(1);
        }
    }

    public void onDestroyView() {
        if (this.zzaBY != null) {
            this.zzaBY.onDestroyView();
        } else {
            zzeZ(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, (C0762zza) new C0762zza() {
            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzaBY.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzaBY != null) {
            this.zzaBY.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzaBY != null) {
            this.zzaBY.onPause();
        } else {
            zzeZ(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, (C0762zza) new C0762zza() {
            public int getState() {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzaBY.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.zzaBY != null) {
            this.zzaBY.onSaveInstanceState(bundle);
        } else if (this.zzaBZ != null) {
            bundle.putAll(this.zzaBZ);
        }
    }

    public void onStart() {
        zza((Bundle) null, (C0762zza) new C0762zza() {
            public int getState() {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzaBY.onStart();
            }
        });
    }

    public void onStop() {
        if (this.zzaBY != null) {
            this.zzaBY.onStop();
        } else {
            zzeZ(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzf<T> zzf);

    public T zzxd() {
        return this.zzaBY;
    }
}
