package com.ucpro.feature.g.b.a;

import com.quark.browser.R;
import com.ucpro.feature.g.a.b;

/* compiled from: ProGuard */
final class a extends b {
    int d = 0;
    final /* synthetic */ b e;

    a(b bVar) {
        this.e = bVar;
        super(30000);
    }

    public final void a(long j) {
        if (this.e.c) {
            CharSequence charSequence;
            if (com.ucweb.common.util.n.a.a(this.e.f)) {
                this.e.f = com.ucpro.ui.c.a.d((int) R.string.cloud_sync_syncing);
            }
            if (this.d == 0) {
                charSequence = this.e.f + ".";
            } else if (this.d == 1) {
                charSequence = this.e.f + "..";
            } else {
                charSequence = this.e.f + "...";
            }
            this.d++;
            if (this.d == 3) {
                this.d = 0;
            }
            this.e.a.setText(charSequence);
            return;
        }
        this.e.b.a();
    }

    public final void c() {
        this.e.a.setText(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_sync));
    }
}
