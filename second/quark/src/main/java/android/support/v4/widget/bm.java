package android.support.v4.widget;

/* compiled from: ProGuard */
final class bm implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar a;

    bm(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.a = contentLoadingProgressBar;
    }

    public final void run() {
        this.a.b = false;
        this.a.a = -1;
        this.a.setVisibility(8);
    }
}
