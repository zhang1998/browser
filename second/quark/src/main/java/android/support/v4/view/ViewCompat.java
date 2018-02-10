package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class ViewCompat {
    static final ej a;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface ScrollIndicators {
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new av();
        } else if (i >= 21) {
            a = new bm();
        } else if (i >= 19) {
            a = new bd();
        } else if (i >= 17) {
            a = new dh();
        } else if (i >= 16) {
            a = new dd();
        } else if (i >= 15) {
            a = new cp();
        } else if (i >= 14) {
            a = new aw();
        } else if (i >= 11) {
            a = new bh();
        } else if (i >= 9) {
            a = new cu();
        } else if (i >= 7) {
            a = new dp();
        } else {
            a = new da();
        }
    }

    public static boolean a(View view, int i) {
        return a.c(view, i);
    }

    public static boolean b(View view, int i) {
        return a.d(view, i);
    }

    public static int a(View view) {
        return a.u(view);
    }

    public static void a(View view, co coVar) {
        a.a(view, coVar);
    }

    public static boolean b(View view) {
        return a.a(view);
    }

    public static boolean c(View view) {
        return a.v(view);
    }

    public static void d(View view) {
        a.w(view);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static int e(View view) {
        return a.x(view);
    }

    public static void c(View view, int i) {
        a.e(view, i);
    }

    public static float f(View view) {
        return a.e(view);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static int g(View view) {
        return a.f(view);
    }

    public static void a(View view, Paint paint) {
        a.a(view, paint);
    }

    public static int h(View view) {
        return a.y(view);
    }

    public static ViewParent i(View view) {
        return a.z(view);
    }

    public static boolean j(View view) {
        return a.A(view);
    }

    public static int a(int i, int i2, int i3) {
        return a.a(i, i2, i3);
    }

    public static int k(View view) {
        return a.g(view);
    }

    public static int l(View view) {
        return a.h(view);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        a.b(view, i, i2, i3, i4);
    }

    public static float m(View view) {
        return a.i(view);
    }

    public static float n(View view) {
        return a.j(view);
    }

    public static int o(View view) {
        return a.C(view);
    }

    public static int p(View view) {
        return a.D(view);
    }

    public static bo q(View view) {
        return a.b(view);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void b(View view, float f) {
        a.b(view, f);
    }

    public static void c(View view, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        a.c(view, f);
    }

    public static void d(View view, float f) {
        a.d(view, f);
    }

    public static void e(View view, float f) {
        a.e(view, f);
    }

    public static float r(View view) {
        return a.k(view);
    }

    public static void f(View view, float f) {
        a.f(view, f);
    }

    public static float s(View view) {
        return a.o(view);
    }

    public static int t(View view) {
        return a.E(view);
    }

    public static void u(View view) {
        a.n(view);
    }

    public static void a(ViewGroup viewGroup) {
        a.a(viewGroup);
    }

    public static boolean v(View view) {
        return a.F(view);
    }

    public static void w(View view) {
        a.l(view);
    }

    public static void a(View view, b bVar) {
        a.a(view, bVar);
    }

    public static g a(View view, g gVar) {
        return a.a(view, gVar);
    }

    public static g b(View view, g gVar) {
        return a.b(view, gVar);
    }

    public static void x(View view) {
        a.m(view);
    }

    public static void a(View view, boolean z) {
        a.a(view, z);
    }

    public static boolean y(View view) {
        return a.B(view);
    }

    public static ColorStateList z(View view) {
        return a.r(view);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static Mode A(View view) {
        return a.s(view);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static boolean B(View view) {
        return a.p(view);
    }

    public static void C(View view) {
        a.q(view);
    }

    public static boolean D(View view) {
        return a.c(view);
    }

    public static void d(View view, int i) {
        a.b(view, i);
    }

    public static void e(View view, int i) {
        a.a(view, i);
    }

    public static boolean E(View view) {
        return a.d(view);
    }

    public static boolean F(View view) {
        return a.t(view);
    }

    public static void f(@NonNull View view, int i) {
        a.a(view, i, 3);
    }
}
