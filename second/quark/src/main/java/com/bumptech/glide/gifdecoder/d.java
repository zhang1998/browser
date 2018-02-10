package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.Log;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class d implements GifDecoder {
    private static final String a = d.class.getSimpleName();
    @ColorInt
    private int[] b;
    @ColorInt
    private final int[] c;
    private ByteBuffer d;
    private byte[] e;
    @Nullable
    private byte[] f;
    private int g;
    private int h;
    private short[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    @ColorInt
    private int[] m;
    private int n;
    private b o;
    private a p;
    private Bitmap q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;

    public d(a aVar, b bVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        a(bVar, byteBuffer, i);
    }

    private d(a aVar) {
        this.c = new int[LogType.UNEXP];
        this.g = 0;
        this.h = 0;
        this.p = aVar;
        this.o = new b();
    }

    public final ByteBuffer a() {
        return this.d;
    }

    public final void b() {
        this.n = (this.n + 1) % this.o.c;
    }

    public final int c() {
        if (this.o.c <= 0 || this.n < 0) {
            return 0;
        }
        int i = this.n;
        if (i < 0 || i >= this.o.c) {
            return -1;
        }
        return ((GifFrame) this.o.e.get(i)).i;
    }

    public final int d() {
        return this.o.c;
    }

    public final int e() {
        return this.n;
    }

    public final void f() {
        this.n = -1;
    }

    public final int g() {
        return (this.d.limit() + this.l.length) + (this.m.length * 4);
    }

    public final synchronized Bitmap h() {
        Bitmap bitmap;
        if (this.o.c <= 0 || this.n < 0) {
            if (Log.isLoggable(a, 3)) {
                new StringBuilder("Unable to decode frame, frameCount=").append(this.o.c).append(", framePointer=").append(this.n);
            }
            this.s = 1;
        }
        if (this.s == 1 || this.s == 2) {
            if (Log.isLoggable(a, 3)) {
                new StringBuilder("Unable to decode frame, status=").append(this.s);
            }
            bitmap = null;
        } else {
            GifFrame gifFrame;
            int[] iArr;
            this.s = 0;
            GifFrame gifFrame2 = (GifFrame) this.o.e.get(this.n);
            int i = this.n - 1;
            if (i >= 0) {
                gifFrame = (GifFrame) this.o.e.get(i);
            } else {
                gifFrame = null;
            }
            if (gifFrame2.k != null) {
                iArr = gifFrame2.k;
            } else {
                iArr = this.o.a;
            }
            this.b = iArr;
            if (this.b == null) {
                if (Log.isLoggable(a, 3)) {
                    new StringBuilder("No valid color table found for frame #").append(this.n);
                }
                this.s = 1;
                bitmap = null;
            } else {
                if (gifFrame2.f) {
                    System.arraycopy(this.b, 0, this.c, 0, this.b.length);
                    this.b = this.c;
                    this.b[gifFrame2.h] = 0;
                }
                bitmap = a(gifFrame2, gifFrame);
            }
        }
        return bitmap;
    }

    public final void i() {
        this.o = null;
        if (this.l != null) {
            this.p.a(this.l);
        }
        if (this.m != null) {
            this.p.a(this.m);
        }
        if (this.q != null) {
            this.p.a(this.q);
        }
        this.q = null;
        this.d = null;
        this.w = false;
        if (this.e != null) {
            this.p.a(this.e);
        }
        if (this.f != null) {
            this.p.a(this.f);
        }
    }

    private synchronized void a(b bVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.s = 0;
        this.o = bVar;
        this.w = false;
        this.n = -1;
        this.d = byteBuffer.asReadOnlyBuffer();
        this.d.position(0);
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.r = false;
        for (GifFrame gifFrame : bVar.e) {
            if (gifFrame.g == 3) {
                this.r = true;
                break;
            }
        }
        this.t = highestOneBit;
        this.v = bVar.f / highestOneBit;
        this.u = bVar.g / highestOneBit;
        this.l = this.p.a(bVar.f * bVar.g);
        this.m = this.p.b(this.v * this.u);
    }

    private Bitmap a(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr = this.m;
        if (gifFrame2 == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.g > 0) {
            if (gifFrame2.g == 2) {
                i = 0;
                if (!gifFrame.f) {
                    i = this.o.l;
                    if (gifFrame.k != null && this.o.j == gifFrame.h) {
                        i = 0;
                    }
                } else if (this.n == 0) {
                    this.w = true;
                }
                i2 = gifFrame2.c / this.t;
                i3 = ((gifFrame2.b / this.t) * this.v) + (gifFrame2.a / this.t);
                i4 = i3 + ((gifFrame2.d / this.t) * this.v);
                while (i3 < i4) {
                    i5 = i3 + i2;
                    for (i6 = i3; i6 < i5; i6++) {
                        iArr[i6] = i;
                    }
                    i3 += this.v;
                }
            } else if (gifFrame2.g == 3 && this.q != null) {
                this.q.getPixels(iArr, 0, this.v, 0, 0, this.v, this.u);
            }
        }
        this.g = 0;
        this.h = 0;
        if (gifFrame != null) {
            this.d.position(gifFrame.j);
        }
        if (gifFrame == null) {
            i = this.o.f * this.o.g;
        } else {
            i = gifFrame.c * gifFrame.d;
        }
        if (this.l == null || this.l.length < i) {
            this.l = this.p.a(i);
        }
        if (this.i == null) {
            this.i = new short[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        }
        if (this.j == null) {
            this.j = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        }
        if (this.k == null) {
            this.k = new byte[4097];
        }
        int k = k();
        int i8 = 1 << k;
        int i9 = i8 + 1;
        i2 = i8 + 2;
        i6 = k + 1;
        i3 = (1 << i6) - 1;
        for (i4 = 0; i4 < i8; i4++) {
            this.i[i4] = (short) 0;
            this.j[i4] = (byte) i4;
        }
        int i10 = 0;
        i4 = 0;
        int i11 = -1;
        i5 = i6;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        i6 = 0;
        int i15 = i3;
        int i16 = i2;
        i2 = 0;
        i3 = 0;
        while (i14 < i) {
            if (i3 == 0) {
                i3 = l();
                if (i3 <= 0) {
                    this.s = 3;
                    break;
                }
                i6 = 0;
            }
            i10 += (this.e[i6] & 255) << i4;
            int i17 = i6 + 1;
            i7 = i3 - 1;
            i6 = i5;
            i3 = i15;
            i5 = i4 + 8;
            i15 = i14;
            i4 = i2;
            i2 = i16;
            i16 = i11;
            while (i5 >= i6) {
                i11 = i10 & i3;
                i14 = i10 >> i6;
                i10 = i5 - i6;
                if (i11 != i8) {
                    if (i11 <= i2) {
                        if (i11 == i9) {
                            i11 = i16;
                            i5 = i6;
                            i16 = i2;
                            i6 = i17;
                            i2 = i4;
                            i4 = i10;
                            i10 = i14;
                            i14 = i15;
                            i15 = i3;
                            i3 = i7;
                            break;
                        } else if (i16 == -1) {
                            i5 = i12 + 1;
                            this.k[i12] = this.j[i11];
                            i16 = i11;
                            i12 = i5;
                            i13 = i11;
                            i5 = i10;
                            i10 = i14;
                        } else {
                            if (i11 >= i2) {
                                i5 = i12 + 1;
                                this.k[i12] = (byte) i13;
                                i12 = i5;
                                i5 = i16;
                            } else {
                                i5 = i11;
                            }
                            while (i5 >= i8) {
                                i13 = i12 + 1;
                                this.k[i12] = this.j[i5];
                                i5 = this.i[i5];
                                i12 = i13;
                            }
                            i13 = this.j[i5] & 255;
                            i5 = i12 + 1;
                            this.k[i12] = (byte) i13;
                            if (i2 < SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
                                this.i[i2] = (short) i16;
                                this.j[i2] = (byte) i13;
                                i2++;
                                if ((i2 & i3) == 0 && i2 < SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
                                    i6++;
                                    i3 += i2;
                                }
                            }
                            i16 = i15;
                            i15 = i5;
                            while (i15 > 0) {
                                i5 = i4 + 1;
                                i15--;
                                this.l[i4] = this.k[i15];
                                i16++;
                                i4 = i5;
                            }
                            i5 = i10;
                            i12 = i15;
                            i10 = i14;
                            i15 = i16;
                            i16 = i11;
                        }
                    } else {
                        this.s = 3;
                        i11 = i16;
                        i5 = i6;
                        i16 = i2;
                        i6 = i17;
                        i2 = i4;
                        i4 = i10;
                        i10 = i14;
                        i14 = i15;
                        i15 = i3;
                        i3 = i7;
                        break;
                    }
                }
                i6 = k + 1;
                i3 = (1 << i6) - 1;
                i2 = i8 + 2;
                i5 = i10;
                i16 = -1;
                i10 = i14;
            }
            i11 = i16;
            i14 = i15;
            i15 = i3;
            i16 = i2;
            i2 = i4;
            i3 = i7;
            i4 = i5;
            i5 = i6;
            i6 = i17;
        }
        for (i6 = i2; i6 < i; i6++) {
            this.l[i6] = (byte) 0;
        }
        i7 = gifFrame.d / this.t;
        k = gifFrame.b / this.t;
        i8 = gifFrame.c / this.t;
        i9 = gifFrame.a / this.t;
        i2 = 1;
        i3 = 8;
        i6 = 0;
        Object obj = this.n == 0 ? 1 : null;
        i11 = 0;
        while (i11 < i7) {
            if (gifFrame.e) {
                if (i6 >= i7) {
                    i2++;
                    switch (i2) {
                        case 2:
                            i6 = 4;
                            break;
                        case 3:
                            i6 = 2;
                            i3 = 4;
                            break;
                        case 4:
                            i6 = 1;
                            i3 = 2;
                            break;
                    }
                }
                i12 = i6 + i3;
                i13 = i3;
                i10 = i2;
            } else {
                i12 = i6;
                i13 = i3;
                i10 = i2;
                i6 = i11;
            }
            i6 += k;
            if (i6 < this.u) {
                i2 = i6 * this.v;
                i3 = i2 + i9;
                i6 = i3 + i8;
                if (this.v + i2 < i6) {
                    i14 = this.v + i2;
                } else {
                    i14 = i6;
                }
                i6 = (this.t * i11) * gifFrame.c;
                int i18 = i6 + ((i14 - i3) * this.t);
                i3 = i6;
                for (i17 = i3; i17 < i14; i17++) {
                    if (this.t == 1) {
                        i6 = this.b[this.l[i3] & 255];
                    } else {
                        int i19;
                        int i20 = gifFrame.c;
                        i16 = 0;
                        i15 = 0;
                        i5 = 0;
                        i4 = 0;
                        i2 = 0;
                        i6 = i3;
                        while (i6 < this.t + i3 && i6 < this.l.length && i6 < i18) {
                            i19 = this.b[this.l[i6] & 255];
                            if (i19 != 0) {
                                i16 += (i19 >> 24) & 255;
                                i15 += (i19 >> 16) & 255;
                                i5 += (i19 >> 8) & 255;
                                i4 += i19 & 255;
                                i2++;
                            }
                            i6++;
                        }
                        i6 = i3 + i20;
                        while (i6 < (i3 + i20) + this.t && i6 < this.l.length && i6 < i18) {
                            i19 = this.b[this.l[i6] & 255];
                            if (i19 != 0) {
                                i16 += (i19 >> 24) & 255;
                                i15 += (i19 >> 16) & 255;
                                i5 += (i19 >> 8) & 255;
                                i4 += i19 & 255;
                                i2++;
                            }
                            i6++;
                        }
                        if (i2 == 0) {
                            i6 = 0;
                        } else {
                            i6 = ((((i16 / i2) << 24) | ((i15 / i2) << 16)) | ((i5 / i2) << 8)) | (i4 / i2);
                        }
                    }
                    if (i6 != 0) {
                        iArr[i17] = i6;
                    } else if (!(this.w || obj == null)) {
                        this.w = true;
                    }
                    i3 += this.t;
                }
            }
            i11++;
            i6 = i12;
            i3 = i13;
            i2 = i10;
        }
        if (this.r && (gifFrame.g == 0 || gifFrame.g == 1)) {
            if (this.q == null) {
                this.q = m();
            }
            this.q.setPixels(iArr, 0, this.v, 0, 0, this.v, this.u);
        }
        Bitmap m = m();
        m.setPixels(iArr, 0, this.v, 0, 0, this.v, this.u);
        return m;
    }

    private void j() {
        if (this.g <= this.h) {
            if (this.f == null) {
                this.f = this.p.a(16384);
            }
            this.h = 0;
            this.g = Math.min(this.d.remaining(), 16384);
            this.d.get(this.f, 0, this.g);
        }
    }

    private int k() {
        try {
            j();
            byte[] bArr = this.f;
            int i = this.h;
            this.h = i + 1;
            return bArr[i] & 255;
        } catch (Exception e) {
            this.s = 1;
            return 0;
        }
    }

    private int l() {
        int k = k();
        if (k > 0) {
            try {
                if (this.e == null) {
                    this.e = this.p.a(255);
                }
                int i = this.g - this.h;
                if (i >= k) {
                    System.arraycopy(this.f, this.h, this.e, 0, k);
                    this.h += k;
                } else if (this.d.remaining() + i >= k) {
                    System.arraycopy(this.f, this.h, this.e, 0, i);
                    this.h = this.g;
                    j();
                    int i2 = k - i;
                    System.arraycopy(this.f, 0, this.e, i, i2);
                    this.h += i2;
                } else {
                    this.s = 1;
                }
            } catch (Throwable e) {
                Log.w(a, "Error Reading Block", e);
                this.s = 1;
            }
        }
        return k;
    }

    private Bitmap m() {
        Bitmap a = this.p.a(this.v, this.u, this.w ? Config.ARGB_8888 : Config.RGB_565);
        a.setHasAlpha(true);
        return a;
    }
}
