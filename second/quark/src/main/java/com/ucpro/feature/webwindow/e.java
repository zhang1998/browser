package com.ucpro.feature.webwindow;

import android.support.annotation.NonNull;
import android.util.Log;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.c.b;
import com.ucpro.feature.c.d.i;
import com.ucpro.ui.c.a;
import java.io.File;

/* compiled from: ProGuard */
final class e implements i {
    final /* synthetic */ aw a;

    e(aw awVar) {
        this.a = awVar;
    }

    public final void a(@NonNull String str, String str2) {
        Object ajVar = new aj();
        ajVar.o = str;
        ajVar.s = aj.h;
        g.a().a(com.ucpro.base.a.e.k, ajVar);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_success) + "[DEBUG]", 0);
        }
        com.ucpro.feature.c.e.a.c();
        com.ucpro.base.system.b.a.d(str2);
    }

    public final void a(@NonNull String str) {
        Log.e("hjw-pic", "fail.." + str);
        com.ucpro.feature.c.e.a.a(str);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_failed) + "[DEBUG] " + str, 0);
        } else {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.search_image_failed), 0);
        }
        com.ucweb.common.util.k.a.b(new File(this.a.b + this.a.c));
    }
}
