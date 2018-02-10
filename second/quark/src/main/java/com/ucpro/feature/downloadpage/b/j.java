package com.ucpro.feature.downloadpage.b;

import com.quark.browser.R;
import com.ucpro.b.d.b;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.c.c;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public final class j implements h {
    o a;
    private m b;

    public j(o oVar, m mVar) {
        this.a = oVar;
        this.b = mVar;
    }

    public final void a(String str, int i) {
        if (b.b("show_set_download_path_tips") || a.c(str, c.c().getPath())) {
            this.a.c(i);
            g.a().a(e.cg);
            return;
        }
        com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(this.b.h());
        mVar.a(1);
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.download_path_ok), com.ucpro.ui.c.a.d((int) R.string.download_path_cancel));
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.download_path_select_info));
        mVar.a(new g(this, i));
        mVar.show();
    }
}
