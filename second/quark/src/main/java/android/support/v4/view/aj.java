package android.support.v4.view;

import android.support.v4.view.b.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
final class aj implements r {
    final /* synthetic */ co a;
    final /* synthetic */ aq b;

    aj(aq aqVar, co coVar) {
        this.b = aqVar;
        this.a = coVar;
    }

    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.c(view, accessibilityEvent);
    }

    public final void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.a(view, accessibilityEvent);
    }

    public final void a(View view, Object obj) {
        this.a.a(view, new s(obj));
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        co.d(view, accessibilityEvent);
    }

    public final boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(viewGroup, view, accessibilityEvent);
    }

    public final void a(View view, int i) {
        co.a(view, i);
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        co.b(view, accessibilityEvent);
    }
}
