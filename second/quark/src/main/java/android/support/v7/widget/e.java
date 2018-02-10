package android.support.v7.widget;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ RecyclerView a;

    e(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void run() {
        if (this.a.g && !this.a.isLayoutRequested()) {
            if (this.a.h) {
                this.a.I = true;
            } else {
                this.a.j();
            }
        }
    }
}
