package com.tencent.tinker.b.a.b;

import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.b.c;
import com.tencent.tinker.c.a.b.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class a {
    public static final byte[] a = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    public final b b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public byte[] u;
    private short v;
    private int w;

    public a(InputStream inputStream) throws IOException {
        this.b = new b(ByteBuffer.wrap(d.a(inputStream, WXMediaMessage.THUMB_LENGTH_LIMIT)));
        byte[] c = this.b.c(a.length);
        if (c.a(c, a) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(c));
        }
        this.v = this.b.b.getShort();
        if (c.a(this.v, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + this.v + ", expected: 2");
        }
        this.c = this.b.b.getInt();
        this.w = this.b.b.getInt();
        this.d = this.b.b.getInt();
        this.e = this.b.b.getInt();
        this.f = this.b.b.getInt();
        this.g = this.b.b.getInt();
        this.h = this.b.b.getInt();
        this.i = this.b.b.getInt();
        this.j = this.b.b.getInt();
        this.k = this.b.b.getInt();
        this.l = this.b.b.getInt();
        this.m = this.b.b.getInt();
        this.n = this.b.b.getInt();
        this.o = this.b.b.getInt();
        this.p = this.b.b.getInt();
        this.q = this.b.b.getInt();
        this.r = this.b.b.getInt();
        this.s = this.b.b.getInt();
        this.t = this.b.b.getInt();
        this.u = this.b.c(20);
        b bVar = this.b;
        bVar.b.position(this.w);
    }
}
