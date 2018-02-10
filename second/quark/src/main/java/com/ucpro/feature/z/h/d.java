package com.ucpro.feature.z.h;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.ucpro.base.system.b;
import com.ucpro.feature.inputenhance.a.a;
import com.ucpro.feature.z.h.a.e;
import com.ucpro.feature.z.h.a.j;
import com.ucweb.common.util.c;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
final class d implements OnGlobalLayoutListener {
    final /* synthetic */ i a;
    private boolean b = false;
    private boolean c = false;
    private int d = b.a.g();

    d(i iVar) {
        this.a = iVar;
    }

    public final void a() {
        this.b = false;
        this.c = false;
        this.d = b.a.g();
    }

    public final void onGlobalLayout() {
        boolean z = true;
        if (this.a.c.getVisibility() == 0) {
            int height = a.a(this.a.b).height();
            boolean z2 = ((float) height) < ((float) b.a.g()) * 0.8f;
            new StringBuilder("onGlobalLayout2 : ").append(height).append("  ").append(z2);
            j b;
            if (z2) {
                b = this.a.c;
                boolean z3 = this.b;
                e eVar = b.a;
                if (eVar.o != height) {
                    eVar.o = height;
                    com.ucweb.common.util.j.a.a("WindowHeightWithKeybord", height);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (eVar.l != null) {
                    eVar.l.u = true;
                    if (eVar.j) {
                        c.b(eVar.l == eVar.m);
                        eVar.l.a(height);
                        c.b(eVar.l == eVar.m);
                        eVar.l.a();
                        eVar.j = false;
                        eVar.k = false;
                    } else if (eVar.k) {
                        if (eVar.l == eVar.n) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        c.b(z2);
                        eVar.l.a(height);
                        c.b(eVar.l == eVar.n);
                        eVar.l.a();
                        eVar.k = false;
                        eVar.j = false;
                    } else if (!z3 || r0) {
                        eVar.a((height - eVar.a.getMeasuredHeight()) - eVar.b.getMeasuredHeight(), true);
                    }
                }
                this.b = true;
                this.a.i.d = true;
                this.c = true;
                return;
            }
            if (this.d == height) {
                z = false;
            }
            if (Math.abs(this.d - height) == f.b(this.a.b)) {
                z = false;
            }
            this.d = height;
            if (this.c) {
                b = this.a.c;
                boolean z4 = this.b;
                e eVar2 = b.a;
                if (z4 || r1) {
                    eVar2.a(eVar2.getMeasuredHeight() - eVar2.a.getMeasuredHeight(), false);
                }
            }
            this.b = false;
            this.a.i.d = false;
        }
    }
}
