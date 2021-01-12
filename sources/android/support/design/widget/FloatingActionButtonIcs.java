package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButtonImpl;
import android.support.p000v4.view.ViewCompat;

class FloatingActionButtonIcs extends FloatingActionButtonEclairMr1 {
    /* access modifiers changed from: private */
    public boolean mIsHiding;
    private float mRotation = this.mView.getRotation();

    FloatingActionButtonIcs(VisibilityAwareImageButton view, ShadowViewDelegate shadowViewDelegate) {
        super(view, shadowViewDelegate);
    }

    /* access modifiers changed from: package-private */
    public boolean requirePreDrawListener() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onPreDraw() {
        float rotation = this.mView.getRotation();
        if (this.mRotation != rotation) {
            this.mRotation = rotation;
            updateFromViewRotation();
        }
    }

    /* access modifiers changed from: package-private */
    public void hide(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener listener, final boolean fromUser) {
        if (this.mIsHiding || this.mView.getVisibility() != 0) {
            if (listener != null) {
                listener.onHidden();
            }
        } else if (!ViewCompat.isLaidOut(this.mView) || this.mView.isInEditMode()) {
            this.mView.internalSetVisibility(8, fromUser);
            if (listener != null) {
                listener.onHidden();
            }
        } else {
            this.mView.animate().cancel();
            this.mView.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter() {
                private boolean mCancelled;

                public void onAnimationStart(Animator animation) {
                    boolean unused = FloatingActionButtonIcs.this.mIsHiding = true;
                    this.mCancelled = false;
                    FloatingActionButtonIcs.this.mView.internalSetVisibility(0, fromUser);
                }

                public void onAnimationCancel(Animator animation) {
                    boolean unused = FloatingActionButtonIcs.this.mIsHiding = false;
                    this.mCancelled = true;
                }

                public void onAnimationEnd(Animator animation) {
                    boolean unused = FloatingActionButtonIcs.this.mIsHiding = false;
                    if (!this.mCancelled) {
                        FloatingActionButtonIcs.this.mView.internalSetVisibility(8, fromUser);
                        if (listener != null) {
                            listener.onHidden();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void show(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener listener, final boolean fromUser) {
        if (!this.mIsHiding && this.mView.getVisibility() == 0) {
            return;
        }
        if (!ViewCompat.isLaidOut(this.mView) || this.mView.isInEditMode()) {
            this.mView.internalSetVisibility(0, fromUser);
            this.mView.setAlpha(1.0f);
            this.mView.setScaleY(1.0f);
            this.mView.setScaleX(1.0f);
            if (listener != null) {
                listener.onShown();
                return;
            }
            return;
        }
        this.mView.animate().cancel();
        if (this.mView.getVisibility() != 0) {
            this.mView.setAlpha(0.0f);
            this.mView.setScaleY(0.0f);
            this.mView.setScaleX(0.0f);
        }
        this.mView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animation) {
                FloatingActionButtonIcs.this.mView.internalSetVisibility(0, fromUser);
            }

            public void onAnimationEnd(Animator animation) {
                if (listener != null) {
                    listener.onShown();
                }
            }
        });
    }

    private void updateFromViewRotation() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.mRotation % 90.0f != 0.0f) {
                if (this.mView.getLayerType() != 1) {
                    this.mView.setLayerType(1, (Paint) null);
                }
            } else if (this.mView.getLayerType() != 0) {
                this.mView.setLayerType(0, (Paint) null);
            }
        }
        if (this.mShadowDrawable != null) {
            this.mShadowDrawable.setRotation(-this.mRotation);
        }
        if (this.mBorderDrawable != null) {
            this.mBorderDrawable.setRotation(-this.mRotation);
        }
    }
}
