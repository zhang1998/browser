package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.b.h;
import android.support.v4.view.b.s;
import android.support.v4.view.ca;
import android.support.v4.view.co;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: ProGuard */
final class am extends co {
    final /* synthetic */ DrawerLayout a;
    private final Rect b = new Rect();

    am(DrawerLayout drawerLayout) {
        this.a = drawerLayout;
    }

    public final void a(View view, s sVar) {
        if (DrawerLayout.j) {
            super.a(view, sVar);
        } else {
            s a = s.a(sVar);
            super.a(view, a);
            sVar.a(view);
            ViewParent i = ViewCompat.i(view);
            if (i instanceof View) {
                sVar.c((View) i);
            }
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
            a.m();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.f(childAt)) {
                    sVar.b(childAt);
                }
            }
        }
        sVar.b(DrawerLayout.class.getName());
        sVar.a(false);
        sVar.b(false);
        sVar.a(h.a);
        sVar.a(h.b);
    }

    public final void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    public final boolean c(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.c(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View a = this.a.d();
        if (a != null) {
            Object obj;
            int c = this.a.c(a);
            View view2 = this.a;
            c = ca.a(c, ViewCompat.h(view2));
            if (c == 3) {
                obj = view2.f;
            } else if (c == 5) {
                obj = view2.g;
            } else {
                obj = null;
            }
            if (obj != null) {
                text.add(obj);
            }
        }
        return true;
    }

    public final boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.j || DrawerLayout.f(view)) {
            return super.a(viewGroup, view, accessibilityEvent);
        }
        return false;
    }
}
