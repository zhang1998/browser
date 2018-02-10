package android.support.v7.widget;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ RecyclerView a;

    c(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void run() {
        if (this.a.n != null) {
            this.a.n.a();
        }
        this.a.ah = false;
    }
}
