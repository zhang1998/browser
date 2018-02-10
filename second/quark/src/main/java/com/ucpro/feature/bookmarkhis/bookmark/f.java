package com.ucpro.feature.bookmarkhis.bookmark;

import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.af;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class f implements af {
    final /* synthetic */ n a;

    f(n nVar) {
        this.a = nVar;
    }

    public final void a(boolean z) {
        if (z) {
            if (this.a.b) {
                e.a().a(a.d((int) R.string.cloud_sync_successful), 0);
            }
            this.a.a(false);
            g.a().b(com.ucpro.base.a.e.aR);
        } else if (this.a.b) {
            e.a().a(a.d((int) R.string.cloud_sync_failure), 0);
        }
        this.a.a.a_(false);
    }
}
