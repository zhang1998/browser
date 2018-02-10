package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.l;
import android.view.View;
import android.view.animation.Interpolator;
import com.uc.apollo.impl.SettingsConst;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class aj implements Runnable {
    int a;
    int b;
    l c;
    final /* synthetic */ RecyclerView d;
    private Interpolator e = RecyclerView.aq;
    private boolean f = false;
    private boolean g = false;

    public aj(RecyclerView recyclerView) {
        this.d = recyclerView;
        this.c = l.a(recyclerView.getContext(), RecyclerView.aq);
    }

    public final void run() {
        if (this.d.f == null) {
            b();
            return;
        }
        this.g = false;
        this.f = true;
        this.d.j();
        l lVar = this.c;
        af afVar = this.d.f.c;
        if (lVar.g()) {
            int a;
            int i;
            int f;
            int i2;
            View view;
            Object obj;
            Object obj2;
            int b = lVar.b();
            int c = lVar.c();
            int i3 = b - this.a;
            int i4 = c - this.b;
            int i5 = 0;
            int i6 = 0;
            this.a = b;
            this.b = c;
            int i7 = 0;
            int i8 = 0;
            if (this.d.A != null) {
                this.d.a();
                this.d.p();
                e.a("RV Scroll");
                if (i3 != 0) {
                    i5 = this.d.f.a(i3, this.d.b, this.d.p);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.d.f.b(i4, this.d.b, this.d.p);
                    i8 = i4 - i6;
                }
                e.a();
                this.d.B();
                this.d.q();
                this.d.a(false);
                if (!(afVar == null || afVar.b || !afVar.c)) {
                    a = this.d.p.a();
                    if (a == 0) {
                        afVar.a();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                        if (!this.d.C.isEmpty()) {
                            this.d.invalidate();
                        }
                        if (ViewCompat.a(this.d) != 2) {
                            this.d.b(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) lVar.f();
                            if (i6 == b) {
                                a = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                                i2 = a;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                f = 0;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = 0;
                            }
                            if (ViewCompat.a(this.d) != 2) {
                                view = this.d;
                                if (i2 < 0) {
                                    view.b();
                                    view.j.a(-i2);
                                } else if (i2 > 0) {
                                    view.c();
                                    view.l.a(i2);
                                }
                                if (f < 0) {
                                    view.d();
                                    view.k.a(-f);
                                } else if (f > 0) {
                                    view.e();
                                    view.m.a(f);
                                }
                                if (!(i2 == 0 && f == 0)) {
                                    ViewCompat.d(view);
                                }
                            }
                            if ((i2 != 0 || i6 == b || lVar.d() == 0) && (f != 0 || i8 == c || lVar.e() == 0)) {
                                lVar.h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.d.g();
                        }
                        if (!this.d.awakenScrollBars()) {
                            this.d.invalidate();
                        }
                        obj = (i4 == 0 && this.d.f.e() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.d.f.d() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!lVar.a() || obj2 == null) {
                            this.d.setScrollState(0);
                        } else {
                            a();
                        }
                    } else {
                        if (afVar.a >= a) {
                            afVar.a = a - 1;
                        }
                        af.a(afVar);
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (this.d.C.isEmpty()) {
                this.d.invalidate();
            }
            if (ViewCompat.a(this.d) != 2) {
                this.d.b(i3, i4);
            }
            f = (int) lVar.f();
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
                f = 0;
            } else if (i8 < 0) {
                f = -f;
            } else if (i8 <= 0) {
                f = 0;
            }
            if (ViewCompat.a(this.d) != 2) {
                view = this.d;
                if (i2 < 0) {
                    view.b();
                    view.j.a(-i2);
                } else if (i2 > 0) {
                    view.c();
                    view.l.a(i2);
                }
                if (f < 0) {
                    view.d();
                    view.k.a(-f);
                } else if (f > 0) {
                    view.e();
                    view.m.a(f);
                }
                ViewCompat.d(view);
            }
            lVar.h();
            this.d.g();
            if (this.d.awakenScrollBars()) {
                this.d.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            if (lVar.a()) {
            }
            this.d.setScrollState(0);
        }
        if (afVar != null) {
            if (afVar.b) {
                af.a(afVar);
            }
            if (!this.g) {
                afVar.a();
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
        a(i, i2, i3, RecyclerView.aq);
    }

    public final void a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.e != interpolator) {
            this.e = interpolator;
            this.c = l.a(this.d.getContext(), interpolator);
        }
        this.d.setScrollState(2);
        this.b = 0;
        this.a = 0;
        this.c.a(0, 0, i, i2, i3);
        a();
    }

    public final void b() {
        this.d.removeCallbacks(this);
        this.c.h();
    }
}
