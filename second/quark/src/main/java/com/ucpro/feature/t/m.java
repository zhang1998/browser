package com.ucpro.feature.t;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.feature.t.b.n;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class m extends ViewGroup {
    final /* synthetic */ l a;
    private n b;
    private View c;
    private int d;
    private int e;

    public m(l lVar, Context context, n nVar, View view) {
        this.a = lVar;
        super(context);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.d = a.c((int) R.dimen.mutil_window_sign_margin_left);
        this.e = a.c((int) R.dimen.mutil_window_sign_margin_bottom);
        this.b = nVar;
        addView(this.b);
        this.c = view;
        addView(this.c);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.c != null) {
            this.c.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.mutil_window_sign_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.mutil_window_sign_width), UCCore.VERIFY_POLICY_QUICK));
        }
        setMeasuredDimension(this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(this.b == null || this.b.getVisibility() == 8)) {
            this.b.layout(0, 0, this.b.getMeasuredWidth() + 0, this.b.getMeasuredHeight() + 0);
        }
        if (this.c != null && this.c.getVisibility() != 8 && this.b.getChildCount() > 0) {
            View webShotImageView = this.b.getFirstCard().getWebShotImageView();
            if (webShotImageView != null) {
                int i5 = this.d;
                int measuredWidth = this.c.getMeasuredWidth() + i5;
                int[] iArr = new int[2];
                webShotImageView.getLocationInWindow(iArr);
                int i6 = iArr[1];
                this.a.getLocationInWindow(iArr);
                int measuredHeight = (webShotImageView.getMeasuredHeight() + (i6 - iArr[1])) - this.e;
                this.c.layout(i5, measuredHeight - this.c.getMeasuredHeight(), measuredWidth, measuredHeight);
            }
        }
    }
}
