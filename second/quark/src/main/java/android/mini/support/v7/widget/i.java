package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.mini.support.v7.widget.RecyclerView.ItemAnimator;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ r b;

    i(r rVar, ArrayList arrayList) {
        this.b = rVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            bf bfVar = (bf) it.next();
            ItemAnimator itemAnimator = this.b;
            cs n = ViewCompat.n(bfVar.a);
            itemAnimator.d.add(bfVar);
            n.a((float) IPictureView.DEFAULT_MIN_SCALE).a(itemAnimator.i).a(new k(itemAnimator, bfVar, n)).b();
        }
        this.a.clear();
        this.b.a.remove(this.a);
    }
}
