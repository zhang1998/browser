package android.support.v7.widget;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.app.aj;
import android.support.v7.c.f;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.support.v7.view.g;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public final class fu extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator i = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private LinearLayoutCompat d;
    private Spinner e;
    private boolean f;
    private int g;
    private int h;

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == UCCore.VERIFY_POLICY_QUICK;
        setFillViewport(z);
        int childCount = this.d.getChildCount();
        if (childCount <= 1 || !(mode == UCCore.VERIFY_POLICY_QUICK || mode == SectionHeader.SHT_LOUSER)) {
            this.b = -1;
        } else {
            if (childCount > 2) {
                this.b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.b = MeasureSpec.getSize(i) / 2;
            }
            this.b = Math.min(this.b, this.c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.g, UCCore.VERIFY_POLICY_QUICK);
        if (z || !this.f) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.d.measure(0, mode);
            if (this.d.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                b();
            } else if (!a()) {
                if (this.e == null) {
                    Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, k.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.e = appCompatSpinner;
                }
                removeView(this.d);
                addView(this.e, new ViewGroup.LayoutParams(-2, -1));
                if (this.e.getAdapter() == null) {
                    this.e.setAdapter(new ec());
                }
                if (this.a != null) {
                    removeCallbacks(this.a);
                    this.a = null;
                }
                this.e.setSelection(this.h);
            }
        } else {
            b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.h);
        }
    }

    private boolean a() {
        return this.e != null && this.e.getParent() == this;
    }

    public final void setAllowCollapse(boolean z) {
        this.f = z;
    }

    private boolean b() {
        if (a()) {
            removeView(this.e);
            addView(this.d, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.e.getSelectedItemPosition());
        }
        return false;
    }

    public final void setTabSelected(int i) {
        this.h = i;
        int childCount = this.d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.d.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                View childAt2 = this.d.getChildAt(i);
                if (this.a != null) {
                    removeCallbacks(this.a);
                }
                this.a = new cj(this, childAt2);
                post(this.a);
            }
        }
        if (this.e != null && i >= 0) {
            this.e.setSelection(i);
        }
    }

    public final void setContentHeight(int i) {
        this.g = i;
        requestLayout();
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        g a = g.a(getContext());
        TypedArray obtainStyledAttributes = a.a.obtainStyledAttributes(null, h.ActionBar, k.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(h.ActionBar_height, 0);
        Resources resources = a.a.getResources();
        if (!a.a()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(f.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.c = a.a.getResources().getDimensionPixelSize(f.abc_action_bar_stacked_tab_max_width);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    static /* synthetic */ fr a(fu fuVar, aj ajVar) {
        fr frVar = new fr(fuVar, fuVar.getContext(), ajVar);
        frVar.setBackgroundDrawable(null);
        frVar.setLayoutParams(new AbsListView.LayoutParams(-1, fuVar.g));
        return frVar;
    }
}
