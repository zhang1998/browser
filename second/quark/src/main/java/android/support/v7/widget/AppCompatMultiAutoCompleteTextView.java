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
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* compiled from: ProGuard */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements e {
    private static final int[] TINT_ATTRS = new int[]{16843126};
    private fc mBackgroundTintHelper;
    private fb mDrawableManager;
    private de mTextHelper;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(fw.a(context), attributeSet, i);
        this.mDrawableManager = fb.a();
        dh a = dh.a(getContext(), attributeSet, TINT_ATTRS, i);
        if (a.e(0)) {
            setDropDownBackgroundDrawable(a.a(0));
        }
        a.a.recycle();
        this.mBackgroundTintHelper = new fc(this, this.mDrawableManager);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = de.a((TextView) this);
        this.mTextHelper.a(attributeSet, i);
        this.mTextHelper.a();
    }

    public void setDropDownBackgroundResource(@DrawableRes int i) {
        if (this.mDrawableManager != null) {
            setDropDownBackgroundDrawable(this.mDrawableManager.a(getContext(), i, false));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.b(null);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.a() : null;
    }

    public void setSupportBackgroundTintMode(@Nullable Mode mode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.a(mode);
        }
    }

    @Nullable
    public Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.c();
        }
        if (this.mTextHelper != null) {
            this.mTextHelper.a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.mTextHelper != null) {
            this.mTextHelper.a(context, i);
        }
    }
}
