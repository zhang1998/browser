package android.support.v7.graphics;

/* compiled from: ProGuard */
final class e implements c {
    e() {
    }

    public final boolean a(float[] fArr) {
        boolean z;
        if (fArr[2] >= 0.95f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (fArr[2] <= 0.05f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (fArr[0] < 10.0f || fArr[0] > 37.0f || fArr[1] > 0.82f) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return true;
                }
            }
        }
        return false;
    }
}
