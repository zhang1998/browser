package android.support.v4.widget;

/* compiled from: ProGuard */
final class bb implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar a;

    bb(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.a = contentLoadingProgressBar;
    }

    public final void run() {
        this.a.c = false;
        if (!this.a.d) {
            this.a.a = System.currentTimeMillis();
            this.a.setVisibility(0);
        }
    }
}
