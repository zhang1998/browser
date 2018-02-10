package android.support.v4.view.b;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: ProGuard */
class j extends x {
    j() {
    }

    public final void c(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public final void d(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public final void e(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public final void f(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public final void a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public final void g(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
