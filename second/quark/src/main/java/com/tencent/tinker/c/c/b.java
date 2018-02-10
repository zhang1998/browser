package com.tencent.tinker.c.c;

/* compiled from: ProGuard */
public final class b implements Cloneable {
    private static final int[] d = new int[0];
    public int[] a;
    public int[] b;
    public int c;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.a = new int[10];
        this.b = new int[this.a.length];
        this.c = 0;
    }

    private static int b(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private b a() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.a = (int[]) this.a.clone();
                bVar.b = (int[]) this.b.clone();
                return bVar;
            } catch (CloneNotSupportedException e) {
                return bVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void a(int i, int i2) {
        int b = b(this.a, this.c, i);
        if (b >= 0) {
            this.b[b] = i2;
            return;
        }
        b ^= -1;
        this.a = a(this.a, this.c, b, i);
        this.b = a(this.b, this.c, b, i2);
        this.c++;
    }

    public final int a(int i) {
        return b(this.a, this.c, i);
    }

    private static int b(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public static int[] a(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[b(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static int[] a(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            Object obj = new int[b(i)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i3;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            return obj;
        }
    }

    public final String toString() {
        if (this.c <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.c * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.a[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.b[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
