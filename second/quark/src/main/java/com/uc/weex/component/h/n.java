package com.uc.weex.component.h;

/* compiled from: ProGuard */
public final class n {
    int a;
    float[] b = new float[0];

    public final void a(double d) {
        Object obj;
        float f = (float) d;
        Object obj2 = this.b;
        int i = this.a;
        if (i == obj2.length) {
            obj = new float[((i < 6 ? 12 : i >> 1) + i)];
            System.arraycopy(obj2, 0, obj, 0, i);
            this.b = obj;
        } else {
            obj = obj2;
        }
        obj[i] = f;
        this.a = i + 1;
    }
}
