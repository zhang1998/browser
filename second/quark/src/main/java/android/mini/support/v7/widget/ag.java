package android.mini.support.v7.widget;

/* compiled from: ProGuard */
final class ag implements Runnable {
    final /* synthetic */ RecyclerView a;

    ag(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void run() {
        if (this.a.h && !this.a.isLayoutRequested()) {
            if (!this.a.I) {
                this.a.requestLayout();
            } else if (this.a.i) {
                this.a.L = true;
            } else {
                this.a.j();
            }
        }
    }
}
