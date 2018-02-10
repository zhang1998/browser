package com.ucpro.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class e extends ViewGroup {
    public View a;
    public int b;
    private View c;
    private View d;
    private int e;

    public e(Context context) {
        super(context);
    }

    public void setContentView(View view) {
        this.d = view;
        addView(this.d);
    }

    public View getContentView() {
        return this.d;
    }

    public View getBottomBarView() {
        return this.a;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c != null) {
            this.c.measure(i, MeasureSpec.makeMeasureSpec(this.e, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.d != null) {
            this.d.measure(i, MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.e) - this.b, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.a != null) {
            this.a.measure(i, MeasureSpec.makeMeasureSpec(this.b, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null) {
            this.c.layout(0, 0, getWidth(), this.c.getMeasuredHeight() + 0);
        }
        if (this.d != null) {
            int measuredHeight = this.c != null ? this.c.getMeasuredHeight() : 0;
            this.d.layout(0, measuredHeight, getWidth(), this.d.getMeasuredHeight() + measuredHeight);
        }
        if (this.a != null) {
            this.a.layout(0, getHeight() - this.a.getMeasuredHeight(), getWidth(), getHeight());
        }
    }
}
