package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.uc.imagecodec.export.IPictureView;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class da implements ej {
    WeakHashMap<View, bo> c = null;

    da() {
    }

    public boolean c(View view, int i) {
        if (view instanceof ch) {
            boolean z;
            ch chVar = (ch) view;
            int computeHorizontalScrollOffset = chVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = chVar.computeHorizontalScrollRange() - chVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange != 0) {
                if (i < 0) {
                    z = computeHorizontalScrollOffset > 0;
                } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public boolean d(View view, int i) {
        if (view instanceof ch) {
            boolean z;
            ch chVar = (ch) view;
            int computeVerticalScrollOffset = chVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = chVar.computeVerticalScrollRange() - chVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange != 0) {
                if (i < 0) {
                    z = computeVerticalScrollOffset > 0;
                } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public int u(View view) {
        return 2;
    }

    public void a(View view, co coVar) {
    }

    public boolean a(View view) {
        return false;
    }

    public boolean v(View view) {
        return false;
    }

    public void w(View view) {
        view.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    long a() {
        return 10;
    }

    public int x(View view) {
        return 0;
    }

    public void e(View view, int i) {
    }

    public float e(View view) {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public void a(View view, int i, Paint paint) {
    }

    public int f(View view) {
        return 0;
    }

    public void a(View view, Paint paint) {
    }

    public int y(View view) {
        return 0;
    }

    public ViewParent z(View view) {
        return view.getParent();
    }

    public boolean A(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public int a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int g(View view) {
        return view.getMeasuredWidth();
    }

    public int h(View view) {
        return 0;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public boolean B(View view) {
        return true;
    }

    public float i(View view) {
        return 0.0f;
    }

    public float j(View view) {
        return 0.0f;
    }

    public float k(View view) {
        return 0.0f;
    }

    public int C(View view) {
        return c.a(view);
    }

    public int D(View view) {
        return c.b(view);
    }

    public bo b(View view) {
        return new bo(view);
    }

    public void a(View view, float f) {
    }

    public void b(View view, float f) {
    }

    public void c(View view, float f) {
    }

    public void d(View view, float f) {
    }

    public void e(View view, float f) {
    }

    public int E(View view) {
        return 0;
    }

    public void n(View view) {
    }

    public void f(View view, float f) {
    }

    public float o(View view) {
        return 0.0f;
    }

    public void a(ViewGroup viewGroup) {
    }

    public boolean F(View view) {
        return false;
    }

    public void l(View view) {
    }

    public void a(View view, b bVar) {
    }

    public g a(View view, g gVar) {
        return gVar;
    }

    public g b(View view, g gVar) {
        return gVar;
    }

    public void m(View view) {
    }

    public void a(View view, boolean z) {
    }

    public boolean p(View view) {
        if (view instanceof eb) {
            return ((eb) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public void q(View view) {
        if (view instanceof eb) {
            ((eb) view).stopNestedScroll();
        }
    }

    public boolean t(View view) {
        return false;
    }

    public void a(View view, int i, int i2) {
    }

    public ColorStateList r(View view) {
        return view instanceof e ? ((e) view).getSupportBackgroundTintList() : null;
    }

    public void a(View view, ColorStateList colorStateList) {
        if (view instanceof e) {
            ((e) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public void a(View view, Mode mode) {
        if (view instanceof e) {
            ((e) view).setSupportBackgroundTintMode(mode);
        }
    }

    public Mode s(View view) {
        return view instanceof e ? ((e) view).getSupportBackgroundTintMode() : null;
    }

    public boolean c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public boolean d(View view) {
        return view.getWindowToken() != null;
    }

    public void a(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    public void b(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }
}
