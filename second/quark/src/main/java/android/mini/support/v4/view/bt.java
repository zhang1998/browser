package android.mini.support.v4.view;

/* compiled from: ProGuard */
final class bt implements Runnable {
    final /* synthetic */ ViewPager a;

    bt(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void run() {
        this.a.setScrollState(0);
        this.a.b();
    }
}
