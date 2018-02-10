package com.uc.apollo.media.b;

/* compiled from: ProGuard */
public final class j {
    int a;
    int b;
    int c;
    String d;

    final boolean a(int i) {
        return i >= this.b && i < this.b + this.c;
    }

    public j(int i, int i2, int i3, String str) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    public final String toString() {
        return a(false);
    }

    public final String a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("pos/dur/pre: ").append(m.a(this.b)).append('/').append(((double) this.c) / 1000.0d).append('/').append(m.a(this.a));
        String stringBuilder2 = stringBuilder.toString();
        if (!z) {
            return stringBuilder2;
        }
        StringBuilder stringBuilder3 = new StringBuilder((stringBuilder2.length() + this.d.length()) + 12);
        stringBuilder3.append(stringBuilder2).append(", url: ").append(this.d);
        return stringBuilder3.toString();
    }
}
