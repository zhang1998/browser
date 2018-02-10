package com.ucpro.feature.l;

import android.app.Activity;
import android.view.View;
import android.view.View.MeasureSpec;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
final class d implements g {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void a() {
        c.c(this.a);
        this.a.e = false;
    }

    public final void b() {
        View findViewById = ((Activity) this.a.b).findViewById(R.id.home_navigation_view);
        if (findViewById != null) {
            findViewById.measure(MeasureSpec.makeMeasureSpec(findViewById.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(findViewById.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
            findViewById.layout(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        }
    }
}
