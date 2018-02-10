package com.ucpro.ui.widget.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public abstract class e implements OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final s a;
    private final Interpolator b;
    private final View c;
    private Runnable d;
    private float[] e;
    private float[] f;
    private int g;
    private int h;
    private float[] i;
    private float[] j;
    private float[] k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private Handler s;

    public abstract void a(int i);

    public abstract boolean b(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        s sVar;
        switch (c.a(motionEvent)) {
            case 0:
                this.n = true;
                this.l = false;
                break;
            case 1:
            case 3:
                if (!this.m) {
                    sVar = this.a;
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    int i = (int) (currentAnimationTimeMillis - sVar.d);
                    int i2 = sVar.a;
                    if (i <= i2) {
                        if (i < 0) {
                            i2 = 0;
                        } else {
                            i2 = i;
                        }
                    }
                    sVar.j = i2;
                    sVar.i = sVar.a(currentAnimationTimeMillis);
                    sVar.h = currentAnimationTimeMillis;
                    break;
                }
                this.o = false;
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.c.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.c.getHeight());
        sVar = this.a;
        sVar.b = a;
        sVar.c = a2;
        if (!this.o && b()) {
            if (this.d == null) {
                this.d = new q();
            }
            this.o = true;
            this.m = true;
            if (this.l || this.h <= 0) {
                this.d.run();
            } else {
                a().postDelayed(this.d, (long) this.h);
            }
            this.l = true;
        }
        if (this.q && this.o) {
            return true;
        }
        return false;
    }

    private boolean b() {
        s sVar = this.a;
        int abs = (int) (sVar.c / Math.abs(sVar.c));
        int abs2 = (int) (sVar.b / Math.abs(sVar.b));
        if (abs != 0 && b(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    public final Handler a() {
        if (this.s == null) {
            this.s = new Handler(Looper.getMainLooper());
        }
        return this.s;
    }

    private float a(int i, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float a = a(this.e[i] * f2, 0.0f, this.f[i]);
        a = a(f2 - f, a) - a(f, a);
        if (a < 0.0f) {
            a = -this.b.getInterpolation(-a);
        } else if (a > 0.0f) {
            a = this.b.getInterpolation(a);
        } else {
            a = 0.0f;
            if (a == 0.0f) {
                return 0.0f;
            }
            f4 = this.i[i];
            f5 = this.j[i];
            f6 = this.k[i];
            f4 *= f3;
            if (a <= 0.0f) {
                return a(a * f4, f5, f6);
            }
            return -a((-a) * f4, f5, f6);
        }
        a = a(a, -1.0f, IPictureView.DEFAULT_MIN_SCALE);
        if (a == 0.0f) {
            return 0.0f;
        }
        f4 = this.i[i];
        f5 = this.j[i];
        f6 = this.k[i];
        f4 *= f3;
        if (a <= 0.0f) {
            return -a((-a) * f4, f5, f6);
        }
        return a(a * f4, f5, f6);
    }

    private float a(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return IPictureView.DEFAULT_MIN_SCALE - (f / f2);
                }
                return (this.o && this.g == 1) ? IPictureView.DEFAULT_MIN_SCALE : 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static float a(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    static /* synthetic */ void i(e eVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        eVar.c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
