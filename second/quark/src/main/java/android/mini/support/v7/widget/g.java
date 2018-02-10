package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.mini.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ r b;

    g(r rVar, ArrayList arrayList) {
        this.b = rVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            ItemAnimator itemAnimator = this.b;
            bf bfVar = pVar.a;
            int i = pVar.b;
            int i2 = pVar.c;
            int i3 = pVar.d;
            int i4 = pVar.e;
            View view = bfVar.a;
            i = i3 - i;
            i2 = i4 - i2;
            if (i != 0) {
                ViewCompat.n(view).b(0.0f);
            }
            if (i2 != 0) {
                ViewCompat.n(view).c(0.0f);
            }
            cs n = ViewCompat.n(view);
            itemAnimator.e.add(bfVar);
            n.a(itemAnimator.k).a(new l(itemAnimator, bfVar, i, i2, n)).b();
        }
        this.a.clear();
        this.b.b.remove(this.a);
    }
}
