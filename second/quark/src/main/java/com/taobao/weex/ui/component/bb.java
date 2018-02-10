package com.taobao.weex.ui.component;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ProGuard */
final class bb implements OnGlobalLayoutListener {
    final /* synthetic */ be a;

    bb(be beVar) {
        this.a = beVar;
    }

    @TargetApi(16)
    public final void onGlobalLayout() {
        this.a.b(0, 0, 0, 0);
        View hostView = this.a.getHostView();
        if (hostView != null) {
            if (VERSION.SDK_INT >= 16) {
                hostView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                hostView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }
}
