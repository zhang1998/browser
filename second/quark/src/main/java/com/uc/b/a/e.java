package com.uc.b.a;

/* compiled from: ProGuard */
abstract class e extends d {
    abstract boolean c();

    private e() {
    }

    public void a(float... fArr) {
        int i = 2;
        int length = fArr.length;
        if (length >= 2) {
            float f = fArr[0];
            float f2 = fArr[1];
            this.c.moveTo(f, f2);
            a(f, f2);
            while (i < length) {
                int i2 = i + 1;
                f2 = fArr[i];
                i = i2 + 1;
                f = fArr[i2];
                this.c.lineTo(f2, f);
                a(f2, f);
            }
        }
        if (c()) {
            this.c.close();
        }
    }
}
