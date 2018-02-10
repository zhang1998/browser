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
public final class d extends g implements c, h {
    private m e;
    private t f = new b(this, getContext());

    public d(Context context, m mVar) {
        super(context);
        this.e = mVar;
        f();
        setBackgroundColor(a.c("default_background_dark"));
        setWindowCallBacks(this);
        this.f.setOnPassWord(this);
        this.f.setPassWordType$1e30636a(p.c);
        b(this.f);
    }

    public final void a(boolean z) {
        this.f.a();
        com.ucpro.base.a.g.a().a(e.cO, Boolean.valueOf(false));
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof d) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cO, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.e.b((g) view);
        }
        return null;
    }

    public final void a(String str) {
        com.ucpro.base.a.g.a().a(e.cO, Boolean.valueOf(true));
        com.ucpro.base.a.g.a().a(e.cF, Boolean.valueOf(true));
    }

    public final void a() {
        com.ucpro.base.a.g.a().a(e.cO, Boolean.valueOf(true));
    }
}
