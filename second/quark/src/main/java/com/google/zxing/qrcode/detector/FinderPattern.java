package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i;
    }

    public final float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    final int getCount() {
        return this.count;
    }

    final boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.estimatedModuleSize);
        if (abs <= IPictureView.DEFAULT_MIN_SCALE || abs <= this.estimatedModuleSize) {
            return true;
        }
        return false;
    }

    final FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count + 1;
        return new FinderPattern(((((float) this.count) * getX()) + f2) / ((float) i), ((((float) this.count) * getY()) + f) / ((float) i), ((((float) this.count) * this.estimatedModuleSize) + f3) / ((float) i), i);
    }
}
