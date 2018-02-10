package com.uc.apollo.media.impl;

import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.media.b.b;
import com.uc.apollo.media.impl.f.a;
import com.uc.apollo.util.f;

/* compiled from: ProGuard */
final class H implements a {
    final /* synthetic */ G a;

    H(G g) {
        this.a = g;
    }

    public final void a(int i, O o, Object obj) {
        if (this.a.u == i) {
            this.a.n = SectionHeader.SHT_LOUSER;
            if (O.a(o)) {
                this.a.v = (b) obj;
                this.a.n = this.a.v.a();
                new StringBuilder("onGotTypeSuccess - ").append(o).append(", duration: ").append(f.b(this.a.n));
            } else {
                new StringBuilder("onGotTypeSuccess - ").append(o);
            }
            this.a.k = o;
            this.a.r.a(this.a.j, 72, this.a.k.i, null);
            if (!this.a.x) {
                return;
            }
            String str;
            if (O.b(o)) {
                if (this.a.l != 0) {
                    str = this.a.b;
                    this.a.m = 0;
                    this.a.r.a(this.a.j, 0);
                }
            } else if (!u.j(this.a.l) && this.a.n >= 0) {
                str = this.a.b;
                this.a.r.a(this.a.j, this.a.n);
            }
        }
    }

    public final void a(int i, String str) {
        if (this.a.u == i) {
            this.a.k = O.PARSE_FAILURE;
            this.a.r.a(this.a.j, 72, this.a.k.i, null);
        }
    }
}
