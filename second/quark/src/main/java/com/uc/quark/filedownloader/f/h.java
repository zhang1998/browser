package com.uc.quark.filedownloader.f;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: ProGuard */
public class h implements Serializable, Comparable<h> {
    static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final h d = new h((byte[]) new byte[0].clone());
    final byte[] e;
    transient int f;
    transient String g;

    public /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int c = c();
        int c2 = hVar.c();
        int min = Math.min(c, c2);
        int i = 0;
        while (i < min) {
            int a = a(i) & 255;
            int a2 = hVar.a(i) & 255;
            if (a == a2) {
                i++;
            } else if (a < a2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (c == c2) {
            return 0;
        }
        return c >= c2 ? 1 : -1;
    }

    h(byte[] bArr) {
        this.e = bArr;
    }

    public String a() {
        String str = this.g;
        if (str != null) {
            return str;
        }
        str = new String(this.e, e.a);
        this.g = str;
        return str;
    }

    public String b() {
        int i = 0;
        char[] cArr = new char[(this.e.length * 2)];
        byte[] bArr = this.e;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = c[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = c[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public h a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.e.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.e.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.e.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.e, i, obj, 0, i3);
                this(obj);
                return this;
            }
        }
    }

    public byte a(int i) {
        return this.e[i];
    }

    public int c() {
        return this.e.length;
    }

    public byte[] d() {
        return (byte[]) this.e.clone();
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.e.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && e.a(this.e, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof h) && ((h) obj).c() == this.e.length && ((h) obj).a(0, this.e, 0, this.e.length);
    }

    public int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.e);
        this.f = i;
        return i;
    }

    public String toString() {
        if (this.e.length == 0) {
            return "[size=0]";
        }
        String a = a();
        int length = a.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            if (i != 64) {
                int codePointAt = a.codePointAt(i2);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    i2 = -1;
                    break;
                }
                i++;
                i2 += Character.charCount(codePointAt);
            } else {
                break;
            }
        }
        i2 = a.length();
        if (i2 != -1) {
            String replace = a.substring(0, i2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            return i2 < a.length() ? "[size=" + this.e.length + " text=" + replace + "…]" : "[text=" + replace + "]";
        } else if (this.e.length <= 64) {
            return "[hex=" + b() + "]";
        } else {
            return "[size=" + this.e.length + " hex=" + a(0, 64).b() + "…]";
        }
    }
}
