package com.taobao.weex.c.b;

import java.util.Arrays;

/* compiled from: ProGuard */
public class g {
    public float[] d = new float[4];
    public float[] e = new float[2];
    public d f = d.LTR;

    public final void a() {
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, Float.NaN);
        this.f = d.LTR;
    }

    public final void a(g gVar) {
        this.d[0] = gVar.d[0];
        this.d[1] = gVar.d[1];
        this.d[2] = gVar.d[2];
        this.d[3] = gVar.d[3];
        this.e[0] = gVar.e[0];
        this.e[1] = gVar.e[1];
        this.f = gVar.f;
    }

    public String toString() {
        return "layout: {left: " + this.d[0] + ", top: " + this.d[1] + ", width: " + this.e[0] + ", height: " + this.e[1] + ", direction: " + this.f + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (o.a(gVar.d[0], this.d[0]) && o.a(gVar.d[1], this.d[1]) && o.a(gVar.d[2], this.d[2]) && o.a(gVar.d[3], this.d[3]) && o.a(gVar.e[1], this.e[1]) && o.a(gVar.e[0], this.e[0])) {
            return true;
        }
        return false;
    }
}
