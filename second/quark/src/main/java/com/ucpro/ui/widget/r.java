package com.ucpro.ui.widget;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class r extends FrameLayout {
    private boolean a = false;
    private Runnable b = new z(this);

    static /* synthetic */ void a(r rVar) {
        rVar.a = false;
        rVar.measure(MeasureSpec.makeMeasureSpec(rVar.getWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(rVar.getHeight(), UCCore.VERIFY_POLICY_QUICK));
        rVar.layout(rVar.getLeft(), rVar.getTop(), rVar.getRight(), rVar.getBottom());
        rVar.invalidate();
    }

    public r(Context context) {
        super(context);
    }

    public void requestLayout() {
        boolean z;
        if (getHeight() <= 0 || getWidth() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            super.requestLayout();
        } else if (!this.a) {
            super.forceLayout();
            this.a = true;
            post(this.b);
        }
    }
}
