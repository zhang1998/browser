package facerecognition.register;

import com.ucweb.common.util.h.m;
import facerecognition.b.a;

/* compiled from: ProGuard */
final class f implements Runnable {
    public int a;
    public Object b;
    final /* synthetic */ g c;

    private f(g gVar) {
        this.c = gVar;
    }

    public final void run() {
        if (this.a == d.a) {
            if (!this.c.r && (this.b instanceof Integer)) {
                ((Integer) this.b).intValue();
            }
        } else if (this.a == d.b) {
            if (!this.c.r) {
                if (this.c.j != null) {
                    this.c.s += 100;
                    this.c.j.a(this.c.s);
                }
                if (this.c.s >= 100 && !this.c.r) {
                    this.c.r = true;
                    m.a(0, new a(this));
                }
            }
        } else if (this.a == d.d) {
            this.c.b = true;
            if (this.c.j != null) {
                this.c.j.c();
            }
            g gVar = this.c;
            if (gVar.g.getRegisteredCount() < a.a) {
                m.a(0, new c(gVar));
            } else if (gVar.j != null) {
                gVar.j.b(12);
            }
        } else if (this.a == d.c && this.c.j != null) {
            this.c.j.a();
            this.c.j.b(((Integer) this.b).intValue());
        }
    }
}
