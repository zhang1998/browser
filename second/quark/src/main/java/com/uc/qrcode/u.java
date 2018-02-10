package com.uc.qrcode;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* compiled from: ProGuard */
final class u implements ResultPointCallback {
    private final ViewfinderView a;

    u(ViewfinderView viewfinderView) {
        this.a = viewfinderView;
    }

    public final void foundPossibleResultPoint(ResultPoint resultPoint) {
        ViewfinderView.a();
    }
}
