package com.ucpro.feature.privacymode;

import com.quark.browser.R;
import com.ucpro.feature.privacymode.b.b;
import com.ucpro.feature.privacymode.view.n;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class r extends b {
    final /* synthetic */ String b;
    final /* synthetic */ q c;

    r(q qVar, String str) {
        this.c = qVar;
        this.b = str;
    }

    protected final void a(int i, long j, long j2) {
        this.c.f.setProgressWithAnimation(i);
        this.c.f.setProgressDesc(this.b + com.ucpro.base.system.b.a.a(j) + "/" + com.ucpro.base.system.b.a.a(j2));
    }

    protected final void a(String str) {
        super.a(str);
        m.a(0, new e(this, str));
    }

    protected final void a() {
        n nVar = this.c.f.a;
        nVar.c.setVisibility(8);
        nVar.b.setVisibility(0);
        nVar.b.setBackgroundDrawable(nVar.e);
        nVar.b.setText(a.d((int) R.string.privacymode_guide_btn_loading_error));
    }
}
