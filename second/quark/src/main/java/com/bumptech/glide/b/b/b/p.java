package com.bumptech.glide.b.b.b;

import android.app.ActivityManager;
import android.content.Context;

/* compiled from: ProGuard */
public final class p {
    public final Context a;
    public ActivityManager b;
    public r c;
    public float d = 2.0f;
    public float e = 4.0f;
    public float f = 0.4f;
    public float g = 0.33f;
    public int h = 4194304;

    public p(Context context) {
        this.a = context;
        this.b = (ActivityManager) context.getSystemService("activity");
        this.c = new q(context.getResources().getDisplayMetrics());
    }
}
