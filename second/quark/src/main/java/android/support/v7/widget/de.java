package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: ProGuard */
class de {
    private static final int[] b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] c = new int[]{k.textAllCaps};
    final TextView a;
    private dl d;
    private dl e;
    private dl f;
    private dl g;

    static de a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new dn(textView);
        }
        return new de(textView);
    }

    de(TextView textView) {
        this.a = textView;
    }

    void a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.a.getContext();
        fb a = fb.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.d = a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.e = a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f = a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.g = a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, h.TextAppearance);
                if (obtainStyledAttributes2.hasValue(h.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(h.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                a(z);
            }
        }
    }

    final void a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, c);
        if (obtainStyledAttributes.hasValue(0)) {
            a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    final void a(boolean z) {
        this.a.setTransformationMethod(z ? new a(this.a.getContext()) : null);
    }

    void a() {
        if (this.d != null || this.e != null || this.f != null || this.g != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.d);
            a(compoundDrawables[1], this.e);
            a(compoundDrawables[2], this.f);
            a(compoundDrawables[3], this.g);
        }
    }

    final void a(Drawable drawable, dl dlVar) {
        if (drawable != null && dlVar != null) {
            fb.a(drawable, dlVar, this.a.getDrawableState());
        }
    }

    protected static dl a(Context context, fb fbVar, int i) {
        ColorStateList b = fbVar.b(context, i);
        if (b == null) {
            return null;
        }
        dl dlVar = new dl();
        dlVar.d = true;
        dlVar.a = b;
        return dlVar;
    }
}
