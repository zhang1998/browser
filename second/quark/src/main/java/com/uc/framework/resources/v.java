package com.uc.framework.resources;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
final class v extends ConstantState {
    Bitmap a;
    Rect b;
    int c;
    int d;
    Paint e;

    v(Bitmap bitmap, Rect rect) {
        this.b = new Rect();
        this.d = 119;
        this.e = new Paint(2);
        this.a = bitmap;
        this.b.set(rect);
    }

    v(v vVar, Rect rect) {
        this(vVar.a, rect);
        this.c = vVar.c;
        this.d = vVar.d;
        this.e = new Paint(vVar.e);
    }

    public final Drawable newDrawable() {
        return new w();
    }

    public final int getChangingConfigurations() {
        return this.c;
    }
}
