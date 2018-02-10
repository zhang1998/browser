package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: ProGuard */
public final class dh {
    public final TypedArray a;
    private final Context b;

    public static dh a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new dh(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static dh a(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new dh(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    private dh(Context context, TypedArray typedArray) {
        this.b = context;
        this.a = typedArray;
    }

    public final Drawable a(int i) {
        if (this.a.hasValue(i)) {
            int resourceId = this.a.getResourceId(i, 0);
            if (resourceId != 0) {
                return fb.a().a(this.b, resourceId, false);
            }
        }
        return this.a.getDrawable(i);
    }

    public final Drawable b(int i) {
        if (this.a.hasValue(i)) {
            int resourceId = this.a.getResourceId(i, 0);
            if (resourceId != 0) {
                return fb.a().a(this.b, resourceId, true);
            }
        }
        return null;
    }

    public final CharSequence c(int i) {
        return this.a.getText(i);
    }

    public final boolean a(int i, boolean z) {
        return this.a.getBoolean(i, z);
    }

    public final int a(int i, int i2) {
        return this.a.getInt(i, i2);
    }

    public final int d(int i) {
        return this.a.getColor(i, -1);
    }

    public final int b(int i, int i2) {
        return this.a.getDimensionPixelOffset(i, i2);
    }

    public final int c(int i, int i2) {
        return this.a.getDimensionPixelSize(i, i2);
    }

    public final int d(int i, int i2) {
        return this.a.getLayoutDimension(i, i2);
    }

    public final int e(int i, int i2) {
        return this.a.getResourceId(i, i2);
    }

    public final boolean e(int i) {
        return this.a.hasValue(i);
    }
}
