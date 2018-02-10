package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class cb extends DataSetObserver implements cg, ef {
    final /* synthetic */ PagerTitleStrip a;
    private int b;

    private cb(PagerTitleStrip pagerTitleStrip) {
        this.a = pagerTitleStrip;
    }

    public final void a(int i, float f) {
        if (f > 0.5f) {
            i++;
        }
        this.a.a(i, f, false);
    }

    public final void a() {
        float f = 0.0f;
        if (this.b == 0) {
            PagerTitleStrip pagerTitleStrip = this.a;
            int currentItem = this.a.a.getCurrentItem();
            this.a.a.getAdapter();
            pagerTitleStrip.a(currentItem);
            if (this.a.g >= 0.0f) {
                f = this.a.g;
            }
            this.a.a(this.a.a.getCurrentItem(), f, true);
        }
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(dr drVar, dr drVar2) {
        this.a.a(drVar, drVar2);
    }

    public final void onChanged() {
        float f = 0.0f;
        PagerTitleStrip pagerTitleStrip = this.a;
        int currentItem = this.a.a.getCurrentItem();
        this.a.a.getAdapter();
        pagerTitleStrip.a(currentItem);
        if (this.a.g >= 0.0f) {
            f = this.a.g;
        }
        this.a.a(this.a.a.getCurrentItem(), f, true);
    }
}
