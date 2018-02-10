package com.ucpro.feature.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
final class e extends FrameLayout {
    final /* synthetic */ q a;

    e(q qVar, Context context) {
        this.a = qVar;
        super(context);
    }

    protected final void onDetachedFromWindow() {
        this.a.d();
        super.onDetachedFromWindow();
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }
}
