package com.bumptech.glide.b;

import android.support.annotation.Nullable;
import java.io.IOException;

/* compiled from: ProGuard */
public final class e extends IOException {
    private final int a;

    public e(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i) {
        this(str, i, (byte) 0);
    }

    private e(String str, int i, @Nullable byte b) {
        super(str, null);
        this.a = i;
    }
}
