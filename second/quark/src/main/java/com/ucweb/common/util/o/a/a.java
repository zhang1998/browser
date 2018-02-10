package com.ucweb.common.util.o.a;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: ProGuard */
public final class a extends Writer implements Serializable {
    private final StringBuilder a;

    public a() {
        this.a = new StringBuilder();
    }

    public a(byte b) {
        this.a = new StringBuilder(4);
    }

    public final Writer append(char c) {
        this.a.append(c);
        return this;
    }

    public final Writer append(CharSequence charSequence) {
        this.a.append(charSequence);
        return this;
    }

    public final Writer append(CharSequence charSequence, int i, int i2) {
        this.a.append(charSequence, i, i2);
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final void write(String str) {
        if (str != null) {
            this.a.append(str);
        }
    }

    public final void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.a.append(cArr, i, i2);
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
