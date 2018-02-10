package com.ucpro.feature.t.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class d extends ViewGroup {
    boolean a;
    int b;
    int c;
    int d;
    ValueAnimator e = null;
    final /* synthetic */ e f;
    private TextView g;
    private View h;
    private String i;
    private String j;
    private String k;
    private int l;
    private int m;

    public d(e eVar, Context context, String str, String str2, String str3) {
        this.f = eVar;
        super(context);
        this.j = str;
        this.i = str2;
        this.k = str3;
        this.h = new View(getContext());
        addView(this.h);
        this.g = new TextView(getContext());
        this.g.setTextSize(12.0f);
        this.g.setGravity(16);
        this.g.setSingleLine();
        this.g.setPadding(0, 0, a.c((int) R.dimen.expandable_button_text_padding_right), 0);
        this.g.setText(this.k);
        addView(this.g);
        a();
    }

    public final void a() {
        Drawable a = a.a(this.j);
        if (a != null) {
            this.l = a.getIntrinsicWidth();
            this.m = a.getIntrinsicHeight();
        }
        this.h.setBackgroundDrawable(a);
        this.g.setTextColor(a.c(this.i));
    }

    protected final void onMeasure(int i, int i2) {
        this.h.measure(MeasureSpec.makeMeasureSpec(this.l, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.m, UCCore.VERIFY_POLICY_QUICK));
        this.g.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        if (this.b == 0) {
            this.b = this.h.getMeasuredWidth();
            this.d = this.b;
        }
        if (this.c == 0) {
            this.c = this.h.getMeasuredWidth() + this.g.getMeasuredWidth();
        }
        setMeasuredDimension(this.d, Math.max(this.h.getMeasuredHeight(), this.g.getMeasuredHeight()));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight = (getMeasuredHeight() - this.h.getMeasuredHeight()) / 2;
        this.h.layout(0, measuredHeight, this.h.getMeasuredWidth() + 0, this.h.getMeasuredHeight() + measuredHeight);
        int right = this.h.getRight();
        int measuredHeight2 = (getMeasuredHeight() - this.g.getMeasuredHeight()) / 2;
        this.g.layout(right, measuredHeight2, this.g.getMeasuredWidth() + right, getHeight() + measuredHeight2);
    }
}
