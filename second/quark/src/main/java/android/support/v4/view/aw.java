package android.support.v4.view;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class aw extends bh {
    static Field a;
    static boolean b = false;

    aw() {
    }

    public final void a(View view, @Nullable co coVar) {
        Object obj;
        if (coVar == null) {
            obj = null;
        } else {
            obj = coVar.c;
        }
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public final boolean a(View view) {
        if (b) {
            return false;
        }
        if (a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                b = true;
                return false;
            }
        }
        try {
            if (a.get(view) != null) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            b = true;
            return false;
        }
    }

    public final bo b(View view) {
        if (this.c == null) {
            this.c = new WeakHashMap();
        }
        bo boVar = (bo) this.c.get(view);
        if (boVar != null) {
            return boVar;
        }
        boVar = new bo(view);
        this.c.put(view, boVar);
        return boVar;
    }

    public final boolean c(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public final boolean d(View view, int i) {
        return view.canScrollVertically(i);
    }
}
