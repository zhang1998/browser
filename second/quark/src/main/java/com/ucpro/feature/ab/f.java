package com.ucpro.feature.ab;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class f extends ViewGroup {
    ImageView a;
    ImageView b = new ImageView(getContext());
    View c = new View(getContext());
    View d = new View(getContext());
    d e;

    public f(Context context) {
        super(context);
        this.b.setImageDrawable(a.a("qrcode_close.svg"));
        this.d.setBackgroundDrawable(a.c());
        this.a = new ImageView(getContext());
        this.a.setImageDrawable(a.a("qrcode_select_photo.svg"));
        this.c.setBackgroundDrawable(a.c());
        addView(this.b);
        addView(this.a);
        addView(this.c);
        addView(this.d);
        this.d.setOnClickListener(new g(this));
        this.c.setOnClickListener(new a(this));
    }

    public final void setIOnQrCodeBarClick(d dVar) {
        this.e = dVar;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK) / 2;
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK);
        this.a.measure(makeMeasureSpec, makeMeasureSpec2);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / 2;
        int measuredWidth = (width / 2) - (this.a.getMeasuredWidth() / 2);
        int height = (getHeight() / 2) - (this.a.getMeasuredHeight() / 2);
        this.a.layout(measuredWidth, height, this.a.getMeasuredWidth() + measuredWidth, this.a.getMeasuredHeight() + height);
        measuredWidth = ((width / 2) - (this.b.getMeasuredWidth() / 2)) + width;
        height = (getHeight() / 2) - (this.b.getMeasuredHeight() / 2);
        this.b.layout(measuredWidth, height, this.b.getMeasuredWidth() + measuredWidth, this.b.getMeasuredHeight() + height);
        this.c.layout(0, 0, width, getHeight());
        this.d.layout(width, 0, getWidth(), getHeight() + 0);
    }
}
