package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.b.a.q;
import android.support.v4.widget.y;
import android.support.v7.c.h;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: ProGuard */
final class cu {
    ColorStateList a = null;
    Mode b = null;
    private final CompoundButton c;
    private final fb d;
    private boolean e = false;
    private boolean f = false;
    private boolean g;

    cu(CompoundButton compoundButton, fb fbVar) {
        this.c = compoundButton;
        this.d = fbVar;
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.c.getContext().obtainStyledAttributes(attributeSet, h.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(h.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(h.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.c.setButtonDrawable(this.d.a(this.c.getContext(), resourceId, false));
                }
            }
            if (obtainStyledAttributes.hasValue(h.CompoundButton_buttonTint)) {
                y.a(this.c, obtainStyledAttributes.getColorStateList(h.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(h.CompoundButton_buttonTintMode)) {
                y.a(this.c, cb.a(obtainStyledAttributes.getInt(h.CompoundButton_buttonTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void a(ColorStateList colorStateList) {
        this.a = colorStateList;
        this.e = true;
        b();
    }

    final void a(@Nullable Mode mode) {
        this.b = mode;
        this.f = true;
        b();
    }

    final void a() {
        if (this.g) {
            this.g = false;
            return;
        }
        this.g = true;
        b();
    }

    private void b() {
        Drawable a = y.a(this.c);
        if (a == null) {
            return;
        }
        if (this.e || this.f) {
            a = q.f(a).mutate();
            if (this.e) {
                q.a(a, this.a);
            }
            if (this.f) {
                q.a(a, this.b);
            }
            if (a.isStateful()) {
                a.setState(this.c.getDrawableState());
            }
            this.c.setButtonDrawable(a);
        }
    }

    final int a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = y.a(this.c);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
