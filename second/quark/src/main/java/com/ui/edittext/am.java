package com.ui.edittext;

import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;

/* compiled from: ProGuard */
final class am extends aa {
    final /* synthetic */ TextView l;

    public am(TextView textView, Drawable drawable, Drawable drawable2) {
        this.l = textView;
        super(textView, drawable, drawable2);
    }

    protected final int a(int i, int i2, boolean z) {
        if (z) {
            return i2 - ((i2 - i) / 2);
        }
        return (i2 - i) / 2;
    }

    public final int d() {
        return this.l.getSelectionEnd();
    }

    public final void a(int i) {
        Selection.setSelection((Spannable) this.l.g, this.l.getSelectionStart(), i);
        a();
    }

    public final void a(float f, float f2) {
        int a = this.l.a(f, f2);
        int selectionStart = this.l.getSelectionStart();
        if (a <= selectionStart) {
            a = Math.min(selectionStart + 1, this.l.g.length());
        }
        a(a, false);
    }
}
