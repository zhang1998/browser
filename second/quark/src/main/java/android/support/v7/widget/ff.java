package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.g;
import android.support.v7.c.h;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: ProGuard */
public final class ff {
    private final ImageView a;
    private final fb b;

    public ff(ImageView imageView, fb fbVar) {
        this.a = imageView;
        this.b = fbVar;
    }

    public final void a(AttributeSet attributeSet, int i) {
        dh a = dh.a(this.a.getContext(), attributeSet, h.AppCompatImageView, i);
        try {
            Drawable b = a.b(h.AppCompatImageView_android_src);
            if (b != null) {
                this.a.setImageDrawable(b);
            }
            int e = a.e(h.AppCompatImageView_srcCompat, -1);
            if (e != -1) {
                b = this.b.a(this.a.getContext(), e, false);
                if (b != null) {
                    this.a.setImageDrawable(b);
                }
            }
            b = this.a.getDrawable();
            if (b != null) {
                cb.b(b);
            }
            a.a.recycle();
        } catch (Throwable th) {
            a.a.recycle();
        }
    }

    public final void a(int i) {
        if (i != 0) {
            Drawable a;
            if (this.b != null) {
                a = this.b.a(this.a.getContext(), i, false);
            } else {
                a = g.a(this.a.getContext(), i);
            }
            if (a != null) {
                cb.b(a);
            }
            this.a.setImageDrawable(a);
            return;
        }
        this.a.setImageDrawable(null);
    }
}
