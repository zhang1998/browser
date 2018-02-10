package android.support.v4.view.b;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: ProGuard */
final class d extends AccessibilityNodeProvider {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        this.a.a();
        return null;
    }

    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.a.c();
    }

    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.b();
    }

    public final AccessibilityNodeInfo findFocus(int i) {
        this.a.d();
        return null;
    }
}
