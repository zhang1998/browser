package android.support.v7.widget;

/* compiled from: ProGuard */
final class w {
    long a = 0;
    w b;

    w() {
    }

    final void a(int i) {
        while (i >= 64) {
            a();
            this = this.b;
            i -= 64;
        }
        this.a |= 1 << i;
    }

    private void a() {
        if (this.b == null) {
            this.b = new w();
        }
    }

    final void b(int i) {
        while (i >= 64) {
            if (this.b != null) {
                this = this.b;
                i -= 64;
            } else {
                return;
            }
        }
        this.a &= (1 << i) ^ -1;
    }

    final boolean c(int i) {
        while (i >= 64) {
            a();
            this = this.b;
            i -= 64;
        }
        return (this.a & (1 << i)) != 0;
    }

    final void a(int i, boolean z) {
        while (true) {
            if (i >= 64) {
                a();
                this = this.b;
                i -= 64;
            } else {
                boolean z2 = (this.a & Long.MIN_VALUE) != 0;
                long j = (1 << i) - 1;
                this.a = (((j ^ -1) & this.a) << 1) | (this.a & j);
                if (z) {
                    a(i);
                } else {
                    b(i);
                }
                if (z2 || this.b != null) {
                    a();
                    this = this.b;
                    i = 0;
                    z = z2;
                } else {
                    return;
                }
            }
        }
    }

    final boolean d(int i) {
        while (i >= 64) {
            a();
            this = this.b;
            i -= 64;
        }
        long j = 1 << i;
        boolean z = (this.a & j) != 0;
        this.a &= j ^ -1;
        j--;
        this.a = Long.rotateRight((j ^ -1) & this.a, 1) | (this.a & j);
        if (this.b != null) {
            if (this.b.c(0)) {
                a(63);
            }
            this.b.d(0);
        }
        return z;
    }

    final int e(int i) {
        if (this.b == null) {
            if (i >= 64) {
                return Long.bitCount(this.a);
            }
            return Long.bitCount(this.a & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.a & ((1 << i) - 1));
        } else {
            return this.b.e(i - 64) + Long.bitCount(this.a);
        }
    }

    public final String toString() {
        return this.b == null ? Long.toBinaryString(this.a) : this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
}
