package com.ucpro.ui.widget;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public abstract class ah extends ViewGroup {
    private boolean a = false;
    private Runnable b = new t(this);

    static /* synthetic */ void a(ah ahVar) {
        ahVar.a = false;
        ahVar.measure(MeasureSpec.makeMeasureSpec(ahVar.getWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(ahVar.getHeight(), UCCore.VERIFY_POLICY_QUICK));
        ahVar.layout(ahVar.getLeft(), ahVar.getTop(), ahVar.getRight(), ahVar.getBottom());
        ahVar.invalidate();
    }

    public ah(Context context) {
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
