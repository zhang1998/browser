package android.support.v7.widget;

/* compiled from: ProGuard */
final class dx implements Runnable {
    final /* synthetic */ SearchView a;

    dx(SearchView searchView) {
        this.a = searchView;
    }

    public final void run() {
        if (this.a.A != null && (this.a.A instanceof di)) {
            this.a.A.a(null);
        }
    }
}
