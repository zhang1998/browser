package android.mini.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: ProGuard */
class f extends n {
    f() {
    }

    public final Object a(int i, int i2) {
        return CollectionInfo.obtain(i, i2, false, 0);
    }

    public final Object a(int i, int i2, int i3, int i4, boolean z) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z, false);
    }
}
