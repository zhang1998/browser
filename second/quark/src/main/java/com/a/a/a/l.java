package com.a.a.a;

/* compiled from: ProGuard */
public final class l {
    public final String a;
    public final byte b;
    public final short c;

    public l() {
        this("", (byte) 0, (short) 0);
    }

    public l(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public final String toString() {
        return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
    }
}
