package com.tencent.tinker.c.a.a;

import com.tencent.tinker.c.a.aa;
import com.tencent.tinker.c.a.ab;
import com.tencent.tinker.c.a.ac;
import com.tencent.tinker.c.a.ad;
import com.tencent.tinker.c.a.ae;
import com.tencent.tinker.c.a.af;
import com.tencent.tinker.c.a.aj;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.c;
import com.tencent.tinker.c.a.d;
import com.tencent.tinker.c.a.e;
import com.tencent.tinker.c.a.f;
import com.tencent.tinker.c.a.g;
import com.tencent.tinker.c.a.h;
import com.tencent.tinker.c.a.i;
import com.tencent.tinker.c.a.j;
import com.tencent.tinker.c.a.k;
import com.tencent.tinker.c.a.l;
import com.tencent.tinker.c.a.x;
import com.tencent.tinker.c.a.z;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: ProGuard */
public class b implements a, com.tencent.tinker.c.a.b.b {
    private static final short[] a = new short[0];
    private static final j[] d = new j[0];
    private static final i[] e = new i[0];
    public ByteBuffer b;
    public int c;
    private boolean f;

    public b() {
        this.b = ByteBuffer.allocate(512);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        this.c = this.b.position();
        this.b.limit(this.b.capacity());
        this.f = true;
    }

    public b(ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        this.c = byteBuffer.limit();
        this.f = false;
    }

    public final void b(int i) {
        if (this.b.position() + i > this.b.limit() && this.f) {
            Object array = this.b.array();
            Object obj = new byte[((array.length + i) + (array.length >> 1))];
            System.arraycopy(array, 0, obj, 0, this.b.position());
            int position = this.b.position();
            this.b = ByteBuffer.wrap(obj);
            this.b.order(ByteOrder.LITTLE_ENDIAN);
            this.b.position(position);
            this.b.limit(this.b.capacity());
        }
    }

    public final byte a() {
        return this.b.get();
    }

    public final byte[] c(int i) {
        byte[] bArr = new byte[i];
        this.b.get(bArr);
        return bArr;
    }

    private short[] e(int i) {
        if (i == 0) {
            return a;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.b.getShort();
        }
        return sArr;
    }

    private int q() {
        return ab.b(this);
    }

    private int r() {
        return ab.b(this) - 1;
    }

    private int s() {
        return ab.a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tinker.c.a.af b() {
        /*
        r9 = this;
        r0 = 0;
        r8 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = r9.b;
        r2 = r1.position();
        r3 = com.tencent.tinker.c.a.ab.b(r9);	 Catch:{ UTFDataFormatException -> 0x0047 }
        r4 = new char[r3];	 Catch:{ UTFDataFormatException -> 0x0047 }
    L_0x000f:
        r1 = r9.a();	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = r1 & 255;
        r5 = (char) r1;	 Catch:{ UTFDataFormatException -> 0x0047 }
        if (r5 != 0) goto L_0x004e;
    L_0x0018:
        r1 = new java.lang.String;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r5 = 0;
        r1.<init>(r4, r5, r0);	 Catch:{ UTFDataFormatException -> 0x0047 }
        r0 = r1.length();	 Catch:{ UTFDataFormatException -> 0x0047 }
        if (r0 == r3) goto L_0x00b9;
    L_0x0024:
        r0 = new com.tencent.tinker.c.a.v;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r4 = "Declared length ";
        r2.<init>(r4);	 Catch:{ UTFDataFormatException -> 0x0047 }
        r2 = r2.append(r3);	 Catch:{ UTFDataFormatException -> 0x0047 }
        r3 = " doesn't match decoded length of ";
        r2 = r2.append(r3);	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = r1.length();	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = r2.append(r1);	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = r1.toString();	 Catch:{ UTFDataFormatException -> 0x0047 }
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0047 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0047 }
    L_0x0047:
        r0 = move-exception;
        r1 = new com.tencent.tinker.c.a.v;
        r1.<init>(r0);
        throw r1;
    L_0x004e:
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0047 }
        if (r5 >= r8) goto L_0x0055;
    L_0x0052:
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x0055:
        r1 = r5 & 224;
        r6 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        if (r1 != r6) goto L_0x007b;
    L_0x005b:
        r1 = r9.a();	 Catch:{ UTFDataFormatException -> 0x0047 }
        r6 = r1 & 255;
        r1 = r6 & 192;
        if (r1 == r8) goto L_0x006d;
    L_0x0065:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = "bad second byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0047 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0047 }
    L_0x006d:
        r1 = r0 + 1;
        r5 = r5 & 31;
        r5 = r5 << 6;
        r6 = r6 & 63;
        r5 = r5 | r6;
        r5 = (char) r5;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r0 = r1;
        goto L_0x000f;
    L_0x007b:
        r1 = r5 & 240;
        r6 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        if (r1 != r6) goto L_0x00b1;
    L_0x0081:
        r1 = r9.a();	 Catch:{ UTFDataFormatException -> 0x0047 }
        r6 = r1 & 255;
        r1 = r9.a();	 Catch:{ UTFDataFormatException -> 0x0047 }
        r7 = r1 & 255;
        r1 = r6 & 192;
        if (r1 != r8) goto L_0x0095;
    L_0x0091:
        r1 = r7 & 192;
        if (r1 == r8) goto L_0x009d;
    L_0x0095:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = "bad second or third byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0047 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0047 }
    L_0x009d:
        r1 = r0 + 1;
        r5 = r5 & 15;
        r5 = r5 << 12;
        r6 = r6 & 63;
        r6 = r6 << 6;
        r5 = r5 | r6;
        r6 = r7 & 63;
        r5 = r5 | r6;
        r5 = (char) r5;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r4[r0] = r5;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r0 = r1;
        goto L_0x000f;
    L_0x00b1:
        r0 = new java.io.UTFDataFormatException;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r1 = "bad byte";
        r0.<init>(r1);	 Catch:{ UTFDataFormatException -> 0x0047 }
        throw r0;	 Catch:{ UTFDataFormatException -> 0x0047 }
    L_0x00b9:
        r0 = new com.tencent.tinker.c.a.af;	 Catch:{ UTFDataFormatException -> 0x0047 }
        r0.<init>(r2, r1);	 Catch:{ UTFDataFormatException -> 0x0047 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.c.a.a.b.b():com.tencent.tinker.c.a.af");
    }

    public aj c() {
        return new aj(this.b.position(), e(this.b.getInt()));
    }

    public aa d() {
        return new aa(this.b.position(), p(), p(), this.b.getInt());
    }

    public ac e() {
        return new ac(this.b.position(), p(), p(), this.b.getInt());
    }

    public ae f() {
        return new ae(this.b.position(), this.b.getInt(), this.b.getInt(), this.b.getInt());
    }

    public k h() {
        i[] iVarArr;
        j[] jVarArr;
        int position = this.b.position();
        int p = p();
        int p2 = p();
        int p3 = p();
        int p4 = p();
        int i = this.b.getInt();
        short[] e = e(this.b.getInt());
        if (p4 > 0) {
            int position2;
            int a;
            int i2;
            if ((e.length & 1) == 1) {
                i(2);
            }
            int position3 = this.b.position();
            i(p4 * 8);
            int position4 = this.b.position();
            int b = ab.b(this);
            iVarArr = new i[b];
            for (int i3 = 0; i3 < b; i3++) {
                position2 = this.b.position() - position4;
                a = ab.a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = ab.b(this);
                    iArr2[i2] = ab.b(this);
                }
                if (a <= 0) {
                    i2 = ab.b(this);
                } else {
                    i2 = -1;
                }
                iVarArr[i3] = new i(iArr, iArr2, i2, position2);
            }
            position4 = this.b.position();
            this.b.position(position3);
            jVarArr = new j[p4];
            position3 = 0;
            while (position3 < p4) {
                b = this.b.getInt();
                position2 = p();
                a = p();
                i2 = 0;
                while (i2 < iVarArr.length) {
                    if (iVarArr[i2].d == a) {
                        jVarArr[position3] = new j(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.b.position(position4);
        } else {
            jVarArr = d;
            iVarArr = e;
        }
        return new k(position, p, p2, p3, i, e, jVarArr, iVarArr);
    }

    public l i() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        int position = this.b.position();
        int b = ab.b(this);
        int b2 = ab.b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = ab.b(this) - 1;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            com.tencent.tinker.c.a.b.b aVar = new a(this, byteArrayOutputStream);
            while (true) {
                byte b3 = this.b.get();
                byteArrayOutputStream.write(b3);
                switch (b3) {
                    case (byte) 0:
                        l lVar = new l(position, b, iArr, byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                        }
                        return lVar;
                    case (byte) 1:
                        ab.a(aVar, q());
                        break;
                    case (byte) 2:
                        try {
                            ab.c(aVar, s());
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            break;
                        }
                    case (byte) 3:
                    case (byte) 4:
                        ab.a(aVar, q());
                        ab.b(aVar, r());
                        ab.b(aVar, r());
                        if (b3 != (byte) 4) {
                            break;
                        }
                        ab.b(aVar, r());
                        break;
                    case (byte) 5:
                    case (byte) 6:
                        ab.a(aVar, q());
                        break;
                    case (byte) 9:
                        ab.b(aVar, r());
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public g j() {
        return new g(this.b.position(), f(ab.b(this)), f(ab.b(this)), g(ab.b(this)), g(ab.b(this)));
    }

    private e[] f(int i) {
        int i2 = 0;
        e[] eVarArr = new e[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += ab.b(this);
            eVarArr[i2] = new e(i3, ab.b(this));
            i2++;
        }
        return eVarArr;
    }

    private f[] g(int i) {
        int i2 = 0;
        f[] fVarArr = new f[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += ab.b(this);
            fVarArr[i2] = new f(i3, ab.b(this), ab.b(this));
            i2++;
        }
        return fVarArr;
    }

    private byte[] h(int i) {
        byte[] bArr = new byte[(this.b.position() - i)];
        this.b.position(i);
        this.b.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.c.a.a k() {
        int position = this.b.position();
        byte b = this.b.get();
        int position2 = this.b.position();
        new z((a) this, 29).s();
        return new com.tencent.tinker.c.a.a(position, b, new x(position2, h(position2)));
    }

    public com.tencent.tinker.c.a.b l() {
        int position = this.b.position();
        int i = this.b.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.b.getInt();
        }
        return new com.tencent.tinker.c.a.b(position, iArr);
    }

    public c m() {
        int position = this.b.position();
        int i = this.b.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.b.getInt();
        }
        return new c(position, iArr);
    }

    public d n() {
        int i;
        int position = this.b.position();
        int i2 = this.b.getInt();
        int i3 = this.b.getInt();
        int i4 = this.b.getInt();
        int i5 = this.b.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i3, 2});
        for (i = 0; i < i3; i++) {
            iArr[i][0] = this.b.getInt();
            iArr[i][1] = this.b.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i4, 2});
        for (i = 0; i < i4; i++) {
            iArr2[i][0] = this.b.getInt();
            iArr2[i][1] = this.b.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i5, 2});
        for (i = 0; i < i5; i++) {
            iArr3[i][0] = this.b.getInt();
            iArr3[i][1] = this.b.getInt();
        }
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public x o() {
        int position = this.b.position();
        new z((a) this, 28).s();
        return new x(position, h(position));
    }

    private void i(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.b.position(this.b.position() + i);
    }

    public final void a(int i) {
        b(1);
        this.b.put((byte) i);
        if (this.b.position() > this.c) {
            this.c = this.b.position();
        }
    }

    public final void a(short s) {
        b(2);
        this.b.putShort(s);
        if (this.b.position() > this.c) {
            this.c = this.b.position();
        }
    }

    private void j(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: " + i);
        }
        a(s);
    }

    public final void d(int i) {
        b(4);
        this.b.putInt(i);
        if (this.b.position() > this.c) {
            this.c = this.b.position();
        }
    }

    public final void a(byte[] bArr) {
        b(bArr.length * 1);
        this.b.put(bArr);
        if (this.b.position() > this.c) {
            this.c = this.b.position();
        }
    }

    public int a(af afVar) {
        int position = this.b.position();
        try {
            ab.a(this, afVar.a.length());
            String str = afVar.a;
            long j = 0;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt != '\u0000' && charAt <= '') {
                    j++;
                } else if (charAt <= '߿') {
                    j += 2;
                } else {
                    j += 3;
                }
                if (j > 65535) {
                    throw new UTFDataFormatException("String more than 65535 UTF bytes long");
                }
            }
            byte[] bArr = new byte[((int) j)];
            ad.a(bArr, 0, str);
            a(bArr);
            a(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int a(aj ajVar) {
        int position = this.b.position();
        short[] sArr = ajVar.b;
        d(sArr.length);
        for (short a : sArr) {
            a(a);
        }
        return position;
    }

    public int a(aa aaVar) {
        int position = this.b.position();
        j(aaVar.a);
        j(aaVar.b);
        d(aaVar.c);
        return position;
    }

    public int a(ac acVar) {
        int position = this.b.position();
        j(acVar.a);
        j(acVar.b);
        d(acVar.c);
        return position;
    }

    public int a(ae aeVar) {
        int position = this.b.position();
        d(aeVar.a);
        d(aeVar.b);
        d(aeVar.c);
        return position;
    }

    public int a(h hVar) {
        int position = this.b.position();
        d(hVar.a);
        d(hVar.b);
        d(hVar.c);
        d(hVar.d);
        d(hVar.e);
        d(hVar.f);
        d(hVar.g);
        d(hVar.h);
        return position;
    }

    public int a(k kVar) {
        int length;
        int position;
        int i = 0;
        int position2 = this.b.position();
        j(kVar.a);
        j(kVar.b);
        j(kVar.c);
        j(kVar.f.length);
        d(kVar.d);
        d(kVar.e.length);
        short[] sArr = kVar.e;
        b(sArr.length * 2);
        for (short a : sArr) {
            a(a);
        }
        if (this.b.position() > this.c) {
            this.c = this.b.position();
        }
        if (kVar.f.length > 0) {
            if ((kVar.e.length & 1) == 1) {
                a((short) 0);
            }
            position = this.b.position();
            length = kVar.f.length * 8;
            b(length * 1);
            i(length);
            i[] iVarArr = kVar.g;
            int position3 = this.b.position();
            ab.a(this, iVarArr.length);
            int[] iArr = new int[iVarArr.length];
            for (length = 0; length < iVarArr.length; length++) {
                iArr[length] = this.b.position() - position3;
                i iVar = iVarArr[length];
                int i2 = iVar.c;
                int[] iArr2 = iVar.a;
                int[] iArr3 = iVar.b;
                if (i2 != -1) {
                    ab.c(this, -iArr2.length);
                } else {
                    ab.c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    ab.a(this, iArr2[i3]);
                    ab.a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    ab.a(this, i2);
                }
            }
            length = this.b.position();
            this.b.position(position);
            j[] jVarArr = kVar.f;
            position = jVarArr.length;
            while (i < position) {
                j jVar = jVarArr[i];
                d(jVar.a);
                j(jVar.b);
                j(iArr[jVar.c]);
                i++;
            }
            this.b.position(length);
        }
        return position2;
    }

    public int a(l lVar) {
        int position = this.b.position();
        ab.a(this, lVar.a);
        ab.a(this, r2);
        for (int i : lVar.b) {
            ab.a(this, i + 1);
        }
        a(lVar.c);
        return position;
    }

    public int a(g gVar) {
        int position = this.b.position();
        ab.a(this, gVar.a.length);
        ab.a(this, gVar.b.length);
        ab.a(this, gVar.c.length);
        ab.a(this, gVar.d.length);
        a(gVar.a);
        a(gVar.b);
        a(gVar.c);
        a(gVar.d);
        return position;
    }

    private void a(e[] eVarArr) {
        int i = 0;
        int length = eVarArr.length;
        int i2 = 0;
        while (i < length) {
            e eVar = eVarArr[i];
            ab.a(this, eVar.a - i2);
            i2 = eVar.a;
            ab.a(this, eVar.b);
            i++;
        }
    }

    private void a(f[] fVarArr) {
        int i = 0;
        int length = fVarArr.length;
        int i2 = 0;
        while (i < length) {
            f fVar = fVarArr[i];
            ab.a(this, fVar.a - i2);
            i2 = fVar.a;
            ab.a(this, fVar.b);
            ab.a(this, fVar.c);
            i++;
        }
    }

    public int a(com.tencent.tinker.c.a.a aVar) {
        int position = this.b.position();
        a(aVar.a);
        a(aVar.b);
        return position;
    }

    public int a(com.tencent.tinker.c.a.b bVar) {
        int position = this.b.position();
        d(bVar.a.length);
        for (int d : bVar.a) {
            d(d);
        }
        return position;
    }

    public int a(c cVar) {
        int position = this.b.position();
        d(cVar.a.length);
        for (int d : cVar.a) {
            d(d);
        }
        return position;
    }

    public int a(d dVar) {
        int position = this.b.position();
        d(dVar.a);
        d(dVar.b.length);
        d(dVar.c.length);
        d(dVar.d.length);
        for (int[] iArr : dVar.b) {
            d(iArr[0]);
            d(iArr[1]);
        }
        for (int[] iArr2 : dVar.c) {
            d(iArr2[0]);
            d(iArr2[1]);
        }
        for (int[] iArr22 : dVar.d) {
            d(iArr22[0]);
            d(iArr22[1]);
        }
        return position;
    }

    public int a(x xVar) {
        int position = this.b.position();
        a(xVar.a);
        return position;
    }

    private int p() {
        return this.b.getShort() & 65535;
    }

    public h g() {
        return new h(this.b.position(), this.b.getInt(), this.b.getInt(), this.b.getInt(), this.b.getInt(), this.b.getInt(), this.b.getInt(), this.b.getInt(), this.b.getInt());
    }
}
