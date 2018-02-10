package com.ucpro.feature.downloadpage.e;

import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
final class ab implements c {
    final /* synthetic */ o a;

    ab(o oVar) {
        this.a = oVar;
    }

    @DebugLog
    public final void a(boolean z) {
        this.a.b();
        this.a.j.a(z);
        this.a.j.d();
    }

    @DebugLog
    public final void a(g gVar, byte b) {
        if (b == (byte) 1) {
            this.a.r = true;
            this.a.j.c();
            m.a(2, new ad(this), 1000);
            if (!this.a.v) {
                this.a.v = true;
                if (this.a.u != null) {
                    this.a.l.setAlpha(0.0f);
                    this.a.m.a(this.a.u);
                    this.a.m.a.a();
                    o.h(this.a);
                    return;
                }
                this.a.a();
            }
        }
    }

    @DebugLog
    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.a.j.b();
        return true;
    }

    @DebugLog
    public final View a(View view) {
        if (view instanceof g) {
            return this.a.j.a((g) view);
        }
        return null;
    }

    @DebugLog
    public final void d() {
    }

    @DebugLog
    public final void e() {
    }

    @DebugLog
    public final void a(com.ui.edittext.c cVar, Object obj) {
    }
}
