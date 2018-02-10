package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.e;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: ProGuard */
public class AppCompatTextView extends TextView implements e {
    private fb a;
    private fc b;
    private de c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(fw.a(context), attributeSet, i);
        this.a = fb.a();
        this.b = new fc(this, this.a);
        this.b.a(attributeSet, i);
        this.c = de.a((TextView) this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.b(null);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    @Nullable
    public Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }
}
