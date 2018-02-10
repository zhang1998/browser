package com.ucpro.feature.l.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class h extends ViewGroup {
    private ImageView a;
    private d b;

    public h(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = new ImageView(getContext());
        addView(this.a);
        this.b = new d(getContext());
        int c = a.c((int) R.dimen.dicover_page_plugin_item_padding);
        this.b.setPadding(c, c, c, c);
        addView(this.b);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.dicover_page_plugin_item_image_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.dicover_page_plugin_item_image_height), UCCore.VERIFY_POLICY_QUICK));
        this.b.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.dicover_page_plugin_item_btn_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.dicover_page_plugin_item_btn_height), UCCore.VERIFY_POLICY_QUICK));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            this.a.layout(0, 0, this.a.getMeasuredWidth() + 0, this.a.getMeasuredHeight() + 0);
        }
        if (this.b != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = measuredWidth - this.b.getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.b.layout(measuredWidth2, measuredHeight - this.b.getMeasuredHeight(), measuredWidth, measuredHeight);
        }
    }

    public final void setImageDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public final void setState(int i) {
        this.b.setState(i);
    }

    public final ImageView getImageView() {
        return this.a;
    }

    public final d getPlusBtn() {
        return this.b;
    }
}
