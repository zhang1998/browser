package com.uc.sync.e;

import android.os.Handler;
import android.os.Looper;
import com.uc.sync.c.a;
import com.uc.sync.f.g;
import com.uc.webview.browser.interfaces.IWebResources;

/* compiled from: ProGuard */
final class b implements g {
    final /* synthetic */ a a;

    private b(a aVar) {
        this.a = aVar;
    }

    public final void a(int i, int i2, int i3, int i4) {
        h hVar = (h) this.a.b.get(i);
        if (hVar != null) {
            if (i3 == 101) {
                a.h().a("sync", "success", "id", String.valueOf(i));
            } else if (i3 == 102) {
                com.uc.sync.h.a.a(i, i3, i4, "failure");
            } else {
                com.uc.sync.h.a.a(i, i3, i4, IWebResources.TEXT_OTHER);
            }
            new Handler(Looper.getMainLooper()).post(new e(this, hVar, i2, i3, i4));
        }
    }
}
