package com.taobao.weex.ui.component;

import com.taobao.weex.ui.view.WXHorizontalScrollView;
import com.taobao.weex.ui.view.WXScrollView;

/* compiled from: ProGuard */
final class bc implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ be d;

    bc(be beVar, boolean z, int i, int i2) {
        this.d = beVar;
        this.a = z;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        if (this.d.a == 1) {
            if (this.a) {
                ((WXScrollView) this.d.d()).smoothScrollBy(0, this.b);
            } else {
                ((WXScrollView) this.d.d()).scrollBy(0, this.b);
            }
        } else if (this.a) {
            ((WXHorizontalScrollView) this.d.d()).smoothScrollBy(this.c, 0);
        } else {
            ((WXHorizontalScrollView) this.d.d()).scrollBy(this.c, 0);
        }
        this.d.d().invalidate();
    }
}
