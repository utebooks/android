package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.C0012R;
import android.support.design.widget.BottomSheetBehavior;
import android.support.p003v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback;

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int theme) {
        super(context, getThemeResId(context, theme));
        this.mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == 5) {
                    BottomSheetDialog.this.dismiss();
                }
            }

            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        };
        supportRequestWindowFeature(1);
    }

    protected BottomSheetDialog(@NonNull Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == 5) {
                    BottomSheetDialog.this.dismiss();
                }
            }

            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        };
        supportRequestWindowFeature(1);
    }

    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(wrapInBottomSheet(layoutResId, (View) null, (ViewGroup.LayoutParams) null));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(-1, -1);
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(wrapInBottomSheet(0, view, params));
    }

    private View wrapInBottomSheet(int layoutResId, View view, ViewGroup.LayoutParams params) {
        CoordinatorLayout coordinator = (CoordinatorLayout) View.inflate(getContext(), C0012R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
        if (layoutResId != 0 && view == null) {
            view = getLayoutInflater().inflate(layoutResId, coordinator, false);
        }
        FrameLayout bottomSheet = (FrameLayout) coordinator.findViewById(C0012R.C0014id.design_bottom_sheet);
        BottomSheetBehavior.from(bottomSheet).setBottomSheetCallback(this.mBottomSheetCallback);
        if (params == null) {
            bottomSheet.addView(view);
        } else {
            bottomSheet.addView(view, params);
        }
        if (shouldWindowCloseOnTouchOutside()) {
            coordinator.findViewById(C0012R.C0014id.touch_outside).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (BottomSheetDialog.this.isShowing()) {
                        BottomSheetDialog.this.cancel();
                    }
                }
            });
        }
        return coordinator;
    }

    private boolean shouldWindowCloseOnTouchOutside() {
        if (Build.VERSION.SDK_INT < 11) {
            return true;
        }
        TypedValue value = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, value, true)) {
            return false;
        }
        if (value.data == 0) {
            return false;
        }
        return true;
    }

    private static int getThemeResId(Context context, int themeId) {
        if (themeId != 0) {
            return themeId;
        }
        TypedValue outValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C0012R.attr.bottomSheetDialogTheme, outValue, true)) {
            return outValue.resourceId;
        }
        return C0012R.style.Theme_Design_Light_BottomSheetDialog;
    }
}
