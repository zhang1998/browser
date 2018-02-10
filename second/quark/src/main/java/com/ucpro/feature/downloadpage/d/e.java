package com.ucpro.feature.downloadpage.d;

import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
final class e implements c {
    final /* synthetic */ l a;

    e(l lVar) {
        this.a = lVar;
    }

    @DebugLog
    public final void a(boolean z) {
        this.a.j.a(z);
    }

    @DebugLog
    public final void a(g gVar, byte b) {
    }

    @DebugLog
    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof l) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.a.j.a();
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
