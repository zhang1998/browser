package com.uc.weex.component.e;

import android.view.View;

/* compiled from: ProGuard */
final class b implements r {
    final /* synthetic */ c a;

    private b(c cVar) {
        this.a = cVar;
    }

    public final View a(View view) {
        for (int size = this.a.e.size() - 1; size > 0; size--) {
            if (this.a.e.get(size) == view) {
                return (View) this.a.e.get(size - 1);
            }
        }
        return null;
    }

    public final void a() {
        this.a.a(this.a.k);
        this.a.b.b();
        l lVar = this.a.b;
        if (((c) lVar.getHostView()).a() == 0) {
            com.uc.weex.component.b.a();
            lVar.getInstanceId();
        }
    }
}
