package com.ucpro.feature.bookmarkhis.a.b;

import com.ucpro.feature.bookmarkhis.a.a.a;

/* compiled from: ProGuard */
public final class b implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ f c;

    public b(f fVar, d dVar, Runnable runnable) {
        this.c = fVar;
        this.a = dVar;
        this.b = runnable;
    }

    public final void run() {
        int i = this.a.b;
        this.c.b.a.a(i).remove(this.a.c);
        if (this.c.b.a.a(i).size() == 0) {
            a aVar = this.c.b.a;
            aVar.a.remove(i);
            aVar.b.remove(i);
        }
        this.c.b.notifyDataSetChanged();
        if (this.c.b.a.b.size() == 0) {
            this.c.b();
        }
        if (this.b != null) {
            this.b.run();
        }
    }
}
