package com.ucpro.feature.downloadpage.dirselect;

import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.g.h;
import com.ucweb.common.util.n.a;
import java.io.File;

/* compiled from: ProGuard */
final class l implements com.ucpro.ui.g.l {
    final /* synthetic */ b a;
    final /* synthetic */ m b;

    l(m mVar, b bVar) {
        this.b = mVar;
        this.a = bVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        boolean a = a.a(this.a.k());
        if (a && i == h.c) {
            e.a().a(com.ucpro.ui.c.a.d((int) R.string.download_dir_is_not_null), 1);
        } else if (i == h.c) {
            m mVar = this.b;
            new File(mVar.c + "/" + this.a.k()).mkdirs();
            mVar.a("");
        }
        if (i == h.d) {
            return false;
        }
        return a;
    }
}
