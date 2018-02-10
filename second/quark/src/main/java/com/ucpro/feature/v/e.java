package com.ucpro.feature.v;

import com.quark.browser.R;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.ucpro.business.stat.m;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
final class e implements l {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    e(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == u.c) {
            m.a(Style.WX_TRANSLATE, "trans_copy", new String[0]);
            com.ucpro.services.e.e.a.a(this.a);
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.share_copy_sucess), 1);
        }
        return false;
    }
}
