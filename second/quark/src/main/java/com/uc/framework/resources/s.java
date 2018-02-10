package com.uc.framework.resources;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import java.util.Hashtable;

/* compiled from: ProGuard */
public final class s extends Drawable {
    Hashtable<String, Drawable> a = new Hashtable();
    long b;
    boolean c;

    public final void a(String str, Drawable drawable) {
        if (drawable == null) {
            new StringBuilder("add drawable ").append(str).append(" is null !!");
        }
        this.a.put(str, drawable);
    }

    public final void draw(Canvas canvas) {
    }

    public final int getOpacity() {
        return 0;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.c = true;
    }
}
