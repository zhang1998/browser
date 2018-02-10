package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.k;
import android.support.v4.view.b.s;
import android.support.v4.view.co;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class ag extends co {
    final RecyclerView a;
    final co b = new l(this);

    public ag(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    final boolean a() {
        RecyclerView recyclerView = this.a;
        return !recyclerView.g || recyclerView.i || recyclerView.c.d();
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
        r0 = r7.a;
        r0 = r0.getLayoutManager();
        if (r0 == 0) goto L_0x000a;
    L_0x0019:
        r0 = r7.a;
        r4 = r0.getLayoutManager();
        r0 = r4.b;
        r0 = r0.b;
        r0 = r4.b;
        r0 = r0.p;
        r0 = r4.b;
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
        r1 = r4.b;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x000a;
    L_0x003b:
        r0 = r4.b;
        r0 = android.support.v4.view.ViewCompat.b(r0, r5);
        if (r0 == 0) goto L_0x009a;
    L_0x0043:
        r0 = r4.k;
        r3 = r4.i();
        r0 = r0 - r3;
        r3 = r4.k();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x0050:
        r3 = r4.b;
        r3 = android.support.v4.view.ViewCompat.a(r3, r5);
        if (r3 == 0) goto L_0x0095;
    L_0x0058:
        r3 = r4.j;
        r5 = r4.h();
        r3 = r3 - r5;
        r5 = r4.j();
        r3 = r3 - r5;
        r3 = -r3;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x0030;
    L_0x0069:
        r0 = r4.b;
        r0 = android.support.v4.view.ViewCompat.b(r0, r2);
        if (r0 == 0) goto L_0x0098;
    L_0x0071:
        r0 = r4.k;
        r3 = r4.i();
        r0 = r0 - r3;
        r3 = r4.k();
        r0 = r0 - r3;
    L_0x007d:
        r3 = r4.b;
        r3 = android.support.v4.view.ViewCompat.a(r3, r2);
        if (r3 == 0) goto L_0x0095;
    L_0x0085:
        r3 = r4.j;
        r5 = r4.h();
        r3 = r3 - r5;
        r5 = r4.j();
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ag.a(android.view.View, int, android.os.Bundle):boolean");
    }

    public final void a(View view, s sVar) {
        super.a(view, sVar);
        sVar.b(RecyclerView.class.getName());
        if (!a() && this.a.getLayoutManager() != null) {
            LayoutManager layoutManager = this.a.getLayoutManager();
            az azVar = layoutManager.b.b;
            v vVar = layoutManager.b.p;
            if (ViewCompat.b(layoutManager.b, -1) || ViewCompat.a(layoutManager.b, -1)) {
                sVar.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                sVar.i(true);
            }
            if (ViewCompat.b(layoutManager.b, 1) || ViewCompat.a(layoutManager.b, 1)) {
                sVar.a((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                sVar.i(true);
            }
            s.a.a(sVar.b, new k(s.a.a(layoutManager.b(azVar, vVar), layoutManager.c(azVar, vVar))).a);
        }
    }

    public final void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }
}
