package android.mini.support.v7.widget;

/* compiled from: ProGuard */
final class as implements aq {
    final /* synthetic */ RecyclerView a;

    private as(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a(bf bfVar) {
        bfVar.a(true);
        if (bfVar.g != null && bfVar.h == null) {
            bfVar.g = null;
        }
        bfVar.h = null;
        if (!bf.g(bfVar) && !RecyclerView.c(this.a, bfVar.a) && bfVar.n()) {
            this.a.removeDetachedView(bfVar.a, false);
        }
    }
}
