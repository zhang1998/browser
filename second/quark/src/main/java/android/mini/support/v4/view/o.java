package android.mini.support.v4.view;

/* compiled from: ProGuard */
class o implements r {
    o() {
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        Object obj = 1;
        Object obj2 = (i3 & 1) != 0 ? 1 : null;
        int i6 = i4 | i5;
        if ((i6 & 1) == 0) {
            obj = null;
        }
        if (obj2 != null) {
            if (obj == null) {
                return i & (i6 ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        } else if (obj != null) {
            return i & (i3 ^ -1);
        } else {
            return i;
        }
    }

    public int a(int i) {
        int i2;
        if ((i & 192) != 0) {
            i2 = i | 1;
        } else {
            i2 = i;
        }
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    public boolean b(int i) {
        if (a(a(a(i) & 247, 1, 1, 64, 128), 1, 2, 16, 32) == 1) {
            return true;
        }
        return false;
    }

    public boolean c(int i) {
        return (a(i) & 247) == 0;
    }
}
