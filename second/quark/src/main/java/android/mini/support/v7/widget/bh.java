package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.a.p;
import android.mini.support.v4.view.a.r;
import android.mini.support.v4.view.h;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class bh extends h {
    final RecyclerView b;
    final h c = new bg(this);

    public bh(RecyclerView recyclerView) {
        this.b = recyclerView;
    }

    final boolean a() {
        RecyclerView recyclerView = this.b;
        return !recyclerView.h || recyclerView.j || recyclerView.c.d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.View r8, int r9, android.os.Bundle r10) {
        /*
        r7 = this;
        r5 = -1;
        r2 = 1;
        r1 = 0;
        r0 = super.a(r8, r9, r10);
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        r1 = r2;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r7.a();
        if (r0 != 0) goto L_0x000a;
    L_0x0011:
        r0 = r7.b;
        r0 = r0.getLayoutManager();
        if (r0 == 0) goto L_0x000a;
    L_0x0019:
        r0 = r7.b;
        r4 = r0.getLayoutManager();
        r0 = r4.q;
        r0 = r0.b;
        r0 = r4.q;
        r0 = r0.p;
        r0 = r4.q;
        if (r0 == 0) goto L_0x000a;
    L_0x002b:
        switch(r9) {
            case 4096: goto L_0x0069;
            case 8192: goto L_0x003b;
            default: goto L_0x002e;
        };
    L_0x002e:
        r0 = r1;
        r3 = r1;
    L_0x0030:
        if (r3 != 0) goto L_0x0034;
    L_0x0032:
        if (r0 == 0) goto L_0x000a;
    L_0x0034:
        r1 = r4.q;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x000a;
    L_0x003b:
        r0 = r4.q;
        r0 = android.mini.support.v4.view.ViewCompat.b(r0, r5);
        if (r0 == 0) goto L_0x009a;
    L_0x0043:
        r0 = r4.z;
        r3 = r4.p();
        r0 = r0 - r3;
        r3 = r4.r();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x0050:
        r3 = r4.q;
        r3 = android.mini.support.v4.view.ViewCompat.a(r3, r5);
        if (r3 == 0) goto L_0x0095;
    L_0x0058:
        r3 = r4.y;
        r5 = r4.o();
        r3 = r3 - r5;
        r5 = r4.q();
        r3 = r3 - r5;
        r3 = -r3;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x0030;
    L_0x0069:
        r0 = r4.q;
        r0 = android.mini.support.v4.view.ViewCompat.b(r0, r2);
        if (r0 == 0) goto L_0x0098;
    L_0x0071:
        r0 = r4.z;
        r3 = r4.p();
        r0 = r0 - r3;
        r3 = r4.r();
        r0 = r0 - r3;
    L_0x007d:
        r3 = r4.q;
        r3 = android.mini.support.v4.view.ViewCompat.a(r3, r2);
        if (r3 == 0) goto L_0x0095;
    L_0x0085:
        r3 = r4.y;
        r5 = r4.o();
        r3 = r3 - r5;
        r5 = r4.q();
        r3 = r3 - r5;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x0030;
    L_0x0095:
        r3 = r0;
        r0 = r1;
        goto L_0x0030;
    L_0x0098:
        r0 = r1;
        goto L_0x007d;
    L_0x009a:
        r0 = r1;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v7.widget.bh.a(android.view.View, int, android.os.Bundle):boolean");
    }

    public final void a(View view, r rVar) {
        super.a(view, rVar);
        rVar.a(RecyclerView.class.getName());
        if (!a() && this.b.getLayoutManager() != null) {
            LayoutManager layoutManager = this.b.getLayoutManager();
            ax axVar = layoutManager.q.b;
            State state = layoutManager.q.p;
            if (ViewCompat.b(layoutManager.q, -1) || ViewCompat.a(layoutManager.q, -1)) {
                rVar.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                rVar.a(true);
            }
            if (ViewCompat.b(layoutManager.q, 1) || ViewCompat.a(layoutManager.q, 1)) {
                rVar.a((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                rVar.a(true);
            }
            r.a.a(rVar.b, new p(r.a.a(layoutManager.a(axVar, state), layoutManager.b(axVar, state))).a);
        }
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }
}
