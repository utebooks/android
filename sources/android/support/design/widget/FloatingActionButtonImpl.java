package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.design.C0012R;
import android.view.ViewTreeObserver;

abstract class FloatingActionButtonImpl {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_ENABLED_STATE_SET = {16842908, 16842910};
    static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    static final int SHOW_HIDE_ANIM_DURATION = 200;
    CircularBorderDrawable mBorderDrawable;
    Drawable mContentBackground;
    float mElevation;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    float mPressedTranslationZ;
    Drawable mRippleDrawable;
    final ShadowViewDelegate mShadowViewDelegate;
    Drawable mShapeDrawable;
    private final Rect mTmpRect = new Rect();
    final VisibilityAwareImageButton mView;

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    /* access modifiers changed from: package-private */
    public abstract float getElevation();

    /* access modifiers changed from: package-private */
    public abstract void getPadding(Rect rect);

    /* access modifiers changed from: package-private */
    public abstract void hide(@Nullable InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z);

    /* access modifiers changed from: package-private */
    public abstract void jumpDrawableToCurrentState();

    /* access modifiers changed from: package-private */
    public abstract void onCompatShadowChanged();

    /* access modifiers changed from: package-private */
    public abstract void onDrawableStateChanged(int[] iArr);

    /* access modifiers changed from: package-private */
    public abstract void onElevationChanged(float f);

    /* access modifiers changed from: package-private */
    public abstract void onTranslationZChanged(float f);

    /* access modifiers changed from: package-private */
    public abstract void setBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void setBackgroundTintList(ColorStateList colorStateList);

    /* access modifiers changed from: package-private */
    public abstract void setBackgroundTintMode(PorterDuff.Mode mode);

    /* access modifiers changed from: package-private */
    public abstract void setRippleColor(int i);

    /* access modifiers changed from: package-private */
    public abstract void show(@Nullable InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z);

    FloatingActionButtonImpl(VisibilityAwareImageButton view, ShadowViewDelegate shadowViewDelegate) {
        this.mView = view;
        this.mShadowViewDelegate = shadowViewDelegate;
    }

    /* access modifiers changed from: package-private */
    public final void setElevation(float elevation) {
        if (this.mElevation != elevation) {
            this.mElevation = elevation;
            onElevationChanged(elevation);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setPressedTranslationZ(float translationZ) {
        if (this.mPressedTranslationZ != translationZ) {
            this.mPressedTranslationZ = translationZ;
            onTranslationZChanged(translationZ);
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable getContentBackground() {
        return this.mContentBackground;
    }

    /* access modifiers changed from: package-private */
    public final void updatePadding() {
        Rect rect = this.mTmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.mShadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void onPaddingUpdated(Rect padding) {
    }

    /* access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        if (requirePreDrawListener()) {
            ensurePreDrawListener();
            this.mView.getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        if (this.mPreDrawListener != null) {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
            this.mPreDrawListener = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean requirePreDrawListener() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public CircularBorderDrawable createBorderDrawable(int borderWidth, ColorStateList backgroundTint) {
        Resources resources = this.mView.getResources();
        CircularBorderDrawable borderDrawable = newCircularDrawable();
        borderDrawable.setGradientColors(resources.getColor(C0012R.color.design_fab_stroke_top_outer_color), resources.getColor(C0012R.color.design_fab_stroke_top_inner_color), resources.getColor(C0012R.color.design_fab_stroke_end_inner_color), resources.getColor(C0012R.color.design_fab_stroke_end_outer_color));
        borderDrawable.setBorderWidth((float) borderWidth);
        borderDrawable.setBorderTint(backgroundTint);
        return borderDrawable;
    }

    /* access modifiers changed from: package-private */
    public CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }

    /* access modifiers changed from: package-private */
    public void onPreDraw() {
    }

    private void ensurePreDrawListener() {
        if (this.mPreDrawListener == null) {
            this.mPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.onPreDraw();
                    return true;
                }
            };
        }
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable createShapeDrawable() {
        GradientDrawable d = new GradientDrawable();
        d.setShape(1);
        d.setColor(-1);
        return d;
    }
}
