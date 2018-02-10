package com.tencent.tinker.c.c;

/* compiled from: ProGuard */
public final class a implements Cloneable {
    private static final int[] a = new int[0];
    private static final boolean[] b = new boolean[0];
    private int[] c;
    private boolean[] d;
    private int e;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.c = new int[10];
        this.d = new boolean[10];
        this.e = 0;
    }

    private static int c(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a a() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.c = (int[]) this.c.clone();
                aVar.d = (boolean[]) this.d.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void a(int i) {
        int a = a(this.c, this.e, i);
        if (a >= 0) {
            this.d[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.c;
        int i3 = this.e;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            iArr[i2] = i;
        } else {
            Object obj = new int[c(i3)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            Object obj2 = obj;
        }
        this.c = iArr;
        boolean[] zArr = this.d;
        i3 = this.e;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            obj = new boolean[c(i3)];
            System.arraycopy(zArr, 0, obj, 0, i2);
            obj[i2] = 1;
            System.arraycopy(zArr, i2, obj, i2 + 1, zArr.length - i2);
            obj2 = obj;
        }
        this.d = zArr;
        this.e++;
    }

    private static int a(int[] iArr, int i, int i2) {
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

    public final boolean b(int i) {
        return a(this.c, this.e, i) >= 0;
    }

    public final String toString() {
        if (this.e <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.c[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.d[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
