package com.uc.apollo.media.impl;

import com.uc.apollo.media.b.b;
import com.uc.apollo.media.impl.f.a;
import com.uc.apollo.util.f;

/* compiled from: ProGuard */
final class w implements a {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final void a(int i, O o, Object obj) {
        if (this.a.v == i) {
            if (O.a(o)) {
                b bVar = (b) obj;
                this.a.n = bVar.a();
                this.a.b("onGotTypeSuccess " + o + ", duration: " + f.b(this.a.n));
                return;
            }
            this.a.b("onGotTypeSuccess " + o);
        }
    }

    public final void a(int i, String str) {
        if (this.a.v == i) {
            this.a.b("onGotTypeFailure " + str);
        }
    }
}
