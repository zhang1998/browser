package android.support.v4.view.b;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
public final class w {
    private static final af a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new r();
        } else if (VERSION.SDK_INT >= 14) {
            a = new n();
        } else {
            a = new ai();
        }
    }

    public static ad a(AccessibilityEvent accessibilityEvent) {
        return new ad(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        a.a(accessibilityEvent, i);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }
}
