package com.ucpro.feature.y;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public final class r extends FrameLayout {
    View a;

    public r(Context context, View view) {
        super(context);
        this.a = view;
        addView(this.a, -1, -1);
    }

    public final void removeView(View view) {
        super.removeView(view);
        if (view != null && view != this.a) {
            if (this.a.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            if (this.a.getVisibility() == 0 && this.a.getWidth() == 0) {
                this.a.measure(MeasureSpec.makeMeasureSpec(getWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getHeight(), UCCore.VERIFY_POLICY_QUICK));
                this.a.layout(0, 0, getWidth(), getHeight());
            }
        }
    }
}
