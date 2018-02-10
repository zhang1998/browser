package android.mini.support.v4.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* compiled from: ProGuard */
public final class k {
    public Object a;
    public g b;

    public static k a(Context context, Interpolator interpolator) {
        return new k(VERSION.SDK_INT, context, interpolator);
    }

    private k(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.b = new j();
        } else if (i >= 9) {
            this.b = new i();
        } else {
            this.b = new h();
        }
        this.a = this.b.a(context, interpolator);
    }

    public final void a() {
        this.b.f(this.a);
    }
}
