package com.ucpro.feature.bookmarkhis.a;

import com.ucweb.common.util.h.a;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
final class j extends a {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        List i = this.a.i();
        try {
            Collections.reverse(i);
        } catch (UnsupportedOperationException e) {
        } finally {
            this.f = i;
        }
    }
}
