package com.ucweb.materialedittext;

import android.graphics.Color;

/* compiled from: ProGuard */
public class Colors {
    public static boolean isLight(int i) {
        return Math.sqrt(((((double) (Color.red(i) * Color.red(i))) * 0.241d) + (((double) (Color.green(i) * Color.green(i))) * 0.691d)) + (((double) (Color.blue(i) * Color.blue(i))) * 0.068d)) > 130.0d;
    }
}
