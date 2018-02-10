package com.uc.quark;

import com.uc.quark.a.m;
import com.uc.quark.b.h;
import com.uc.quark.filedownloader.ai;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class e extends ai {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ x b;

    e(x xVar, ArrayList arrayList) {
        this.b = xVar;
        this.a = arrayList;
    }

    public final void a() {
        if (!this.b.m) {
            this.b.m = true;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                m.b(new v(this, (h) it.next()));
            }
        }
    }

    public final void b() {
    }
}
