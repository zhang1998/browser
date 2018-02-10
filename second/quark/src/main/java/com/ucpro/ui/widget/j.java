package com.ucpro.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ucpro.base.c.b.g;

/* compiled from: ProGuard */
public abstract class j extends g implements af {
    public LinearLayout e;
    public f f;
    private FrameLayout g;

    public j(Context context) {
        super(context);
        this.g = new FrameLayout(context);
        this.e = new LinearLayout(context);
        this.e.setFocusable(true);
        this.e.setFocusableInTouchMode(true);
        this.e.setClickable(false);
        this.e.setOrientation(1);
        this.e.requestFocus();
        this.f = new f(context);
        this.e.addView(this.f.a, new LayoutParams(-1, -2));
        this.g.addView(this.e);
        b(this.g);
    }

    public final void a(View view, LayoutParams layoutParams) {
        this.g.addView(view, layoutParams);
    }

    public void setTitlebarMarginTop(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((LinearLayout) this.f.a).getLayoutParams();
        layoutParams.topMargin = i;
        this.f.a.setLayoutParams(layoutParams);
    }

    public void d(boolean z) {
        this.f.a.setVisibility(z ? 0 : 8);
    }
}
