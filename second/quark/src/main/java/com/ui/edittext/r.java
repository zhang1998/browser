package com.ui.edittext;

import android.text.GetChars;
import android.text.GraphicsOperations;

/* compiled from: ProGuard */
final class r implements GetChars, GraphicsOperations, CharSequence {
    private char[] a;
    private int b;
    private int c;

    public final int length() {
        return this.c;
    }

    public final char charAt(int i) {
        return this.a[this.b + i];
    }

    public final String toString() {
        return new String(this.a, this.b, this.c);
    }

    public final CharSequence subSequence(int i, int i2) {
        if (i >= 0 && i2 >= 0 && i <= this.c && i2 <= this.c) {
            return new String(this.a, this.b + i, i2 - i);
        }
        throw new IndexOutOfBoundsException(i + ", " + i2);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0 || i2 < 0 || i > this.c || i2 > this.c) {
            throw new IndexOutOfBoundsException(i + ", " + i2);
        }
        System.arraycopy(this.a, this.b + i, cArr, i3, i2 - i);
    }
}
