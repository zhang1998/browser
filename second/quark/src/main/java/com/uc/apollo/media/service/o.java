package com.uc.apollo.media.service;

import com.uc.apollo.media.LittleWindowConfig;
import com.uc.apollo.media.LittleWindowController;
import com.uc.apollo.media.base.WndPos;
import com.uc.apollo.media.service.LittleWindowActionStatistic.Factory;
import com.uc.apollo.rebound.SimpleSpringListener;
import com.uc.apollo.rebound.Spring;
import com.uc.apollo.rebound.SpringConfig;
import com.uc.apollo.rebound.SpringSystem;
import com.uc.apollo.util.f;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class o {
    private static int A = 0;
    private static b B;
    private static a C = new a();
    static final int a;
    static final int b;
    static final int c = ((f.f() * 2) / 3);
    static final int d;
    static final int e;
    static final int f = f.c(100);
    static final int g = f.c(100);
    private static final int h = LittleWindowConfig.getMinLittleWindowWidth();
    private static final int i = LittleWindowConfig.getMinLittleWindowHeight();
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static WndPos r;
    private static float s = 1.2222222f;
    private static boolean t = true;
    private static LittleWindowController u;
    private static SpringSystem v;
    private static Spring w;
    private static Spring x;
    private static c y;
    private static c z;

    /* compiled from: ProGuard */
    interface b {
        void a();

        void b();
    }

    /* compiled from: ProGuard */
    final class a {
        public int a;
        public int b;
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
        public boolean p;
        public boolean q;

        private a() {
            this.f = Integer.MAX_VALUE;
            this.g = Integer.MAX_VALUE;
        }

        final void a(double d) {
            this.l = a(this.b, this.c, d);
            this.m = a(this.e, this.f, d);
            if (this.p && this.q) {
                while (true) {
                    if (this.l <= o.o && this.l >= o.n) {
                        break;
                    } else if (this.l > o.o) {
                        this.l = o.o - (this.l - o.o);
                    } else {
                        this.l = o.n + (o.n - this.l);
                    }
                }
                while (true) {
                    if (this.m <= o.q && this.m >= o.p) {
                        break;
                    } else if (this.m > o.q) {
                        this.m = o.q - (this.m - o.q);
                    } else {
                        this.m = o.p + (o.p - this.m);
                    }
                }
            }
            this.n = a(this.h, this.j, d);
            this.o = a(this.i, this.k, d);
        }

        private static int a(int i, int i2, double d) {
            return (int) (((double) i) + (((double) (i2 - i)) * d));
        }
    }

    /* compiled from: ProGuard */
    class c extends SimpleSpringListener {
        int a;

        private c() {
        }
    }

    static {
        int c = f.c(1);
        a = c;
        b = c;
        c = (f.c() * 3) / 5;
        d = c;
        e = (int) (((float) c) / 1.2222222f);
    }

    static void a(LittleWindowController littleWindowController) {
        u = littleWindowController;
        if (v == null) {
            v = SpringSystem.create();
        }
    }

    static void a() {
        t = true;
        s = 1.2222222f;
    }

    static void b() {
        t = false;
    }

    static void c() {
        if (f.e()) {
            j = f.d();
            k = f.c();
        } else {
            j = f.c();
            k = f.d();
        }
        j += b * 2;
        k += b * 2;
        l = j / 10 > g ? g : j / 10;
        m = k / 10 > g ? g : k / 10;
    }

    static void d() {
        r = u.getWinPosition();
        c();
        if (r.screenY != r.y) {
            int f = k - f.f();
            k = f;
            m = f / 10 > g ? g : k / 10;
        }
        n = f - r.w;
        o = j - f;
        p = f - r.h;
        q = k - f;
    }

    static void e() {
        d();
        int i = r.x;
        int i2 = r.y;
        int i3 = r.w;
        int i4 = r.h;
        if (i3 > j || i4 > k) {
            if (s >= (((float) j) * IPictureView.DEFAULT_MIN_SCALE) / ((float) k)) {
                if (i3 > j) {
                    i3 = j;
                    i4 = (int) (((float) i3) / s);
                }
            } else if (i4 > k) {
                i4 = k;
                i3 = (int) (((float) i4) * s);
            }
        }
        if (i3 < h) {
            i3 = h;
        }
        if (i4 < i) {
            i4 = i;
        }
        if (i3 == j || i < 0) {
            i = -b;
        } else if (i + i3 > j) {
            i = b(i3);
        }
        if (i4 == k || i2 < 0) {
            i2 = -b;
        } else if (i2 + i4 > k) {
            i2 = (k - i4) - b;
        }
        if (i != r.x || i2 != r.y || i3 != r.w || i4 != r.h) {
            f();
            u.moveTo(i, i2, i3, i4);
        }
    }

    static int a(int i, int i2) {
        int i3;
        float f = (IPictureView.DEFAULT_MIN_SCALE * ((float) r.w)) / ((float) r.h);
        int i4 = (int) (((float) i) / f);
        if (i4 > i2) {
            i3 = i2;
        } else {
            i3 = i4;
        }
        i4 = (int) (((float) i2) * f);
        if (i4 <= i) {
            i = i4;
        }
        b(r.x, r.y, r.w + i, i3 + r.h);
        return i;
    }

    static void a(int i) {
        int i2;
        int i3 = r.w;
        int i4 = r.h;
        if (i3 > i4) {
            i2 = i;
            i = (int) (((((float) i4) * IPictureView.DEFAULT_MIN_SCALE) * ((float) i)) / ((float) i3));
        } else {
            i2 = (int) (((((float) i3) * IPictureView.DEFAULT_MIN_SCALE) * ((float) i)) / ((float) i4));
        }
        b(r.x, r.y, i2 + i3, i4 + i);
    }

    static void b(int i, int i2) {
        u.moveTo(r.x + i, r.y + i2, r.w, r.h);
    }

    static void a(boolean z, int i, int i2) {
        c();
        float f = (((float) i) * IPictureView.DEFAULT_MIN_SCALE) / ((float) i2);
        float f2 = (((float) j) * IPictureView.DEFAULT_MIN_SCALE) / ((float) k);
        s = f;
        int i3 = r.x;
        int i4 = r.y;
        if (f >= f2) {
            if ((l * 2) + i > j) {
                i = j - (l * 2);
                i2 = (int) (((float) i) / f);
            } else if (i < h) {
                i = h;
                i2 = (int) (((float) i) / f);
            }
        } else if ((m * 2) + i2 > k) {
            i2 = k - (m * 2);
            i = (int) (f * ((float) i2));
        } else if (i2 < i) {
            i2 = i;
            i = (int) (f * ((float) i2));
        }
        if (i < h) {
            i = h;
        }
        if (i2 < i) {
            i2 = i;
        }
        if (t) {
            if (!z) {
                t = false;
                Factory.getInstance().onAction(7, 0);
            }
            i3 = (j - i) / 2;
            i4 = (k - i2) / 2;
            if (i4 > m) {
                i4 = m;
            }
        }
        u.moveTo(i3, i4, i, i2);
    }

    private static void b(int i, int i2, int i3, int i4) {
        if (i3 >= h && i3 <= j && i4 >= i && i4 <= k) {
            u.moveTo(i, i2, i3, i4);
        }
    }

    static void a(b bVar) {
        B = bVar;
    }

    static void f() {
        if (C != null) {
            C.a = Integer.MAX_VALUE;
        }
        if (w != null) {
            w.setCurrentValue(0.0d);
            w.setEndValue(0.0d);
        }
        if (x != null) {
            x.setCurrentValue(0.0d);
            x.setEndValue(0.0d);
        }
    }

    private static int b(int i) {
        return (j - i) - b;
    }

    static void c(int i, int i2) {
        a(i, i2, 0, 0);
    }

    static void a(int i, int i2, int i3, int i4) {
        int i5;
        d();
        int i6 = r.w;
        int i7 = r.h;
        int i8 = r.w + i3;
        int i9 = r.h + i4;
        int i10 = r.x;
        int i11 = r.y;
        int i12 = r.x;
        int i13 = r.y;
        int i14 = Integer.MAX_VALUE;
        if (i == 0 && i2 == 0) {
            Object obj = 1;
            if (i10 > o) {
                i12 = o;
            } else if (i10 < n) {
                i12 = n;
            } else if (i10 != (-b) && Math.abs(b + i10) <= c) {
                i12 = -b;
            } else if (i10 + i8 == j || Math.abs((i10 + i8) - j) > c) {
                obj = null;
            } else {
                i12 = b(i8);
            }
            Object obj2 = 1;
            if (i11 > q) {
                i13 = q;
            } else if (i11 < p) {
                i13 = p;
            } else if (i11 != (-b) && Math.abs(b + i11) <= c) {
                i13 = -b;
            } else if (i11 + i9 == k || Math.abs((i11 + i9) - k) > c) {
                obj2 = null;
            } else {
                i13 = (k - i9) - b;
            }
            if (obj != null || r5 != null || i3 != 0 || i4 != 0) {
                i5 = i12;
                i12 = Integer.MAX_VALUE;
            } else {
                return;
            }
        }
        i5 = i10 + i;
        i13 = i11 + i2;
        i12 = b(i8);
        if (i5 <= i12) {
            i12 = -b;
            if (i5 >= i12) {
                i12 = Integer.MAX_VALUE;
                i14 = i5;
            } else if (i5 > f - i8) {
                i14 = i5;
            } else {
                i14 = (n - (i8 - f)) + b;
                i12 = Integer.MAX_VALUE;
            }
        } else if (i5 <= j - f) {
            i14 = i5;
        } else {
            i14 = (o + (i8 - f)) + b;
            i12 = Integer.MAX_VALUE;
        }
        i5 = ((k - i9) - b) - f.c(1);
        int i15;
        if (i13 <= i5) {
            i5 = -b;
            if (i13 >= i5) {
                i5 = i13;
            } else if (i13 > f - i9) {
                i15 = i5;
                i5 = i14;
                i14 = i12;
                i12 = i15;
            } else {
                i5 = (p - (i9 - f)) + b;
            }
            i13 = i5;
            i5 = i14;
            i14 = i12;
            i12 = Integer.MAX_VALUE;
        } else if (i13 <= k - f) {
            i15 = i5;
            i5 = i14;
            i14 = i12;
            i12 = i15;
        } else {
            i13 = f.c(1) + ((q + (i9 - f)) + b);
            i5 = i14;
            i14 = i12;
            i12 = Integer.MAX_VALUE;
        }
        int i16 = A;
        A = i16 + 1;
        int i17 = A;
        A = i17 + 1;
        if (A == Integer.MAX_VALUE || A + 1 == Integer.MAX_VALUE) {
            A = 0;
        }
        a aVar = C;
        aVar.a = i16;
        aVar.b = i10;
        aVar.e = i11;
        aVar.c = i5;
        aVar.f = i13;
        aVar.d = i14;
        aVar.g = i12;
        aVar.h = i6;
        aVar.i = i7;
        aVar.j = i8;
        aVar.k = i9;
        boolean z = i5 > o || i5 < n || i13 > q || i13 < p;
        aVar.p = z;
        aVar.q = true;
        if (z == null) {
            z = new p();
        }
        if (y == null) {
            y = new q();
        }
        y.a = i16;
        z.a = i17;
        if (w == null) {
            Spring createSpring = v.createSpring();
            w = createSpring;
            createSpring.a(y);
        }
        w.a(SpringConfig.fromOrigamiTensionAndFriction(35.0d, 17.0d));
        w.setCurrentValue(0.0d);
        w.setEndValue(1.0d);
    }

    static /* synthetic */ void a(int i, Spring spring) {
        if (C != null) {
            a aVar = C;
            if (aVar.a == i) {
                double currentValue = spring.getCurrentValue();
                aVar.a(currentValue);
                u.moveTo(aVar.l, aVar.m, aVar.n, aVar.o);
                if (aVar.h != aVar.j || aVar.i != aVar.k) {
                    if (currentValue == 0.0d) {
                        B.a();
                    } else if (currentValue == 1.0d) {
                        B.b();
                    }
                }
            }
        }
    }
}
