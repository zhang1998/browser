package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.b.aj;
import android.support.v4.view.b.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
public class co {
    private static final bs a;
    private static final Object b = a.a();
    final Object c = a.a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new cz();
        } else if (VERSION.SDK_INT >= 14) {
            a = new aq();
        } else {
            a = new an();
        }
    }

    public static void a(View view, int i) {
        a.a(b, view, i);
    }

    public static void b(View view, AccessibilityEvent accessibilityEvent) {
        a.d(b, view, accessibilityEvent);
    }

    public boolean c(View view, AccessibilityEvent accessibilityEvent) {
        return a.a(b, view, accessibilityEvent);
    }

    public static void d(View view, AccessibilityEvent accessibilityEvent) {
        a.c(b, view, accessibilityEvent);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        a.b(b, view, accessibilityEvent);
    }

    public void a(View view, s sVar) {
        a.a(b, view, sVar);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return a.a(b, viewGroup, view, accessibilityEvent);
    }

    public static aj a(View view) {
        return a.a(b, view);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return a.a(b, view, i, bundle);
    }
}
