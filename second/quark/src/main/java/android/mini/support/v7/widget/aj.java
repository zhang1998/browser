package android.mini.support.v7.widget;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;

/* compiled from: ProGuard */
final class aj implements br {
    final /* synthetic */ RecyclerView a;

    aj(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a(bf bfVar, @NonNull ar arVar, @Nullable ar arVar2) {
        this.a.b.b(bfVar);
        RecyclerView.a(this.a, bfVar, arVar, arVar2);
    }

    public final void b(bf bfVar, ar arVar, ar arVar2) {
        RecyclerView.b(this.a, bfVar, arVar, arVar2);
    }

    public final void c(bf bfVar, @NonNull ar arVar, @NonNull ar arVar2) {
        bfVar.a(false);
        if (this.a.j) {
            if (this.a.o.a(bfVar, bfVar, arVar, arVar2)) {
                this.a.s();
            }
        } else if (this.a.o.c(bfVar, arVar, arVar2)) {
            this.a.s();
        }
    }

    public final void a(bf bfVar) {
        this.a.f.a(bfVar.a, this.a.b);
    }
}
