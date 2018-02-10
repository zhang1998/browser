package com.UCMobile.Apollo.util;

/* compiled from: ProGuard */
public final class c {
    public byte[] a;
    public int b;
    public int c;

    public final String a() {
        if (this.c - this.b == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != (byte) 10 && this.a[i] != (byte) 13) {
            i++;
        }
        if (i - this.b >= 3 && this.a[this.b] == (byte) -17 && this.a[this.b + 1] == (byte) -69 && this.a[this.b + 2] == (byte) -65) {
            this.b += 3;
        }
        String str = new String(this.a, this.b, i - this.b);
        this.b = i;
        if (this.b == this.c) {
            return str;
        }
        if (this.a[this.b] == (byte) 13) {
            this.b++;
            if (this.b == this.c) {
                return str;
            }
        }
        if (this.a[this.b] == (byte) 10) {
            this.b++;
        }
        return str;
    }
}
