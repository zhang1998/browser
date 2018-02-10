package android.support.v4.view;

/* compiled from: ProGuard */
final class ap implements Runnable {
    final /* synthetic */ ViewPager a;

    ap(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void run() {
        this.a.setScrollState(0);
        this.a.b();
    }
}
