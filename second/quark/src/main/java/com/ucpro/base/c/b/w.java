package com.ucpro.base.c.b;

import android.content.Context;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.business.stat.a.c;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.lightapp.f;

/* compiled from: ProGuard */
public final class w extends f implements c {
    public LinearLayout e = new LinearLayout(getContext());
    l f;
    t g;

    public w(Context context) {
        super(context);
        this.e.setOrientation(1);
        b(this.e);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.f = new l(context);
        this.e.addView(this.f, layoutParams);
        f();
    }

    public final void setPresenter(com.ucpro.feature.lightapp.c cVar) {
        super.setPresenter(cVar);
        setWindowCallBacks(cVar);
    }

    final boolean a() {
        if (this.g == null) {
            return false;
        }
        this.g.b(false);
        this.g.getRootWindow().a((byte) 15);
        this.f.removeView(this.g);
        this.g = null;
        return true;
    }

    final t getCurrentWindowStack() {
        return this.g;
    }

    protected final void onMeasure(int i, int i2) {
        f();
        super.onMeasure(i, i2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = false;
        if (keyEvent.getAction() != 1) {
            return true;
        }
        if (getCurrentWindowStack() != null && getCurrentWindowStack().getWindowCount() > 1) {
            g stackTopWindow = getCurrentWindowStack().getStackTopWindow();
            if (stackTopWindow != null) {
                z = stackTopWindow.dispatchKeyEvent(keyEvent);
            }
        }
        if (z || getPresenter() == null) {
            return true;
        }
        getPresenter().f();
        return true;
    }

    public final void requestLayout() {
        super.requestLayout();
    }

    public final com.ucpro.feature.lightapp.c getPresenter() {
        return super.getPresenter();
    }

    public final String getUrl() {
        if (getPresenter() != null) {
            return getPresenter().c();
        }
        return "";
    }

    public final d getCurUtPage() {
        if (this.g != null) {
            g rootWindow = this.g.getRootWindow();
            if (rootWindow instanceof d) {
                return (d) rootWindow;
            }
        }
        return null;
    }
}
