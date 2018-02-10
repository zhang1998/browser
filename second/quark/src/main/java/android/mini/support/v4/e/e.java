package android.mini.support.v4.e;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class e {
    private static final c b;
    private Object a;

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new d();
        } else if (VERSION.SDK_INT >= 14) {
            b = new b();
        } else {
            b = new a();
        }
    }

    public e(Context context) {
        this.a = b.a(context);
    }

    public final void a(int i, int i2) {
        b.a(this.a, i, i2);
    }

    public final boolean a() {
        return b.a(this.a);
    }

    public final void b() {
        b.b(this.a);
    }

    @Deprecated
    public final boolean a(float f) {
        return b.a(this.a, f);
    }

    public final boolean a(float f, float f2) {
        return b.a(this.a, f, f2);
    }

    public final boolean c() {
        return b.c(this.a);
    }

    public final boolean a(int i) {
        return b.a(this.a, i);
    }

    public final boolean a(Canvas canvas) {
        return b.a(this.a, canvas);
    }
}
