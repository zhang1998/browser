package android.mini.support.v4.view;

import android.mini.support.v4.view.a.r;
import android.mini.support.v4.view.a.y;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
public class h {
    private static final d b;
    private static final Object c = b.a();
    final Object a = b.a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            b = new f();
        } else if (VERSION.SDK_INT >= 14) {
            b = new c();
        } else {
            b = new g();
        }
    }

    public static void a(View view, int i) {
        b.a(c, view, i);
    }

    public static void a(View view, AccessibilityEvent accessibilityEvent) {
        b.d(c, view, accessibilityEvent);
    }

    public static boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, view, accessibilityEvent);
    }

    public static void c(View view, AccessibilityEvent accessibilityEvent) {
        b.c(c, view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.b(c, view, accessibilityEvent);
    }

    public void a(View view, r rVar) {
        b.a(c, view, rVar);
    }

    public static boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, viewGroup, view, accessibilityEvent);
    }

    public static y a(View view) {
        return b.a(c, view);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return b.a(c, view, i, bundle);
    }
}
