package com.taobao.weex.ui.view.refresh.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar;

/* compiled from: ProGuard */
public class WXRefreshView extends FrameLayout {
    private CircleProgressBar a;
    private LinearLayout b;

    public WXRefreshView(Context context) {
        super(context);
        c();
    }

    public WXRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public WXRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        this.b = new LinearLayout(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.b.setOrientation(1);
        this.b.setGravity(17);
        addView(this.b, layoutParams);
    }

    public void setContentGravity(int i) {
        if (this.b != null) {
            this.b.setGravity(i);
        }
    }

    public boolean post(Runnable runnable) {
        return super.post(w.a(runnable));
    }

    public void setRefreshView(View view) {
        if (view != null) {
            post(new a(this, view));
        }
    }

    public void setProgressBgColor(int i) {
        if (this.a != null) {
            this.a.setBackgroundColor(i);
        }
    }

    public void setProgressColor(int i) {
        if (this.a != null) {
            this.a.setColorSchemeColors(i);
        }
    }

    protected final void a() {
        if (this.a != null) {
            this.a.a.start();
        }
    }

    public final void a(float f, float f2) {
        if (this.a != null) {
            this.a.a.a(f, f2);
        }
    }

    protected final void b() {
        if (this.a != null) {
            this.a.a.stop();
        }
    }

    public void setProgressRotation(float f) {
        if (this.a != null) {
            this.a.setProgressRotation(f);
        }
    }
}
