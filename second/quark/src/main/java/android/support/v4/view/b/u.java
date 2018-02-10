package android.support.v4.view.b;

import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: ProGuard */
class u extends o {
    u() {
    }

    public final boolean s(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public final void h(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    public final boolean t(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    public final void i(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }

    public final void b(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
    }

    public final int r(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMovementGranularities();
    }
}
