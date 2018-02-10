package android.mini.support.v7.widget;

import android.util.SparseIntArray;

/* compiled from: ProGuard */
public abstract class t {
    final SparseIntArray a = new SparseIntArray();
    private boolean b = false;

    final int b(int i, int i2) {
        if (!this.b) {
            return a(i, i2);
        }
        int i3 = this.a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = a(i, i2);
        this.a.put(i, i3);
        return i3;
    }

    public int a(int i, int i2) {
        if (1 == i2) {
            return 0;
        }
        int size;
        int i3;
        int i4;
        if (this.b && this.a.size() > 0) {
            size = this.a.size() - 1;
            i3 = 0;
            while (i3 <= size) {
                int i5 = (i3 + size) >>> 1;
                if (this.a.keyAt(i5) < i) {
                    i3 = i5 + 1;
                } else {
                    size = i5 - 1;
                }
            }
            size = i3 - 1;
            if (size < 0 || size >= this.a.size()) {
                size = -1;
            } else {
                size = this.a.keyAt(size);
            }
            if (size >= 0) {
                i3 = this.a.get(size) + 1;
                size++;
                i4 = size;
                size = i3;
                for (i3 = i4; i3 < i; i3++) {
                    size++;
                    if (size == i2) {
                        size = 0;
                    } else if (size > i2) {
                        size = 1;
                    }
                }
                if (size + 1 > i2) {
                    return size;
                }
                return 0;
            }
        }
        size = 0;
        i3 = 0;
        i4 = size;
        size = i3;
        for (i3 = i4; i3 < i; i3++) {
            size++;
            if (size == i2) {
                size = 0;
            } else if (size > i2) {
                size = 1;
            }
        }
        if (size + 1 > i2) {
            return 0;
        }
        return size;
    }

    public static int c(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i4++;
            if (i4 == i2) {
                i3++;
                i4 = 0;
            } else if (i4 > i2) {
                i4 = 1;
                i3++;
            }
        }
        if (i4 + 1 > i2) {
            return i3 + 1;
        }
        return i3;
    }
}
