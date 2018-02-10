package com.ucpro.base.weex.component;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.ucpro.ui.widget.tablayout.ProTabLayout;

/* compiled from: ProGuard */
final class f extends ViewGroup {
    ProTabLayout a = null;
    final /* synthetic */ WXTablayout b;

    public f(WXTablayout wXTablayout, Context context) {
        this.b = wXTablayout;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null) {
            this.a.measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), SectionHeader.SHT_LOUSER), i2);
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            int measuredWidth;
            int measuredHeight = (getMeasuredHeight() - this.a.getMeasuredHeight()) / 2;
            int measuredHeight2 = measuredHeight + this.a.getMeasuredHeight();
            if (this.a.getMeasuredWidth() < getMeasuredWidth()) {
                measuredWidth = (getMeasuredWidth() - this.a.getMeasuredWidth()) / 2;
            } else {
                measuredWidth = 0;
            }
            this.a.layout(measuredWidth, measuredHeight, this.a.getMeasuredWidth() + measuredWidth, measuredHeight2);
        }
    }
}
