package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class ae implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ab b;

    ae(ab abVar, ArrayList arrayList) {
        this.b = abVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            View view;
            al alVar = (al) it.next();
            ItemAnimator itemAnimator = this.b;
            bh bhVar = alVar.a;
            View view2 = bhVar == null ? null : bhVar.a;
            bh bhVar2 = alVar.b;
            if (bhVar2 != null) {
                view = bhVar2.a;
            } else {
                view = null;
            }
            if (view2 != null) {
                bo a = ViewCompat.q(view2).a(itemAnimator.f);
                itemAnimator.m.add(alVar.a);
                a.b((float) (alVar.e - alVar.c));
                a.c((float) (alVar.f - alVar.d));
                a.a(0.0f).a(new t(itemAnimator, alVar, a)).b();
            }
            if (view != null) {
                a = ViewCompat.q(view);
                itemAnimator.m.add(alVar.b);
                a.b(0.0f).c(0.0f).a(itemAnimator.f).a((float) IPictureView.DEFAULT_MIN_SCALE).a(new i(itemAnimator, alVar, a, view)).b();
            }
        }
        this.a.clear();
        this.b.i.remove(this.a);
    }
}
