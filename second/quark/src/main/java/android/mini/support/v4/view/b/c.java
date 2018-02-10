package android.mini.support.v4.view.b;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: ProGuard */
public final class c {
    public static Interpolator a(float f, float f2, float f3, float f4) {
        if (VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f, f2, f3, f4);
        }
        return new d(f, f2, f3, f4);
    }
}
