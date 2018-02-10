package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: ProGuard */
class p implements v {
    p() {
    }

    public void a(SlidingPaneLayout slidingPaneLayout, View view) {
        ViewCompat.a(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
