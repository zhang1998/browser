package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* compiled from: ProGuard */
public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] a = new int[]{16843016};
    private fb b;
    private de c;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(fw.a(context), attributeSet, i);
        this.c = de.a((TextView) this);
        this.c.a(attributeSet, i);
        this.c.a();
        this.b = fb.a();
        dh a = dh.a(getContext(), attributeSet, a, i);
        setCheckMarkDrawable(a.a(0));
        a.a.recycle();
    }

    public void setCheckMarkDrawable(@DrawableRes int i) {
        if (this.b != null) {
            setCheckMarkDrawable(this.b.a(getContext(), i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c != null) {
            this.c.a();
        }
    }
}
