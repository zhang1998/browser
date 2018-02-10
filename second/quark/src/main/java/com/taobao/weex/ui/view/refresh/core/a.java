package com.taobao.weex.ui.view.refresh.core;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ WXRefreshView b;

    a(WXRefreshView wXRefreshView, View view) {
        this.b = wXRefreshView;
        this.a = view;
    }

    public final void run() {
        View view = this.a;
        if (this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
            View childAt = ((ViewGroup) view).getChildAt(i);
            if (childAt instanceof CircleProgressBar) {
                this.b.a = (CircleProgressBar) childAt;
            }
        }
        this.b.b.addView(view);
    }
}
