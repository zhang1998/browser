package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.b.aj;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: ProGuard */
final class cz extends aq {
    cz() {
    }

    public final Object a(co coVar) {
        return new y(new cn(this, coVar));
    }

    public final aj a(Object obj, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new aj(accessibilityNodeProvider);
        }
        return null;
    }

    public final boolean a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
