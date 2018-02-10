package com.ucpro.feature.webwindow;

import com.ucpro.business.stat.m;
import com.ucpro.feature.webwindow.a.g;
import com.ucweb.common.util.j.a;

/* compiled from: ProGuard */
final class d implements aq {
    final /* synthetic */ bb a;

    d(bb bbVar) {
        this.a = bbVar;
    }

    public final void a() {
        m.a("webwindow", "web_gesture_go_back", new String[0]);
        this.a.q();
    }

    public final void b() {
        m.a("webwindow", "web_gesture_go_forward", new String[0]);
        this.a.r();
    }

    public final void c() {
        if (this.a.e != null && this.a.e.h()) {
            m.a("webwindow", "web_gesture_go_home", new String[0]);
            this.a.a();
            if (!bb.o) {
                bb.o = true;
                g b = this.a.getGuideManager();
                if (!a.b("1BFFE8AD1E20ED68", false)) {
                    a.a("1BFFE8AD1E20ED68", true);
                    b.b = true;
                }
            }
        }
    }

    public final void d() {
        this.a.e.b(this.a.G());
    }

    public final void a(int i) {
        this.a.e.c(i);
    }

    public final void e() {
        this.a.e.g();
    }
}
