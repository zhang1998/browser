package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class ei implements OnClickListener {
    final /* synthetic */ PagerTabStrip a;

    ei(PagerTabStrip pagerTabStrip) {
        this.a = pagerTabStrip;
    }

    public final void onClick(View view) {
        this.a.a.setCurrentItem(this.a.a.getCurrentItem() - 1);
    }
}
