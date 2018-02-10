package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.support.v4.view.cx;
import android.support.v7.c.c;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
abstract class fo extends ViewGroup {
    private boolean a;
    private boolean b;
    protected final dj c;
    protected final Context d;
    protected ActionMenuView e;
    protected ActionMenuPresenter f;
    protected int g;
    protected bo h;

    fo(Context context) {
        this(context, null);
    }

    fo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    fo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new dj(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(k.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.d = context;
        } else {
            this.d = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, h.ActionBar, k.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(h.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f != null) {
            ActionMenuPresenter actionMenuPresenter = this.f;
            if (!actionMenuPresenter.m) {
                actionMenuPresenter.l = actionMenuPresenter.b.getResources().getInteger(c.abc_max_action_buttons);
            }
            if (actionMenuPresenter.c != null) {
                actionMenuPresenter.c.b(true);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = cx.a(motionEvent);
        if (a == 0) {
            this.a = false;
        }
        if (!this.a) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.a = true;
            }
        }
        if (a == 1 || a == 3) {
            this.a = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = cx.a(motionEvent);
        if (a == 9) {
            this.b = false;
        }
        if (!this.b) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.b = true;
            }
        }
        if (a == 10 || a == 3) {
            this.b = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.g = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.g;
    }

    public int getAnimatedVisibility() {
        if (this.h != null) {
            return this.c.a;
        }
        return getVisibility();
    }

    public bo a(int i, long j) {
        if (this.h != null) {
            this.h.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.c((View) this, 0.0f);
            }
            bo a = ViewCompat.q(this).a((float) IPictureView.DEFAULT_MIN_SCALE);
            a.a(j);
            a.a(this.c.a(a, i));
            return a;
        }
        a = ViewCompat.q(this).a(0.0f);
        a.a(j);
        a.a(this.c.a(a, i));
        return a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.h != null) {
                this.h.a();
            }
            super.setVisibility(i);
        }
    }

    public boolean b() {
        if (this.f != null) {
            return this.f.c();
        }
        return false;
    }

    protected static int a(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, SectionHeader.SHT_LOUSER), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
