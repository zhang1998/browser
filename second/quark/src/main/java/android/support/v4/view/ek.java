package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: ProGuard */
class ek implements bp {
    ek() {
    }

    public boolean a(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof bg) {
            return ((bg) viewParent).onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public void b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof bg) {
            ((bg) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }

    public void a(ViewParent viewParent, View view) {
        if (viewParent instanceof bg) {
            ((bg) viewParent).onStopNestedScroll(view);
        }
    }

    public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof bg) {
            ((bg) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof bg) {
            ((bg) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (viewParent instanceof bg) {
            return ((bg) viewParent).onNestedFling(view, f, f2, z);
        }
        return false;
    }

    public boolean a(ViewParent viewParent, View view, float f, float f2) {
        if (viewParent instanceof bg) {
            return ((bg) viewParent).onNestedPreFling(view, f, f2);
        }
        return false;
    }
}
