package com.ucpro.feature.t.a;

import com.ucpro.feature.t.n;
import com.ucpro.feature.t.p;
import com.ucpro.feature.t.q;
import java.util.List;

/* compiled from: ProGuard */
public final class e implements d {
    private c a = null;
    private p b = null;
    private n c = null;

    public e(c cVar) {
        this.a = cVar;
        this.a.setPresenter(this);
    }

    public final void a() {
        if (this.b != null && this.c != null) {
            List a = this.b.a();
            if (!a.isEmpty()) {
                q qVar = (q) a.get(0);
                this.a.setWebShotImage(this.c.a(qVar.c));
                this.a.setIconDrawable(qVar.a);
                this.a.setTitleText(qVar.b);
            }
        }
    }

    public final void a(int i, boolean z) {
        if (this.b != null && this.c != null) {
            if (z) {
                this.a.setWebShotImage(this.c.a(i));
                return;
            }
            for (q qVar : this.b.a()) {
                if (qVar != null && qVar.c == i) {
                    break;
                }
            }
            q qVar2 = null;
            if (qVar2 != null) {
                this.a.setWebShotImage(this.c.a(qVar2.c));
                this.a.setIconDrawable(qVar2.a);
                this.a.setTitleText(qVar2.b);
            }
        }
    }

    public final void a(p pVar) {
        this.b = pVar;
    }

    public final void a(n nVar) {
        this.c = nVar;
    }
}
