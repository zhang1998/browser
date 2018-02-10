package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class ec extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private ec(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void onChanged() {
        this.a.a();
    }

    public final void onInvalidated() {
        this.a.a();
    }
}
