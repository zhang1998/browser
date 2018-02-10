package com.tencent.tinker.c.a;

import java.io.IOException;
import java.util.Arrays;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class ai {
    public final ah a = new ah(0, true);
    public final ah b = new ah(1, true);
    public final ah c = new ah(2, true);
    public final ah d = new ah(3, true);
    public final ah e = new ah(4, true);
    public final ah f = new ah(5, true);
    public final ah g = new ah(6, true);
    public final ah h = new ah(SpdyProtocol.SLIGHTSSL_0_RTT_MODE, true);
    public final ah i = new ah(4097, true);
    public final ah j = new ah(4098, true);
    public final ah k = new ah(4099, true);
    public final ah l = new ah(SpdyProtocol.SLIGHTSSL_1_RTT_MODE, false);
    public final ah m = new ah(8193, true);
    public final ah n = new ah(8194, false);
    public final ah o = new ah(8195, false);
    public final ah p = new ah(8196, false);
    public final ah q = new ah(8197, false);
    public final ah r = new ah(8198, true);
    public final ah[] s = new ah[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r};
    public int t;
    public byte[] u = new byte[20];
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    final void a(q qVar) throws IOException {
        int i;
        int i2 = qVar.b.getInt();
        int i3 = 0;
        ah ahVar = null;
        while (i3 < i2) {
            short s = qVar.b.getShort();
            qVar.b.getShort();
            for (ah ahVar2 : this.s) {
                if (ahVar2.a == s) {
                    i = qVar.b.getInt();
                    int i4 = qVar.b.getInt();
                    if ((ahVar2.c == 0 || ahVar2.c == i) && (ahVar2.d == -1 || ahVar2.d == i4)) {
                        ahVar2.c = i;
                        ahVar2.d = i4;
                        if (ahVar == null || ahVar.d <= ahVar2.d) {
                            i3++;
                            ahVar = ahVar2;
                        } else {
                            throw new v("Map is unsorted at " + ahVar + ", " + ahVar2);
                        }
                    }
                    throw new v("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: " + s);
        }
        this.a.d = 0;
        Arrays.sort(this.s);
        for (i = 1; i < this.s.length; i++) {
            if (this.s[i].d == -1) {
                this.s[i].d = this.s[i - 1].d;
            }
        }
    }

    public final void a() {
        int i = this.v;
        for (int length = this.s.length - 1; length >= 0; length--) {
            ah ahVar = this.s[length];
            if (ahVar.d != -1) {
                if (ahVar.d > i) {
                    throw new v("Map is unsorted at " + ahVar);
                }
                ahVar.e = i - ahVar.d;
                i = ahVar.d;
            }
        }
        this.z = (((((this.a.e + this.b.e) + this.c.e) + this.d.e) + this.e.e) + this.f.e) + this.g.e;
        this.y = this.v - this.z;
    }

    public final void b(q qVar) throws IOException {
        int i = 0;
        for (ah a : this.s) {
            if (a.a()) {
                i++;
            }
        }
        qVar.d(i);
        for (ah ahVar : this.s) {
            if (ahVar.a()) {
                qVar.a(ahVar.a);
                qVar.a((short) 0);
                qVar.d(ahVar.c);
                qVar.d(ahVar.d);
            }
        }
    }
}
