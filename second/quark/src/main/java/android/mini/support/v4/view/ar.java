package android.mini.support.v4.view;

import android.view.VelocityTracker;

/* compiled from: ProGuard */
final class ar implements as {
    ar() {
    }

    public final float a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    public final float b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
