package com.ucpro.feature.l.c;

import android.content.Context;
import com.ucpro.base.c.b.g;
import com.ucpro.business.stat.a.c;
import com.ucpro.business.stat.a.d;

/* compiled from: ProGuard */
public final class a extends g implements c {
    private i e;

    public a(Context context) {
        super(context);
        this.e = null;
        this.e = new i(getContext());
        b(this.e);
    }

    public final i getDiscoverPage() {
        return this.e;
    }

    public final void l() {
        this.e.a();
    }

    public final d getCurUtPage() {
        m a = this.e.getPresenter().a();
        if (a instanceof d) {
            return (d) a;
        }
        return null;
    }
}
