package android.mini.support.v4.view;

import android.mini.support.annotation.Nullable;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class ba extends ay {
    static Field b;
    static boolean c = false;

    ba() {
    }

    public final void a(View view, @Nullable h hVar) {
        Object obj;
        if (hVar == null) {
            obj = null;
        } else {
            obj = hVar.a;
        }
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public final boolean b(View view) {
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            if (b.get(view) != null) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }

    public final cs o(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        cs csVar = (cs) this.a.get(view);
        if (csVar != null) {
            return csVar;
        }
        csVar = new cs(view);
        this.a.put(view, csVar);
        return csVar;
    }

    public final boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public final boolean b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
