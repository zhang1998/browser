package com.ucpro.feature.privacymode;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.privacymode.c.b;
import com.ucpro.feature.privacymode.view.h;
import com.ucpro.feature.privacymode.view.t;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class p extends g implements c, h {
    private m e;
    private t f;
    private boolean g = false;

    public p(Context context, m mVar) {
        super(context);
        this.e = mVar;
        f();
        setBackgroundColor(a.c("default_background_dark"));
        setWindowCallBacks(this);
        setEnableSwipeGesture(false);
        this.f = new t(getContext());
        this.f.setOnPassWord(this);
        b(this.f);
    }

    public final void setFromChangePassword(boolean z) {
        this.g = z;
        if (this.g) {
            setEnableSwipeGesture(true);
            this.f.b.setVisibility(0);
            this.f.setTitle(a.d((int) R.string.privacymode_setting_change_password_new_title));
        }
    }

    public final void a(boolean z) {
        this.f.a();
        com.ucpro.base.a.g.a().a(e.cG, Boolean.valueOf(false));
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof p) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        if (!this.g) {
            return true;
        }
        com.ucpro.base.a.g.a().a(e.cG, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.e.b((g) view);
        }
        return null;
    }

    public final void a(String str) {
        b bVar = new b();
        bVar.b = str;
        com.ucweb.common.util.h.m.a(0, new com.ucpro.feature.privacymode.c.c(bVar));
        com.ucpro.base.a.g.a().a(e.cG, Boolean.valueOf(true));
        if (!this.g) {
            com.ucpro.base.a.g.a().a(e.cz, Boolean.valueOf(true));
        }
        com.ucpro.ui.b.e.a().a(getContext().getString(R.string.privacymode_setting_password_add_ok), 1);
    }

    public final void a() {
        com.ucpro.base.a.g.a().a(e.cG, Boolean.valueOf(true));
        if (!this.g) {
            com.ucpro.base.a.g.a().a(e.cz, Boolean.valueOf(true));
        }
    }
}
