package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: ProGuard */
public final class at {
    static final as a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new ar();
        } else {
            a = new aq();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
