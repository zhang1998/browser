package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.View;

/* compiled from: ProGuard */
public abstract class bc {
    private final bb a = new bb();
    public int g = -1;
    RecyclerView h;
    LayoutManager i;
    boolean j;
    boolean k;
    View l;

    protected abstract void a();

    protected abstract void a(int i, int i2, bb bbVar);

    protected abstract void a(View view, bb bbVar);

    static /* synthetic */ void a(bc bcVar, int i, int i2) {
        boolean z = false;
        RecyclerView recyclerView = bcVar.h;
        if (!bcVar.k || bcVar.g == -1 || recyclerView == null) {
            bcVar.c();
        }
        bcVar.j = false;
        if (bcVar.l != null) {
            if (RecyclerView.d(bcVar.l) == bcVar.g) {
                View view = bcVar.l;
                State state = recyclerView.p;
                bcVar.a(view, bcVar.a);
                bb.a(bcVar.a, recyclerView);
                bcVar.c();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                bcVar.l = null;
            }
        }
        if (bcVar.k) {
            State state2 = recyclerView.p;
            bcVar.a(i, i2, bcVar.a);
            if (bcVar.a.a >= 0) {
                z = true;
            }
            bb.a(bcVar.a, recyclerView);
            if (!z) {
                return;
            }
            if (bcVar.k) {
                bcVar.j = true;
                recyclerView.ai.a();
                return;
            }
            bcVar.c();
        }
    }

    protected final void c() {
        if (this.k) {
            a();
            this.h.p.a = -1;
            this.l = null;
            this.g = -1;
            this.j = false;
            this.k = false;
            LayoutManager.a(this.i, this);
            this.i = null;
            this.h = null;
        }
    }
}
