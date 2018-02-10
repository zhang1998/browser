package android.mini.support.v4.view;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.mini.support.annotation.FloatRange;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.c.a;
import android.os.Build.VERSION;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class ViewCompat {
    static final bh a;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface AccessibilityLiveRegion {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface ImportantForAccessibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface LayerType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface LayoutDirectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface OverScroll {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface ResolvedLayoutDirectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface ScrollIndicators {
    }

    static {
        int i = VERSION.SDK_INT;
        if (a.a()) {
            a = new au();
        } else if (i >= 23) {
            a = new bg();
        } else if (i >= 21) {
            a = new bf();
        } else if (i >= 19) {
            a = new be();
        } else if (i >= 18) {
            a = new bc();
        } else if (i >= 17) {
            a = new bb();
        } else if (i >= 16) {
            a = new bd();
        } else if (i >= 15) {
            a = new az();
        } else if (i >= 14) {
            a = new ba();
        } else if (i >= 11) {
            a = new ay();
        } else if (i >= 9) {
            a = new ax();
        } else if (i >= 7) {
            a = new aw();
        } else {
            a = new av();
        }
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }

    public static boolean b(View view, int i) {
        return a.b(view, i);
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static void a(View view, h hVar) {
        a.a(view, hVar);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static void d(View view) {
        a.d(view);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static void c(View view, int i) {
        a.c(view, i);
    }

    public static float f(View view) {
        return a.f(view);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static int g(View view) {
        return a.g(view);
    }

    public static int h(View view) {
        return a.h(view);
    }

    public static float i(View view) {
        return a.j(view);
    }

    public static float j(View view) {
        return a.k(view);
    }

    @Nullable
    public static Matrix k(View view) {
        return a.l(view);
    }

    public static int l(View view) {
        return a.m(view);
    }

    public static int m(View view) {
        return a.n(view);
    }

    public static cs n(View view) {
        return a.o(view);
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

    public static void a(View view, an anVar) {
        a.a(view, anVar);
    }

    public static cy a(View view, cy cyVar) {
        return a.a(view, cyVar);
    }

    public static cy b(View view, cy cyVar) {
        return a.b(view, cyVar);
    }

    public static void o(View view) {
        a.p(view);
    }

    public static boolean p(View view) {
        return a.i(view);
    }

    public static void q(View view) {
        a.q(view);
    }

    public static boolean r(View view) {
        return a.r(view);
    }
}
