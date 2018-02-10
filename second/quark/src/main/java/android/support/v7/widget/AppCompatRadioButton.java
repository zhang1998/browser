package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.g;
import android.support.v4.widget.b;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* compiled from: ProGuard */
public class AppCompatRadioButton extends RadioButton implements b {
    private fb a;
    private cu b;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(fw.a(context), attributeSet, i);
        this.a = fb.a();
        this.b = new cu(this, this.a);
        this.b.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.b != null) {
            this.b.a();
        }
    }

    public void setButtonDrawable(@DrawableRes int i) {
        setButtonDrawable(this.a != null ? this.a.a(getContext(), i, false) : g.a(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.b != null ? this.b.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportButtonTintList() {
        if (this.b != null) {
            return this.b.a;
        }
        return null;
    }

    public void setSupportButtonTintMode(@Nullable Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    @Nullable
    public Mode getSupportButtonTintMode() {
        if (this.b != null) {
            return this.b.b;
        }
        return null;
    }
}
