package android.mini.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
public final class e {
    private static final d a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new b();
        } else if (VERSION.SDK_INT >= 14) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static ak a(AccessibilityEvent accessibilityEvent) {
        return new ak(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        a.a(accessibilityEvent, i);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }
}
