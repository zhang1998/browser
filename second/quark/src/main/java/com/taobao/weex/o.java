package com.taobao.weex;

import android.content.Context;
import android.content.Intent;
import android.mini.support.v4.b.g;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ Context a;

    o(Context context) {
        this.a = context;
    }

    public final void run() {
        g.a(this.a).a(new Intent("js_framework_reload"));
    }
}
