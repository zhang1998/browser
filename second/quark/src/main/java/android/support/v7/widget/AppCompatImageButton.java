package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.e;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* compiled from: ProGuard */
public class AppCompatImageButton extends ImageButton implements e {
    private fc a;
    private ff b;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(fw.a(context), attributeSet, i);
        fb a = fb.a();
        this.a = new fc(this, a);
        this.a.a(attributeSet, i);
        this.b = new ff(this, a);
        this.b.a(attributeSet, i);
    }

    public void setImageResource(@DrawableRes int i) {
        this.b.a(i);
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a != null) {
            this.a.b(null);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }

    @Nullable
    public Mode getSupportBackgroundTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
    }
}
