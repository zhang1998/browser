package android.mini.support.v4.view;

import android.mini.support.v4.view.a.r;
import android.mini.support.v4.view.a.y;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
final class e implements m {
    final /* synthetic */ h a;
    final /* synthetic */ f b;

    e(f fVar, h hVar) {
        this.b = fVar;
        this.a = hVar;
    }

    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return h.b(view, accessibilityEvent);
    }

    public final void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.d(view, accessibilityEvent);
    }

    public final void a(View view, Object obj) {
        this.a.a(view, new r(obj));
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        h.c(view, accessibilityEvent);
    }

    public final boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return h.a(viewGroup, view, accessibilityEvent);
    }

    public final void a(View view, int i) {
        h.a(view, i);
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        h.a(view, accessibilityEvent);
    }

    public final Object a(View view) {
        y a = h.a(view);
        if (a != null) {
            return a.a;
        }
        return null;
    }

    public final boolean a(View view, int i, Bundle bundle) {
        return this.a.a(view, i, bundle);
    }
}
