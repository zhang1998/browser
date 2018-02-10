package com.ucpro.feature.d;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.webview.browser.interfaces.IWebResources;
import com.ucpro.business.stat.m;
import com.ucpro.services.e.e;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.o;
import com.ucweb.c.b.b;

/* compiled from: ProGuard */
public final class f extends o implements g, n {
    private k a;
    private b b;
    private Activity v;
    private e w = new e(getContext());

    public f(Context context) {
        super(context);
        this.w.setOnSharePlatform(this);
        this.w.setPadding(a.c((int) R.dimen.share_main_padding_left), a.c((int) R.dimen.share_main_padding_top), a.c((int) R.dimen.share_main_padding_right), a.c((int) R.dimen.share_main_padding_bottom));
        h().a(this.w, new LayoutParams(-1, -2));
    }

    public final void a(b bVar, Activity activity) {
        this.b = bVar;
        this.v = activity;
        if (this.b != null && com.ucweb.common.util.n.a.a(this.b.c)) {
            this.b.c = this.b.b;
        }
        m.a(IWebResources.TEXT_SHARE, "share_show", new String[0]);
        show();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.a = (k) bVar;
    }

    public final void a() {
        super.a();
        this.w.s.a.a();
        for (l lVar : l.values()) {
            lVar.g = a.a(a.a(lVar.h));
        }
    }

    public final void a(com.ucweb.c.a.b bVar) {
        if (bVar != null) {
            String str = "";
            if (bVar == com.ucweb.c.a.b.CLIPBOARD) {
                str = "share_copy";
            } else if (bVar == com.ucweb.c.a.b.WECHAT_FRIENDS) {
                str = "share_wech_frie";
            } else if (bVar == com.ucweb.c.a.b.WECHAT_TIMELINE) {
                str = "share_wech_circ";
            } else if (bVar == com.ucweb.c.a.b.QQ) {
                str = "share_qq_frie";
            } else if (bVar == com.ucweb.c.a.b.QZONE) {
                str = "share_qq_zone";
            } else if (bVar == com.ucweb.c.a.b.SHARE_MORE) {
                str = "share_more";
            }
            m.a(IWebResources.TEXT_SHARE, str, new String[0]);
        }
        if (bVar == com.ucweb.c.a.b.CLIPBOARD) {
            e.a.a(this.b.a);
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.share_copy_sucess), 1);
        } else {
            com.ucweb.c.a.a(this.v, this.b, bVar);
        }
        dismiss();
    }
}
