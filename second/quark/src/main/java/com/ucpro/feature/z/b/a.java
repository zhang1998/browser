package com.ucpro.feature.z.b;

import android.content.Context;
import com.ucpro.base.d.b;
import com.ucpro.feature.inputenhance.s;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class a extends s implements c {
    private i i = null;

    public a(Context context) {
        super(context);
    }

    public final void setPresenter(b bVar) {
        c.a((Object) bVar);
        c.b(bVar instanceof i);
        this.i = (i) bVar;
    }

    public final void setUrlState(boolean z) {
        if (z) {
            a(this.a, 1);
        } else {
            a(this.a, 0);
        }
    }

    public final void c() {
        a(this.e, -1);
    }

    public final boolean d() {
        if (getCurrentState() == this.a || getCurrentState() == this.e) {
            return true;
        }
        return false;
    }
}
