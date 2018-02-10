package android.support.v4.view;

import android.view.WindowInsets;

/* compiled from: ProGuard */
final class ae extends g {
    final WindowInsets a;

    ae(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    public final int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    public final int b() {
        return this.a.getSystemWindowInsetTop();
    }

    public final int c() {
        return this.a.getSystemWindowInsetRight();
    }

    public final int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    public final boolean e() {
        return this.a.isConsumed();
    }

    public final g a(int i, int i2, int i3, int i4) {
        return new ae(this.a.replaceSystemWindowInsets(i, i2, i3, i4));
    }
}
