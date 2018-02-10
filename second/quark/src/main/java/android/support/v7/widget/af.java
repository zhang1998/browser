package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;
import android.view.View;

/* compiled from: ProGuard */
public abstract class af {
    int a;
    boolean b;
    boolean c;
    View d;
    private RecyclerView e;
    private LayoutManager f;
    private final ar g;

    static /* synthetic */ void a(af afVar) {
        boolean z = false;
        RecyclerView recyclerView = afVar.e;
        if (!afVar.c || afVar.a == -1 || recyclerView == null) {
            afVar.a();
        }
        afVar.b = false;
        if (afVar.d != null) {
            if (RecyclerView.c(afVar.d) == afVar.a) {
                v vVar = recyclerView.p;
                ar.a(afVar.g, recyclerView);
                afVar.a();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                afVar.d = null;
            }
        }
        if (afVar.c) {
            vVar = recyclerView.p;
            if (afVar.g.a >= 0) {
                z = true;
            }
            ar.a(afVar.g, recyclerView);
            if (!z) {
                return;
            }
            if (afVar.c) {
                afVar.b = true;
                recyclerView.o.a();
                return;
            }
            afVar.a();
        }
    }

    protected final void a() {
        if (this.c) {
            this.e.p.a = -1;
            this.d = null;
            this.a = -1;
            this.b = false;
            this.c = false;
            LayoutManager.a(this.f, this);
            this.f = null;
            this.e = null;
        }
    }
}
