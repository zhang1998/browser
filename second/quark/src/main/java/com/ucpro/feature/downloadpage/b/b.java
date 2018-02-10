package com.ucpro.feature.downloadpage.b;

import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.c.c;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public final class b implements m {
    private l a;
    private m b;

    public b(l lVar, m mVar) {
        this.a = lVar;
        this.b = mVar;
    }

    public final void a() {
        g.a().a(e.cf, Boolean.valueOf(false));
    }

    public final com.ucpro.base.c.b.g a(com.ucpro.base.c.b.g gVar) {
        return this.b.b(gVar);
    }

    public final void b() {
        g.a().a(e.cf, Boolean.valueOf(true));
    }

    public final void d() {
        g.a().a(e.cc, Boolean.valueOf(true));
    }

    public final String c() {
        String path = c.c().getPath();
        return a.d(path, com.ucpro.model.a.a.a.a("setting_download_store_path", path)) ? com.ucpro.ui.c.a.d((int) R.string.download_path_inner_desc) : com.ucpro.ui.c.a.d((int) R.string.download_path_ext_def_desc);
    }

    public final void a(boolean z) {
        com.ucpro.model.a.a.a.b("setting_download_apk_auto_install", z);
    }

    public final boolean e() {
        return com.ucpro.model.a.a.a.a("setting_download_apk_auto_install", true);
    }
}
