package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

/* compiled from: ProGuard */
class bm extends bd {
    bm() {
    }

    public final void n(View view) {
        view.requestApplyInsets();
    }

    public final void f(View view, float f) {
        view.setElevation(f);
    }

    public final float o(View view) {
        return view.getElevation();
    }

    public final void a(View view, b bVar) {
        if (bVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new ac(bVar));
        }
    }

    public final boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public final void q(View view) {
        view.stopNestedScroll();
    }

    public final ColorStateList r(View view) {
        return view.getBackgroundTintList();
    }

    public final void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public final void a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public final Mode s(View view) {
        return view.getBackgroundTintMode();
    }

    public final g a(View view, g gVar) {
        if (!(gVar instanceof ae)) {
            return gVar;
        }
        WindowInsets windowInsets = ((ae) gVar).a;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        return onApplyWindowInsets != windowInsets ? new ae(onApplyWindowInsets) : gVar;
    }

    public final g b(View view, g gVar) {
        if (!(gVar instanceof ae)) {
            return gVar;
        }
        WindowInsets windowInsets = ((ae) gVar).a;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        return dispatchApplyWindowInsets != windowInsets ? new ae(dispatchApplyWindowInsets) : gVar;
    }

    public void a(View view, int i) {
        Object obj;
        Rect a = ad.a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        i.b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    public void b(View view, int i) {
        Object obj;
        Rect a = ad.a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        i.a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }
}
