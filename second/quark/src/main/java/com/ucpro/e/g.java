package com.ucpro.e;

import android.util.Log;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.c.b;
import com.ucpro.feature.c.d.i;
import com.ucpro.feature.c.e.a;
import com.ucpro.feature.webwindow.aj;

/* compiled from: ProGuard */
final class g implements i {
    final /* synthetic */ o a;

    g(o oVar) {
        this.a = oVar;
    }

    public final void a(String str, String str2) {
        if (b.b()) {
            Log.e("hjw-pic", "handleSearchPictureOutSide:success:picUrl=" + str);
        }
        Object ajVar = new aj();
        ajVar.s = aj.i;
        ajVar.o = str;
        com.ucpro.base.a.g.a().a(e.k, ajVar);
        a.b();
    }

    public final void a(String str) {
        if (b.b()) {
            Log.e("hjw-pic", "handleSearchPictureOutSide:fail:errMsg=" + str);
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.search_image_failed) + "[DEBUG] " + str, 0);
        } else {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.search_image_failed), 0);
        }
        a.a(str);
    }
}
