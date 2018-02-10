package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.mini.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ r b;

    h(r rVar, ArrayList arrayList) {
        this.b = rVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            View view;
            o oVar = (o) it.next();
            ItemAnimator itemAnimator = this.b;
            bf bfVar = oVar.a;
            View view2 = bfVar == null ? null : bfVar.a;
            bf bfVar2 = oVar.b;
            if (bfVar2 != null) {
                view = bfVar2.a;
            } else {
                view = null;
            }
            if (view2 != null) {
                cs a = ViewCompat.n(view2).a(itemAnimator.l);
                itemAnimator.g.add(oVar.a);
                a.b((float) (oVar.e - oVar.c));
                a.c((float) (oVar.f - oVar.d));
                a.a(0.0f).a(new m(itemAnimator, oVar, a)).b();
            }
            if (view != null) {
                a = ViewCompat.n(view);
                itemAnimator.g.add(oVar.b);
                a.b(0.0f).c(0.0f).a(itemAnimator.l).a((float) IPictureView.DEFAULT_MIN_SCALE).a(new n(itemAnimator, oVar, a, view)).b();
            }
        }
        this.a.clear();
        this.b.c.remove(this.a);
    }
}
