package com.ui.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;

/* compiled from: ProGuard */
public class EditText extends TextView {
    public EditText(Context context) {
        this(context, null);
    }

    public EditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public EditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected boolean getDefaultEditable() {
        return true;
    }

    protected h getDefaultMovementMethod() {
        return a.b();
    }

    public Editable getText() {
        return (Editable) super.getText();
    }

    public final void a(CharSequence charSequence, int i) {
        super.a(charSequence, p.c);
    }

    public void a(int i, int i2) {
        Selection.setSelection(getText(), i, i2);
    }

    public void setSelection(int i) {
        Selection.setSelection(getText(), i);
    }

    public void setEllipsize(TruncateAt truncateAt) {
        if (truncateAt == TruncateAt.MARQUEE) {
            throw new IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
        }
        super.setEllipsize(truncateAt);
    }
}
