package com.ucweb.common.util;

import android.util.DisplayMetrics;
import android.util.TypedValue;

/* compiled from: ProGuard */
public final class h {
    public static DisplayMetrics a;

    public static int a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, a);
    }
}
