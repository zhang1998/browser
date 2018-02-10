package android.mini.support.v4.view;

import android.mini.support.v4.view.a.y;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: ProGuard */
final class f extends c {
    f() {
    }

    public final Object a(h hVar) {
        return new l(new e(this, hVar));
    }

    public final y a(Object obj, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new y(accessibilityNodeProvider);
        }
        return null;
    }

    public final boolean a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
