package com.andexert.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

public class RippleView extends RelativeLayout {
    private int HEIGHT;
    private int WIDTH;
    private boolean animationRunning = false;
    private Handler canvasHandler;
    private int durationEmpty = -1;
    private int frameRate = 10;
    private GestureDetector gestureDetector;
    private Boolean hasToZoom;
    private Boolean isCentered;
    private OnRippleCompleteListener onCompletionListener;
    private Bitmap originBitmap;
    private Paint paint;
    private float radiusMax = 0.0f;
    private int rippleAlpha = 90;
    private int rippleColor;
    private int rippleDuration = 400;
    private int ripplePadding;
    private Integer rippleType;
    private final Runnable runnable = new Runnable() {
        public void run() {
            RippleView.this.invalidate();
        }
    };
    private ScaleAnimation scaleAnimation;
    private int timer = 0;
    private int timerEmpty = 0;

    /* renamed from: x */
    private float f41x = -1.0f;

    /* renamed from: y */
    private float f42y = -1.0f;
    private int zoomDuration;
    private float zoomScale;

    public interface OnRippleCompleteListener {
        void onComplete(RippleView rippleView);
    }

    public RippleView(Context context) {
        super(context);
    }

    public RippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RippleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, C0376R.styleable.RippleView);
            this.rippleColor = typedArray.getColor(C0376R.styleable.RippleView_rv_color, getResources().getColor(C0376R.color.rippelColor));
            this.rippleType = Integer.valueOf(typedArray.getInt(C0376R.styleable.RippleView_rv_type, 0));
            this.hasToZoom = Boolean.valueOf(typedArray.getBoolean(C0376R.styleable.RippleView_rv_zoom, false));
            this.isCentered = Boolean.valueOf(typedArray.getBoolean(C0376R.styleable.RippleView_rv_centered, false));
            this.rippleDuration = typedArray.getInteger(C0376R.styleable.RippleView_rv_rippleDuration, this.rippleDuration);
            this.frameRate = typedArray.getInteger(C0376R.styleable.RippleView_rv_framerate, this.frameRate);
            this.rippleAlpha = typedArray.getInteger(C0376R.styleable.RippleView_rv_alpha, this.rippleAlpha);
            this.ripplePadding = typedArray.getDimensionPixelSize(C0376R.styleable.RippleView_rv_ripplePadding, 0);
            this.canvasHandler = new Handler();
            this.zoomScale = typedArray.getFloat(C0376R.styleable.RippleView_rv_zoomScale, 1.03f);
            this.zoomDuration = typedArray.getInt(C0376R.styleable.RippleView_rv_zoomDuration, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
            typedArray.recycle();
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.rippleColor);
            this.paint.setAlpha(this.rippleAlpha);
            setWillNotDraw(false);
            this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent event) {
                    super.onLongPress(event);
                    RippleView.this.animateRipple(event);
                    RippleView.this.sendClickEvent(true);
                }

                public boolean onSingleTapConfirmed(MotionEvent e) {
                    return true;
                }

                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
            setDrawingCacheEnabled(true);
            setClickable(true);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.animationRunning) {
            return;
        }
        if (this.rippleDuration <= this.timer * this.frameRate) {
            this.animationRunning = false;
            this.timer = 0;
            this.durationEmpty = -1;
            this.timerEmpty = 0;
            canvas.restore();
            invalidate();
            if (this.onCompletionListener != null) {
                this.onCompletionListener.onComplete(this);
                return;
            }
            return;
        }
        this.canvasHandler.postDelayed(this.runnable, (long) this.frameRate);
        if (this.timer == 0) {
            canvas.save();
        }
        canvas.drawCircle(this.f41x, this.f42y, this.radiusMax * ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration)), this.paint);
        this.paint.setColor(Color.parseColor("#ffff4444"));
        if (this.rippleType.intValue() == 1 && this.originBitmap != null && (((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration) > 0.4f) {
            if (this.durationEmpty == -1) {
                this.durationEmpty = this.rippleDuration - (this.timer * this.frameRate);
            }
            this.timerEmpty++;
            Bitmap tmpBitmap = getCircleBitmap((int) (this.radiusMax * ((((float) this.timerEmpty) * ((float) this.frameRate)) / ((float) this.durationEmpty))));
            canvas.drawBitmap(tmpBitmap, 0.0f, 0.0f, this.paint);
            tmpBitmap.recycle();
        }
        this.paint.setColor(this.rippleColor);
        if (this.rippleType.intValue() != 1) {
            this.paint.setAlpha((int) (((float) this.rippleAlpha) - (((float) this.rippleAlpha) * ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration)))));
        } else if ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration) > 0.6f) {
            this.paint.setAlpha((int) (((float) this.rippleAlpha) - (((float) this.rippleAlpha) * ((((float) this.timerEmpty) * ((float) this.frameRate)) / ((float) this.durationEmpty)))));
        } else {
            this.paint.setAlpha(this.rippleAlpha);
        }
        this.timer++;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.WIDTH = w;
        this.HEIGHT = h;
        this.scaleAnimation = new ScaleAnimation(1.0f, this.zoomScale, 1.0f, this.zoomScale, (float) (w / 2), (float) (h / 2));
        this.scaleAnimation.setDuration((long) this.zoomDuration);
        this.scaleAnimation.setRepeatMode(2);
        this.scaleAnimation.setRepeatCount(1);
    }

    public void animateRipple(MotionEvent event) {
        createAnimation(event.getX(), event.getY());
    }

    public void animateRipple(float x, float y) {
        createAnimation(x, y);
    }

    private void createAnimation(float x, float y) {
        if (isEnabled() && !this.animationRunning) {
            if (this.hasToZoom.booleanValue()) {
                startAnimation(this.scaleAnimation);
            }
            this.radiusMax = (float) Math.max(this.WIDTH, this.HEIGHT);
            if (this.rippleType.intValue() != 2) {
                this.radiusMax /= 2.0f;
            }
            this.radiusMax -= (float) this.ripplePadding;
            if (this.isCentered.booleanValue() || this.rippleType.intValue() == 1) {
                this.f41x = (float) (getMeasuredWidth() / 2);
                this.f42y = (float) (getMeasuredHeight() / 2);
            } else {
                this.f41x = x;
                this.f42y = y;
            }
            this.animationRunning = true;
            if (this.rippleType.intValue() == 1 && this.originBitmap == null) {
                this.originBitmap = getDrawingCache(true);
            }
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.gestureDetector.onTouchEvent(event)) {
            animateRipple(event);
            sendClickEvent(false);
        }
        return super.onTouchEvent(event);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        onTouchEvent(event);
        return super.onInterceptTouchEvent(event);
    }

    /* access modifiers changed from: private */
    public void sendClickEvent(Boolean isLongClick) {
        if (getParent() instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) getParent();
            int position = adapterView.getPositionForView(this);
            long id = adapterView.getItemIdAtPosition(position);
            if (isLongClick.booleanValue()) {
                if (adapterView.getOnItemLongClickListener() != null) {
                    adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, position, id);
                }
            } else if (adapterView.getOnItemClickListener() != null) {
                adapterView.getOnItemClickListener().onItemClick(adapterView, this, position, id);
            }
        }
    }

    private Bitmap getCircleBitmap(int radius) {
        Bitmap output = Bitmap.createBitmap(this.originBitmap.getWidth(), this.originBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint2 = new Paint();
        Rect rect = new Rect((int) (this.f41x - ((float) radius)), (int) (this.f42y - ((float) radius)), (int) (this.f41x + ((float) radius)), (int) (this.f42y + ((float) radius)));
        paint2.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(this.f41x, this.f42y, (float) radius, paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.originBitmap, rect, rect, paint2);
        return output;
    }

    public void setRippleColor(int rippleColor2) {
        this.rippleColor = getResources().getColor(rippleColor2);
    }

    public int getRippleColor() {
        return this.rippleColor;
    }

    public RippleType getRippleType() {
        return RippleType.values()[this.rippleType.intValue()];
    }

    public void setRippleType(RippleType rippleType2) {
        this.rippleType = Integer.valueOf(rippleType2.ordinal());
    }

    public Boolean isCentered() {
        return this.isCentered;
    }

    public void setCentered(Boolean isCentered2) {
        this.isCentered = isCentered2;
    }

    public int getRipplePadding() {
        return this.ripplePadding;
    }

    public void setRipplePadding(int ripplePadding2) {
        this.ripplePadding = ripplePadding2;
    }

    public Boolean isZooming() {
        return this.hasToZoom;
    }

    public void setZooming(Boolean hasToZoom2) {
        this.hasToZoom = hasToZoom2;
    }

    public float getZoomScale() {
        return this.zoomScale;
    }

    public void setZoomScale(float zoomScale2) {
        this.zoomScale = zoomScale2;
    }

    public int getZoomDuration() {
        return this.zoomDuration;
    }

    public void setZoomDuration(int zoomDuration2) {
        this.zoomDuration = zoomDuration2;
    }

    public int getRippleDuration() {
        return this.rippleDuration;
    }

    public void setRippleDuration(int rippleDuration2) {
        this.rippleDuration = rippleDuration2;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public void setFrameRate(int frameRate2) {
        this.frameRate = frameRate2;
    }

    public int getRippleAlpha() {
        return this.rippleAlpha;
    }

    public void setRippleAlpha(int rippleAlpha2) {
        this.rippleAlpha = rippleAlpha2;
    }

    public void setOnRippleCompleteListener(OnRippleCompleteListener listener) {
        this.onCompletionListener = listener;
    }

    public enum RippleType {
        SIMPLE(0),
        DOUBLE(1),
        RECTANGLE(2);
        
        int type;

        private RippleType(int type2) {
            this.type = type2;
        }
    }
}
