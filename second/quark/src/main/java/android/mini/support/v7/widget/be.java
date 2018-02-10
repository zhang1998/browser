package android.mini.support.v7.widget;

import android.mini.support.v4.c.f;
import android.mini.support.v4.e.k;
import android.mini.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Interpolator;
import com.uc.apollo.impl.SettingsConst;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class be implements Runnable {
    int a;
    int b;
    k c;
    final /* synthetic */ RecyclerView d;
    private Interpolator e = RecyclerView.au;
    private boolean f = false;
    private boolean g = false;

    public be(RecyclerView recyclerView) {
        this.d = recyclerView;
        this.c = k.a(recyclerView.getContext(), RecyclerView.au);
    }

    public final void run() {
        if (this.d.f == null) {
            b();
            return;
        }
        this.g = false;
        this.f = true;
        this.d.j();
        k kVar = this.c;
        bc bcVar = this.d.f.r;
        if (kVar.b.e(kVar.a)) {
            int a;
            int i;
            int d;
            int i2;
            View view;
            Object obj;
            Object obj2;
            int b = kVar.b.b(kVar.a);
            int c = kVar.b.c(kVar.a);
            int i3 = b - this.a;
            int i4 = c - this.b;
            int i5 = 0;
            int i6 = 0;
            this.a = b;
            this.b = c;
            int i7 = 0;
            int i8 = 0;
            if (this.d.E != null) {
                this.d.a();
                this.d.p();
                f.a("RV Scroll");
                if (i3 != 0) {
                    i5 = this.d.f.a(i3, this.d.b, this.d.p);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.d.f.b(i4, this.d.b, this.d.p);
                    i8 = i4 - i6;
                }
                f.a();
                this.d.B();
                this.d.q();
                this.d.a(false);
                if (!(bcVar == null || bcVar.j || !bcVar.k)) {
                    a = this.d.p.a();
                    if (a == 0) {
                        bcVar.c();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                        if (!this.d.g.isEmpty()) {
                            this.d.invalidate();
                        }
                        if (ViewCompat.a(this.d) != 2) {
                            this.d.d(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            d = (int) kVar.b.d(kVar.a);
                            if (i6 == b) {
                                a = i6 >= 0 ? -d : i6 <= 0 ? d : 0;
                                i2 = a;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                d = 0;
                            } else if (i8 < 0) {
                                d = -d;
                            } else if (i8 <= 0) {
                                d = 0;
                            }
                            if (ViewCompat.a(this.d) != 2) {
                                view = this.d;
                                if (i2 < 0) {
                                    view.b();
                                    view.k.a(-i2);
                                } else if (i2 > 0) {
                                    view.c();
                                    view.m.a(i2);
                                }
                                if (d < 0) {
                                    view.d();
                                    view.l.a(-d);
                                } else if (d > 0) {
                                    view.e();
                                    view.n.a(d);
                                }
                                if (!(i2 == 0 && d == 0)) {
                                    ViewCompat.d(view);
                                }
                            }
                            if ((i2 != 0 || i6 == b || kVar.b.g(kVar.a) == 0) && (d != 0 || i8 == c || kVar.b.h(kVar.a) == 0)) {
                                kVar.a();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.d.c(i5, i7);
                        }
                        if (!this.d.awakenScrollBars()) {
                            this.d.invalidate();
                        }
                        obj = (i4 == 0 && this.d.f.f() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.d.f.e() && i5 == i3) ? 1 : null;
                        if ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (!kVar.b.a(kVar.a) || r1 == null) {
                            this.d.setScrollState(0);
                        } else {
                            a();
                        }
                    } else {
                        if (bcVar.g >= a) {
                            bcVar.g = a - 1;
                        }
                        bc.a(bcVar, i3 - i7, i4 - i8);
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (this.d.g.isEmpty()) {
                this.d.invalidate();
            }
            if (ViewCompat.a(this.d) != 2) {
                this.d.d(i3, i4);
            }
            d = (int) kVar.b.d(kVar.a);
            if (i6 == b) {
                i2 = 0;
            } else {
                if (i6 >= 0) {
                    if (i6 <= 0) {
                    }
                }
                i2 = a;
            }
            if (i8 != c) {
                d = 0;
            } else if (i8 < 0) {
                d = -d;
            } else if (i8 <= 0) {
                d = 0;
            }
            if (ViewCompat.a(this.d) != 2) {
                view = this.d;
                if (i2 < 0) {
                    view.b();
                    view.k.a(-i2);
                } else if (i2 > 0) {
                    view.c();
                    view.m.a(i2);
                }
                if (d < 0) {
                    view.d();
                    view.l.a(-d);
                } else if (d > 0) {
                    view.e();
                    view.n.a(d);
                }
                ViewCompat.d(view);
            }
            kVar.a();
            this.d.c(i5, i7);
            if (this.d.awakenScrollBars()) {
                this.d.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            obj2 = null;
            if (kVar.b.a(kVar.a)) {
            }
            this.d.setScrollState(0);
        }
        if (bcVar != null) {
            if (bcVar.j) {
                bc.a(bcVar, 0, 0);
            }
            if (!this.g) {
                bcVar.c();
            }
        }
        this.f = false;
        if (this.g) {
            a();
        }
    }

    final void a() {
        if (this.f) {
            this.g = true;
            return;
        }
        this.d.removeCallbacks(this);
        ViewCompat.a(this.d, (Runnable) this);
    }

    public final void a(int i, int i2) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt(0.0d);
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.d.getWidth() : this.d.getHeight();
        int i3 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(IPictureView.DEFAULT_MIN_SCALE, (((float) sqrt2) * IPictureView.DEFAULT_MIN_SCALE) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
        } else {
            if (obj != null) {
                round = abs;
            } else {
                round = abs2;
            }
            round = (int) (((((float) round) / ((float) width)) + IPictureView.DEFAULT_MIN_SCALE) * 300.0f);
        }
        a(i, i2, Math.min(round, SettingsConst.GLOBAL_SETTINGS));
    }

    public final void a(int i, int i2, int i3) {
        a(i, i2, i3, RecyclerView.au);
    }

    public final void a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.e != interpolator) {
            this.e = interpolator;
            this.c = k.a(this.d.getContext(), interpolator);
        }
        this.d.setScrollState(2);
        this.b = 0;
        this.a = 0;
        k kVar = this.c;
        kVar.b.a(kVar.a, i, i2, i3);
        a();
    }

    public final void b() {
        this.d.removeCallbacks(this);
        this.c.a();
    }
}
