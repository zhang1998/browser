package android.support.v4.view.b;

import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
final class r extends n {
    r() {
    }

    public final void a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public final int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
