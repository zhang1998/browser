package com.ucpro.feature.privacymode;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.privacymode.view.h;
import com.ucpro.feature.privacymode.view.p;
import com.ucpro.feature.privacymode.view.t;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class o extends g implements c, h {
    private m e;
    private t f = new f(this, getContext());

    public o(Context context, m mVar) {
        super(context);
        this.e = mVar;
        f();
        setWindowCallBacks(this);
        this.f.setBackgroundColor(a.c("default_background_dark"));
        this.f.setOnPassWord(this);
        this.f.setPassWordType$1e30636a(p.b);
        b(this.f);
    }

    public final void a(boolean z) {
        this.f.a();
        com.ucpro.base.a.g.a().a(e.cI, Boolean.valueOf(false));
    }

    public final void a(g gVar, byte b) {
        if (b != (byte) 1 && b == (byte) 4) {
            this.e.a((g) this);
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof o) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cI, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.e.b((g) view);
        }
        return null;
    }

    public final void a(String str) {
        com.ucpro.base.a.g.a().a(e.cz, Boolean.valueOf(true));
        com.ucpro.business.stat.m.a("privacy_mode", "privacy_box_page", "privacy_box_page_enter_ways", "privacy_box_page_pw");
    }

    public final void a() {
        com.ucpro.base.a.g.a().a(e.cI, Boolean.valueOf(true));
    }
}
