package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.cx;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public abstract class au implements OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final an a = new an();
    private final Interpolator b = new AccelerateInterpolator();
    private final View c;
    private Runnable d;
    private float[] e = new float[]{0.0f, 0.0f};
    private float[] f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int g;
    private int h;
    private float[] i = new float[]{0.0f, 0.0f};
    private float[] j = new float[]{0.0f, 0.0f};
    private float[] k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    public abstract void a(int i);

    public abstract boolean b(int i);

    public au(View view) {
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.k[0] = f / 1000.0f;
        this.k[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.j[0] = f2 / 1000.0f;
        this.j[1] = f2 / 1000.0f;
        this.g = 1;
        this.f[0] = Float.MAX_VALUE;
        this.f[1] = Float.MAX_VALUE;
        this.e[0] = 0.2f;
        this.e[1] = 0.2f;
        this.i[0] = 0.001f;
        this.i[1] = 0.001f;
        this.h = r;
        this.a.a = SecExceptionCode.SEC_ERROR_DYN_STORE;
        this.a.b = SecExceptionCode.SEC_ERROR_DYN_STORE;
    }

    public final au a(boolean z) {
        if (this.p && !z) {
            b();
        }
        this.p = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        switch (cx.a(motionEvent)) {
            case 0:
                this.n = true;
                this.l = false;
                break;
            case 1:
            case 3:
                b();
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.c.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.c.getHeight());
        an anVar = this.a;
        anVar.c = a;
        anVar.d = a2;
        if (!this.o && a()) {
            if (this.d == null) {
                this.d = new bu();
            }
            this.o = true;
            this.m = true;
            if (this.l || this.h <= 0) {
                this.d.run();
            } else {
                ViewCompat.a(this.c, this.d, (long) this.h);
            }
            this.l = true;
        }
        if (this.q && this.o) {
            return true;
        }
        return false;
    }

    private boolean a() {
        an anVar = this.a;
        int abs = (int) (anVar.d / Math.abs(anVar.d));
        int abs2 = (int) (anVar.c / Math.abs(anVar.c));
        if (abs != 0 && b(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    private void b() {
        if (this.m) {
            this.o = false;
            return;
        }
        an anVar = this.a;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i = (int) (currentAnimationTimeMillis - anVar.e);
        int i2 = anVar.b;
        if (i <= i2) {
            if (i < 0) {
                i2 = 0;
            } else {
                i2 = i;
            }
        }
        anVar.k = i2;
        anVar.j = anVar.a(currentAnimationTimeMillis);
        anVar.i = currentAnimationTimeMillis;
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

    static /* synthetic */ void i(au auVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        auVar.c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
