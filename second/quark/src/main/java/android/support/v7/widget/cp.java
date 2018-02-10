package android.support.v7.widget;

/* compiled from: ProGuard */
final class cp implements Runnable {
    final /* synthetic */ fm a;

    private cp(fm fmVar) {
        this.a = fmVar;
    }

    public final void run() {
        this.a.d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
