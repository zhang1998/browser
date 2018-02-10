package android.support.v4.view.b;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: ProGuard */
class z extends m {
    z() {
    }

    public final Object a(int i, int i2) {
        return CollectionInfo.obtain(i, i2, false, 0);
    }

    public final Object a(int i) {
        return new AccessibilityAction(i, null);
    }

    public final boolean c(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
    }

    public final Object a(int i, int i2, int i3, int i4, boolean z) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z, false);
    }
}
