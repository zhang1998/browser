package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.c.h;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: ProGuard */
final class fc {
    private final View a;
    private final fb b;
    private dl c;
    private dl d;
    private dl e;

    fc(View view, fb fbVar) {
        this.a = view;
        this.b = fbVar;
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, h.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(h.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.b.b(this.a.getContext(), obtainStyledAttributes.getResourceId(h.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(h.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.a(this.a, obtainStyledAttributes.getColorStateList(h.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(h.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.a(this.a, cb.a(obtainStyledAttributes.getInt(h.ViewBackgroundHelper_backgroundTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void a(int i) {
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
    }

    final void a(ColorStateList colorStateList) {
        if (this.d == null) {
            this.d = new dl();
        }
        this.d.a = colorStateList;
        this.d.d = true;
        c();
    }

    final ColorStateList a() {
        return this.d != null ? this.d.a : null;
    }

    final void a(Mode mode) {
        if (this.d == null) {
            this.d = new dl();
        }
        this.d.b = mode;
        this.d.c = true;
        c();
    }

    final Mode b() {
        return this.d != null ? this.d.b : null;
    }

    final void c() {
        boolean z = false;
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (VERSION.SDK_INT == 21) {
                if (this.e == null) {
                    this.e = new dl();
                }
                dl dlVar = this.e;
                dlVar.a = null;
                dlVar.d = false;
                dlVar.b = null;
                dlVar.c = false;
                ColorStateList z2 = ViewCompat.z(this.a);
                if (z2 != null) {
                    dlVar.d = true;
                    dlVar.a = z2;
                }
                Mode A = ViewCompat.A(this.a);
                if (A != null) {
                    dlVar.c = true;
                    dlVar.b = A;
                }
                if (dlVar.d || dlVar.c) {
                    fb.a(background, dlVar, this.a.getDrawableState());
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (this.d != null) {
                fb.a(background, this.d, this.a.getDrawableState());
            } else if (this.c != null) {
                fb.a(background, this.c, this.a.getDrawableState());
            }
        }
    }

    final void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.c == null) {
                this.c = new dl();
            }
            this.c.a = colorStateList;
            this.c.d = true;
        } else {
            this.c = null;
        }
        c();
    }
}
