package com.taobao.weex.ui.component;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ l b;

    k(l lVar, Context context) {
        this.b = lVar;
        this.a = context;
    }

    public final void run() {
        if (!(((Activity) this.a).getCurrentFocus() instanceof EditText)) {
            this.b.a.hideSoftInputFromWindow(((com.taobao.weex.ui.view.k) this.b.getHostView()).getWindowToken(), 0);
        }
    }
}
