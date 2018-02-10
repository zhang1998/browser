package android.mini.support.v4.view.a;

import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
final class b extends a {
    b() {
    }

    public final void a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public final int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
