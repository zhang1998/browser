package com.taobao.weex.ui.component.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ProGuard */
final class b implements OnGlobalLayoutListener {
    final /* synthetic */ e a;

    b(e eVar) {
        this.a = eVar;
    }

    @TargetApi(16)
    public final void onGlobalLayout() {
        ViewGroup viewGroup = (ViewGroup) this.a.getHostView();
        if (viewGroup != null) {
            this.a.o.a(((g) viewGroup).getInnerView(), 0, 0);
            if (VERSION.SDK_INT >= 16) {
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }
}
