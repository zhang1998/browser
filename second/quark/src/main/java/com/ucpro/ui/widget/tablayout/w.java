package com.ucpro.ui.widget.tablayout;

import com.ucpro.ui.widget.viewpager.n;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class w implements n {
    int a;
    int b;
    private final WeakReference<ProTabLayout> c;

    public w(ProTabLayout proTabLayout) {
        this.c = new WeakReference(proTabLayout);
    }

    public final void b(int i) {
        this.a = this.b;
        this.b = i;
    }

    public final void a(int i, float f) {
        boolean z = false;
        ProTabLayout proTabLayout = (ProTabLayout) this.c.get();
        if (proTabLayout != null) {
            boolean z2 = this.b != 2 || this.a == 1;
            if (!(this.b == 2 && this.a == 0)) {
                z = true;
            }
            proTabLayout.a(i, f, z2, z);
        }
    }

    public final void a(int i) {
        ProTabLayout proTabLayout = (ProTabLayout) this.c.get();
        if (proTabLayout != null && proTabLayout.getSelectedTabPosition() != i) {
            boolean z = this.b == 0 || (this.b == 2 && this.a == 0);
            proTabLayout.b(proTabLayout.a(i), z);
        }
    }
}
