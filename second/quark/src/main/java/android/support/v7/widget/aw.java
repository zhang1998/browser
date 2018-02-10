package android.support.v7.widget;

/* compiled from: ProGuard */
final class aw implements ax {
    final /* synthetic */ RecyclerView a;

    private aw(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a(bh bhVar) {
        bhVar.a(true);
        if (bhVar.g != null && bhVar.h == null) {
            bhVar.g = null;
        }
        bhVar.h = null;
        if (!bh.g(bhVar) && !RecyclerView.c(this.a, bhVar.a) && bhVar.n()) {
            this.a.removeDetachedView(bhVar.a, false);
        }
    }
}
