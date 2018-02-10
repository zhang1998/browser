package android.mini.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: ProGuard */
final class ac extends AccessibilityNodeProvider {
    final /* synthetic */ ad a;

    ac(ad adVar) {
        this.a = adVar;
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        this.a.c();
        return null;
    }

    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.a.b();
    }

    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.a();
    }

    public final AccessibilityNodeInfo findFocus(int i) {
        this.a.d();
        return null;
    }
}
