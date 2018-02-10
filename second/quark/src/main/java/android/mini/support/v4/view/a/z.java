package android.mini.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: ProGuard */
final class z extends AccessibilityNodeProvider {
    final /* synthetic */ aa a;

    z(aa aaVar) {
        this.a = aaVar;
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
}
