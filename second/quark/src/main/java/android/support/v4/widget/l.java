package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* compiled from: ProGuard */
public final class l {
    Object a;
    ac b;

    public static l a(Context context, Interpolator interpolator) {
        return new l(VERSION.SDK_INT, context, interpolator);
    }

    private l(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.b = new bq();
        } else if (i >= 9) {
            this.b = new bd();
        } else {
            this.b = new ax();
        }
        this.a = this.b.a(context, interpolator);
    }

    public final boolean a() {
        return this.b.a(this.a);
    }

    public final int b() {
        return this.b.b(this.a);
    }

    public final int c() {
        return this.b.c(this.a);
    }

    public final int d() {
        return this.b.g(this.a);
    }

    public final int e() {
        return this.b.h(this.a);
    }

    public final float f() {
        return this.b.d(this.a);
    }

    public final boolean g() {
        return this.b.e(this.a);
    }

    public final void a(int i, int i2, int i3, int i4, int i5) {
        this.b.a(this.a, i, i2, i3, i4, i5);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.b.a(this.a, i, i2, i3, i4);
    }

    public final boolean a(int i, int i2, int i3) {
        return this.b.b(this.a, i, i2, i3);
    }

    public final void h() {
        this.b.f(this.a);
    }
}
