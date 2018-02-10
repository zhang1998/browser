package android.mini.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: ProGuard */
class af extends aj {
    af() {
    }

    public final void a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public final void b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public final void a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public final void c(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
