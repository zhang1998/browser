package com.taobao.weex.c.b;

import java.util.Arrays;

/* compiled from: ProGuard */
public final class m {
    public d a = d.INHERIT;
    public e b = e.COLUMN;
    public f c = f.FLEX_START;
    public b d = b.FLEX_START;
    public b e = b.STRETCH;
    public b f = b.AUTO;
    public l g = l.RELATIVE;
    public n h = n.NOWRAP;
    public float i = 0.0f;
    public r j = new r();
    public r k = new r();
    public r l = new r();
    public float[] m = new float[4];
    public float[] n = new float[2];
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;

    m() {
        this.j.a();
        this.k.a();
        this.l.a();
        Arrays.fill(this.m, Float.NaN);
        Arrays.fill(this.n, Float.NaN);
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
    }

    public final String toString() {
        return "direction =" + this.a + "\nflexDirection =" + this.b + "\njustifyContent=" + this.c + "\nalignContent =" + this.d + "\nalignItems =" + this.e + "\nalignSelf =" + this.f + "\npositionType =" + this.g + "\nflexWrap =" + this.h + "\nflex =" + this.i + "\nmargin =" + this.j + "\npadding =" + this.k + "\nborder =" + this.l + "\nposition[POSITION_TOP] =" + this.m[1] + "\nposition[POSITION_BOTTOM] =" + this.m[3] + "\nposition[POSITION_LEFT] =" + this.m[0] + "\nposition[POSITION_RIGHT] =" + this.m[2] + "\nposition[DIMENSION_WIDTH] =" + this.m[0] + "\nposition[DIMENSION_HEIGHT] =" + this.m[1] + "\nminWidth =" + this.o + "\nminHeight =" + this.p + "\nmaxWidth =" + this.q + "\nmaxHeight =" + this.r + "\n";
    }
}
