package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ab b;

    u(ab abVar, ArrayList arrayList) {
        this.b = abVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            bh bhVar = (bh) it.next();
            ItemAnimator itemAnimator = this.b;
            bo q = ViewCompat.q(bhVar.a);
            itemAnimator.j.add(bhVar);
            q.a((float) IPictureView.DEFAULT_MIN_SCALE).a(itemAnimator.c).a(new ao(itemAnimator, bhVar, q)).b();
        }
        this.a.clear();
        this.b.g.remove(this.a);
    }
}
