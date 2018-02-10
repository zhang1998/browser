package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class s implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ab b;

    s(ab abVar, ArrayList arrayList) {
        this.b = abVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            bm bmVar = (bm) it.next();
            ItemAnimator itemAnimator = this.b;
            bh bhVar = bmVar.a;
            int i = bmVar.b;
            int i2 = bmVar.c;
            int i3 = bmVar.d;
            int i4 = bmVar.e;
            View view = bhVar.a;
            i = i3 - i;
            i2 = i4 - i2;
            if (i != 0) {
                ViewCompat.q(view).b(0.0f);
            }
            if (i2 != 0) {
                ViewCompat.q(view).c(0.0f);
            }
            bo q = ViewCompat.q(view);
            itemAnimator.k.add(bhVar);
            q.a(itemAnimator.e).a(new bg(itemAnimator, bhVar, i, i2, q)).b();
        }
        this.a.clear();
        this.b.h.remove(this.a);
    }
}
