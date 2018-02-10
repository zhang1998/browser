package com.ucpro.ui.widget.viewpager;

import android.view.View;
import com.ucpro.ui.widget.viewpager.ProViewPager.LayoutParams;
import java.util.Comparator;

/* compiled from: ProGuard */
final class e implements Comparator<View> {
    e() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
        if (layoutParams.a != layoutParams2.a) {
            return layoutParams.a ? 1 : -1;
        } else {
            return layoutParams.e - layoutParams2.e;
        }
    }
}
