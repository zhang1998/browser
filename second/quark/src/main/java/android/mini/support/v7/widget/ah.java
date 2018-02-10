package android.mini.support.v7.widget;

/* compiled from: ProGuard */
final class ah implements Runnable {
    final /* synthetic */ RecyclerView a;

    ah(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void run() {
        if (this.a.o != null) {
            this.a.o.a();
        }
        this.a.al = false;
    }
}
