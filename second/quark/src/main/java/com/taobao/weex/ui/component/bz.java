package com.taobao.weex.ui.component;

import com.taobao.weex.i;
import com.taobao.weex.ui.view.u;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class bz implements u {
    final /* synthetic */ ca a;

    bz(ca caVar) {
        this.a = caVar;
    }

    public final void a() {
        if (i.c()) {
            WXLogUtils.d("Video", "onPause");
        }
        if (this.a.getDomObject().c_().contains("pause")) {
            ca.a(this.a, "pause", "pause");
        }
    }

    public final void b() {
        if (i.c()) {
            WXLogUtils.d("Video", "onStart");
        }
        if (this.a.getDomObject().c_().contains("start")) {
            ca.a(this.a, "start", "play");
        }
    }
}
