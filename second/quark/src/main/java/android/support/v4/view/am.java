package android.support.v4.view;

import android.view.VelocityTracker;

/* compiled from: ProGuard */
final class am implements dy {
    am() {
    }

    public final float a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    public final float b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
