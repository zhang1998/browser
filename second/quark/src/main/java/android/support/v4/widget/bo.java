package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.s;
import android.support.v4.view.co;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ProGuard */
final class bo extends co {
    final /* synthetic */ SlidingPaneLayout a;
    private final Rect b = new Rect();

    bo(SlidingPaneLayout slidingPaneLayout) {
        this.a = slidingPaneLayout;
    }

    public final void a(View view, s sVar) {
        s a = s.a(sVar);
        super.a(view, a);
        Rect rect = this.b;
        a.a(rect);
        sVar.b(rect);
        a.c(rect);
        sVar.d(rect);
        sVar.c(a.d());
        sVar.a(a.j());
        sVar.b(a.k());
        sVar.c(a.l());
        sVar.h(a.i());
        sVar.f(a.g());
        sVar.a(a.b());
        sVar.b(a.c());
        sVar.d(a.e());
        sVar.e(a.f());
        sVar.g(a.h());
        sVar.a(a.a());
        s.a.b(sVar.b, s.a.r(a.b));
        a.m();
        sVar.b(SlidingPaneLayout.class.getName());
        sVar.a(view);
        ViewParent i = ViewCompat.i(view);
        if (i instanceof View) {
            sVar.c((View) i);
        }
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.a.getChildAt(i2);
            if (!b(childAt) && childAt.getVisibility() == 0) {
                ViewCompat.c(childAt, 1);
                sVar.b(childAt);
            }
        }
    }

    public final void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }

    public final boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (b(view)) {
            return false;
        }
        return super.a(viewGroup, view, accessibilityEvent);
    }

    private boolean b(View view) {
        return this.a.b(view);
    }
}
