package android.mini.support.v4.view;

import android.view.VelocityTracker;

/* compiled from: ProGuard */
final class aq implements as {
    aq() {
    }

    public final float a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity();
    }

    public final float b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity();
    }
}
