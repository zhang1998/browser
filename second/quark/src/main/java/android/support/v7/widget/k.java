package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: ProGuard */
final class k implements p {
    final /* synthetic */ RecyclerView a;

    k(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a(bh bhVar, @NonNull m mVar, @Nullable m mVar2) {
        this.a.b.b(bhVar);
        RecyclerView.a(this.a, bhVar, mVar, mVar2);
    }

    public final void b(bh bhVar, m mVar, m mVar2) {
        RecyclerView.b(this.a, bhVar, mVar, mVar2);
    }

    public final void c(bh bhVar, @NonNull m mVar, @NonNull m mVar2) {
        bhVar.a(false);
        if (this.a.i) {
            if (this.a.n.a(bhVar, bhVar, mVar, mVar2)) {
                this.a.s();
            }
        } else if (this.a.n.c(bhVar, mVar, mVar2)) {
            this.a.s();
        }
    }

    public final void a(bh bhVar) {
        this.a.f.a(bhVar.a, this.a.b);
    }
}
