package com.ucpro.feature.webwindow;

import android.support.annotation.NonNull;
import com.quark.browser.R;
import com.uc.webview.browser.BrowserWebView.HitTestResult;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.c.b;
import com.ucpro.c.c;
import com.ucpro.feature.c.d.i;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.i.f;

/* compiled from: ProGuard */
final class k implements i {
    final /* synthetic */ HitTestResult a;
    final /* synthetic */ y b;

    k(y yVar, HitTestResult hitTestResult) {
        this.b = yVar;
        this.a = hitTestResult;
    }

    public final void a(@NonNull String str, String str2) {
        Object ajVar = new aj();
        ajVar.o = str;
        ajVar.s = aj.h;
        g.a().a(e.k, ajVar);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_success) + "[DEBUG]", 0);
        }
        com.ucpro.feature.c.e.a.c();
    }

    public final void a(@NonNull String str) {
        if (str.equals("online_search_error")) {
            y yVar = this.b;
            HitTestResult hitTestResult = this.a;
            String str2 = c.b("tmp").getAbsolutePath() + "/";
            String str3 = null;
            if (!(hitTestResult == null || hitTestResult.getExtension() == null)) {
                str3 = hitTestResult.getExtension().getImageUrl();
            }
            String f = f.f(str3);
            if (!(f == null || f.trim().length() <= 0 || f.contains("."))) {
                f = f + ".jpg";
            }
            yVar.a.a(str2, f, str3, new aw(yVar, str2, f));
            return;
        }
        com.ucpro.feature.c.e.a.a(str);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_failed) + "[DEBUG] " + str, 0);
        } else {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_failed), 0);
        }
    }
}
